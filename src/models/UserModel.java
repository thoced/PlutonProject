package models;

import javafx.beans.property.StringProperty;

/**
 * @class class model contenant les informations sur un utilisateur
 */

public class UserModel extends ModelBase {

    private StringProperty nom;

    private StringProperty prenom;

    private StringProperty login;

    private StringProperty password;

    private long ref_id_sections;


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

    public String getLogin() {
        return login.get();
    }

    public StringProperty loginProperty() {
        return login;
    }

    public void setLogin(String login) {
        this.login.set(login);
    }

    public String getPassword() {
        return password.get();
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public long getRef_id_sections() {
        return ref_id_sections;
    }

    public void setRef_id_sections(long ref_id_sections) {
        this.ref_id_sections = ref_id_sections;
    }
}
