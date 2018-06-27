package fr.ubordeaux.ao.references.domain.model;

import java.util.UUID;

public class ReferenceId {
    private UUID id;

    public ReferenceId() {
        this.id = UUID.randomUUID();
    }

    public ReferenceId(String uuid) {
        this.id = UUID.fromString(uuid);
    }
}