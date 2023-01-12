public class MainC {

    private static final int NUM_OF_THREADS = 4;
    private DataC dataC = new DataC(0, 0);
    private DataReaderC[] dataReadersC = new DataReaderC[NUM_OF_THREADS];
    private DataWriterC[] dataWritersC = new DataWriterC[NUM_OF_THREADS];


    private DataReaderC[] createDataReaders(){
        for (int i = 0; i < NUM_OF_THREADS; i++){
            DataReaderC dataReaderC = new DataReaderC(dataC);
            dataReadersC[i] = dataReaderC;
        }
        return dataReadersC;
    }

    private DataWriterC[] createDataWriter(){
        for (int i = 0; i < NUM_OF_THREADS; i++){
            DataWriterC dataWriterC = new DataWriterC(dataC);
            dataWritersC[i] = dataWriterC;
        }
        return dataWritersC;
    }

    public static void main(String[] args) {
        MainC mainC = new MainC();
        mainC.dataReadersC = mainC.createDataReaders();
        mainC.dataWritersC = mainC.createDataWriter();
        for (int i = 0 ; i < NUM_OF_THREADS; i++){
            mainC.dataWritersC[i].start();
            mainC.dataReadersC[i].start();
        }
    }
}