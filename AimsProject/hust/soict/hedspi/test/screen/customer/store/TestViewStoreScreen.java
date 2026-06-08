package hust.soict.hedspi.test.screen.customer.store;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.screen.customer.controller.ViewStoreController;
import hust.soict.hedspi.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewStoreScreen extends Application {
    private static Store store;
    private static Cart cart;

    @Override
    public void start(Stage primaryStage) throws Exception {
        final String STORE_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));

        ViewStoreController viewStoreController = new ViewStoreController(store, cart);
        fxmlLoader.setController(viewStoreController);

        Parent root = fxmlLoader.load();
        primaryStage.setTitle("AIMS Hedspi Customer Store");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        store = new Store();
        cart = new Cart();

        // Thêm vật phẩm mẫu hợp lệ
        store.addMedia(new Book("Sách Đắc Nhân Tâm", "Kỹ năng", 10.5f));
        store.addMedia(new DigitalVideoDisc("Phim Inception", "Sci-Fi", "Nolan", 148, 15.0f));

        // Thêm vật phẩm LỖI ĐỘ DÀI để kiểm thử tính năng bắt lỗi Popup của bài Lab
        store.addMedia(new DigitalVideoDisc("Phim Lỗi Độ Dài (Test)", "Lỗi", "Director", 0, 5.0f));

        CompactDisc cdFaulty = new CompactDisc("CD Nhạc Lỗi (Test)", "Pop", 20.0f, 0, "Director", "Artist");
        cdFaulty.addTrack(new Track("Track 1 bị âm thời lượng", -10));
        store.addMedia(cdFaulty);

        launch(args);
    }
}