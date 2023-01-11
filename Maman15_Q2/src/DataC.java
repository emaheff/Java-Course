public class DataC {
    private int x = 0, y = 0;
    private int readers = 0, writers = 0, writeRequests = 0 ;

    public DataC(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getDiff() {
        lockRead();
        int diff = Math.abs(x - y);
        unlockRead();
        return diff;
    }

    public void update(int dx, int dy) {
        lockWrite();
        x += dx;
        y += dy;
        unlockWrite();
    }

    private synchronized void lockRead(){
        while(writers > 0 || writeRequests > 0){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        readers++;
    }

    private synchronized void unlockRead(){
        readers--;
        notifyAll();
    }

    private synchronized void lockWrite(){
        writeRequests++;
        while(readers > 0 || writers > 0){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        writeRequests--;
        writers++;
    }

    private synchronized void unlockWrite(){
        writers--;
        notifyAll();
    }
}