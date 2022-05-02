/*
 * This file is generated by jOOQ.
 */
package org.jooq.demo.db.tables.pojos;


import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public record Store(
    Long          storeId,
    Long          managerStaffId,
    Long          addressId,
    LocalDateTime lastUpdate
) implements Serializable {

    private static final long serialVersionUID = 1L;


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Store other = (Store) obj;
        if (this.storeId == null) {
            if (other.storeId != null)
                return false;
        }
        else if (!this.storeId.equals(other.storeId))
            return false;
        if (this.managerStaffId == null) {
            if (other.managerStaffId != null)
                return false;
        }
        else if (!this.managerStaffId.equals(other.managerStaffId))
            return false;
        if (this.addressId == null) {
            if (other.addressId != null)
                return false;
        }
        else if (!this.addressId.equals(other.addressId))
            return false;
        if (this.lastUpdate == null) {
            if (other.lastUpdate != null)
                return false;
        }
        else if (!this.lastUpdate.equals(other.lastUpdate))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.storeId == null) ? 0 : this.storeId.hashCode());
        result = prime * result + ((this.managerStaffId == null) ? 0 : this.managerStaffId.hashCode());
        result = prime * result + ((this.addressId == null) ? 0 : this.addressId.hashCode());
        result = prime * result + ((this.lastUpdate == null) ? 0 : this.lastUpdate.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Store (");

        sb.append(storeId);
        sb.append(", ").append(managerStaffId);
        sb.append(", ").append(addressId);
        sb.append(", ").append(lastUpdate);

        sb.append(")");
        return sb.toString();
    }
}
