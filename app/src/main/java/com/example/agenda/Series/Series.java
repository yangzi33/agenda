package series;

import java.util.ArrayList;

import event.*;

public class Series {

    // Events' ID in this Series
    protected ArrayList<Event> eventArray = new ArrayList<>();

    protected ArrayList<String> eventIdArray = new ArrayList<>();

    protected String name;
    protected String seriesId;

    public Series(String seriesName, String seriesId) {
        this.name = seriesName;
        this.seriesId = seriesId;
    }

    public String getSeriesName() {
        return this.name;
    }

    public String getSeriesId() {
        return this.seriesId;
    }

    public ArrayList<String> getSeriesEventsId() {
        return this.eventIdArray;
    }


    public boolean addEvent(Event event) {
        if (!(eventIdArray.contains(event.getEventId()))) {
            eventIdArray.add(event.getEventId());
            return true;
        } else {
            System.out.println("Event already in this series.");
            return false;
        }
    }

    public boolean removeEvent(Event event) {
        if (eventIdArray.contains(event.getEventId())) {
            eventIdArray.remove(event.getEventId());
            System.out.println("Event removed. ");
            return true;
        } else {
            System.out.println("Error: no such event in this series.");
            return false;
        }
    }


}
