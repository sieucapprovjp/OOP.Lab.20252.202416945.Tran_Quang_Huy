import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class GarbageCreator {
    public static void main(String[] args) {
        String filename = "test.txt"; // Tên file hoặc đường dẫn tới một file dung lượng lớn
        byte[] inputBytes = { 0 };
        long startTime, endTime;

        try {
            inputBytes = Files.readAllBytes(Paths.get(filename));
            startTime = System.currentTimeMillis();

            String outputString = "";
            for (byte b : inputBytes) {
                // Tạo ra một đống "Rác" (Garbage) vì String là bất biến
                outputString += (char)b;
            }

            endTime = System.currentTimeMillis();
            System.out.println("Thời gian đọc file (Garbage Creator): " + (endTime - startTime) + " ms");
        } catch (IOException e) {
            System.out.println("Lỗi: Không tìm thấy file " + filename);
            e.printStackTrace();
        }
    }
}