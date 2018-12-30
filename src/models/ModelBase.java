package models;

/**
 * @class class de base des models
 */

public class ModelBase {
    protected long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ModelBase{" +
                "id=" + id +
                '}';
    }
}
