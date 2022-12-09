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

        priorityQueue.add(customer1, 2);
        priorityQueue.add(customer2,3);
        priorityQueue.add(customer3,2);
        priorityQueue.add(customer4,1);
        priorityQueue.add(customer5,1);
        priorityQueue.add(customer6,2);
        priorityQueue.add(customer7,2);
        priorityQueue.add(customer8,3);


        for (int i = 0; i < priorityQueue.getPrioritySize(); i++){
            for (int j = 0; j < priorityQueue.getPriorityQueue()[i].size(); j++){
                System.out.println(priorityQueue.getPriorityQueue()[i].get(j).toString());
            }
        }
        if (customer1.equals(customer3)){
            System.out.println("customer1 and customer3 are equals");
        }

        System.out.println("Current highest priority customer is:\n" + priorityQueue.poll().toString());
        priorityQueue.remove(customer4);
        System.out.println("Current highest priority customer is:\n" + priorityQueue.poll().toString());
        if (priorityQueue.contains(customer4)) {
            System.out.println("someone have the same details as customer4");
        }
    }
}