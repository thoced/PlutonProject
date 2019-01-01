package tests;

import config.SingletonConnection;
import dao.DAOFactory;
import dao.IdentiteDAO;
import models.IdentiteModel;

import java.sql.SQLException;
import java.util.List;

public class testIdentite {

    public static void main(String[] args) {

       testIdentite testIdentite = new testIdentite();
       testIdentite.delete();
    }

    public void insert(){
        IdentiteModel model = new IdentiteModel();
        model.setNumero("32494386461");
        model.setIdentite("Thonon cedric");
        model.setRef_id_dossiers(2);
        try {
            ((IdentiteDAO)DAOFactory.getInstance().getIdentiteDAO()).insert(model);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void findNumero(){
        try {
            List<IdentiteModel> list = ((IdentiteDAO)DAOFactory.getInstance().getIdentiteDAO()).findNumero("386461");
            if(list != null){
                for(IdentiteModel m : list){
                    System.out.println(m);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void findIdentite(){
        try {
            List<IdentiteModel> list = ((IdentiteDAO)DAOFactory.getInstance().getIdentiteDAO()).findIdentite("ThONON ced");
            if(list != null){
                for(IdentiteModel m : list){
                    System.out.println(m);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(){
        try {
            ((IdentiteDAO)DAOFactory.getInstance().getIdentiteDAO()).delete(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
