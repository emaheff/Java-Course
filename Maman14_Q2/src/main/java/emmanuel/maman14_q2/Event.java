package emmanuel.maman14_q2;

import java.util.Calendar;

public class Event implements Comparable<Event>{

    private Calendar date;
    private String title;

    public Event(Calendar date, String title) {
        this.date = date;
        this.title = title;
    }

    public Calendar getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public int compareTo(Event e) {
        return this.getDate().compareTo(e.getDate());
    }
}