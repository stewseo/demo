/*
 * This file is generated by jOOQ.
 */
package org.jooq.demo.kotlin.db.tables.pojos


import java.io.Serializable
import java.time.LocalDateTime


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
data class Actor(
    var actorId: Long? = null,
    var firstName: String? = null,
    var lastName: String? = null,
    var lastUpdate: LocalDateTime? = null
): Serializable {

}