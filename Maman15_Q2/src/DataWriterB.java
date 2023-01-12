public class DataWriterB extends Thread  {
    private static final int ITERATIONS_COUNT = 10;
    private static final int RANGE = 10;
    private static final int TIME = 300;
    private DataB dataB;

    public DataWriterB(DataB dataB){
        this.dataB = dataB;
    }

    @Override
    public void run(){
        for (int i = 0; i < ITERATIONS_COUNT; i++){
            int dx = (int)(Math.random() * RANGE);
            int dy = (int)(Math.random() * RANGE);
            dataB.update(dx, dy);
            try {
                sleep(TIME);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
