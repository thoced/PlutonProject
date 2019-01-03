package tests;

import importers.ImporterOperatorFactory;
import importers.OperatorException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.IOException;

public class testImporter {

    public static void main(String[] args) {

        testImporter testImporter = new testImporter();
        testImporter.load("/home/thonon/Bureau/testTelenet.xlsx");

    }

    public void load(String name){

        try {
            ImporterOperatorFactory.getInstance().getImporterParser(name);
        } catch (OperatorException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
    }
}
