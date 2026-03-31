import java.io.*;

public class PipedStreamDemo {

    public static void main(String[] args) {

        try {
            // piped streams
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos);

            // Create threads
            Thread writerThread = new Thread(new Writer(pos));
            Thread readerThread = new Thread(new Reader(pis));

            // Start threads
            readerThread.start();
            writerThread.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // WRITER THREAD
    static class Writer implements Runnable {
        private PipedOutputStream pos;

        Writer(PipedOutputStream pos) {
            this.pos = pos;
        }

        @Override
        public void run() {
            try {
                String message = "Hello from Writer Thread";
                pos.write(message.getBytes());
                pos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // READER THREAD
    static class Reader implements Runnable {
        private PipedInputStream pis;

        Reader(PipedInputStream pis) {
            this.pis = pis;
        }

        @Override
        public void run() {
            try {
                int data;
                while ((data = pis.read()) != -1) {
                    System.out.print((char) data);
                }
                pis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
