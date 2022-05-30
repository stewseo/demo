/*
 * This file is generated by jOOQ.
 */
package org.jooq.demo.skala.db.tables


import java.lang.Class
import java.lang.Long
import java.lang.String
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.Arrays
import java.util.List
import java.util.function.Function

import org.jooq.Field
import org.jooq.ForeignKey
import org.jooq.Identity
import org.jooq.Index
import org.jooq.Name
import org.jooq.Record
import org.jooq.Row6
import org.jooq.Schema
import org.jooq.SelectField
import org.jooq.Table
import org.jooq.TableField
import org.jooq.TableLike
import org.jooq.TableOptions
import org.jooq.UniqueKey
import org.jooq.demo.skala.db.Indexes
import org.jooq.demo.skala.db.Keys
import org.jooq.demo.skala.db.Public
import org.jooq.demo.skala.db.tables.records.CustomerRecord
import org.jooq.demo.skala.db.tables.records.PaymentRecord
import org.jooq.demo.skala.db.tables.records.RentalRecord
import org.jooq.demo.skala.db.tables.records.StaffRecord
import org.jooq.impl.DSL
import org.jooq.impl.Internal
import org.jooq.impl.SQLDataType
import org.jooq.impl.TableImpl

import scala.Array


object Payment {

  /**
   * The reference instance of <code>public.payment</code>
   */
  val PAYMENT = new Payment
}

/**
 * This class is generated by jOOQ.
 */
