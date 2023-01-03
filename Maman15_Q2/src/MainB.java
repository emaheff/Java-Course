public class MainB {
    private static DataB dataB = new DataB(0, 0);

    public static void main(String[] args) {
        DataReaderB dataReaderB = new DataReaderB(dataB);
        DataWriterB dataWriterB = new DataWriterB(dataB);
        dataWriterB.start();
        dataReaderB.start();
    }
}
