public class BufferVsBuilder {
    public static void main(String[] args) {
        int n = 1_000_000;

        long startSB = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) sb.append("hello");
        long endSB = System.nanoTime();

        long startBuf = System.nanoTime();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < n; i++) buffer.append("hello");
        long endBuf = System.nanoTime();

        System.out.println("StringBuilder Time: " + (endSB - startSB));
        System.out.println("StringBuffer Time: " + (endBuf - startBuf));
    }
}
