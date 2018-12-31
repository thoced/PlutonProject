package tests;

import dao.DAOFactory;
import models.DossierModel;
import models.SectionModel;

import java.sql.SQLException;
import java.util.List;

public class testDossier {

    public static void main(String[] args) {

        testDossier testDossier = new testDossier();
        testDossier.delete();

    }

    public void insert(){
        DossierModel model = new DossierModel();
        model.setName("LI_XATMAN");
        model.setComment("vendeur de drogue");
        model.setRef_id_sections(3);
        try {
            DAOFactory.getInstance().getDossierDAO().insert(model);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void select(){
        try {
            List<DossierModel> list = DAOFactory.getInstance().getDossierDAO().selectAll();
            for(DossierModel model : list){
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
