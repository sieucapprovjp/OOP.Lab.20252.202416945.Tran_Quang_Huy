package hust.soict.hedspi.aims.media; // Đổi lại tên package nếu cần

import java.util.Comparator;

public class MediaComparatorByCost implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        // 1. Sắp xếp theo Giá (Giảm dần - Món đắt hơn xếp trước)
        int costCompare = Float.compare(m2.getCost(), m1.getCost());
        if (costCompare != 0) {
            return costCompare; // Nếu khác giá thì trả về kết quả so sánh
        }

        // 2. Nếu trùng giá, sắp xếp theo Tiêu đề (Bảng chữ cái ABC...)
        return m1.getTitle().compareToIgnoreCase(m2.getTitle());
    }
}