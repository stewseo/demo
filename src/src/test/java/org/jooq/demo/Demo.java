package org.jooq.demo;

import org.jooq.*;

import static org.jooq.Records.mapping;
import static org.jooq.SQLDialect.*;
import static org.jooq.demo.db.Tables.*;
import static org.jooq.impl.DSL.*;

import org.jooq.conf.Settings;
import org.jooq.demo.db.tables.Actor;
import org.jooq.demo.db.tables.FilmActor;
import org.jooq.demo.db.tables.records.ActorRecord;
import org.jooq.impl.DSL;
import org.jooq.impl.DefaultConfiguration;
import org.junit.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import java.util.stream.Stream;

public class Demo {

    Connection connection;
    DSLContext ctx;

    // Intro - queries
    // -----------------------------------------------------------------------------------------------------------------

    @Test
    public void fetchDual() {
        title("A simple SELECT 1 FROM DUAL (if needed)");
        println(ctx.selectOne().fetch());

        // Turn on debug logging to see contents
    }

    @Test
    public void typeSafetySimpleQuery() {
        title("A simple type safe query");
        Result<Record2<String, String>> r =
            ctx.select(ACTOR.FIRST_NAME, ACTOR.LAST_NAME)
               .from(ACTOR)
               .where(ACTOR.LAST_NAME.like("A%"))
               .orderBy(ACTOR.FIRST_NAME.asc())
               .fetch();

        // Try playing around with data types above:
        // - Use auto-completion to access columns from the table
        // - Adding / removing columns from the projection
        // - Changing the LIKE predicate's argument to an int
    }

    @Test
    public void consumeRecordsForEach() {
        title("ResultQuery<R> extends Iterable<R>, which means that we can iterate queries!");
        for (var r : ctx
            .select(ACTOR.FIRST_NAME, ACTOR.LAST_NAME)
            .from(ACTOR)
            .where(ACTOR.ACTOR_ID.lt(5L))
        ) {
            println("Actor: %s %s".formatted(r.value1(), r.value2()));
        }

        title("This also means we can call Iterable::forEach on it");
        ctx.select(FILM.FILM_ID, FILM.TITLE)
           .from(FILM)
           .limit(5)
           .forEach(r -> println("Film %s: %s".formatted(r.value1(), r.value2())));

        // Try removing type inference to see what r really is
    }

    @Test
    public void typeSafetyActiveRecords() {
        title("The resulting records can be nominally typed, too");
        ActorRecord actor =
        ctx.selectFrom(ACTOR)
            .where(ACTOR.ACTOR_ID.eq(1L))
            .fetchSingle();

        println("Resulting actor: %s %s".formatted(actor.getFirstName(), actor.getLastName()));

        // More on these UpdatableRecords later
    }

    @Test
    public void typeSafetyWithUnions() {
        title("UNION / INTERSECT / EXCEPT are also type safe");
        var result =
            ctx.select(ACTOR.FIRST_NAME, ACTOR.LAST_NAME)
               .from(ACTOR)
               .where(ACTOR.FIRST_NAME.like("A%"))
               .union(select(CUSTOMER.FIRST_NAME, CUSTOMER.LAST_NAME)
                    .from(CUSTOMER)
                    .where(CUSTOMER.FIRST_NAME.like("A%")))
               .fetch();

        // Try adding / removing projected columns, or changing data types
    }

    @Test
    public void typeSafetyWithInPredicate() {
        title("A lot of predicate expressions also type safe");
        var r1 =
            ctx.select(ACTOR.FIRST_NAME, ACTOR.LAST_NAME)
                .from(ACTOR)
                .where(ACTOR.FIRST_NAME.like("A%"))
                .and(ACTOR.ACTOR_ID.in(select(FILM_ACTOR.ACTOR_ID).from(FILM_ACTOR)))
                .fetch();

        title("This also works for type safe row value expressions!");
        var r2 =
            ctx.select(ACTOR.FIRST_NAME, ACTOR.LAST_NAME)
               .from(ACTOR)
               .where(ACTOR.FIRST_NAME.like("A%"))
               .and(row(ACTOR.FIRST_NAME, ACTOR.LAST_NAME).in(select(CUSTOMER.FIRST_NAME, CUSTOMER.LAST_NAME).from(CUSTOMER)))
               .fetch();
    }

