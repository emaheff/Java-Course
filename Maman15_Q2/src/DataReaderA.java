public class DataReaderA extends Thread {

    private static final int ITERATIONS_COUNT = 10;
    private static final int TIME = 300;
    private DataA dataA;

    public DataReaderA(DataA dataA){
        this.dataA = dataA;
    }

    @Override
    public void run(){
        for (int i = 0; i < ITERATIONS_COUNT; i++){
            dataA.getDiff();
            try {
                sleep(TIME);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}