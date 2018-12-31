package tests;

import dao.DAOFactory;
import models.UserModel;

import java.sql.SQLException;
import java.util.List;

import static javafx.application.Application.launch;

public class testUser {

    public static void main(String[] args) {

        try {
                DAOFactory.getInstance().getUserDAO().delete(2);





        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
