public class DataC {
    private int x = 0, y = 0;
    private int readers = 0, writers = 0;

    public DataC(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public synchronized int getDiff() {
        while (writers > 0){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        readers++;
        return (Math.abs(x - y));
    }

    public synchronized void unlockDiff(){
        readers--;
        notifyAll();
    }

    public synchronized void update(int dx, int dy) {
        while (readers > 0 || writers > 0){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        writers++;
        x += dx;
        y += dy;
    }

    public synchronized void unlockUpdate(){
        writers--;
        notifyAll();
    }
}