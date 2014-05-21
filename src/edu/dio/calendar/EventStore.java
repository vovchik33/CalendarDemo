package edu.dio.calendar;

import java.util.*;

/**
 * Created by Vladimir V. Kravchenko on 20.05.2014.
 */
public class EventStore {
    private List<CalendarEvent> list;

    public EventStore() {
        list = new ArrayList<CalendarEvent>();
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

    public CalendarEvent getEvent(String title) {
        CalendarEvent event;
        Collections.sort(list, new CalendarEventComparator());
        try {
            return list.get(Collections.binarySearch(list, new CalendarEvent.Builder().setTitle(title).setDescription("").build(),
                    new CalendarEventComparator()));
        } catch (Exception e) {
            return null;
        }
    }

    public CalendarEvent getEvent(String title, String description) {
        CalendarEvent event;
        Collections.sort(list, new CalendarEventComparator());
        return list.get(Collections.binarySearch(list, new CalendarEvent.Builder().setTitle(title).setDescription(description).build(), new CalendarEventComparator()));
    }

    class CalendarEventComparator implements Comparator<CalendarEvent> {

        @Override
        public int compare(CalendarEvent o1, CalendarEvent o2) {
            int result = o1.getTitle().compareTo(o2.getTitle());
            if (o1.getDescription()!=null && o2.getDescription()!=null && o1.getDescription().compareTo("")!=0 && o2.getDescription().compareTo("")!=0) {
                if (result==0) result = o1.getDescription().compareTo(o2.getDescription());
            }
            return result;
        }
    }
}
