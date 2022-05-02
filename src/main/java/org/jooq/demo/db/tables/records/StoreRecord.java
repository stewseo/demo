/*
 * This file is generated by jOOQ.
 */
package org.jooq.demo.db.tables.records;


import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.demo.db.tables.Store;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class StoreRecord extends UpdatableRecordImpl<StoreRecord> implements Record4<Long, Long, Long, LocalDateTime> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.store.store_id</code>.
     */
    public void setStoreId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.store.store_id</code>.
     */
    public Long getStoreId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.store.manager_staff_id</code>.
     */
    public void setManagerStaffId(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.store.manager_staff_id</code>.
     */
    public Long getManagerStaffId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>public.store.address_id</code>.
     */
    public void setAddressId(Long value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.store.address_id</code>.
     */
    public Long getAddressId() {
        return (Long) get(2);
    }

    /**
     * Setter for <code>public.store.last_update</code>.
     */
    public void setLastUpdate(LocalDateTime value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.store.last_update</code>.
     */
    public LocalDateTime getLastUpdate() {
        return (LocalDateTime) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row4<Long, Long, Long, LocalDateTime> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    @Override
    public Row4<Long, Long, Long, LocalDateTime> valuesRow() {
        return (Row4) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return Store.STORE.STORE_ID;
    }

    @Override
    public Field<Long> field2() {
        return Store.STORE.MANAGER_STAFF_ID;
    }

    @Override
    public Field<Long> field3() {
        return Store.STORE.ADDRESS_ID;
    }

    @Override
    public Field<LocalDateTime> field4() {
        return Store.STORE.LAST_UPDATE;
    }

    @Override
    public Long component1() {
        return getStoreId();
    }

    @Override
    public Long component2() {
        return getManagerStaffId();
    }

    @Override
    public Long component3() {
        return getAddressId();
    }

    @Override
    public LocalDateTime component4() {
        return getLastUpdate();
    }

    @Override
    public Long value1() {
        return getStoreId();
    }

    @Override
    public Long value2() {
        return getManagerStaffId();
    }

    @Override
    public Long value3() {
        return getAddressId();
    }

    @Override
    public LocalDateTime value4() {
        return getLastUpdate();
    }

    @Override
    public StoreRecord value1(Long value) {
        setStoreId(value);
        return this;
    }

    @Override
    public StoreRecord value2(Long value) {
        setManagerStaffId(value);
        return this;
    }

    @Override
    public StoreRecord value3(Long value) {
        setAddressId(value);
        return this;
    }

    @Override
    public StoreRecord value4(LocalDateTime value) {
        setLastUpdate(value);
        return this;
    }

    @Override
    public StoreRecord values(Long value1, Long value2, Long value3, LocalDateTime value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached StoreRecord
     */
    public StoreRecord() {
        super(Store.STORE);
    }

    /**
     * Create a detached, initialised StoreRecord
     */
    public StoreRecord(Long storeId, Long managerStaffId, Long addressId, LocalDateTime lastUpdate) {
        super(Store.STORE);

        setStoreId(storeId);
        setManagerStaffId(managerStaffId);
        setAddressId(addressId);
        setLastUpdate(lastUpdate);
    }

    /**
     * Create a detached, initialised StoreRecord
     */
    public StoreRecord(org.jooq.demo.db.tables.pojos.Store value) {
        super(Store.STORE);

        if (value != null) {
            setStoreId(value.storeId());
            setManagerStaffId(value.managerStaffId());
            setAddressId(value.addressId());
            setLastUpdate(value.lastUpdate());
        }
    }
}
