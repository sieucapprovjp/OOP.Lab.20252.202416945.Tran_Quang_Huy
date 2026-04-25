package AIMS;

import java.util.ArrayList;
import java.util.List;

public class Polymorphism{
    public static void main(String[] args) {
        // Tạo một ArrayList có thể chứa bất kỳ loại Media nào
        List<Media> mediaList = new ArrayList<Media>();

        // Tạo ra các sản phẩm cụ thể
        // Nhớ truyền đúng tham số theo constructor bạn đã viết nhé
        DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);

        CompactDisc cd = new CompactDisc("Adele 21", "Music", 15.50f, 0, "Various", "Adele");
        // Giả sử thêm vài track cho CD
        cd.addTrack(new Track("Rolling in the Deep", 3));
        cd.addTrack(new Track("Someone Like You", 4));

        Book book = new Book("Harry Potter", "Fantasy", 25.00f);
        book.addAuthors("J.K. Rowling");

        // Thêm tất cả vào chung một danh sách
        mediaList.add(dvd);
        mediaList.add(cd);
        mediaList.add(book);

        // Duyệt qua danh sách và in thông tin
        System.out.println("------------------------------------");
        for (Media media : mediaList) {
            // Đây chính là lúc tính Đa hình (Polymorphism) tỏa sáng!
            System.out.println(media.toString());
        }
        System.out.println("------------------------------------");
    }
}