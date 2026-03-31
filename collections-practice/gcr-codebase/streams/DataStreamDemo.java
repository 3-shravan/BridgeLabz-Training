import java.io.*;

public class DataStreamDemo {

    public static void main(String[] args) {

        String fileName = "collections-practice\\gcr-codebase\\streams\\user_info.txt";

        // WRITE
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {

            dos.writeInt(101);
            dos.writeUTF("Shravan");
            dos.writeDouble(8.75);

            System.out.println("Student data written successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }

        // READ
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {

            int rollNo = dis.readInt();
            String name = dis.readUTF();
            double gpa = dis.readDouble();

            System.out.println("\n Student Details:");
            System.out.println("Roll No : " + rollNo);
            System.out.println("Name    : " + name);
            System.out.println("GPA     : " + gpa);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
