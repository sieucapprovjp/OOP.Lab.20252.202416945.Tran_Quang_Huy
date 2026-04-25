package hust.soict.hedspi.aims.media; // Đổi lại tên package nếu cần

import java.util.Comparator;

public class MediaComparatorByTitle implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        // 1. Sắp xếp theo Tiêu đề (Bảng chữ cái ABC...)
        int titleCompare = m1.getTitle().compareToIgnoreCase(m2.getTitle());
        if (titleCompare != 0) {
            return titleCompare; // Nếu khác tiêu đề thì trả về kết quả so sánh
        }

        // 2. Nếu trùng tiêu đề, sắp xếp theo Giá (Giảm dần - Món đắt hơn xếp trước)
        return Float.compare(m2.getCost(), m1.getCost());
    }
}