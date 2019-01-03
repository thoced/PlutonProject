package importers;

import models.EventModel;
import models.IdentiteModel;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.List;

public abstract class OperatorParser {

    protected final XSSFWorkbook wb;

    public OperatorParser(XSSFWorkbook wb){

        this.wb = wb;
    }
    public abstract String getNameOperator();
    public abstract long getNbIdentites();
    public abstract long getNbEvents();
    public abstract List<IdentiteModel> getIdentites();
    public abstract List<EventModel> getEvents();

}
