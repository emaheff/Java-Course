public class DataA {
    private int x = 0;
    private int y = 0;

    public DataA(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getDiff(){
        int diff = (Math.abs(x - y));
        System.out.println("Reader) diff = " + diff);
        return diff;
    }
    public void update(int dx, int dy){
        x += dx;
        y += dy;
        System.out.println("Writer) dx = " + dx + " ,dy = " + dy + " ====>>> x = " + x + ", y = " + y);
    }
}
