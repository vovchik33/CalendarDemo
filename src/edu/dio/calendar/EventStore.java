package edu.dio.calendar;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Vladimir V. Kravchenko on 20.05.2014.
 */
public class EventStore {
    private List<CalendarEvent> list;

    public EventStore() {
        list = new LinkedList<CalendarEvent>();
    }

    public EventStore(List<CalendarEvent> list) {
        this.list = list;
    }

    public void add(CalendarEvent event) {
        list.add(event);
    }

    public int indexOf(CalendarEvent event) {
        return list.indexOf(event);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("EventStore{");
        sb.append("list=").append(list);
        sb.append('}');
        return sb.toString();
    }
}
