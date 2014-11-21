package com.mycompany.mycalendar.dao;

import java.util.List;

import com.mycompany.mycalendar.domain.Event;
import com.mycompany.mycalendar.domain.EventAttendee;
import com.mycompany.mycalendar.domain.EventLevel;

public interface EventDao {

    public Event findEvent(int eventId);

    public int createEvent(Event event);
    
    public void udpateEvent(Event event); 

    public List<Event> findForOwner(int ownerUserId);

    public List<Event> findAllEvents();
    
    public List<Event> findEventsByLevel(EventLevel eventLevel);
    
    public void deleteAll();
}