public class DataReaderB extends Thread {

    private static final int ITERATIONS_COUNT = 10;
    private static final int TIME = 300;
    private DataB dataB;

    public DataReaderB(DataB dataB){
        this.dataB = dataB;
    }

    @Override
    public void run(){
        for (int i = 0; i < ITERATIONS_COUNT; i++){
            dataB.getDiff();
            try {
                sleep(TIME);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
