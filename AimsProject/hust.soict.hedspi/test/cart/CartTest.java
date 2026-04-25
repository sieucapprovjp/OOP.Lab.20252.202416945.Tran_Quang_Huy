package hust.soict.hedspi.test.cart;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.*;

public class CartTest {
    public static void main(String[] args) {
        // Khởi tạo giỏ hàng
        Cart cart = new Cart();

        // 1. Tạo các sản phẩm ĐA DẠNG (DVD, CD, Book)
        DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.99f);

        CompactDisc cd = new CompactDisc("Star Wars Soundtrack", "Music", 24.99f, 0, "George Lucas", "John Williams");
        cd.addTrack(new Track("Main Theme", 5));
        cd.addTrack(new Track("Imperial March", 4));

        Book book = new Book("Aladdin Story", "Fairy Tale", 20.99f);
        book.addAuthors("Disney");

        // 2. Thêm tất cả vào giỏ hàng (Sử dụng chung hàm addMedia)
        System.out.println("=== Adding Media to Cart ===");
        cart.addMedia(dvd);
        cart.addMedia(cd);
        cart.addMedia(book);

        // Test 1: In giỏ hàng ra màn hình (Test đa hình toString)
        System.out.println("\n=== Test 1: print() method ===");
        cart.print();

        // Test 2: searchById() - Tìm thấy
        System.out.println("\n=== Test 2: searchById() - Tìm ID hợp lệ ===");
        // Lấy ID của đĩa CD để test (vì ID được tự động tăng nên ta lấy thẳng từ object)
        int searchId = cd.getId();
        Media foundById = cart.searchById(searchId);
        if (foundById != null) {
            System.out.println("Found: " + foundById.toString());
        }

        // Test 3: searchById() - Không tìm thấy
        System.out.println("\n=== Test 3: searchById() - Tìm ID = 99 ===");
        Media notFoundById = cart.searchById(99);
        if (notFoundById == null) {
            System.out.println("Không tìm thấy sản phẩm có ID 99.");
        }

        // Test 4: searchByTitle() - Tìm thấy (Khớp 1 phần)
        System.out.println("\n=== Test 4: searchByTitle() - 'Star' ===");
        Media foundByTitle = cart.searchByTitle("Star");
        if (foundByTitle != null) {
            System.out.println("Found: " + foundByTitle.toString());
        }

        // Test 5: searchByTitle() - Không tìm thấy
        System.out.println("\n=== Test 5: searchByTitle() - 'Frozen' ===");
        Media notFoundByTitle = cart.searchByTitle("Frozen");
        if (notFoundByTitle == null) {
            System.out.println("Không tìm thấy sản phẩm chứa từ khóa 'Frozen'.");
        }

        // Test 6: Remove sản phẩm và in lại giỏ
        System.out.println("\n=== Test 6: Remove CD and print cart ===");
        cart.removeMedia(cd);
        cart.print();

        System.out.println("\n=== All Tests Completed ===");
    }
}