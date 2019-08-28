package fr.ubordeaux.ao.domain.model;

import java.util.Objects;

import fr.ubordeaux.ao.domain.exception.ReferenceManagementException;
import fr.ubordeaux.ao.domain.type.Price;

public class Reference {
    private String id;
    private String name;
    private String description;
    private Price basePrice;

    public Reference(String id, String name, String desc, Price price) {
        this.setReferenceId(id);
        this.setName(name);
        this.setDescription(desc);
        this.setBasePrice(price);
    }

    private void setReferenceId(String id) {
        if (id == null) {
            String msg = "cannot create reference with null id";
            throw new ReferenceManagementException(msg);
        }
        this.id = id;
    }

    private void setName(String name) {
        if (name == null) {
            String msg = "cannot create reference with null name";
            throw new ReferenceManagementException(msg);
        }
        this.name = name;
    }

    private void setDescription(String description) {
        String msg = "cannot create reference with null description";
        if (description == null) {
            throw new ReferenceManagementException(msg);
        }
        this.description = description;
    }

    private void setBasePrice(Price basePrice) {
        if (basePrice == null) {
            String msg = "cannot create reference with null basePrice";
            throw new ReferenceManagementException(msg);
        }
        this.basePrice = basePrice;
    }

    public String getName() {
        return this.name;
    }

    public String getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    public Price getBasePrice() {
        return this.basePrice;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Reference) {
            Reference otherRef = (Reference) other;
            boolean equals = this.getId().compareTo(otherRef.getId()) == 0;
            return equals;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        String res = "Reference id=" + id;
        res = res + " name=" + name;
        res = res + " description=" + description;
        return  res;
    }
}
