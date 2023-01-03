public class DataB {
    private int x = 0;
    private int y = 0;
    private int counter = 0;



    public DataB(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public synchronized int getDiff(){
        while (counter % 2 == 0){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        notifyAll();
        counter++;
        return (Math.abs(x - y));
    }
    public synchronized void update(int dx, int dy){
        while (counter % 2 == 1){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        x += dx;
        y += dy;
        counter++;
        notifyAll();
    }
}