public class DataWriterB extends Thread  {
    private static final int ITERATIONS_COUNT = 10;
    private static final int RANGE = 10;
    private DataB dataB;

    public DataWriterB(DataB dataB){
        this.dataB = dataB;
    }

    @Override
    public void run(){
        for (int i = 0; i < ITERATIONS_COUNT; i++){
            int dx = (int)(Math.random() * RANGE);
            int dy = (int)(Math.random() * RANGE);
            System.out.println("Writer" + (i+1) + ") dx = " + dx + " ,dy = " + dy);
            dataB.update(dx, dy);
            try {
                sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
