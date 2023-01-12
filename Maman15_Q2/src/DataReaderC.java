public class DataReaderC extends Thread {

    private static final int ITERATIONS_COUNT = 3;
    private static final int TIME = 300;
    private DataC dataC;

    public DataReaderC(DataC dataC){
        this.dataC = dataC;
    }

    @Override
    public void run(){
        for (int i = 0; i < ITERATIONS_COUNT; i++){
            dataC.getDiff();
            try {
                sleep(TIME);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}