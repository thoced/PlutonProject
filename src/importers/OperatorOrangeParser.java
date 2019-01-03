package importers;

import models.EventModel;
import models.IdentiteModel;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.List;

public class OperatorOrangeParser extends OperatorParser {

    private final String operatorName = "ORANGE";

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
    public List<IdentiteModel> getIdentites() {
        return null;
    }

    @Override
    public List<EventModel> getEvents() {
        return null;
    }
}
