package hust.soict.hedspi.aims.cart;

import hust.soict.hedspi.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
    // Thuộc tính phục vụ Data-driven UI cho JavaFX TableView
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    public ObservableList<Media> getItemsOrdered() {
        return this.itemsOrdered;
    }

    public void addMedia(Media media) {
        if (media == null) {
            return;
        }
        if (!itemsOrdered.contains(media)) {
            itemsOrdered.add(media);
            System.out.println("Đã thêm \"" + media.getTitle() + "\" vào giỏ hàng.");
        } else {
            System.out.println("Sản phẩm \"" + media.getTitle() + "\" đã có trong giỏ hàng.");
        }
    }

    public void removeMedia(Media media) {
        if (media == null) {
            return;
        }
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("Đã xóa \"" + media.getTitle() + "\" khỏi giỏ hàng.");
        } else {
            System.out.println("Không tìm thấy \"" + media.getTitle() + "\" trong giỏ hàng.");
        }
    }

    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    public void clear() {
        itemsOrdered.clear();
    }

    // KHẮC PHỤC LỖI: cannot find symbol method searchById(int)
    public Media searchById(int id) {
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                return media;
            }
        }
        return null;
    }

    // KHẮC PHỤC LỖI: cannot find symbol method searchByTitle(String)
    public Media searchByTitle(String title) {
        for (Media media : itemsOrdered) {
            if (media.isMatch(title)) {
                return media;
            }
        }
        return null;
    }

    // KHẮC PHỤC LỖI: cannot find symbol method sortByTitleCost()
    public void sortByTitleCost() {
        itemsOrdered.sort(Media.COMPARE_BY_TITLE_COST);
        System.out.println("Đã sắp xếp giỏ hàng theo Tiêu đề -> Giá.");
    }

    // KHẮC PHỤC LỖI: cannot find symbol method sortByCostTitle()
    public void sortByCostTitle() {
        itemsOrdered.sort(Media.COMPARE_BY_COST_TITLE);
        System.out.println("Đã sắp xếp giỏ hàng theo Giá -> Tiêu đề.");
    }

    // KHẮC PHỤC LỖI: cannot find symbol method print()
    public void print() {
        System.out.println("*********************** CART ***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.println((i + 1) + ". " + itemsOrdered.get(i).toString());
        }
        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("****************************************************");
    }
}
