package series;

import event.Event;

import java.util.*;

public class LinkedSeries extends Series {
    /*
    * An LinkedSeries. Users select Events to add to this series.
    *
    */
    protected static String LINKED_DATA_FILE = "./data/linkedData.csv";

    protected ArrayList<Event> eventArray;

    protected ArrayList<String> eventIdArray = new ArrayList<>();

    private String name;

    public LinkedSeries(String seriesName, String seriesId) {
        super(seriesName, seriesId);
    }

}
