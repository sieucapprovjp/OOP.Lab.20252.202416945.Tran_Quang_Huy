package AIMS;

import java.util.ArrayList;
import java.util.Collections;

public class Cart {
    // Thay thế mảng cũ bằng ArrayList chứa các đối tượng Media
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    // Hàm thêm sản phẩm vào giỏ
    public void addMedia(Media media) {
        if (!itemsOrdered.contains(media)) {
            itemsOrdered.add(media);
            System.out.println("Đã thêm \"" + media.getTitle() + "\" vào giỏ hàng.");
        } else {
            System.out.println("Sản phẩm \"" + media.getTitle() + "\" đã có sẵn trong giỏ hàng.");
        }
    }

    // Hàm xóa sản phẩm khỏi giỏ
    public void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("Đã xóa \"" + media.getTitle() + "\" khỏi giỏ hàng.");
        } else {
            System.out.println("Không tìm thấy \"" + media.getTitle() + "\" trong giỏ hàng.");
        }
    }
    // Tính tổng tiền
    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    // Tìm kiếm theo ID
    public Media searchById(int id) {
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                return media;
            }
        }
        return null; // Không tìm thấy
    }

    // Tìm kiếm theo Tiêu đề (Title)
    public Media searchByTitle(String title) {
        for (Media media : itemsOrdered) {
            if (media.isMatch(title)) {
                return media;
            }
        }
        return null; // Không tìm thấy
    }

    // Thêm import này ở đầu file: import java.util.Collections;

    // Sắp xếp theo Tiêu đề rồi đến Giá
    public void sortByTitleCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        System.out.println("Đã sắp xếp giỏ hàng theo Tiêu đề -> Giá.");
    }

    // Sắp xếp theo Giá rồi đến Tiêu đề
    public void sortByCostTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        System.out.println("Đã sắp xếp giỏ hàng theo Giá -> Tiêu đề.");
    }

    // In hóa đơn (Yêu cầu của Lab 03 - Section 4)
    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < itemsOrdered.size(); i++) {
            // Nhờ tính đa hình, hàm toString() của đúng loại sản phẩm (Book/CD/DVD) sẽ được gọi
            System.out.println((i + 1) + ". " + itemsOrdered.get(i).toString());
        }
        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("***************************************************");
    }
}
