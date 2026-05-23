package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.media.Media;
import java.util.ArrayList;

public class Store {
    // Danh sách các mặt hàng có trong cửa hàng
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public void addMedia(Media media) {
        if (!itemsInStore.contains(media)) {
            itemsInStore.add(media);
            System.out.println("Đã thêm \"" + media.getTitle() + "\" vào kho của cửa hàng.");
        } else {
            System.out.println("Sản phẩm \"" + media.getTitle() + "\" đã tồn tại trong kho.");
        }
    }

    public void removeMedia(Media media) {
        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            System.out.println("Đã xóa \"" + media.getTitle() + "\" khỏi kho cửa hàng.");
        } else {
            System.out.println("Không tìm thấy \"" + media.getTitle() + "\" trong kho.");
        }
    }
    public void displayStore() {
        System.out.println("******************** STORE INVENTORY ********************");
        if (itemsInStore.size() == 0) {
            System.out.println("Cửa hàng hiện đang trống.");
        } else {
            for (int i = 0; i < itemsInStore.size(); i++) {
                System.out.println((i + 1) + ". " + itemsInStore.get(i).toString());
            }
        }
        System.out.println("*********************************************************");
    }
    public ArrayList<Media> getItemsInStore() {
        return this.itemsInStore;
    }
}