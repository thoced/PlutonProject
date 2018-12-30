package models;

import javafx.beans.property.StringProperty;

/**
 * @class class model comprenant les informations sur une section
 */

public class SectionModel extends ModelBase{

    private StringProperty name;

    private StringProperty comment;

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
}
