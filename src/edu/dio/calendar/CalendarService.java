package edu.dio.calendar;

/**
 * Created by Vladimir V. Kravchenko on 20.05.2014.
 */
public class CalendarService {
    private EventStore store;

    public CalendarService(EventStore store) {
        this.store = store;
    }

    public void add(CalendarEvent event) {
        store.add(event);
    }

    public int indexOf(CalendarEvent event) {
        return (event==null)?-1:store.indexOf(event);
    }

    public CalendarEvent getEventByTitle(String title) {
        return store.getEvent(title);
    }

    public CalendarEvent getEventByTitleAndDescription(String title, String description) {
        return store.getEvent(title, description);
    }

    public String toString() {
        return store.toString();
    }
}
