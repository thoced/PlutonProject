package models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @class class model pour les identites
 * @author thonon cedric
 */

public class IdentiteModel extends ModelBase {

    private StringProperty numero = new SimpleStringProperty();

    private StringProperty nom = new SimpleStringProperty();

    private StringProperty prenom = new SimpleStringProperty();

    private StringProperty adresse = new SimpleStringProperty();

    private StringProperty num = new SimpleStringProperty();

    private StringProperty boite = new SimpleStringProperty();

    private StringProperty codePostal = new SimpleStringProperty();

    private StringProperty ville = new SimpleStringProperty();

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

    public String getNom() {
        return nom.get();
    }

    public StringProperty nomProperty() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom.set(nom);
    }

    public String getPrenom() {
        return prenom.get();
    }

    public StringProperty prenomProperty() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom.set(prenom);
    }

    public String getAdresse() {
        return adresse.get();
    }

    public StringProperty adresseProperty() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse.set(adresse);
    }

    public String getNum() {
        return num.get();
    }

    public StringProperty numProperty() {
        return num;
    }

    public void setNum(String num) {
        this.num.set(num);
    }

    public String getBoite() {
        return boite.get();
    }

    public StringProperty boiteProperty() {
        return boite;
    }

    public void setBoite(String boite) {
        this.boite.set(boite);
    }

    public String getCodePostal() {
        return codePostal.get();
    }

    public StringProperty codePostalProperty() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal.set(codePostal);
    }

    public String getVille() {
        return ville.get();
    }

    public StringProperty villeProperty() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville.set(ville);
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
                ", nom=" + nom +
                ", prenom=" + prenom +
                ", adresse=" + adresse +
                ", num=" + num +
                ", boite=" + boite +
                ", codePostal=" + codePostal +
                ", ville=" + ville +
                ", ref_id_observations=" + ref_id_observations +
                '}';
    }
}
