public class DataWriterC extends Thread  {
    private static final int ITERATIONS_COUNT = 3;
    private static final int RANGE = 10;
    private static final int TIME = 200;
    private DataC dataC;

    public DataWriterC(DataC dataC){
        this.dataC = dataC;
    }

    @Override
    public void run(){
        for (int i = 0; i < ITERATIONS_COUNT; i++){
            int dx = (int)(Math.random() * RANGE);
            int dy = (int)(Math.random() * RANGE);
            dataC.update(dx, dy);
            System.out.println("Writer" + (i+1) + ") dx = " + dx + " ,dy = " + dy);
            dataC.unlockUpdate();
            try {
                sleep(TIME);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
