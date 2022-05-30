/*
 * This file is generated by jOOQ.
 */
package org.jooq.demo.skala.db.tables.pojos


import java.io.Serializable
import java.lang.Long
import java.math.BigDecimal
import java.time.LocalDateTime


/**
 * This class is generated by jOOQ.
 */
case class Payment(
  var paymentId: Long,
  var customerId: Long,
  var staffId: Long,
  var rentalId: Long,
  var amount: BigDecimal,
  var paymentDate: LocalDateTime
) extends Serializable {

  def this() = this(null, null, null, null, null, null)

  def this(value: Payment) = this(
    value.paymentId,
    value.customerId,
    value.staffId,
    value.rentalId,
    value.amount,
    value.paymentDate
  )

  /**
   * Getter for <code>public.payment.payment_id</code>.
   */
  def getPaymentId: Long = this.paymentId

  /**
   * Setter for <code>public.payment.payment_id</code>.
   */
  def setPaymentId(paymentId: Long): Unit = {
    this.paymentId = paymentId
  }

  /**
   * Getter for <code>public.payment.customer_id</code>.
   */
  def getCustomerId: Long = this.customerId

  /**
   * Setter for <code>public.payment.customer_id</code>.
   */
  def setCustomerId(customerId: Long): Unit = {
    this.customerId = customerId
  }

  /**
   * Getter for <code>public.payment.staff_id</code>.
   */
  def getStaffId: Long = this.staffId

  /**
   * Setter for <code>public.payment.staff_id</code>.
   */
  def setStaffId(staffId: Long): Unit = {
    this.staffId = staffId
  }

  /**
   * Getter for <code>public.payment.rental_id</code>.
   */
  def getRentalId: Long = this.rentalId

  /**
   * Setter for <code>public.payment.rental_id</code>.
   */
  def setRentalId(rentalId: Long): Unit = {
    this.rentalId = rentalId
  }

  /**
   * Getter for <code>public.payment.amount</code>.
   */
  def getAmount: BigDecimal = this.amount

  /**
   * Setter for <code>public.payment.amount</code>.
   */
  def setAmount(amount: BigDecimal): Unit = {
    this.amount = amount
  }

  /**
   * Getter for <code>public.payment.payment_date</code>.
   */
  def getPaymentDate: LocalDateTime = this.paymentDate

  /**
   * Setter for <code>public.payment.payment_date</code>.
   */
  def setPaymentDate(paymentDate: LocalDateTime): Unit = {
    this.paymentDate = paymentDate
  }
}
