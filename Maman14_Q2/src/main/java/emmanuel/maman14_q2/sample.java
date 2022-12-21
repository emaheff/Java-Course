package emmanuel.maman14_q2;

import java.util.*;

public class sample {


    public static void main(String[] args) {
        EventRepository eventRepository = new EventRepository();

        Calendar date1 = Calendar.getInstance();
        date1.set(2000, 1,1);
        String str1 = "yosi";

        Calendar date2 = Calendar.getInstance();
        date2.set(2000, 1,2);
        String str2 = "yosi";

        Calendar date4 = Calendar.getInstance();
        date4.set(2000, 1,3);
        String str4 = "yosi";

        Calendar date5 = Calendar.getInstance();
        date5.set(2000, 1,4);
        String str5 = "yosi7";

        Calendar date6 = Calendar.getInstance();
        date6.set(2000, 1,5);
        String str6 = "yosi";

        Calendar date7 = Calendar.getInstance();
        date7.set(2000, 1,6);
        String str7 = "yosi";

        Event event1 = new Event(date1,str1);
        Event event2 = new Event(date2,str2);
        Event event4 = new Event(date4,str4);
        Event event5 = new Event(date5,str5);
        Event event6 = new Event(date6,str6);
        Event event7 = new Event(date7,str7);

        List<Event> sample = new ArrayList<>();
        sample.add(event1);
        sample.add(event2);
        sample.add(event4);
        sample.add(event5);
        sample.add(event6);
        sample.add(event7);

        Collections.shuffle(sample);
//        for (Event e: sample){
//            System.out.println(e.getDate().getTime());
//        }
//        Collections.sort(sample);
//        System.out.println("###################################");
//        for (Event e: sample){
//            System.out.println(e.getDate().getTime());
//        }

        eventRepository.saveEvent(event1);
        eventRepository.saveEvent(event2);
        for(Event e: sample){
            eventRepository.saveEvent(e);
        }


        List<Event> events = eventRepository.findByTitle("yosi7");
        Collections.sort(events);

        for (Event e: events){
            System.out.println(e.getTitle());
            System.out.println(e.getDate().getTime());
        }






    }
}
