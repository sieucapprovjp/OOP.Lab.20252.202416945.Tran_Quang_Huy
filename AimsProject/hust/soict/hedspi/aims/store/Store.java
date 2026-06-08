package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.media.Media;
import java.util.ArrayList;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public void addMedia(Media media) {
        if (!itemsInStore.contains(media)) {
            itemsInStore.add(media);
            System.out.println("Đã thêm \"" + media.getTitle() + "\" vào kho.");
        } else {
            System.out.println("Sản phẩm \"" + media.getTitle() + "\" đã tồn tại.");
        }
    }

    public void removeMedia(Media media) {
        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            System.out.println("Đã xóa \"" + media.getTitle() + "\" khỏi kho.");
        } else {
            System.out.println("Không tìm thấy \"" + media.getTitle() + "\" trong kho.");
        }
    }

    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }

    // KHẮC PHỤC LỖI: cannot find symbol method displayStore()
    public void displayStore() {
        System.out.println("******************** STORE INVENTORY ********************");
        if (itemsInStore.isEmpty()) {
            System.out.println("Cửa hàng hiện đang trống.");
        } else {
            for (int i = 0; i < itemsInStore.size(); i++) {
                System.out.println((i + 1) + ". " + itemsInStore.get(i).toString());
            }
        }
        System.out.println("*********************************************************");
    }
}