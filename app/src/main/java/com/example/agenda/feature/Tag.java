package com.example.agenda.feature;


import com.example.agenda.event.Event;

import java.util.ArrayList;

public class Tag extends Feature {
    /**name of the tag.*/
    public String Name;
    /**all events inside the tag.*/
    public ArrayList<Event> tagEvents = new ArrayList<>();


    public void addEvent(Event event) {
        tagEvents.add(event);
    }

    public void deleteEvent(Event event){
        tagEvents.remove(event);}

    /**
     * Gets the tag's events
     *
     * @return - all events inside the tag
     */
    public ArrayList<Event> getEvents(){
        return tagEvents;
    }

    public void setName(String name){
        Name = name;
    }

    /**
     * Gets the tag's name
     *
     * @return - the tag's name
     */
    public String getName(){return Name;}

    /**
     * Gets the tag's event ids
     *
     * @return - the tag's event ids
     */
    public ArrayList<String> getIds(){
        ArrayList<String> ids = new ArrayList<>();
        for (int i = 0; i < tagEvents.size(); i++){
//            ids.add(tagEvents.get(i).getEventId());
        }
        return ids;

    }

}
