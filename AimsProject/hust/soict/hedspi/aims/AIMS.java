package hust.soict.hedspi.aims;

import java.util.Scanner;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.playable;

public class AIMS {
    private static final Store store = new Store();
    private static Cart cart = new Cart();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initData();

        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
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
    private static void initData() {
        store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.99f));
        store.addMedia(new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 121, 24.99f));
        store.addMedia(new CompactDisc("Adele 21", "Music", 15.50f, 0, "Various", "Adele"));
        store.addMedia(new Book("Harry Potter", "Fantasy", 25.00f));
    }
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
    public static void viewStore() {
        store.displayStore();
        int choice;
        do {
            storeMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Chức năng đang được cập nhật...");
                    break;
                case 2:
                    System.out.println("Chức năng đang được cập nhật...");
                    break;
                case 3:
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
    public static void mediaDetailsMenu() {
        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2: ");
    }
    public static void updateStore() {
        System.out.println("\n--- Chức năng Update Store (Đang xây dựng) ---");
    }

    public static void seeCurrentCart() {
        cart.print();
        int choice;
        do {
            cartMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    // Filter (Theo ID hoặc Title)
                    System.out.println("Lọc sản phẩm theo: 1. ID | 2. Tiêu đề");
                    int filterChoice = scanner.nextInt();
                    scanner.nextLine();
                    if (filterChoice == 1) {
                        System.out.print("Nhập ID cần tìm: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        Media foundById = cart.searchById(id);
                        if (foundById != null) {
                            System.out.println("Kết quả: " + foundById.toString());
                        } else {
                            System.out.println("Không tìm thấy sản phẩm với ID: " + id);
                        }
                    } else if (filterChoice == 2) {
                        System.out.print("Nhập tiêu đề cần tìm: ");
                        String title = scanner.nextLine();
                        Media foundByTitle = cart.searchByTitle(title);
                        if (foundByTitle != null) {
                            System.out.println("Kết quả: " + foundByTitle.toString());
                        } else {
                            System.out.println("Không tìm thấy sản phẩm với tiêu đề: " + title);
                        }
                    } else {
                        System.out.println("Lựa chọn không hợp lệ.");
                    }
                    break;

                case 2:
                    System.out.println("Sắp xếp theo: 1. Tiêu đề -> Giá | 2. Giá -> Tiêu đề");
                    int sortChoice = scanner.nextInt();
                    scanner.nextLine();
                    if (sortChoice == 1) {
                        cart.sortByTitleCost();
                        cart.print();
                    } else if (sortChoice == 2) {
                        cart.sortByCostTitle();
                        cart.print();
                    } else {
                        System.out.println("Lựa chọn không hợp lệ.");
                    }
                    break;
                case 3:
                    System.out.print("Nhập tiêu đề sản phẩm cần xóa: ");
                    String removeTitle = scanner.nextLine();
                    Media mediaToRemove = cart.searchByTitle(removeTitle);
                    if (mediaToRemove != null) {
                        cart.removeMedia(mediaToRemove);
                    } else {
                        System.out.println("Không tìm thấy sản phẩm trong giỏ hàng.");
                    }
                    break;

                case 4:
                    System.out.print("Nhập tiêu đề sản phẩm muốn Play: ");
                    String playTitle = scanner.nextLine();
                    Media mediaToPlay = cart.searchByTitle(playTitle);
                    if (mediaToPlay != null) {
                        if (mediaToPlay instanceof playable) {
                            ((playable) mediaToPlay).play();
                        } else {
                            System.out.println("Sản phẩm này không hỗ trợ tính năng Play (Ví dụ: Sách).");
                        }
                    } else {
                        System.out.println("Không tìm thấy sản phẩm trong giỏ hàng.");
                    }
                    break;

                case 5:
                    // Place order
                    System.out.println("Cảm ơn bạn! Đơn hàng của bạn đã được ghi nhận.");
                    cart = new Cart();
                    choice = 0;
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