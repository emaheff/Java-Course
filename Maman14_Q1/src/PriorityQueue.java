import java.util.ArrayList;
import java.util.Iterator;


public class PriorityQueue<T> implements Iterator<T>{
    private static int MAX_PRIORITY_SIZE = 10;
    private int prioritySize;
    private ArrayList<T>[] priorityQueue;

    public ArrayList<T>[] getPriorityQueue() {
        return priorityQueue;
    }

    // a constructor
    public PriorityQueue(int prioritySize) {
        if (prioritySize < 1 || prioritySize > MAX_PRIORITY_SIZE) {
            this.prioritySize = MAX_PRIORITY_SIZE;
        } else {
            this.prioritySize = prioritySize;
        }
        priorityQueue = new ArrayList[prioritySize];
        for (int i = 0; i < this.prioritySize; i++){
            priorityQueue[i] = new ArrayList<T>();
        }
    }
    public void add(T element, int priority){
        if (priority < 1 || priority > prioritySize){
            priorityQueue[prioritySize - 1].add(element);
        }
        else {
            priorityQueue[priority - 1].add(element);
        }
    }

    public T poll(){
        for (int i = 0; i < prioritySize; i++){
            if (!priorityQueue[i].isEmpty()){
                return priorityQueue[i].get(0);
            }
        }
        return null;
    }

    public boolean contains(T element){
        for (int i = 0; i < prioritySize; i++){
            for (int j = 0; j < priorityQueue[i].size(); j++){
                if (priorityQueue[i].get(j).equals(element)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean remove(T element){
        for (int i = 0; i < prioritySize; i++){
            for (int j = 0; j < priorityQueue[i].size(); j++){
                if (priorityQueue[i].get(j).equals(element)){
                    priorityQueue[i].remove(j);
                    return true;
                }
            }
        }
        return false;
    }

    public int size(){
        int counter = 0;
        for (int i = 0; i < prioritySize; i++) {
            counter += priorityQueue[i].size();
        }
        return counter;
    }

    @Override
    public boolean hasNext() {
        for (int i = 0; i < prioritySize; i++){
            if(!priorityQueue[i].isEmpty()){
                return true;
            }
        }
        return false;
    }

    @Override
    public T next() {
        for (int i = 0; i < prioritySize; i++){
            for (int j = 0; j < priorityQueue[i].size(); j++){
                if (priorityQueue[i].get(j) != null){
                    return priorityQueue[i].get(j);
                }
            }
        }
        return null;
    }
    public int getPrioritySize(){
        return this.prioritySize;
    }
}

//    private void addToQueue(ArrayList<T> queue, T element){
//        queue.add(element);
//    }
//
//    private T pollFromQueue(ArrayList<T> queue){
//        if(!queue.isEmpty()){
//            return queue.get(0);
//        }
//        return null;
//    }
//
//    private boolean containsInQueue(ArrayList<T> queue, T element){
//        return queue.contains(element);
//    }
//
//    private boolean removeFromQueue(ArrayList<T> queue, T element){
//        for (int i = 0; i < queue.size(); i++){
//            if (queue.get(i).equals(element)){
//                queue.remove(i);
//                return true;
//            }
//        }
//        return false;
//    }
