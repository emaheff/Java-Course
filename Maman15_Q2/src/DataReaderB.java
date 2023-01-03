public class DataReaderB extends Thread {

    private static final int ITERATIONS_COUNT = 10;
    private DataB dataB;

    public DataReaderB(DataB dataB){
        this.dataB = dataB;
    }

    @Override
    public void run(){
        for (int i = 0; i < ITERATIONS_COUNT; i++){
            int diff =  dataB.getDiff();
            System.out.println("Reader" + (i+1) + ") diff = " + diff);
            try {
                sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
