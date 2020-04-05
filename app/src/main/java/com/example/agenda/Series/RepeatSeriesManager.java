package series;

import event.Event;
import event.ReadWriteCSV;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class RepeatSeriesManager {

    private static String REPEAT_DATA_FILE = "./data/repeatData.csv";

    public static ArrayList<RepeatSeries> allRepeatSeries = RepeatSeriesIO.readRepeatData();

    private String frequency;

    public RepeatSeriesManager() {
    }

    public static void addNewSeries(String name, String startTime, String endTime,
                                    String frequency, String frequencyEnd) {
        int numRSeries = allRepeatSeries.size() + 1;
        String seriesId = "repeat" + numRSeries;

        RepeatSeries newSeries = new RepeatSeries(name, seriesId, startTime, endTime, frequency, frequencyEnd);
        allRepeatSeries.add(newSeries);
    }

}
