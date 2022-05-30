/*
 * This file is generated by jOOQ.
 */
package org.jooq.demo.skala.db.tables


import java.lang.Class
import java.lang.Long
import java.lang.String
import java.time.LocalDateTime
import java.util.function.Function

import org.jooq.Field
import org.jooq.ForeignKey
import org.jooq.Identity
import org.jooq.Name
import org.jooq.Record
import org.jooq.Row3
import org.jooq.Schema
import org.jooq.SelectField
import org.jooq.Table
import org.jooq.TableField
import org.jooq.TableOptions
import org.jooq.UniqueKey
import org.jooq.demo.skala.db.Keys
import org.jooq.demo.skala.db.Public
import org.jooq.demo.skala.db.tables.records.LanguageRecord
import org.jooq.impl.DSL
import org.jooq.impl.Internal
import org.jooq.impl.SQLDataType
import org.jooq.impl.TableImpl

import scala.Array


object Language {

  /**
   * The reference instance of <code>public.language</code>
   */
  val LANGUAGE = new Language
}

/**
 * This class is generated by jOOQ.
 */
class Language(
  alias: Name,
  child: Table[_ <: Record],
  path: ForeignKey[_ <: Record, LanguageRecord],
  aliased: Table[LanguageRecord],
  parameters: Array[ Field[_] ]
)
extends TableImpl[LanguageRecord](
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
  override def getRecordType: Class[LanguageRecord] = classOf[LanguageRecord]

  /**
   * The column <code>public.language.language_id</code>.
   */
  val LANGUAGE_ID: TableField[LanguageRecord, Long] = createField(DSL.name("language_id"), SQLDataType.BIGINT.nullable(false).identity(true), "")

  /**
   * The column <code>public.language.name</code>.
   */
  val NAME: TableField[LanguageRecord, String] = createField(DSL.name("name"), SQLDataType.CHAR(20).nullable(false), "")

  /**
   * The column <code>public.language.last_update</code>.
   */
  val LAST_UPDATE: TableField[LanguageRecord, LocalDateTime] = createField(DSL.name("last_update"), SQLDataType.LOCALDATETIME(6).nullable(false).defaultValue(DSL.field("now()", SQLDataType.LOCALDATETIME)), "")

  private def this(alias: Name, aliased: Table[LanguageRecord]) = this(alias, null, null, aliased, null)

  /**
   * Create an aliased <code>public.language</code> table reference
   */
  def this(alias: String) = this(DSL.name(alias), org.jooq.demo.skala.db.tables.Language.LANGUAGE)

  /**
   * Create an aliased <code>public.language</code> table reference
   */
  def this(alias: Name) = this(alias, org.jooq.demo.skala.db.tables.Language.LANGUAGE)

  /**
   * Create a <code>public.language</code> table reference
   */
  def this() = this(DSL.name("language"), null)

  def this(child: Table[_ <: Record], key: ForeignKey[_ <: Record, LanguageRecord]) = this(Internal.createPathAlias(child, key), child, key, org.jooq.demo.skala.db.tables.Language.LANGUAGE, null)

  override def getSchema: Schema = if (aliased()) null else Public.PUBLIC

  override def getIdentity: Identity[LanguageRecord, Long] = super.getIdentity.asInstanceOf[ Identity[LanguageRecord, Long] ]

  override def getPrimaryKey: UniqueKey[LanguageRecord] = Keys.LANGUAGE_PKEY
  override def as(alias: String): Language = new Language(DSL.name(alias), this)
  override def as(alias: Name): Language = new Language(alias, this)
  override def as(alias: Table[_]): Language = new Language(alias.getQualifiedName(), this)

  /**
   * Rename this table
   */
  override def rename(name: String): Language = new Language(DSL.name(name), null)

  /**
   * Rename this table
   */
  override def rename(name: Name): Language = new Language(name, null)

  /**
   * Rename this table
   */
  override def rename(name: Table[_]): Language = new Language(name.getQualifiedName(), null)

  // -------------------------------------------------------------------------
  // Row3 type methods
  // -------------------------------------------------------------------------
  override def fieldsRow: Row3[Long, String, LocalDateTime] = super.fieldsRow.asInstanceOf[ Row3[Long, String, LocalDateTime] ]

  /**
   * Convenience mapping calling {@link #convertFrom(Function)}.
   */
  def mapping[U](from: (Long, String, LocalDateTime) => U): SelectField[U] = convertFrom(r => from.apply(r.value1(), r.value2(), r.value3()))

  /**
   * Convenience mapping calling {@link #convertFrom(Class, Function)}.
   */
  def mapping[U](toType: Class[U], from: (Long, String, LocalDateTime) => U): SelectField[U] = convertFrom(toType,r => from.apply(r.value1(), r.value2(), r.value3()))
}
