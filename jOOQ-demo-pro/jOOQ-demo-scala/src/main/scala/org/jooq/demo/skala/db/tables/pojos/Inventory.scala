/*
 * This file is generated by jOOQ.
 */
package org.jooq.demo.skala.db.tables.pojos


import java.io.Serializable
import java.lang.Long
import java.time.LocalDateTime


/**
 * This class is generated by jOOQ.
 */
case class Inventory(
  var inventoryId: Long,
  var filmId: Long,
  var storeId: Long,
  var lastUpdate: LocalDateTime
) extends Serializable {

  def this() = this(null, null, null, null)

  def this(value: Inventory) = this(
    value.inventoryId,
    value.filmId,
    value.storeId,
    value.lastUpdate
  )

  /**
   * Getter for <code>public.inventory.inventory_id</code>.
   */
  def getInventoryId: Long = this.inventoryId

  /**
   * Setter for <code>public.inventory.inventory_id</code>.
   */
  def setInventoryId(inventoryId: Long): Unit = {
    this.inventoryId = inventoryId
  }

  /**
   * Getter for <code>public.inventory.film_id</code>.
   */
  def getFilmId: Long = this.filmId

  /**
   * Setter for <code>public.inventory.film_id</code>.
   */
  def setFilmId(filmId: Long): Unit = {
    this.filmId = filmId
  }

  /**
   * Getter for <code>public.inventory.store_id</code>.
   */
  def getStoreId: Long = this.storeId

  /**
   * Setter for <code>public.inventory.store_id</code>.
   */
  def setStoreId(storeId: Long): Unit = {
    this.storeId = storeId
  }

  /**
   * Getter for <code>public.inventory.last_update</code>.
   */
  def getLastUpdate: LocalDateTime = this.lastUpdate

  /**
   * Setter for <code>public.inventory.last_update</code>.
   */
  def setLastUpdate(lastUpdate: LocalDateTime): Unit = {
    this.lastUpdate = lastUpdate
  }
}