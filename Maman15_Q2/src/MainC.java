public class MainC {

    private static final int NUM_OF_THREADS = 4;
    private static DataC dataC = new DataC(0, 0);
    private static DataReaderC[] dataReadersC = new DataReaderC[NUM_OF_THREADS];
    private static DataWriterC[] dataWritersC = new DataWriterC[NUM_OF_THREADS];


    private static DataReaderC[] createDataReaders(){
        for (int i = 0; i < NUM_OF_THREADS; i++){
            DataReaderC dataReaderC = new DataReaderC(dataC);
            dataReadersC[i] = dataReaderC;
        }
        return dataReadersC;
    }

    private static DataWriterC[] createDataWriter(){
        for (int i = 0; i < NUM_OF_THREADS; i++){
            DataWriterC dataWriterC = new DataWriterC(dataC);
            dataWritersC[i] = dataWriterC;
        }
        return dataWritersC;
    }

    public static void main(String[] args) {
        dataReadersC = createDataReaders();
        dataWritersC = createDataWriter();
        for (int i = 0 ; i < NUM_OF_THREADS; i++){
            dataWritersC[i].start();
            dataReadersC[i].start();
        }
    }
}