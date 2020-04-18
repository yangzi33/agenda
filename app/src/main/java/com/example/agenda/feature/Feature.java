package com.example.agenda.feature;


import com.example.agenda.event.Event;

import java.util.ArrayList;

public abstract class Feature {
    /*
     *features.feature.Feature of an event, has sub class memo and tag
     * */


    /** Abstract get all events inside the feature.*/
    public abstract ArrayList<Event> getEvents();
    /** Abstract get all event ids inside the feature.*/
    public abstract ArrayList<String> getIds();



}