    @Test
    public void standardisationLimit() {
        title("LIMIT .. OFFSET works in (almost) all dialects");
        var r1 =
            ctx.select(ACTOR.FIRST_NAME, ACTOR.LAST_NAME)
                .from(ACTOR)
                .where(ACTOR.FIRST_NAME.like("A%"))
                .orderBy(ACTOR.ACTOR_ID)
                .limit(10)
                .offset(10)
                .fetch();
    }

    @Test
    public void typeSafetySyntaxChecking() {
        title("UNION / INTERSECT / EXCEPT are also type safe");
        var result =
            ctx.select(ACTOR.FIRST_NAME, ACTOR.LAST_NAME)
               .from(ACTOR)
               .join(FILM_ACTOR)
               .on(ACTOR.ACTOR_ID.eq(FILM_ACTOR.ACTOR_ID))
               .where(ACTOR.FIRST_NAME.like("A%"))
               .fetch();

        // Try reordering the operations, or replacing ON by WHERE
    }

    @Test
    public void typeSafetyAliasing() {
        title("Table aliases also provide column type safety");

        Actor a = ACTOR.as("a");
        FilmActor fa = FILM_ACTOR.as("fa");

        var result =
            ctx.select(a.FIRST_NAME, a.LAST_NAME)
               .from(a)
               .join(fa)
               .on(a.ACTOR_ID.eq(fa.ACTOR_ID))
               .where(a.FIRST_NAME.like("A%"))
               .fetch();

        // Try reordering the operations, or replacing ON by WHERE
    }

    @Test
    public void implicitJoins() {
        title("No need to spell out trivial to-one joins");
        ctx.select(CUSTOMER.FIRST_NAME, CUSTOMER.LAST_NAME, CUSTOMER.address().city().country().COUNTRY_)
            .from(CUSTOMER)
            .orderBy(1, 2)
            .limit(5)
            .fetch();
    }

    @Test
    public void nestedRecords() {
        title("Need all columns of those active records?");

        var r =
        ctx.select(CUSTOMER, CUSTOMER.address().city().country())
           .from(CUSTOMER)
           .orderBy(1, 2)
           .limit(1)
           .fetchSingle();

        println("Customer %s %s from %s".formatted(r.value1().getFirstName(), r.value1().getLastName(), r.value2().getCountry()));

        // Though beware. While this is convenient, it's also likely inefficient as you're projecting too many columns
    }

    @Test
    public void nestedRowValuesWithAdHocConverters() {
        record Country(String name) {}
        record Customer(String firstName, String lastName, Country country) {}

        title("Nesting is particularly useful when using ad-hoc converters");
        List<Customer> r =
            ctx.select(CUSTOMER.FIRST_NAME, CUSTOMER.LAST_NAME, CUSTOMER.address().city().country().COUNTRY_.convertFrom(Country::new))
               .from(CUSTOMER)
               .orderBy(1, 2)
               .limit(5)
               .fetch(mapping(Customer::new));

        r.forEach(Demo::println);
    }

    @Test
    public void deeplyNestedRowValuesWithAdHocConverters() {
        record Country(String name) {}
        record Customer(String firstName, String lastName, Country country) {}

        title("Nesting is particularly useful when using ad-hoc converters");
        List<Customer> r =
            ctx.select(row(
                   CUSTOMER.FIRST_NAME,
                   CUSTOMER.LAST_NAME,
                   row(CUSTOMER.address().city().country().COUNTRY_).mapping(Country::new)
               ).mapping(Customer::new))
               .from(CUSTOMER)
               .orderBy(CUSTOMER.FIRST_NAME, CUSTOMER.LAST_NAME)
               .limit(5)
               .fetch(Record1::value1);

        r.forEach(Demo::println);
    }

    @Test
    public void nestingToManyRelationships() {
        title("The envy of all other ORMs: MULTISET!");
        var r =
        ctx.select(
                FILM.TITLE,
                multiset(
                    select(
                        FILM_ACTOR.actor().FIRST_NAME,
                        FILM_ACTOR.actor().LAST_NAME)
                    .from(FILM_ACTOR)
                    .where(FILM_ACTOR.FILM_ID.eq(FILM.FILM_ID))
                ),
                multiset(
                    select(FILM_CATEGORY.category().NAME)
                    .from(FILM_CATEGORY)
                    .where(FILM_CATEGORY.FILM_ID.eq(FILM.FILM_ID))
                )
           )
            .from(FILM)
            .orderBy(FILM.TITLE)
            .limit(5)
            .fetch();

        // By the way, any jOOQ Result and Record can be exported as CSV, XML, JSON, Text, etc.
        title("Formatted as JSON");
        println(r.formatJSON(JSONFormat.DEFAULT_FOR_RESULTS.format(true).header(false)));

        title("Formatted as XML");
        println(r.formatXML(XMLFormat.DEFAULT_FOR_RESULTS.format(true).header(false)));
    }

