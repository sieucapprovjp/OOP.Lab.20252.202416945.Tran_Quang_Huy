package hust.soict.hedspi.test.store;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        // Khởi tạo cửa hàng
        Store store = new Store();

        // 1. Tạo các sản phẩm ĐA DẠNG (DVD, CD, Book)
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.99f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 121, 24.99f);

        CompactDisc cd = new CompactDisc("Star Wars Soundtrack", "Music", 24.99f, 0, "George Lucas", "John Williams");
        Book book = new Book("Aladdin Story", "Fairy Tale", 20.99f);

        // Test addMedia()
        System.out.println("=== Test addMedia() ===");
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(cd);
        store.addMedia(book);

        // Display store
        System.out.println("\n=== Display Store ===");
        store.displayStore();

        // Test removeMedia()
        System.out.println("\n=== Test removeMedia() ===");
        store.removeMedia(dvd2);

        // Display store after removal
        System.out.println("\n=== Display Store After Removal ===");
        store.displayStore();

        // Test removing a Media not in store
        System.out.println("\n=== Test removeMedia() - Not in Store ===");
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Frozen", "Animation", 15.99f);
        store.removeMedia(dvd4);

        System.out.println("\n=== All Tests Completed ===");
    }
}