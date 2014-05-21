import edu.dio.calendar.CalendarEvent;
import edu.dio.calendar.CalendarService;
import edu.dio.calendar.EventStore;
import edu.dio.calendar.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {
        CalendarService calendarService=new CalendarService(new EventStore());
        List<Person> attenders = new ArrayList<Person>();
        attenders.add(new Person.Builder().setId(UUID.randomUUID()).setFirstName("Vladimir").setLastName("Kravchenko").setAge(32).setMail("vovchik33@gmail.com").build());
        attenders.add(new Person.Builder().setId(UUID.randomUUID()).setFirstName("Sergey").setLastName("Kravchenko").setAge(32).setMail("vovchik33@gmail.com").build());


        CalendarEvent event1 = new CalendarEvent.Builder()
                .setId(UUID.randomUUID())
                .setTitle("event1")
                .setDescription("description")
                .setStartDate("12-05-2014")
                .setStartDate("19-05-2014")
                .setAttenders(attenders)
                .build();
        CalendarEvent event2 = new CalendarEvent.Builder()
                .setId(UUID.randomUUID())
                .setTitle("event2")
                .setDescription("description")
                .setStartDate("18-05-2014")
                .setStartDate("19-05-2014")
                .build();
        CalendarEvent event3 = new CalendarEvent.Builder()
                .setId(UUID.randomUUID())
                .setTitle("event3")
                .setDescription("description")
                .setStartDate("12-04-2014")
                .setStartDate("19-04-2014")
                .setAttenders(attenders.subList(0,0))
                .build();
        CalendarEvent event4 = new CalendarEvent.Builder()
                .setId(UUID.randomUUID())
                .setTitle("event5")
                .setDescription("description")
                .setStartDate("12-04-2014")
                .setStartDate("19-04-2014")
                .setAttenders(attenders.subList(1,1))
                .build();
        CalendarEvent event5 = new CalendarEvent.Builder()
                .setId(UUID.randomUUID())
                .setTitle("event4")
                .setDescription("description")
                .setStartDate("12-04-2014")
                .setStartDate("19-04-2014")
                .setAttenders(attenders.subList(1,1))
                .build();

        calendarService.add(event1);
        calendarService.add(event2);
        calendarService.add(event3);
        calendarService.add(event4);
        calendarService.add(event5);

        System.out.println(calendarService);

        System.out.println(calendarService.getEventByTitle("event2"));

        System.out.println(calendarService.getEventByTitleAndDescription("event3", "description"));

        System.out.println(calendarService.indexOf(calendarService.getEventByTitle("event1")));
        System.out.println(calendarService.indexOf(calendarService.getEventByTitle("event4")));
    }
}
