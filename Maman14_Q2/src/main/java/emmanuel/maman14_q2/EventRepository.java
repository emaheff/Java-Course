package emmanuel.maman14_q2;

import java.util.*;

public class EventRepository {

    private Map<Calendar, Event> events = new HashMap<>();

    Event getEvent(Calendar date) {
        return events.get(date);
    }

    void saveEvent(Event event) {
        Calendar date = event.getDate();
        events.put(date, event);
    }

    public List<Event> findByTitle(String title) {
        List<Event> events = new ArrayList<>();
        for (Map.Entry<Calendar, Event> entry : this.events.entrySet()) {
            if (entry.getValue().getTitle().contains(title)) {
                events.add(entry.getValue());
            }
        }
        return events;
    }
}