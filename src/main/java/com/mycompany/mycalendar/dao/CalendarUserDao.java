package com.mycompany.mycalendar.dao;

import java.util.List;

import com.mycompany.mycalendar.domain.CalendarUser;
import com.mycompany.mycalendar.domain.Event;
import com.mycompany.mycalendar.domain.EventAttendee;

public interface CalendarUserDao {
    public CalendarUser findUser(int id);

    public CalendarUser findUserByEmail(String email);

    public List<CalendarUser> findUsersByEmail(String partialEmail);

    public int createUser(CalendarUser user);

    public List<CalendarUser> findAllusers();
    
    public void deleteAll();
}
