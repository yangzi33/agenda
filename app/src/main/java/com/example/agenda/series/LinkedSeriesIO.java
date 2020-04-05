//package series;
//
//import event.Event;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Scanner;
//
//public class LinkedSeriesIO {
//
//    protected static String LINKED_DATA_FILE = "./data/linkedData.csv";
//
//    protected static ArrayList<LinkedSeries> allLinkedSeries = new ArrayList<>();
//
//    protected static ArrayList<String> allLinkedSeriesId = new ArrayList<>();
//
//    protected static ArrayList<String> allLinkedSeriesName = new ArrayList<>();
//
//    public LinkedSeriesIO() {}
//
//    public static ArrayList<LinkedSeries> readLinkedSeriesData() {
//        ArrayList<LinkedSeries> series = new ArrayList<>();
//        File seriesFile = new File(LINKED_DATA_FILE);
//        if (seriesFile.exists()) {
//            try {
//                Scanner scanner = new Scanner(seriesFile);
//                while (scanner.hasNextLine()) {
//                    String curr = scanner.nextLine().trim();
//                    String[] attr = curr.split(",");
//                    String seriesId = attr[0];
//                    String seriesName = attr[1];
//                    ArrayList<String> seriesEventsId = new ArrayList<>(Arrays.asList(attr).subList(2, attr.length));
//
//                    allLinkedSeriesId.add(seriesId);
//                    allLinkedSeriesName.add(seriesName);
//
//                    LinkedSeries currLinkedSeries = new LinkedSeries(seriesName, seriesId);
//                    currLinkedSeries.eventIdArray = seriesEventsId;
//                    series.add(currLinkedSeries);
//                    System.out.println("Line is invalid");
//                    System.out.println(curr);
//                }scanner.close();
//            } catch (FileNotFoundException ex){
//                ex.printStackTrace();
//            }
//        } else {
//            System.out.println("No Valid LinkedSeries File Found");
//        }
//        allLinkedSeries = series;
//        return series;
//    }
//
//    /**
//     * Writes the LinkedSeries list into the event data file.
//     *
//     * @param allLinkedSeries - the list of all LinkedSeries to save into the event data file
//     * @return - true if the write was successful, false otherwise.
//     */
//    public static boolean writeSeriesData(ArrayList<LinkedSeries> allLinkedSeries) {
//        try {
//            File linkedSeriesFile = new File(LINKED_DATA_FILE);
//            if (!linkedSeriesFile.exists()) {
//                if (!linkedSeriesFile.createNewFile()) {
//                    return false;
//                }
//            }
//            FileWriter writer = new FileWriter(linkedSeriesFile);
//            for (LinkedSeries curr : allLinkedSeries) {
//                List<String> curr_line_lst = Arrays.asList(
//                        curr.getSeriesId(),
//                        curr.getSeriesName()
//                );
//
//                curr_line_lst.addAll(curr.getSeriesEventsId());
//
//                writer.write(String.join(",", curr_line_lst) +
//                        System.lineSeparator());
//            }
//            writer.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return true;
//    }
//}
