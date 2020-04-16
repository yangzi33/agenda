package com.example.agenda.event;

public class Event {

    private String id;
    public String name;
    public String startTime;
    public String endTime;
    private boolean isPostponedIndefinitely;

    public Event(String name, String startTime, String endTime, String id) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.id = id;
        this.isPostponedIndefinitely = false;
    }

    public String getName() {
        return name;
    }

    public String getStartTime() {
        return startTime;
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
