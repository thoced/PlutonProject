package models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @class class model pour les observations
 * @author thonon cedric
 */

public class ObservationModel extends ModelBase {

    private StringProperty namefile = new SimpleStringProperty();

    private StringProperty comment = new SimpleStringProperty();

    private long ref_id_dossiers;

    public String getNamefile() {
        return namefile.get();
    }

    public StringProperty namefileProperty() {
        return namefile;
    }

    public void setNamefile(String namefile) {
        this.namefile.set(namefile);
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

    public long getRef_id_dossiers() {
        return ref_id_dossiers;
    }

    public void setRef_id_dossiers(long ref_id_dossiers) {
        this.ref_id_dossiers = ref_id_dossiers;
    }

    @Override
    public String toString() {
        return super.toString() + " ObservationModel{" +
                "namefile=" + namefile +
                ", comment=" + comment +
                ", ref_id_dossiers=" + ref_id_dossiers +
                '}';
    }

}
