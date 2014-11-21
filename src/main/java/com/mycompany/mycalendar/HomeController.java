package com.mycompany.mycalendar;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.mycalendar.dao.EventAttendeeDao;
import com.mycompany.mycalendar.dao.JdbcCalendarUserDao;
import com.mycompany.mycalendar.dao.JdbcEventAttendeeDao;
import com.mycompany.mycalendar.dao.JdbcEventDao;
import com.mycompany.mycalendar.domain.CalendarUser;
import com.mycompany.mycalendar.domain.Event;
import com.mycompany.mycalendar.domain.EventAttendee;
import com.mycompany.mycalendar.service.CalendarService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	private CalendarService calendarService;	

	private CalendarUser[] calendarUsers = null;
	private Event[] events = null;
	private EventAttendee[] eventAttentees = null;

	private Random random = new Random(System.currentTimeMillis());

	private static final int numInitialNumUsers = 12;
	private static final int numInitialNumEvents = 4;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		calendarUsers = new CalendarUser[numInitialNumUsers];
		events = new Event[numInitialNumEvents];
		eventAttentees = new EventAttendee[numInitialNumEvents];

		this.calendarService.deleteAllUsers();
		this.calendarService.deleteAllEvents();
		this.calendarService.deleteAllEventAttendees();

		for (int i = 0; i < numInitialNumUsers; i++) {
			calendarUsers[i] = new CalendarUser();
			calendarUsers[i].setEmail("user" + i + "@example.com");
			calendarUsers[i].setPassword("user" + i);
			calendarUsers[i].setName("User" + i);
			calendarUsers[i].setId(calendarService.createUser(calendarUsers[i]));
		}

		for (int i = 0; i < numInitialNumEvents; i++) {
			events[i] = new Event();
			events[i].setSummary("Event Summary - " + i);
			events[i].setDescription("Event Description - " + i);
			events[i].setOwner(calendarUsers[random.nextInt(numInitialNumUsers)]);
			switch (i) {
			case 0:
				events[i].setNumLikes(0);  							
				break;
			case 1:
				events[i].setNumLikes(9);
				break;
			case 2:
				events[i].setNumLikes(10);
				break;
			case 3:
				events[i].setNumLikes(10);
				break;
			}
			events[i].setId(calendarService.createEvent(events[i]));
		}

		for (int i = 0; i < numInitialNumEvents; i++) {
			eventAttentees[i] = new EventAttendee();
			eventAttentees[i].setEvent(events[i]);
			eventAttentees[i].setAttendee(calendarUsers[3 * i ]);
			eventAttentees[i].setAttendee(calendarUsers[3 * i + 1]);
			eventAttentees[i].setAttendee(calendarUsers[3 * i + 2]);
			eventAttentees[i].setId(calendarService.createEventAttendee(eventAttentees[i]));
		}

		/*
		 * 
		 * DB내의 값을 불러오는 버젼으로 해보려 했으나 원하는 값이 모두 출력 되지 않아 주석처리 해놨습니다.
		 * 

		List<EventAttendee> eventAttendee = new ArrayList<EventAttendee>();
		List<Event> event = new ArrayList<Event>();
		List<CalendarUser> calendarUser = new ArrayList<CalendarUser>();

		eventAttendee = this.calendarService.getAllEventAttendee();
		event = this.calendarService.getAllEvents();
		calendarUser = this.calendarService.getAllCalendarUser();

		model.addAttribute("event",event);
		model.addAttribute("eventAttendee",eventAttendee);
		model.addAttribute("calendarUser",calendarUser);
		
		 */

		model.addAttribute("calendarUsers", calendarUsers);
		model.addAttribute("events", events);
		model.addAttribute("eventAttentees",eventAttentees);

		return "home";
	}
}
