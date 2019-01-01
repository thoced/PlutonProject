package tests;

import dao.DAOFactory;
import models.SectionModel;

import java.sql.SQLException;
import java.util.List;

public class testSection {

    public void addSection(){

        SectionModel model = new SectionModel();
        model.setName("Stupefiants");
        model.setComment("section du SLR");
        try {
            DAOFactory.getInstance().getSectionDAO().insert(model);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteSection(){

        try {
            DAOFactory.getInstance().getSectionDAO().delete(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void selectAll(){
        try {
            List<SectionModel> list = DAOFactory.getInstance().getSectionDAO().selectAll();
            for(SectionModel model : list)
                System.out.println(model);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(){
        SectionModel model = new SectionModel();
        model.setName("VMA");
        model.setComment("Section VOL et VMA");
        model.setId(2);
        try {
            DAOFactory.getInstance().getSectionDAO().update(model);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        try {
            SectionModel model = (SectionModel) DAOFactory.getInstance().getSectionDAO().find(2);

            testSection testSection = new testSection();
            testSection.addSection();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



}
