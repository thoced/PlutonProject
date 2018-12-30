package tests;

import dao.DAOFactory;
import models.UserModel;

import java.sql.SQLException;
import java.util.List;

import static javafx.application.Application.launch;

public class testUser {

    public static void main(String[] args) {

        try {
            List<UserModel> list = DAOFactory.getInstance().getUserDAO().selectAll();

            for(UserModel m : list){
                System.out.println(m);
            }


           /* UserModel model = new UserModel();
            model.setNom("Denis");
            model.setPrenom("Meliza");
            model.setLogin("mel1989");
            model.setPassword("12345678");
            DAOFactory.getInstance().getUserDAO().insert(model);*/


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
