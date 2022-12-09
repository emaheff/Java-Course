public class StringCheck {

    public static void main(String[] args) {

            PriorityQueue priorityQueue = new PriorityQueue(5);

            priorityQueue.add("apple",3);
            priorityQueue.add("orange",3);
            priorityQueue.add("banana",3);
            priorityQueue.add("pear",2);
            priorityQueue.add("avocado",2);
            priorityQueue.add("peach",1);
            priorityQueue.add("mango",1);
            priorityQueue.add("coconut",5);
            priorityQueue.add("papaya",5);
            priorityQueue.add("apple",3);
            priorityQueue.add("watermelon",2);
            priorityQueue.add("dates",3);
            priorityQueue.add("grapefruit",3);
            priorityQueue.add("lemon",4);
            priorityQueue.add("pear",2);
            priorityQueue.add("blueberry",2);
            priorityQueue.add("melon",2);
            priorityQueue.add("eggplant",5);

            System.out.println("current priorityQueue size is " + priorityQueue.size());
            if (priorityQueue.hasNext()){
                System.out.println("current first priority: " + priorityQueue.poll());
            }
            if(priorityQueue.remove("peach")){
                if (priorityQueue.hasNext()) {
                    System.out.println("current first priority: " + priorityQueue.poll());
                }
            }
            if (priorityQueue.contains("eggplant")){
                priorityQueue.remove("eggplant");
                System.out.println("eggplant is not a fruit!");
            }
            System.out.println("current priorityQueue size is " + priorityQueue.size());
    }
}

//            String apple = "apple";
//            String orange = "orange";
//            String banana = "banana";
//            String pear = "pear";
//            String avocado = "avocado";
//            String peach = "peach";
//            String mango = "mango";
//            String coconut = "coconut";
//            String papaya = "papaya";
//            String watermelon = "watermelon";
//            String dates = "dates";
//            String grapefruit = "grapefruit";
//            String lemon = "lemon";
//            String blueberry = "blueberry";
//            String melon = "melon";