package tests;

import importers.ImporterOperatorFactory;
import importers.OperatorException;
import importers.OperatorOrangeParser;
import models.IdentiteModel;
import models.ObservationModel;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.IOException;
import java.util.List;

public class testImporter {

    public static void main(String[] args) {

        testImporter testImporter = new testImporter();
        testImporter.load("/home/thonon/Bureau/testOrange.xlsx");

    }

    public void load(String name){

        try {
            OperatorOrangeParser orangeParser = (OperatorOrangeParser) ImporterOperatorFactory.getInstance().getImporterParser(name);
            ObservationModel observationModel = new ObservationModel();
            observationModel.setId(2);
            List<IdentiteModel> listIdentites = orangeParser.getIdentites(observationModel);
            int i=0;
            for(IdentiteModel m : listIdentites){
                System.out.println("INDICE: " + i + " " + m);
                i++;
            }

        } catch (OperatorException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
    }
}
