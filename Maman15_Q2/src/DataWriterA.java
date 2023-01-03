public class DataWriterA extends Thread {

    private static final int ITERATIONS_COUNT = 10;
    private static final int RANGE = 10;
    private DataA dataA;

    public DataWriterA(DataA dataA){
        this.dataA = dataA;
    }

    @Override
    public void run(){
        for (int i = 0; i < ITERATIONS_COUNT; i++){
            int dx = (int)(Math.random() * RANGE);
            int dy = (int)(Math.random() * RANGE);
            System.out.println("Writer" + (i+1) + ") dx = " + dx + " ,dy = " + dy);
            dataA.update(dx, dy);
            try {
                sleep((int)(Math.random() * 1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}