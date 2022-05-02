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
public record Address(
    Long          addressId,
    String        address,
    String        address2,
    String        district,
    Long          cityId,
    String        postalCode,
    String        phone,
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
        final Address other = (Address) obj;
        if (this.addressId == null) {
            if (other.addressId != null)
                return false;
        }
        else if (!this.addressId.equals(other.addressId))
            return false;
        if (this.address == null) {
            if (other.address != null)
                return false;
        }
        else if (!this.address.equals(other.address))
            return false;
        if (this.address2 == null) {
            if (other.address2 != null)
                return false;
        }
        else if (!this.address2.equals(other.address2))
            return false;
        if (this.district == null) {
            if (other.district != null)
                return false;
        }
        else if (!this.district.equals(other.district))
            return false;
        if (this.cityId == null) {
            if (other.cityId != null)
                return false;
        }
        else if (!this.cityId.equals(other.cityId))
            return false;
        if (this.postalCode == null) {
            if (other.postalCode != null)
                return false;
        }
        else if (!this.postalCode.equals(other.postalCode))
            return false;
        if (this.phone == null) {
            if (other.phone != null)
                return false;
        }
        else if (!this.phone.equals(other.phone))
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
        result = prime * result + ((this.addressId == null) ? 0 : this.addressId.hashCode());
        result = prime * result + ((this.address == null) ? 0 : this.address.hashCode());
        result = prime * result + ((this.address2 == null) ? 0 : this.address2.hashCode());
        result = prime * result + ((this.district == null) ? 0 : this.district.hashCode());
        result = prime * result + ((this.cityId == null) ? 0 : this.cityId.hashCode());
        result = prime * result + ((this.postalCode == null) ? 0 : this.postalCode.hashCode());
        result = prime * result + ((this.phone == null) ? 0 : this.phone.hashCode());
        result = prime * result + ((this.lastUpdate == null) ? 0 : this.lastUpdate.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Address (");

        sb.append(addressId);
        sb.append(", ").append(address);
        sb.append(", ").append(address2);
        sb.append(", ").append(district);
        sb.append(", ").append(cityId);
        sb.append(", ").append(postalCode);
        sb.append(", ").append(phone);
        sb.append(", ").append(lastUpdate);

        sb.append(")");
        return sb.toString();
    }
}
