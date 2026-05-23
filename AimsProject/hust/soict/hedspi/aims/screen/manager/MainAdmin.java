package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.CompactDisc;

public class MainAdmin {
    public static void main(String[] args) {
        // 1. Khởi tạo kho hàng Store
        Store store = new Store();

        // 2. Thêm một số sản phẩm demo vào kho bằng code cũ của bạn
        Book book1 = new Book("Harry Potter", "Fantasy", 12.5f);
        book1.addAuthors("J.K. Rowling");
        store.addMedia(book1);

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Inception", "Sci-Fi", "Christopher Nolan", 148, 19.99f);
        store.addMedia(dvd1);

        CompactDisc cd1 = new CompactDisc("Abbey Road", "Rock", 15.0f, 47, "George Martin", "The Beatles");
        store.addMedia(cd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Avatar", "Action", "James Cameron", 162, 24.5f);
        store.addMedia(dvd2);

        // 3. Kích hoạt giao diện quản lý bằng Swing
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StoreManagerScreen(store);
            }
        });
    }
}