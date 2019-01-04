package importers;

import models.EventModel;
import models.IdentiteModel;
import models.ObservationModel;
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
    public abstract long getNbIdentitesUnknow();
    public abstract List<IdentiteModel> getIdentites(ObservationModel observationModel);
    public abstract List<IdentiteModel> getIdentitesUnknow();
    public abstract List<EventModel> getEvents();

}
