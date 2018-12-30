package models;

import javafx.beans.property.StringProperty;

/**
 * @class class model comprenant les informations sur un evenement
 */

public class EventModel extends ModelBase {

    private StringProperty start_time;

    private StringProperty end_time;

    public String getStart_time() {
        return start_time.get();
    }

    public StringProperty start_timeProperty() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time.set(start_time);
    }

    public String getEnd_time() {
        return end_time.get();
    }

    public StringProperty end_timeProperty() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time.set(end_time);
    }
}
