
import java.util.Iterator;
import java.util.LinkedList;


public class PriorityQueue<T> {
    private static int MAX_PRIORITY_SIZE = 10;
    private int prioritySize;
    private LinkedList<T>[] queues;

    public PriorityQueue(int prioritySize) {
        int n = Math.min(prioritySize, MAX_PRIORITY_SIZE);
        this.prioritySize = Math.max(1, n);
        queues = new LinkedList[this.prioritySize];
        for (int i = 0; i < prioritySize; i++){
            queues[i] = new LinkedList<T>();
        }
    }
    public void add(T element, int priority){
        int i = Math.min(priority,prioritySize);
        i = Math.max(1, i);
        queues[i-1].add(element);
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