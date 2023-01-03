public class DataC {
    private int x = 0;
    private int y = 0;
    private boolean isReading, isWriting;

    public DataC(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public synchronized int getDiff() {
        while (isWriting){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        isReading = false;
        notifyAll();
        return (Math.abs(x - y));
    }

    public synchronized void update(int dx, int dy) {
        isWriting = true;
        while (isReading){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        x += dx;
        y += dy;
        isWriting = false;
        notifyAll();
    }
}