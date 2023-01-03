public class DataReaderA extends Thread {

    private static final int ITERATIONS_COUNT = 10;
    private DataA dataA;

    public DataReaderA(DataA dataA){
        this.dataA = dataA;
    }

    @Override
    public void run(){
        for (int i = 0; i < ITERATIONS_COUNT; i++){
            int diff =  dataA.getDiff();
            System.out.println("Reader" + (i+1) + ") diff = " + diff);
            try {
                sleep((int)(Math.random() * 1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}