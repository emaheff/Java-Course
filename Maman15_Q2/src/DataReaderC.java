public class DataReaderC extends Thread {

    private static final int ITERATIONS_COUNT = 2;
    private static final int TIME = 200;
    private DataC dataC;

    public DataReaderC(DataC dataC){
        this.dataC = dataC;
    }

    @Override
    public void run(){
        for (int i = 0; i < ITERATIONS_COUNT; i++){
            int diff =  dataC.getDiff();
            System.out.println("Reader" + (i+1) + ") diff = " + diff);
            dataC.unlockDiff();
            try {
                sleep(TIME);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
