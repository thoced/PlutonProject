package models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @class class model comprenant les informations sur un dossier
 */

public class DossierModel extends ModelBase {

    private StringProperty name = new SimpleStringProperty();

    private StringProperty comment = new SimpleStringProperty();

    private long ref_id_sections;

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getComment() {
        return comment.get();
    }

    public StringProperty commentProperty() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment.set(comment);
    }

    public long getRef_id_sections() {
        return ref_id_sections;
    }

    public void setRef_id_sections(long ref_id_sections) {
        this.ref_id_sections = ref_id_sections;
    }

    @Override
    public String toString() {
        return getName();
    }
}
