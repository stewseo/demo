/*
 * This file is generated by jOOQ.
 */
package org.jooq.demo.skala.db.tables.records


import java.lang.Long
import java.math.BigDecimal
import java.time.LocalDateTime

import org.jooq.Field
import org.jooq.Record6
import org.jooq.Row6
import org.jooq.demo.skala.db.tables.PaymentP2007_04
import org.jooq.impl.TableRecordImpl


/**
 * This class is generated by jOOQ.
 */
class PaymentP2007_04Record extends TableRecordImpl[PaymentP2007_04Record](PaymentP2007_04.PAYMENT_P2007_04) with Record6[Long, Long, Long, Long, BigDecimal, LocalDateTime] {

  /**
   * Setter for <code>public.payment_p2007_04.payment_id</code>.
   */
  def setPaymentId(value: Long): Unit = {
    set(0, value)
  }

  /**
   * Getter for <code>public.payment_p2007_04.payment_id</code>.
   */
  def getPaymentId: Long = get(0).asInstanceOf[Long]

  /**
   * Setter for <code>public.payment_p2007_04.customer_id</code>.
   */
  def setCustomerId(value: Long): Unit = {
    set(1, value)
  }

  /**
   * Getter for <code>public.payment_p2007_04.customer_id</code>.
   */
  def getCustomerId: Long = get(1).asInstanceOf[Long]

  /**
   * Setter for <code>public.payment_p2007_04.staff_id</code>.
   */
  def setStaffId(value: Long): Unit = {
    set(2, value)
  }

  /**
   * Getter for <code>public.payment_p2007_04.staff_id</code>.
   */
  def getStaffId: Long = get(2).asInstanceOf[Long]

  /**
   * Setter for <code>public.payment_p2007_04.rental_id</code>.
   */
  def setRentalId(value: Long): Unit = {
    set(3, value)
  }

  /**
   * Getter for <code>public.payment_p2007_04.rental_id</code>.
   */
  def getRentalId: Long = get(3).asInstanceOf[Long]

  /**
   * Setter for <code>public.payment_p2007_04.amount</code>.
   */
  def setAmount(value: BigDecimal): Unit = {
    set(4, value)
  }

  /**
   * Getter for <code>public.payment_p2007_04.amount</code>.
   */
  def getAmount: BigDecimal = get(4).asInstanceOf[BigDecimal]

  /**
   * Setter for <code>public.payment_p2007_04.payment_date</code>.
   */
  def setPaymentDate(value: LocalDateTime): Unit = {
    set(5, value)
  }

  /**
   * Getter for <code>public.payment_p2007_04.payment_date</code>.
   */
  def getPaymentDate: LocalDateTime = get(5).asInstanceOf[LocalDateTime]

  // -------------------------------------------------------------------------
  // Record6 type implementation
  // -------------------------------------------------------------------------

  override def fieldsRow: Row6[Long, Long, Long, Long, BigDecimal, LocalDateTime] = super.fieldsRow.asInstanceOf[ Row6[Long, Long, Long, Long, BigDecimal, LocalDateTime] ]

  override def valuesRow: Row6[Long, Long, Long, Long, BigDecimal, LocalDateTime] = super.valuesRow.asInstanceOf[ Row6[Long, Long, Long, Long, BigDecimal, LocalDateTime] ]
  override def field1: Field[Long] = PaymentP2007_04.PAYMENT_P2007_04.PAYMENT_ID
  override def field2: Field[Long] = PaymentP2007_04.PAYMENT_P2007_04.CUSTOMER_ID
  override def field3: Field[Long] = PaymentP2007_04.PAYMENT_P2007_04.STAFF_ID
  override def field4: Field[Long] = PaymentP2007_04.PAYMENT_P2007_04.RENTAL_ID
  override def field5: Field[BigDecimal] = PaymentP2007_04.PAYMENT_P2007_04.AMOUNT
  override def field6: Field[LocalDateTime] = PaymentP2007_04.PAYMENT_P2007_04.PAYMENT_DATE
  override def component1: Long = getPaymentId
  override def component2: Long = getCustomerId
  override def component3: Long = getStaffId
  override def component4: Long = getRentalId
  override def component5: BigDecimal = getAmount
  override def component6: LocalDateTime = getPaymentDate
  override def value1: Long = getPaymentId
  override def value2: Long = getCustomerId
  override def value3: Long = getStaffId
  override def value4: Long = getRentalId
  override def value5: BigDecimal = getAmount
  override def value6: LocalDateTime = getPaymentDate

  override def value1(value: Long): PaymentP2007_04Record = {
    setPaymentId(value)
    this
  }

  override def value2(value: Long): PaymentP2007_04Record = {
    setCustomerId(value)
    this
  }

  override def value3(value: Long): PaymentP2007_04Record = {
    setStaffId(value)
    this
  }

  override def value4(value: Long): PaymentP2007_04Record = {
    setRentalId(value)
    this
  }

  override def value5(value: BigDecimal): PaymentP2007_04Record = {
    setAmount(value)
    this
  }

  override def value6(value: LocalDateTime): PaymentP2007_04Record = {
    setPaymentDate(value)
    this
  }

  override def values(value1 : Long, value2 : Long, value3 : Long, value4 : Long, value5 : BigDecimal, value6 : LocalDateTime): PaymentP2007_04Record = {
    this.value1(value1)
    this.value2(value2)
    this.value3(value3)
    this.value4(value4)
    this.value5(value5)
    this.value6(value6)
    this
  }

  /**
   * Create a detached, initialised PaymentP2007_04Record
   */
  def this(paymentId : Long, customerId : Long, staffId : Long, rentalId : Long, amount : BigDecimal, paymentDate : LocalDateTime) = {
    this()

    this.setPaymentId(paymentId)
    this.setCustomerId(customerId)
    this.setStaffId(staffId)
    this.setRentalId(rentalId)
    this.setAmount(amount)
    this.setPaymentDate(paymentDate)
  }

  /**
   * Create a detached, initialised PaymentP2007_04Record
   */
  def this(value: org.jooq.demo.skala.db.tables.pojos.PaymentP2007_04) = {
    this()

    if (value != null) {
      this.setPaymentId(value.getPaymentId)
      this.setCustomerId(value.getCustomerId)
      this.setStaffId(value.getStaffId)
      this.setRentalId(value.getRentalId)
      this.setAmount(value.getAmount)
      this.setPaymentDate(value.getPaymentDate)
    }
  }
}
