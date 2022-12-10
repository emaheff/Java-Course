
import java.util.Iterator;
import java.util.LinkedList;


public class PriorityQueue<T> {
    private static int MAX_PRIORITY_SIZE = 10;
    private int prioritySize;
    private LinkedList<T>[] priorityQueue;

    public PriorityQueue(int prioritySize) {
        if (prioritySize < 1 ) {
            this.prioritySize = 1;
        }else {
            this.prioritySize =  Math.min(prioritySize, MAX_PRIORITY_SIZE);
        }
        priorityQueue = new LinkedList[this.prioritySize];
        for (int i = 0; i < this.prioritySize; i++){
            priorityQueue[i] = new LinkedList<T>();
        }
    }
    public void add(T element, int priority){
        if (priority < 1){
            priorityQueue[0].add(element);
        } else{
            int i = Math.min(priority,prioritySize);
            priorityQueue[i-1].add(element);
        }
    }

    public T poll(){
        for (LinkedList<T> queue: priorityQueue){
            if (!queue.isEmpty()) {
                return queue.get(0);
            }
        }
        return null;
    }

    public boolean contains(T element){
        for (LinkedList<T> queue: priorityQueue){
            if (queue.contains(element)) {
                return true;
            }
        }
        return false;
    }

    public boolean remove(T element){
        for (LinkedList<T> queue: priorityQueue){
            if (queue.remove(element)){
                return true;
            }
        }
        return false;
    }

    public int size(){
        int counter = 0;
        for (LinkedList<T> queue: priorityQueue){
            counter += queue.size();
        }
        return counter;
    }
    public Iterator<T> iterator(){
        LinkedList<T> longQueue = new LinkedList<T>();
        for (LinkedList<T> queue: priorityQueue){
               longQueue.addAll(queue);
        }
        return longQueue.iterator();
    }
}