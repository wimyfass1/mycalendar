package com.mycompany.mycalendar.service;

import java.util.List;

//import org.springframework.transaction.annotation.Transactional;

import com.mycompany.mycalendar.domain.CalendarUser;
import com.mycompany.mycalendar.domain.Event;
import com.mycompany.mycalendar.domain.EventAttendee;

public interface CalendarService {
	/* CalendarUser */
    public CalendarUser getUser(int id);

    public CalendarUser getUserByEmail(String email);

    public List<CalendarUser> getUsersByEmail(String partialEmail);
    
    public List<CalendarUser> getAllCalendarUser();

    public int createUser(CalendarUser user);
    
    public void deleteAllUsers();
    
    /* Event */
    public Event getEvent(int eventId);

    public List<Event> getEventForOwner(int ownerUserId);

    public List<Event> getAllEvents();

    public int createEvent(Event event);
    
    public void deleteAllEvents();
    
    /* EventAttendee */
    public List<EventAttendee> getEventAttendeeByEventId(int eventId);
    
    public List<EventAttendee> getEventAttendeeByAttendeeId(int attendeeId);
    
    public List<EventAttendee> getAllEventAttendee();

    public int createEventAttendee(EventAttendee eventAttendee);

    public void deleteEventAttendee(int id);
    
    public void deleteAllEventAttendees();
    
	/* upgradeEventLevels */
	public void upgradeEventLevels() throws Exception;

	public boolean canUpgradeEventLevel(Event event);
	
	public void upgradeEventLevel(Event event);
}