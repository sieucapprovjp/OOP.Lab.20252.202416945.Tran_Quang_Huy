package hust.soict.hedspi.aims;

import java.util.Scanner;

public class AIMS {
    // Biến toàn cục để toàn bộ hệ thống menu có thể truy cập
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initData(); // Nạp dữ liệu mẫu vào cửa hàng

        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Xóa bộ đệm (phím Enter)

            switch (choice) {
                case 1:
                    viewStore();
                    break;
                case 2:
                    updateStore();
                    break;
                case 3:
                    seeCurrentCart();
                    break;
                case 0:
                    System.out.println("Tạm biệt! Cảm ơn bạn đã sử dụng hệ thống AIMS.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại!");
            }
        } while (choice != 0);

        scanner.close();
    }

    // Nạp sẵn một số sản phẩm vào Store để test
    private static void initData() {
        store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.99f));
        store.addMedia(new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 121, 24.99f));
        store.addMedia(new CompactDisc("Adele 21", "Music", 15.50f, 0, "Various", "Adele"));
        store.addMedia(new Book("Harry Potter", "Fantasy", 25.00f));
    }

    // ================= MÀN HÌNH CHÍNH =================
    public static void showMenu() {
        System.out.println("\nAIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3: ");
    }

    // ================= MÀN HÌNH CỬA HÀNG =================
    public static void viewStore() {
        store.displayStore();
        int choice;
        do {
            storeMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // TODO: Yêu cầu nhập title, tìm trong store, gọi mediaDetailsMenu()
                    System.out.println("Chức năng đang được cập nhật...");
                    break;
                case 2:
                    // TODO: Yêu cầu nhập title, tìm trong store, thêm vào cart
                    System.out.println("Chức năng đang được cập nhật...");
                    break;
                case 3:
                    // TODO: Yêu cầu nhập title, tìm trong store, ép kiểu sang Playable và gọi hàm play()
                    System.out.println("Chức năng đang được cập nhật...");
                    break;
                case 4:
                    seeCurrentCart();
                    break;
                case 0:
                    System.out.println("Quay lại màn hình chính.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 0);
    }

    public static void storeMenu() {
        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4: ");
    }

    // ================= MÀN HÌNH CHI TIẾT SẢN PHẨM =================
    public static void mediaDetailsMenu() {
        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2: ");
    }

    // ================= MÀN HÌNH CẬP NHẬT CỬA HÀNG =================
    public static void updateStore() {
        // TODO: Cho phép người dùng nhập thông tin để tạo Media mới và thêm vào store, hoặc xóa đi
        System.out.println("\n--- Chức năng Update Store (Đang xây dựng) ---");
    }

    // ================= MÀN HÌNH GIỎ HÀNG =================
    public static void seeCurrentCart() {
        cart.print();
        int choice;
        do {
            cartMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // TODO: Filter (Theo ID hoặc Title)
                    break;
                case 2:
                    // TODO: Sort (Theo Title/Cost hoặc Cost/Title)
                    break;
                case 3:
                    // TODO: Xóa sản phẩm khỏi giỏ
                    break;
                case 4:
                    // TODO: Play sản phẩm trong giỏ
                    break;
                case 5:
                    System.out.println("Cảm ơn bạn! Đơn hàng của bạn đã được ghi nhận.");
                    // Làm trống giỏ hàng sau khi đặt (Bạn có thể thêm hàm clear() vào Cart)
                    choice = 0; // Quay về main menu sau khi đặt xong
                    break;
                case 0:
                    System.out.println("Quay lại màn hình trước.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 0);
    }

    public static void cartMenu() {
        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4-5: ");
    }
}