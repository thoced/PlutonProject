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
       testIdentite.findObservation();
    }

    public void insert(){
        IdentiteModel model = new IdentiteModel();
        model.setNumero("32465335474");
        model.setIdentite("DENIS Meliza");
        model.setRef_id_observations(3);
        try {
            ((IdentiteDAO)DAOFactory.getInstance().getIdentiteDAO()).insert(model);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void find(){
        try {
            IdentiteModel model = ((IdentiteDAO)DAOFactory.getInstance().getIdentiteDAO()).find(17);


                    System.out.println(model);


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void findNumero(){
        try {
            List<IdentiteModel> list = ((IdentiteDAO)DAOFactory.getInstance().getIdentiteDAO()).findNumero("74");
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
            List<IdentiteModel> list = ((IdentiteDAO)DAOFactory.getInstance().getIdentiteDAO()).findIdentite("DENIS");
            if(list != null){
                for(IdentiteModel m : list){
                    System.out.println(m);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void findObservation(){
        try {
            List<IdentiteModel> list = ((IdentiteDAO)DAOFactory.getInstance().getIdentiteDAO()).selectFromForeignKey(3);
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
