public class DataA {
    private int x = 0;
    private int y = 0;

    public DataA(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getDiff(){
        return (Math.abs(x - y));
    }
    public void update(int dx, int dy){
        x += dx;
        y += dy;
    }
}
