public class DataB {
    private int x = 0;
    private int y = 0;

    public DataB(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public synchronized int getDiff(){
        return (Math.abs(x - y));
    }

    public synchronized void update(int dx, int dy){
        x += dx;
        y += dy;
    }
}