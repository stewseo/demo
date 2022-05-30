/*
 * This file is generated by jOOQ.
 */
package org.jooq.demo.skala.db.tables


import java.lang.Class
import java.lang.Long
import java.lang.String
import java.util.function.Function

import org.jooq.Field
import org.jooq.ForeignKey
import org.jooq.Name
import org.jooq.Record
import org.jooq.Row4
import org.jooq.Schema
import org.jooq.SelectField
import org.jooq.Table
import org.jooq.TableField
import org.jooq.TableOptions
import org.jooq.demo.skala.db.Public
import org.jooq.demo.skala.db.tables.records.ActorInfoRecord
import org.jooq.impl.DSL
import org.jooq.impl.Internal
import org.jooq.impl.SQLDataType
import org.jooq.impl.TableImpl

import scala.Array


object ActorInfo {

  /**
   * The reference instance of <code>public.actor_info</code>
   */
  val ACTOR_INFO = new ActorInfo
}

/**
 * This class is generated by jOOQ.
 */
class ActorInfo(
  alias: Name,
  child: Table[_ <: Record],
  path: ForeignKey[_ <: Record, ActorInfoRecord],
  aliased: Table[ActorInfoRecord],
  parameters: Array[ Field[_] ]
)
extends TableImpl[ActorInfoRecord](
  alias,
  Public.PUBLIC,
  child,
  path,
  aliased,
  parameters,
  DSL.comment(""),
  TableOptions.view("""
  create view "actor_info" as  SELECT a.actor_id,
    a.first_name,
    a.last_name,
    group_concat(DISTINCT (((c.name)::text || ': '::text) || ( SELECT group_concat((f.title)::text) AS group_concat
           FROM ((film f
             JOIN film_category fc_1 ON ((f.film_id = fc_1.film_id)))
             JOIN film_actor fa_1 ON ((f.film_id = fa_1.film_id)))
          WHERE ((fc_1.category_id = c.category_id) AND (fa_1.actor_id = a.actor_id))
          GROUP BY fa_1.actor_id))) AS film_info
   FROM (((actor a
     LEFT JOIN film_actor fa ON ((a.actor_id = fa.actor_id)))
     LEFT JOIN film_category fc ON ((fa.film_id = fc.film_id)))
     LEFT JOIN category c ON ((fc.category_id = c.category_id)))
  GROUP BY a.actor_id, a.first_name, a.last_name;
  """)
) {

  /**
   * The class holding records for this type
   */
  override def getRecordType: Class[ActorInfoRecord] = classOf[ActorInfoRecord]

  /**
   * The column <code>public.actor_info.actor_id</code>.
   */
  val ACTOR_ID: TableField[ActorInfoRecord, Long] = createField(DSL.name("actor_id"), SQLDataType.BIGINT, "")

  /**
   * The column <code>public.actor_info.first_name</code>.
   */
  val FIRST_NAME: TableField[ActorInfoRecord, String] = createField(DSL.name("first_name"), SQLDataType.VARCHAR(45), "")

  /**
   * The column <code>public.actor_info.last_name</code>.
   */
  val LAST_NAME: TableField[ActorInfoRecord, String] = createField(DSL.name("last_name"), SQLDataType.VARCHAR(45), "")

  /**
   * The column <code>public.actor_info.film_info</code>.
   */
  val FILM_INFO: TableField[ActorInfoRecord, String] = createField(DSL.name("film_info"), SQLDataType.CLOB, "")

  private def this(alias: Name, aliased: Table[ActorInfoRecord]) = this(alias, null, null, aliased, null)

  /**
   * Create an aliased <code>public.actor_info</code> table reference
   */
  def this(alias: String) = this(DSL.name(alias), org.jooq.demo.skala.db.tables.ActorInfo.ACTOR_INFO)

  /**
   * Create an aliased <code>public.actor_info</code> table reference
   */
  def this(alias: Name) = this(alias, org.jooq.demo.skala.db.tables.ActorInfo.ACTOR_INFO)

  /**
   * Create a <code>public.actor_info</code> table reference
   */
  def this() = this(DSL.name("actor_info"), null)

  def this(child: Table[_ <: Record], key: ForeignKey[_ <: Record, ActorInfoRecord]) = this(Internal.createPathAlias(child, key), child, key, org.jooq.demo.skala.db.tables.ActorInfo.ACTOR_INFO, null)

  override def getSchema: Schema = if (aliased()) null else Public.PUBLIC
  override def as(alias: String): ActorInfo = new ActorInfo(DSL.name(alias), this)
  override def as(alias: Name): ActorInfo = new ActorInfo(alias, this)
  override def as(alias: Table[_]): ActorInfo = new ActorInfo(alias.getQualifiedName(), this)

  /**
   * Rename this table
   */
  override def rename(name: String): ActorInfo = new ActorInfo(DSL.name(name), null)

  /**
   * Rename this table
   */
  override def rename(name: Name): ActorInfo = new ActorInfo(name, null)

  /**
   * Rename this table
   */
  override def rename(name: Table[_]): ActorInfo = new ActorInfo(name.getQualifiedName(), null)

  // -------------------------------------------------------------------------
  // Row4 type methods
  // -------------------------------------------------------------------------
  override def fieldsRow: Row4[Long, String, String, String] = super.fieldsRow.asInstanceOf[ Row4[Long, String, String, String] ]

  /**
   * Convenience mapping calling {@link #convertFrom(Function)}.
   */
  def mapping[U](from: (Long, String, String, String) => U): SelectField[U] = convertFrom(r => from.apply(r.value1(), r.value2(), r.value3(), r.value4()))

  /**
   * Convenience mapping calling {@link #convertFrom(Class, Function)}.
   */
  def mapping[U](toType: Class[U], from: (Long, String, String, String) => U): SelectField[U] = convertFrom(toType,r => from.apply(r.value1(), r.value2(), r.value3(), r.value4()))
}
