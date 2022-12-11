import java.util.Iterator;

public class CustomerRequests {

    public static void main(String[] args) {

        PriorityQueue priorityQueue = new PriorityQueue(3);


        Customer customer1 = new Customer("Avi", "315644892", "passport renew");
        Customer customer2 = new Customer("Yosi", "3786423892", "licence renew");
        Customer customer3 = new Customer("Shira", "316896812", "passport renew");
        Customer customer4 = new Customer("Levona", "315644892", "passport renew");
        Customer customer5 = new Customer("Avi", "312348892", "visa renew");
        Customer customer6 = new Customer("Noga", "123444892", "tofes 4");
        Customer customer7 = new Customer("Meir", "316896812", "passport renew");
        Customer customer8 = new Customer("Shaked", "315321432", "tofes 4");

        assert priorityQueue.size() == 0; // check 'size' method
        priorityQueue.add(customer1,2);
        System.out.println("################## poll check ##################");
        System.out.println(priorityQueue.poll()); // check 'poll' and 'add' methods
        assert priorityQueue.size() == 0; // check that poll remove the element
        priorityQueue.add(customer1,2);
        System.out.println("################## remove check ##################");
        if (priorityQueue.remove(customer1)){
            System.out.println("customer1 removed successfully!");
        }
        assert priorityQueue.size() == 0; // check remove method

        priorityQueue.add(customer2,3);
        priorityQueue.add(customer3,2);
        priorityQueue.add(customer4,1);
        priorityQueue.add(customer5,1);
        priorityQueue.add(customer6,2);
        priorityQueue.add(customer7,2);
        priorityQueue.add(customer8,3);

        priorityQueue.remove(customer2);

        assert !priorityQueue.contains(customer2); // customer2 isn't in the queue, and there is no another element that equals to customer2
        assert priorityQueue.contains(customer1); // customer1 isn't in the queue. But customer4 should be equals to customer1

        Iterator<Customer> it = priorityQueue.iterator();
        System.out.println("################## Iterator check ##################");
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}