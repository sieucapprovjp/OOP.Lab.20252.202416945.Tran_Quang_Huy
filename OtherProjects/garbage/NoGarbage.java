import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class NoGarbage{
    public static void main(String[] args) {
        String filename = "test.txt"; // Cùng file test lớn ở trên
        byte[] inputBytes = { 0 };
        long startTime, endTime;

        try {
            inputBytes = Files.readAllBytes(Paths.get(filename));
            startTime = System.currentTimeMillis();

            // Sử dụng StringBuilder để không tạo ra rác
            StringBuilder outputStringBuilder = new StringBuilder();
            for (byte b : inputBytes) {
                outputStringBuilder.append((char)b);
            }

            endTime = System.currentTimeMillis();
            System.out.println("Thời gian đọc file (No Garbage - StringBuilder): " + (endTime - startTime) + " ms");

        } catch (IOException e) {
            System.out.println("Lỗi: Không tìm thấy file " + filename);
            e.printStackTrace();
        }
    }
}