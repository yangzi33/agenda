package series;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class RepeatSeriesIO {

    protected static String REPEAT_DATA_FILE = "./data/repeatData.csv";

    public RepeatSeriesIO() {}

    public static ArrayList<RepeatSeries> readRepeatData() {
        ArrayList<RepeatSeries> series = new ArrayList<>();
        File seriesFile = new File(REPEAT_DATA_FILE);
        if (seriesFile.exists()) {
            try {
                Scanner scanner = new Scanner(seriesFile);
                while (scanner.hasNextLine()) {
                    String curr = scanner.nextLine().trim();
                    String[] attr = curr.split(",");
                    String seriesId = attr[0];
                    String seriesName = attr[1];
                    String seriesStartTime = attr[2];
                    String seriesEndTime = attr[3];
                    String seriesFrequency = attr[4];
                    String frequencyEnd = attr[5];
                    ArrayList<String> seriesEvents = new ArrayList<>(Arrays.asList(attr).subList(6, attr.length));

                    RepeatSeries currRepeatSeries = new RepeatSeries(
                            seriesName, seriesId, seriesStartTime, seriesEndTime, seriesFrequency, frequencyEnd
                    );
                    currRepeatSeries.eventIdArray = seriesEvents;
                    series.add(currRepeatSeries);
                }
                scanner.close();
            } catch (FileNotFoundException ex){
                ex.printStackTrace();
            }
        } else {
            System.out.println("No Valid RepeatSeries File Found");
        }
//        LinkedSeriesManager.allLinkedSeries = series;
        return series;
    }

    /**
     * Writes the events list into the event data file.
     *
     * @param allRepeatSeries - the list of all RepeatSeries to save into the event data file
     * @return - true if the write was successful, false otherwise.
     */
    public static boolean writeRepeatData(ArrayList<RepeatSeries> allRepeatSeries) {
        try {
            File linkedSeriesFile = new File(REPEAT_DATA_FILE);
            if (!linkedSeriesFile.exists()) {
                if (!linkedSeriesFile.createNewFile()) {
                    return false;
                }
            }
            FileWriter writer = new FileWriter(linkedSeriesFile);
            for (RepeatSeries curr : allRepeatSeries) {
                List<String> curr_line_lst = Arrays.asList(
                        curr.getSeriesId(),
                        curr.getSeriesName()
                );

                curr_line_lst.addAll(curr.getSeriesEventsId());

                writer.write(String.join(",", curr_line_lst) +
                        System.lineSeparator());
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

}