class Payment(
  alias: Name,
  child: Table[_ <: Record],
  path: ForeignKey[_ <: Record, PaymentRecord],
  aliased: Table[PaymentRecord],
  parameters: Array[ Field[_] ]
)
extends TableImpl[PaymentRecord](
  alias,
  Public.PUBLIC,
  child,
  path,
  aliased,
  parameters,
  DSL.comment(""),
  TableOptions.table
) {

  /**
   * The class holding records for this type
   */
  override def getRecordType: Class[PaymentRecord] = classOf[PaymentRecord]

  /**
   * The column <code>public.payment.payment_id</code>.
   */
  val PAYMENT_ID: TableField[PaymentRecord, Long] = createField(DSL.name("payment_id"), SQLDataType.BIGINT.nullable(false).identity(true), "")

  /**
   * The column <code>public.payment.customer_id</code>.
   */
  val CUSTOMER_ID: TableField[PaymentRecord, Long] = createField(DSL.name("customer_id"), SQLDataType.BIGINT.nullable(false), "")

  /**
   * The column <code>public.payment.staff_id</code>.
   */
  val STAFF_ID: TableField[PaymentRecord, Long] = createField(DSL.name("staff_id"), SQLDataType.BIGINT.nullable(false), "")

  /**
   * The column <code>public.payment.rental_id</code>.
   */
  val RENTAL_ID: TableField[PaymentRecord, Long] = createField(DSL.name("rental_id"), SQLDataType.BIGINT.nullable(false), "")

  /**
   * The column <code>public.payment.amount</code>.
   */
  val AMOUNT: TableField[PaymentRecord, BigDecimal] = createField(DSL.name("amount"), SQLDataType.NUMERIC(5, 2).nullable(false), "")

  /**
   * The column <code>public.payment.payment_date</code>.
   */
  val PAYMENT_DATE: TableField[PaymentRecord, LocalDateTime] = createField(DSL.name("payment_date"), SQLDataType.LOCALDATETIME(6).nullable(false), "")

  private def this(alias: Name, aliased: Table[PaymentRecord]) = this(alias, null, null, aliased, null)

  /**
   * Create an aliased <code>public.payment</code> table reference
   */
  def this(alias: String) = this(DSL.name(alias), org.jooq.demo.skala.db.tables.Payment.PAYMENT)

  /**
   * Create an aliased <code>public.payment</code> table reference
   */
  def this(alias: Name) = this(alias, org.jooq.demo.skala.db.tables.Payment.PAYMENT)

  /**
   * Create a <code>public.payment</code> table reference
   */
  def this() = this(DSL.name("payment"), null)

  def this(child: Table[_ <: Record], key: ForeignKey[_ <: Record, PaymentRecord]) = this(Internal.createPathAlias(child, key), child, key, org.jooq.demo.skala.db.tables.Payment.PAYMENT, null)

  override def getSchema: Schema = if (aliased()) null else Public.PUBLIC

  override def getIndexes: List[Index] = Arrays.asList[ Index ](Indexes.IDX_FK_CUSTOMER_ID, Indexes.IDX_FK_STAFF_ID)

  override def getIdentity: Identity[PaymentRecord, Long] = super.getIdentity.asInstanceOf[ Identity[PaymentRecord, Long] ]

  override def getPrimaryKey: UniqueKey[PaymentRecord] = Keys.PAYMENT_PKEY

  override def getReferences: List[ ForeignKey[PaymentRecord, _] ] = Arrays.asList[ ForeignKey[PaymentRecord, _] ](Keys.PAYMENT__PAYMENT_CUSTOMER_ID_FKEY, Keys.PAYMENT__PAYMENT_STAFF_ID_FKEY, Keys.PAYMENT__PAYMENT_RENTAL_ID_FKEY)

  /**
   * Get the implicit join path to the <code>public.customer</code> table.
   */
  lazy val customer: Customer = { new Customer(this, Keys.PAYMENT__PAYMENT_CUSTOMER_ID_FKEY) }

  /**
   * Get the implicit join path to the <code>public.staff</code> table.
   */
  lazy val staff: Staff = { new Staff(this, Keys.PAYMENT__PAYMENT_STAFF_ID_FKEY) }

  /**
   * Get the implicit join path to the <code>public.rental</code> table.
   */
  lazy val rental: Rental = { new Rental(this, Keys.PAYMENT__PAYMENT_RENTAL_ID_FKEY) }

  /**
   * A convenience constructor for correlated <code>ROW</code>s expressions to
   * the <code>public.payment</code> to-one parent table.
   */
  def customerRow(): Field[CustomerRecord] = customerRow(t => t)

  /**
   * A convenience constructor for correlated <code>ROW</code>s expressions to
   * the <code>public.payment</code> to-one parent table.
   */
  def customerRow[O <: Record](subquery: (Customer) => TableLike[O]): Field[O] = toOneRow(Keys.PAYMENT__PAYMENT_CUSTOMER_ID_FKEY, (t: Table[CustomerRecord]) => subquery(t.asInstanceOf[Customer]))

  /**
   * A convenience constructor for correlated <code>ROW</code>s expressions to
   * the <code>public.payment</code> to-one parent table.
   */
  def staffRow(): Field[StaffRecord] = staffRow(t => t)

  /**
   * A convenience constructor for correlated <code>ROW</code>s expressions to
   * the <code>public.payment</code> to-one parent table.
   */
  def staffRow[O <: Record](subquery: (Staff) => TableLike[O]): Field[O] = toOneRow(Keys.PAYMENT__PAYMENT_STAFF_ID_FKEY, (t: Table[StaffRecord]) => subquery(t.asInstanceOf[Staff]))

  /**
   * A convenience constructor for correlated <code>ROW</code>s expressions to
   * the <code>public.payment</code> to-one parent table.
   */
  def rentalRow(): Field[RentalRecord] = rentalRow(t => t)

  /**
   * A convenience constructor for correlated <code>ROW</code>s expressions to
   * the <code>public.payment</code> to-one parent table.
   */
  def rentalRow[O <: Record](subquery: (Rental) => TableLike[O]): Field[O] = toOneRow(Keys.PAYMENT__PAYMENT_RENTAL_ID_FKEY, (t: Table[RentalRecord]) => subquery(t.asInstanceOf[Rental]))
  override def as(alias: String): Payment = new Payment(DSL.name(alias), this)
  override def as(alias: Name): Payment = new Payment(alias, this)
  override def as(alias: Table[_]): Payment = new Payment(alias.getQualifiedName(), this)

  /**
   * Rename this table
   */
  override def rename(name: String): Payment = new Payment(DSL.name(name), null)

  /**
   * Rename this table
   */
  override def rename(name: Name): Payment = new Payment(name, null)

  /**
   * Rename this table
   */
  override def rename(name: Table[_]): Payment = new Payment(name.getQualifiedName(), null)

  // -------------------------------------------------------------------------
  // Row6 type methods
  // -------------------------------------------------------------------------
  override def fieldsRow: Row6[Long, Long, Long, Long, BigDecimal, LocalDateTime] = super.fieldsRow.asInstanceOf[ Row6[Long, Long, Long, Long, BigDecimal, LocalDateTime] ]

  /**
   * Convenience mapping calling {@link #convertFrom(Function)}.
   */
  def mapping[U](from: (Long, Long, Long, Long, BigDecimal, LocalDateTime) => U): SelectField[U] = convertFrom(r => from.apply(r.value1(), r.value2(), r.value3(), r.value4(), r.value5(), r.value6()))

  /**
   * Convenience mapping calling {@link #convertFrom(Class, Function)}.
   */
  def mapping[U](toType: Class[U], from: (Long, Long, Long, Long, BigDecimal, LocalDateTime) => U): SelectField[U] = convertFrom(toType,r => from.apply(r.value1(), r.value2(), r.value3(), r.value4(), r.value5(), r.value6()))
}
