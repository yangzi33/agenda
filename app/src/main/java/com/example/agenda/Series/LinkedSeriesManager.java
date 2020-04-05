package series;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import event.Event;

public class LinkedSeriesManager {


    public static ArrayList<LinkedSeries> allLinkedSeries = LinkedSeriesIO.readLinkedSeriesData();

    public LinkedSeriesManager() {
    }

    public ArrayList<LinkedSeries> getAllLinkedSeries() {
        return allLinkedSeries;
    }

    public static void addNewSeries(String seriesName){
        int numLSeries = allLinkedSeries.size() + 1;
        String seriesId = "linked" + numLSeries;

        LinkedSeries newSeries = new LinkedSeries(seriesName, seriesId);
        allLinkedSeries.add(newSeries);
    }



}
