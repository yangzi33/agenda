package com.example.agenda.event;

public class Event {

    private String id;
    public String name;
    public String startTime;
    public String endTime;
    public String descriptions;
    private boolean isPostponedIndefinitely;

    public Event(String id, String name, String startTime, String endTime, String descriptions) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.id = id;
        this.isPostponedIndefinitely = false;
        this.descriptions = descriptions;
    }

    public String getName() {
        return name;
    }

    public String getStartDay() {
        return startTime.substring(0, 2);
    }

    public String getStartMonth() {
        return startTime.substring(3, 5);
    }

    public String getStartYear() {
        return startTime.substring(6, 10);
    }

    public String getStartMin() {
        return startTime.substring(14);
    }

    public String getStartHour() {
        return startTime.substring(11, 13);
    }

    public String getEndDay() {
        return endTime.substring(0, 2);
    }

    public String getEndMonth() {
        return endTime.substring(3, 5);
    }

    public String getEndYear() {
        return endTime.substring(6, 10);
    }

    public String getEndMin() {
        return endTime.substring(14);
    }

    public String getEndHour() {
        return endTime.substring(11, 13);
    }

    public String getStartTime() {
        return endTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getId() {
        return id;
    }


    /**
     * Postpone this event (if not already).
     * @return Returns true iff event is postponed.
     */
    public boolean postpone() {
        if (isPostponedIndefinitely) {
            return false;
        } else {
            isPostponedIndefinitely = true;
            return true;
        }
    }
}
