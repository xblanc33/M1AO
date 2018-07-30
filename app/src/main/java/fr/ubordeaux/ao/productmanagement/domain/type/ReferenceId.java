package fr.ubordeaux.ao.productmanagement.domain.type;

import java.util.Objects;
import java.util.UUID;

public class ReferenceId {
    private UUID id;

    public ReferenceId() {
        this.id = UUID.randomUUID();
    }

    public ReferenceId(String uuid) {
        this.id = UUID.fromString(uuid);
    }

    @Override
    public boolean equals(Object other) {
        if (! (other instanceof ReferenceId)) return false;
        return this.id.equals(((ReferenceId)other).id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return this.id.toString();
    }
}