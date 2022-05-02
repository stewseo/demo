/*
 * This file is generated by jOOQ.
 */
package org.jooq.demo.db.tables.pojos;


import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public record Payment(
    Long          paymentId,
    Long          customerId,
    Long          staffId,
    Long          rentalId,
    BigDecimal    amount,
    LocalDateTime paymentDate
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
        final Payment other = (Payment) obj;
        if (this.paymentId == null) {
            if (other.paymentId != null)
                return false;
        }
        else if (!this.paymentId.equals(other.paymentId))
            return false;
        if (this.customerId == null) {
            if (other.customerId != null)
                return false;
        }
        else if (!this.customerId.equals(other.customerId))
            return false;
        if (this.staffId == null) {
            if (other.staffId != null)
                return false;
        }
        else if (!this.staffId.equals(other.staffId))
            return false;
        if (this.rentalId == null) {
            if (other.rentalId != null)
                return false;
        }
        else if (!this.rentalId.equals(other.rentalId))
            return false;
        if (this.amount == null) {
            if (other.amount != null)
                return false;
        }
        else if (!this.amount.equals(other.amount))
            return false;
        if (this.paymentDate == null) {
            if (other.paymentDate != null)
                return false;
        }
        else if (!this.paymentDate.equals(other.paymentDate))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.paymentId == null) ? 0 : this.paymentId.hashCode());
        result = prime * result + ((this.customerId == null) ? 0 : this.customerId.hashCode());
        result = prime * result + ((this.staffId == null) ? 0 : this.staffId.hashCode());
        result = prime * result + ((this.rentalId == null) ? 0 : this.rentalId.hashCode());
        result = prime * result + ((this.amount == null) ? 0 : this.amount.hashCode());
        result = prime * result + ((this.paymentDate == null) ? 0 : this.paymentDate.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Payment (");

        sb.append(paymentId);
        sb.append(", ").append(customerId);
        sb.append(", ").append(staffId);
        sb.append(", ").append(rentalId);
        sb.append(", ").append(amount);
        sb.append(", ").append(paymentDate);

        sb.append(")");
        return sb.toString();
    }
}
