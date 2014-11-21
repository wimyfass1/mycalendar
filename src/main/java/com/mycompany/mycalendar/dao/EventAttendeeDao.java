package com.mycompany.mycalendar.dao;

import java.util.List;

import com.mycompany.mycalendar.domain.Event;
import com.mycompany.mycalendar.domain.EventAttendee;

public interface EventAttendeeDao {
    public List<EventAttendee> findEventAttendeeByEventId(int eventId);
    
    public List<EventAttendee> findEventAttendeeByAttendeeId(int attendeeId);
    
    public List<EventAttendee> findAllAttendee();

    public int createEventAttendee(EventAttendee eventAttendee);

    public void deleteEventAttendee(int id);
    
    public void deleteAll();

}