    @Test
    public void nestingToManyRelationshipsWithAdHocConverters() {
        title("MULTISET combined with ad-hoc converters and nested rows! 🤩");

        record Name(String firstName, String lastName) {}
        record Actor(Name name) {}
        record Category(String name) {}
        record Film(String title, List<Actor> actors, List<Category> categories) {}

        var result =
            ctx.select(
                   FILM.TITLE,
                   multiset(
                       select(
                           row(
                               FILM_ACTOR.actor().FIRST_NAME,
                               FILM_ACTOR.actor().LAST_NAME
                           ).mapping(Name::new))
                       .from(FILM_ACTOR)
                       .where(FILM_ACTOR.FILM_ID.eq(FILM.FILM_ID))
                   ).convertFrom(r -> r.map(mapping(Actor::new))),
                   multiset(
                       select(FILM_CATEGORY.category().NAME)
                           .from(FILM_CATEGORY)
                           .where(FILM_CATEGORY.FILM_ID.eq(FILM.FILM_ID))
                   ).convertFrom(r -> r.map(mapping(Category::new)))
               )
               .from(FILM)
               .orderBy(FILM.TITLE)
               .limit(5)
               .fetch(mapping(Film::new));

        for (Film film : result) {
            println("Film %s with categories %s and actors %s ".formatted(film.title, film.categories, film.actors));
        }

        // Try modifying the records and see what needs to be done to get the query to compile again
    }

    @Test
    public void updatableRecords() {
        ActorRecord actor =
            ctx.selectFrom(ACTOR)
               .where(ACTOR.ACTOR_ID.eq(200L))
               .fetchSingle();

        String lastName = actor.getLastName();
        try {
            actor.setLastName("Smith");
            actor.store();
        }
        finally {
            actor.setLastName(lastName);
            actor.store();
        }
    }

    @Test
    public void dml() {
        try {
            ctx.insertInto(ACTOR)
               .columns(ACTOR.ACTOR_ID, ACTOR.FIRST_NAME, ACTOR.LAST_NAME)
               .values(201L, "Jon", "Doe")
               .values(202L, "Jane", "Smith")
               .execute();

            ctx.update(ACTOR)
               .set(ACTOR.LAST_NAME, "X")
               .where(ACTOR.ACTOR_ID.gt(200L))
               .execute();
        }
        finally {
            ctx.delete(ACTOR)
               .where(ACTOR.ACTOR_ID.gt(200L))
               .execute();
        }
    }

    // Utilities
    // -----------------------------------------------------------------------------------------------------------------

    @Before
    public void setup() throws IOException, SQLException {
        Properties properties = new Properties();
        properties.load(Demo.class.getResourceAsStream("/config.properties"));
        connection = DriverManager.getConnection(
            properties.getProperty("db.cockroachdb.url"),
            properties.getProperty("db.cockroachdb.username"),
            properties.getProperty("db.cockroachdb.password")
        );

        ctx = using(new DefaultConfiguration()
            .set(connection)
            .set(SQLDialect.COCKROACHDB)
            .set(new Settings()
//                .withRenderFormatted(true)
            )

            // Activate this to get the output from different dialects
//            .set(ExecuteListener.onExecuteStart(e -> Stream
//                .of(MYSQL, ORACLE, POSTGRES, SQLSERVER)
//                .map(d -> using(d, new Settings().withRenderFormatted(true)))
//                .forEach(c -> {
//                    title(c.dialect());
//                    println(c.renderInlined(e.query()));
//                })))
        );

        // Initialise classes
        ctx.selectOne().toString();
    }

    @After
    public void teardown() throws SQLException {
        connection.close();
    }

    public static void title(Object title) {
        println("");
        println(title);
        println("-".repeat(("" + title).length()));
    }

    public static <T> T println(T t) {
        System.out.println(t);
        return t;
    }
}
