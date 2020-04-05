package series;

import event.Event;
import event.EventManager;
import event.ReadWriteCSV;
import sun.util.resources.CalendarData;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class RepeatSeries extends Series {

    protected String name;

    protected String startTime;

    protected String endTime;

    protected String frequency;

    protected String frequencyEnd;

    protected ArrayList<Event> eventArray;

    protected ArrayList<String> eventIdArray;

    public RepeatSeries(String name, String seriesId, String startTime, String endTime, String frequency,
                        String frequencyEnd) {
        super(name, seriesId);
        this.startTime = startTime;
        this.endTime = endTime;
        this.frequency = frequency;
        this.frequencyEnd = frequencyEnd;
        createRepeatingEvents();
    }

    public void createRepeatingEvents() {
//        String sTime = startTime.substring(10, startTime.length());
//        String eTime = endTime.substring(10, endTime.length());
//
//
//        String startDate = startTime.substring(0, 10);
//        String endDate = endTime.substring(0, 10);

        SimpleDateFormat startSDF = new SimpleDateFormat("dd-MM-yyyy HH:MM");
        SimpleDateFormat endSDF = new SimpleDateFormat("dd-MM-yyyy HH:MM");
        SimpleDateFormat terminateSDF = new SimpleDateFormat("dd-MM-yyyy HH:MM");

        Calendar startCalendar = Calendar.getInstance();
        Calendar endCalendar = Calendar.getInstance();
        Calendar terminateCalendar = Calendar.getInstance();

        try {
            startCalendar.setTime(startSDF.parse(startTime));
            endCalendar.setTime(endSDF.parse(endTime));
            terminateCalendar.setTime(terminateSDF.parse(frequencyEnd));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        while (startCalendar.getTime().before(terminateCalendar.getTime())) {
            String eventStartDate = startSDF.format(startCalendar.getTime());
            String eventEndDate = endSDF.format(endCalendar.getTime());

            int eventIdNum = EventManager.allEvents.size() + 1;
            String eventId = "event" + eventIdNum;

            Event newEvent = new Event(name, eventStartDate, eventEndDate, eventId);
            EventManager.allEvents.add(newEvent);
            eventArray.add(newEvent);

            switch (frequency){
                case "monthly":
                    startCalendar.add(Calendar.MONTH, 1);
                case "weekly":
                    startCalendar.add(Calendar.WEEK_OF_MONTH, 1);
                case "daily":
                    startCalendar.add(Calendar.DAY_OF_MONTH, 1);
            }
        }
    }

    public String getFrequency() {
        return frequency;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getFrequencyEnd() {
        return frequencyEnd;
    }
}
