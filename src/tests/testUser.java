package tests;

import dao.DAOFactory;
import models.UserModel;

import java.sql.SQLException;
import java.util.List;

import static javafx.application.Application.launch;

public class testUser {

    public static void main(String[] args) {

        try {
                UserModel model = new UserModel();
                model.setNom("thonon");
                model.setPrenom("cedric");
                model.setPassword("12345678");
                model.setLogin("446207070");
                model.setRef_id_sections(1);
                DAOFactory.getInstance().getUserDAO().insert(model);





        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
