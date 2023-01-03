public class DataReaderC extends Thread {

    private static final int ITERATIONS_COUNT = 2;
    private DataC dataC;

    public DataReaderC(DataC dataC){
        this.dataC = dataC;
    }

    @Override
    public void run(){
        for (int i = 0; i < ITERATIONS_COUNT; i++){
            int diff =  dataC.getDiff();
            System.out.println("Reader" + (i+1) + ") diff = " + diff);
            try {
                sleep((int)(Math.random() * 1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
