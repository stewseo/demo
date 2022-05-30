/*
 * This file is generated by jOOQ.
 */
package org.jooq.demo.skala.db.tables.records


import java.lang.Long
import java.lang.Short
import java.lang.String
import java.math.BigDecimal

import org.jooq.Field
import org.jooq.Record8
import org.jooq.Row8
import org.jooq.demo.skala.db.enums.MpaaRating
import org.jooq.demo.skala.db.tables.FilmList
import org.jooq.impl.TableRecordImpl


/**
 * This class is generated by jOOQ.
 */
class FilmListRecord extends TableRecordImpl[FilmListRecord](FilmList.FILM_LIST) with Record8[Long, String, String, String, BigDecimal, Short, MpaaRating, String] {

  /**
   * Setter for <code>public.film_list.fid</code>.
   */
  def setFid(value: Long): Unit = {
    set(0, value)
  }

  /**
   * Getter for <code>public.film_list.fid</code>.
   */
  def getFid: Long = get(0).asInstanceOf[Long]

  /**
   * Setter for <code>public.film_list.title</code>.
   */
  def setTitle(value: String): Unit = {
    set(1, value)
  }

  /**
   * Getter for <code>public.film_list.title</code>.
   */
  def getTitle: String = get(1).asInstanceOf[String]

  /**
   * Setter for <code>public.film_list.description</code>.
   */
  def setDescription(value: String): Unit = {
    set(2, value)
  }

  /**
   * Getter for <code>public.film_list.description</code>.
   */
  def getDescription: String = get(2).asInstanceOf[String]

  /**
   * Setter for <code>public.film_list.category</code>.
   */
  def setCategory(value: String): Unit = {
    set(3, value)
  }

  /**
   * Getter for <code>public.film_list.category</code>.
   */
  def getCategory: String = get(3).asInstanceOf[String]

  /**
   * Setter for <code>public.film_list.price</code>.
   */
  def setPrice(value: BigDecimal): Unit = {
    set(4, value)
  }

  /**
   * Getter for <code>public.film_list.price</code>.
   */
  def getPrice: BigDecimal = get(4).asInstanceOf[BigDecimal]

  /**
   * Setter for <code>public.film_list.length</code>.
   */
  def setLength(value: Short): Unit = {
    set(5, value)
  }

  /**
   * Getter for <code>public.film_list.length</code>.
   */
  def getLength: Short = get(5).asInstanceOf[Short]

  /**
   * Setter for <code>public.film_list.rating</code>.
   */
  def setRating(value: MpaaRating): Unit = {
    set(6, value)
  }

  /**
   * Getter for <code>public.film_list.rating</code>.
   */
  def getRating: MpaaRating = get(6).asInstanceOf[MpaaRating]

  /**
   * Setter for <code>public.film_list.actors</code>.
   */
  def setActors(value: String): Unit = {
    set(7, value)
  }

  /**
   * Getter for <code>public.film_list.actors</code>.
   */
  def getActors: String = get(7).asInstanceOf[String]

  // -------------------------------------------------------------------------
  // Record8 type implementation
  // -------------------------------------------------------------------------

  override def fieldsRow: Row8[Long, String, String, String, BigDecimal, Short, MpaaRating, String] = super.fieldsRow.asInstanceOf[ Row8[Long, String, String, String, BigDecimal, Short, MpaaRating, String] ]

  override def valuesRow: Row8[Long, String, String, String, BigDecimal, Short, MpaaRating, String] = super.valuesRow.asInstanceOf[ Row8[Long, String, String, String, BigDecimal, Short, MpaaRating, String] ]
  override def field1: Field[Long] = FilmList.FILM_LIST.FID
  override def field2: Field[String] = FilmList.FILM_LIST.TITLE
  override def field3: Field[String] = FilmList.FILM_LIST.DESCRIPTION
  override def field4: Field[String] = FilmList.FILM_LIST.CATEGORY
  override def field5: Field[BigDecimal] = FilmList.FILM_LIST.PRICE
  override def field6: Field[Short] = FilmList.FILM_LIST.LENGTH
  override def field7: Field[MpaaRating] = FilmList.FILM_LIST.RATING
  override def field8: Field[String] = FilmList.FILM_LIST.ACTORS
  override def component1: Long = getFid
  override def component2: String = getTitle
  override def component3: String = getDescription
  override def component4: String = getCategory
  override def component5: BigDecimal = getPrice
  override def component6: Short = getLength
  override def component7: MpaaRating = getRating
  override def component8: String = getActors
  override def value1: Long = getFid
  override def value2: String = getTitle
  override def value3: String = getDescription
  override def value4: String = getCategory
  override def value5: BigDecimal = getPrice
  override def value6: Short = getLength
  override def value7: MpaaRating = getRating
  override def value8: String = getActors

  override def value1(value: Long): FilmListRecord = {
    setFid(value)
    this
  }

  override def value2(value: String): FilmListRecord = {
    setTitle(value)
    this
  }

  override def value3(value: String): FilmListRecord = {
    setDescription(value)
    this
  }

  override def value4(value: String): FilmListRecord = {
    setCategory(value)
    this
  }

  override def value5(value: BigDecimal): FilmListRecord = {
    setPrice(value)
    this
  }

  override def value6(value: Short): FilmListRecord = {
    setLength(value)
    this
  }

  override def value7(value: MpaaRating): FilmListRecord = {
    setRating(value)
    this
  }

  override def value8(value: String): FilmListRecord = {
    setActors(value)
    this
  }

  override def values(value1 : Long, value2 : String, value3 : String, value4 : String, value5 : BigDecimal, value6 : Short, value7 : MpaaRating, value8 : String): FilmListRecord = {
    this.value1(value1)
    this.value2(value2)
    this.value3(value3)
    this.value4(value4)
    this.value5(value5)
    this.value6(value6)
    this.value7(value7)
    this.value8(value8)
    this
  }

  /**
   * Create a detached, initialised FilmListRecord
   */
  def this(fid : Long, title : String, description : String, category : String, price : BigDecimal, length : Short, rating : MpaaRating, actors : String) = {
    this()

    this.setFid(fid)
    this.setTitle(title)
    this.setDescription(description)
    this.setCategory(category)
    this.setPrice(price)
    this.setLength(length)
    this.setRating(rating)
    this.setActors(actors)
  }

  /**
   * Create a detached, initialised FilmListRecord
   */
  def this(value: org.jooq.demo.skala.db.tables.pojos.FilmList) = {
    this()

    if (value != null) {
      this.setFid(value.getFid)
      this.setTitle(value.getTitle)
      this.setDescription(value.getDescription)
      this.setCategory(value.getCategory)
      this.setPrice(value.getPrice)
      this.setLength(value.getLength)
      this.setRating(value.getRating)
      this.setActors(value.getActors)
    }
  }
}
