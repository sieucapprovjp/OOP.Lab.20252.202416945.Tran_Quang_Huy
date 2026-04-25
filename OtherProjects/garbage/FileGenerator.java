import java.io.FileWriter;
import java.io.IOException;

public class FileGenerator {
    public static void main(String[] args) {
        String filename = "test.txt"; // Lưu ở thư mục gốc của project

        System.out.println("Đang tạo file rác, vui lòng đợi...");

        try (FileWriter writer = new FileWriter(filename)) {
            // Viết 2 triệu ký tự 'A' vào file để tạo dung lượng khoảng 2MB
            for (int i = 0; i < 2000000; i++) {
                writer.write("A");
            }
            System.out.println("Đã tạo thành công file: " + filename + " (Dung lượng ~2MB).");
        } catch (IOException e) {
            System.out.println("Lỗi: Không thể tạo file!");
            e.printStackTrace();
        }
    }
}