import edu.dio.calendar.CalendarEvent;
import edu.dio.calendar.CalendarService;

import java.util.UUID;

public class Main {

    public static void main(String[] args) {
        CalendarService calendarService=new CalendarService();

        CalendarEvent event1 = new CalendarEvent.Builder()
                .setId(UUID.randomUUID())
                .setTitle("event1")
                .setDescription("description")
                .build();
        CalendarEvent event2 = new CalendarEvent.Builder()
                .setId(UUID.randomUUID())
                .setTitle("event2")
                .setDescription("description")
                .build();
        CalendarEvent event3 = new CalendarEvent.Builder()
                .setId(UUID.randomUUID())
                .setTitle("event3")
                .setDescription("description")
                .build();

        calendarService.add(event1);
        calendarService.add(event2);
        calendarService.add(event3);

        System.out.println(calendarService);
        System.out.println(calendarService.indexOf(event2));
    }
}
