package emmanuel.maman14_q2;

import java.util.*;

public class EventRepository {

    private Map<Calendar, Event> events = new HashMap<>();

    // this method return an event from the calendar by a given date
    Event getEvent(Calendar date) {
        return events.get(date);
    }

    // this method saves a given event to the calendar
    void saveEvent(Event event) {
        Calendar date = event.getDate();
        events.put(date, event);
    }

    // this method finds all the events that contain the given title and returns sorted (by date) list of events
    public List<Event> findByTitle(String title) {
        List<Event> events = new ArrayList<>();
        for (Map.Entry<Calendar, Event> entry : this.events.entrySet()) {
            if (entry.getValue().getTitle().contains(title)) {
                events.add(entry.getValue());
            }
        }
        Collections.sort(events);
        return events;
    }
}