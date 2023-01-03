public class MainA {
    private static DataA dataA = new DataA(0, 0);

    public static void main(String[] args) {
        DataReaderA dataReaderA = new DataReaderA(dataA);
        DataWriterA dataWriterA = new DataWriterA(dataA);
        dataWriterA.start();
        dataReaderA.start();
    }
}
