package fr.ubordeaux.ao.productmanagement.domain.model.concept;

import fr.ubordeaux.ao.productmanagement.domain.model.type.ReferenceId;

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
        this.id = id;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setDescription(String description) {
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
}