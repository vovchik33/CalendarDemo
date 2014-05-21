import edu.dio.calendar.CalendarEvent;
import edu.dio.calendar.CalendarService;
import edu.dio.calendar.EventStore;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.awt.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class MainTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testCreation() throws Exception {
        Assert.assertNotNull(new CalendarService(new EventStore()));
    }

    @Test
    public void testAddCalendarEvent() throws Exception {
        CalendarService service = new CalendarService(new EventStore());
        service.add(new CalendarEvent.Builder().setTitle("event").build());
        service.add(new CalendarEvent.Builder().setTitle("event").setDescription("description").build());
        Assert.assertNotNull(service.getEventByTitle("event"));
        Assert.assertNotNull(service.getEventByTitleAndDescription("event", "description"));
    }
    @Test
    public void testAddCalendarEventWithVerify() throws Exception {
        EventStore store = mock(EventStore.class);
        when(store.getEvent("event")).thenReturn(new CalendarEvent.Builder().setTitle("event").build());

        CalendarService service = spy(new CalendarService(store));
        service.getEventByTitle("event");
        service.getEventByTitle("event2");

        verify(store, atLeast(1)).getEvent("event");
        verify(store, atLeast(1)).getEvent((String) any());
        verify(store, atLeast(1)).getEvent(anyString());
        verify(service, atLeastOnce()).getEventByTitle("event");
    }
}