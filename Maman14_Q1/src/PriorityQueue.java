import java.util.Iterator;
import java.util.LinkedList;

public class PriorityQueue<T> {
    private static final int MAX_PRIORITY_SIZE = 10;
    private LinkedList<T>[] queues;

    public PriorityQueue(int prioritySize) {
        int size = Math.min(prioritySize, MAX_PRIORITY_SIZE); // priority can't be smaller than 10
        size = Math.max(1, size); // priority can't be grater than 1
        queues = new LinkedList[size];
        // initializing the data structure
        for (int i = 0; i < prioritySize; i++){
            queues[i] = new LinkedList<T>();
        }
    }

    public void add(T element, int priority){
        int actualPriority = Math.min(priority,queues.length); // priority can't be smaller than the declared lowest priority in the constructor
        actualPriority = Math.max(1, actualPriority); // priority can't be grater than 1
        queues[actualPriority-1].add(element);
    }

    public T poll(){
        for (LinkedList<T> queue: queues){
            if (!queue.isEmpty()) {
                return queue.poll();
            }
        }
        return null;
    }

    public boolean contains(T element){
        for (LinkedList<T> queue: queues){
            if (queue.contains(element)) {
                return true;
            }
        }
        return false;
    }

    public boolean remove(T element){
        for (LinkedList<T> queue: queues){
            if (queue.remove(element)){
                return true;
            }
        }
        return false;
    }

    public int size(){
        int counter = 0;
        for (LinkedList<T> queue: queues){
            counter += queue.size();
        }
        return counter;
    }

    public Iterator<T> iterator(){
        LinkedList<T> mergedQueue = new LinkedList<T>();
        for (LinkedList<T> queue: queues){
            mergedQueue.addAll(queue);
        }
        return mergedQueue.iterator();
    }
}