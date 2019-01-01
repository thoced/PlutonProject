package models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @class class model pour les identites
 * @author thonon cedric
 */

public class IdentiteModel extends ModelBase {

    private StringProperty numero = new SimpleStringProperty();

    private StringProperty identite = new SimpleStringProperty();

    private long ref_id_observations;

    public String getNumero() {
        return numero.get();
    }

    public StringProperty numeroProperty() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero.set(numero);
    }

    public String getIdentite() {
        return identite.get();
    }

    public StringProperty identiteProperty() {
        return identite;
    }

    public void setIdentite(String identite) {
        this.identite.set(identite);
    }

    public long getRef_id_observations() {
        return ref_id_observations;
    }

    public void setRef_id_observations(long ref_id_observations) {
        this.ref_id_observations = ref_id_observations;
    }

    @Override
    public String toString() {
        return super.toString() + " IdentiteModel{" +
                "numero=" + numero +
                ", identite=" + identite +
                ", ref_id_observations=" + ref_id_observations +
                '}';
    }
}
