package fr.ubordeaux.ao.references.domain.model;

public class Reference {
    private ReferenceId id;
    private String name;
    private String description;

    public Reference(String name, String description) {
        this.setName(name);
        this.setDescription(description);
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
}