package fr.ubordeaux.ao.productmanagement.domain.model.concept;

import java.util.Objects;

import fr.ubordeaux.ao.productmanagement.domain.exception.ProductManagementException;
import fr.ubordeaux.ao.productmanagement.domain.type.ReferenceId;

public class Reference {
    private ReferenceId id;
    private String name;
    private String description;

    public Reference(ReferenceId id, String name, String description) {
        this.setReferenceId(id);
        this.setName(name);
        this.setDescription(description);
    }

    private void setReferenceId(ReferenceId id) {
        if (id == null) throw new ProductManagementException("cannot create reference with null id");
        this.id = id;
    }

    private void setName(String name) {
        if (name == null) throw new ProductManagementException("cannot create reference with null name");
        this.name = name;
    }

    private void setDescription(String description) {
        if (description == null) throw new ProductManagementException("cannot create description with null name");
        this.description = description;
    }

    public String getName() {
        return this.name;
    }

    public ReferenceId getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Reference) {
            Reference otherReference = (Reference)other;
            boolean equals = this.getId().equals(otherReference.getId());
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
        return "Reference id="+id+ " name="+name+" description="+description;
    }
}