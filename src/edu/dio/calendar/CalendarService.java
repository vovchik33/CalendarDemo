package edu.dio.calendar;

/**
 * Created by Vladimir V. Kravchenko on 20.05.2014.
 */
public class CalendarService {
    private EventStore store;

    public CalendarService() {
        store = new EventStore();
    }

    public void add(CalendarEvent event) {
        store.add(event);
    }

    public int indexOf(CalendarEvent event) {
        return store.indexOf(event);
    }

    public String toString() {
        return store.toString();
    }
}
