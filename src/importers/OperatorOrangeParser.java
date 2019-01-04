package importers;

import models.EventModel;
import models.IdentiteModel;
import models.ObservationModel;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.ArrayList;
import java.util.List;

public class OperatorOrangeParser extends OperatorParser {

    private final String operatorName = "ORANGE";

    private XSSFRow rowLabels;

    public OperatorOrangeParser(XSSFWorkbook wb) {
        super(wb);
    }


    @Override
    public String getNameOperator() {
        return operatorName;
    }

    @Override
    public long getNbIdentites() {
        return 0;
    }

    @Override
    public long getNbEvents() {
        return 0;
    }

    @Override
    public long getNbIdentitesUnknow() {
        return 0;
    }

    @Override
    public List<IdentiteModel> getIdentites(ObservationModel observationModel) {

        // recherche de la première ligne
        XSSFSheet sheet = wb.getSheetAt(0);
        XSSFRow rowLabels = getRowLabels(sheet);
        // recherche de la colonne "Partner GSM" sur base du rowLabels
        XSSFCell cellPartner = getCellLabelPartner(rowLabels);
        // retour des couples numero et nom
        int numRow = rowLabels.getRowNum();
        int lastRow = sheet.getLastRowNum();
        int cellNum = cellPartner.getColumnIndex();
        List<IdentiteModel> listIdentites = new ArrayList<IdentiteModel>();
        for(int i=numRow + 1; i <= lastRow ; i++){
            XSSFCell cell = sheet.getRow(i).getCell(cellNum);
            if(cell != null){
                IdentiteModel model = new IdentiteModel();
                if(cell.getCellType() == CellType.STRING){
                    model.setNumero(cell.getStringCellValue().trim());
                    model.setIdentite(sheet.getRow(i).getCell(cellNum + 4).getStringCellValue().trim() + " " + sheet.getRow(i).getCell(cellNum + 5).getStringCellValue().trim() + " " +
                            sheet.getRow(i).getCell(cellNum + 6).getStringCellValue().trim() + " " + sheet.getRow(i).getCell(cellNum + 7).getStringCellValue().trim() + " " +
                            sheet.getRow(i).getCell(cellNum + 8).getStringCellValue().trim());
                    model.setRef_id_observations(observationModel.getId());
                    listIdentites.add(model);
                }
            }
        }


        return listIdentites;

    }

    @Override
    public List<IdentiteModel> getIdentitesUnknow() {
        return null;
    }

    @Override
    public List<EventModel> getEvents() {
        return null;
    }

    private XSSFCell getCellLabelPartner(XSSFRow rowLabels){

        int first = rowLabels.getFirstCellNum();
        int last = rowLabels.getLastCellNum();
        for(int i = first; i < last ; i++){
            XSSFCell cell = rowLabels.getCell(i);
            if(cell != null && cell.getCellType() == CellType.STRING){
                if(cell.getStringCellValue().startsWith("Partner GSM")){
                    return cell;
                }
            }
        }
        return null;
    }

    private XSSFRow getRowLabels(XSSFSheet sheet){
        int first = sheet.getFirstRowNum();
        int last = sheet.getLastRowNum();
        for(int i=first; i < last ; i++){
            XSSFRow currentRow = sheet.getRow(i);
            if(currentRow != null){
                XSSFCell cell = currentRow.getCell(0);
                if(cell != null && cell.getCellType() == CellType.STRING){
                    if(cell.getStringCellValue().startsWith("Start Session")){
                        return currentRow;
                    }

                }
            }
        }
        return null;
    }


}
