package tests;

import dao.DAOFactory;
import models.DossierModel;
import models.ObservationModel;

import java.sql.SQLException;
import java.util.List;

public class testObservation {

    public static void main(String[] args) {

        testObservation testObservation = new testObservation();
        testObservation.insert();

    }

    public void insert(){
        ObservationModel model = new ObservationModel();
        model.setNamefile("12345.xlsx");
        model.setComment("yooo");
        model.setRef_id_dossiers(1);
        try {
            DAOFactory.getInstance().getObservationDAO().insert(model);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void select(){
        try {
            List<ObservationModel> list = DAOFactory.getInstance().getObservationDAO().selectAll();
            for(ObservationModel model : list){
                System.out.println(model);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(){
        try {
            DAOFactory.getInstance().getDossierDAO().delete(1 );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
