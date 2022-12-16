import java.util.Iterator;

public class StringCheck {

        public static void main(String[] args) {

                PriorityQueue priorityQueue = new PriorityQueue(5);

                assert priorityQueue.size() == 0;
                assert priorityQueue.poll() == null;
                priorityQueue.add("apple", 3);
                assert priorityQueue.size() == 1; // check size and add methods
                System.out.println("################## poll check ##################");
                System.out.println(priorityQueue.poll()); // check 'poll' and 'add' methods
                assert priorityQueue.size() == 0; // check that poll removes the element
                priorityQueue.add("apple", 3);

                // check remove method
                assert priorityQueue.remove("apple") == true;
                assert priorityQueue.size() == 0;
                priorityQueue.add("orange", 3);
                priorityQueue.add("banana", 3);
                priorityQueue.add("pear", 2);
                priorityQueue.add("avocado", 2);
                priorityQueue.add("peach", 1);
                priorityQueue.add("mango", 1);
                priorityQueue.add("coconut", 5);
                priorityQueue.add("papaya", 5);
                priorityQueue.add("apple", 3);
                priorityQueue.add("watermelon", 2);
                priorityQueue.add("dates", 3);
                priorityQueue.add("grapefruit", 3);
                priorityQueue.add("lemon", 3);
                priorityQueue.add("pear", 2);
                priorityQueue.add("blueberry", 2);
                priorityQueue.add("melon", 2);
                assert priorityQueue.size() == 16;

                assert priorityQueue.contains("banana"); // banana is in the queue
                assert !priorityQueue.contains("eggplant"); // eggplant isn't in the queue

                Iterator<String> it = priorityQueue.iterator();
                System.out.println("################## Iterator check ##################");
                while (it.hasNext()){
                        System.out.println(it.next());
                }
        }
}