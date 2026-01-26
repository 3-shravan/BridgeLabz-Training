import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class LargeFileGenerator {

    public static void main(String[] args) {

        String fileName = "collections-practice\\gcr-codebase\\streams\\largeFile.dat";
        int fileSizeMB = 100;          // Size of file
        int bufferSize = 4096;         // 4 KB buffer

        byte[] buffer = new byte[bufferSize];
        Random random = new Random();

        long totalBytes = (long) fileSizeMB * 1024 * 1024;
        long writtenBytes = 0;

        try (FileOutputStream fos = new FileOutputStream(fileName)) {

            while (writtenBytes < totalBytes) {
                random.nextBytes(buffer);
                fos.write(buffer);
                writtenBytes += bufferSize;
            }

            System.out.println("✅ File generated successfully!");
            System.out.println("📁 File Name : " + fileName);
            System.out.println("📦 File Size : " + fileSizeMB + " MB");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
