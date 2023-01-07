import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DataC {
    private int x = 0, y = 0;
    private int readers = 0, writers = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public DataC(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getDiff() {
        readers++;
        try {
            while (writers > 0)
                condition.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        readers--;
        return (Math.abs(x - y));
    }

    public void update(int dx, int dy) {
        lock.lock();
        writers++;
        try {
            while (readers > 0)
                condition.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        x += dx;
        y += dy;
        writers--;
        condition.signalAll();
        lock.unlock();
    }
}