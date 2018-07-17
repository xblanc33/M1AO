package fr.ubordeaux.ao.productmanagement.domain.application;

import fr.ubordeaux.ao.productmanagement.domain.model.exception.ProductManagementException;
import fr.ubordeaux.ao.productmanagement.domain.model.type.ReferenceId;

public class CreateReferenceCommand {
    private ReferenceId id;
    private String name;
    private String description;

    public CreateReferenceCommand(ReferenceId id, String name, String description) {
        if (id == null) throw new ProductManagementException("Id of reference (AddReference) cannot be null");
        if (name == null) throw new ProductManagementException("Name of reference (AddReference) cannot be null");
        if (description == null) throw new ProductManagementException("Description of Product (AddReference) cannot be null");
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public ReferenceId getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

}