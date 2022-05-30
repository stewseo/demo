/*
 * This file is generated by jOOQ.
 */
package org.jooq.demo.skala.db.tables.pojos


import java.io.Serializable
import java.lang.String
import java.math.BigDecimal


/**
 * This class is generated by jOOQ.
 */
case class SalesByFilmCategory(
  var category: String,
  var totalSales: BigDecimal
) extends Serializable {

  def this() = this(null, null)

  def this(value: SalesByFilmCategory) = this(
    value.category,
    value.totalSales
  )

  /**
   * Getter for <code>public.sales_by_film_category.category</code>.
   */
  def getCategory: String = this.category

  /**
   * Setter for <code>public.sales_by_film_category.category</code>.
   */
  def setCategory(category: String): Unit = {
    this.category = category
  }

  /**
   * Getter for <code>public.sales_by_film_category.total_sales</code>.
   */
  def getTotalSales: BigDecimal = this.totalSales

  /**
   * Setter for <code>public.sales_by_film_category.total_sales</code>.
   */
  def setTotalSales(totalSales: BigDecimal): Unit = {
    this.totalSales = totalSales
  }
}
