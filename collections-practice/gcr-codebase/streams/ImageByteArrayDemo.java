import java.io.*;

public class ImageByteArrayDemo {

    public static void main(String[] args) {

        String sourceImage = "collections-practice\\gcr-codebase\\streams\\Honor.jpg";
        String destinationImage = "collections-practice\\gcr-codebase\\streams\\image_copy.jpg";

        try {

            // Read image and store in ByteArrayOutputStream

            FileInputStream fis = new FileInputStream(sourceImage);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }

            byte[] imageBytes = baos.toByteArray();

            fis.close();
            baos.close();

            // Write byte array back to image using ByteArrayInputStream
            ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
            FileOutputStream fos = new FileOutputStream(destinationImage);

            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            bais.close();
            fos.close();

            System.out.println("✅ Image converted to byte array and restored successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
