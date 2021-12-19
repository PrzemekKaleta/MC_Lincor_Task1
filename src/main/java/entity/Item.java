package entity;

import java.util.StringJoiner;
import java.util.UUID;

public class Item {
    private UUID ID_uuid;

    private String name;

    public Item(UUID ID_uuid, String name) {
        this.ID_uuid = ID_uuid;
        this.name = name;
    }

    public UUID getID_uuid() {
        return ID_uuid;
    }

    public void setID_uuid(UUID ID_uuid) {
        this.ID_uuid = ID_uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Item.class.getSimpleName() + "[", "]")
                .add("ID_uuid=" + ID_uuid)
                .add("name='" + name + "'")
                .toString();
    }
}
