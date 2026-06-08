package hust.soict.hedspi.aims.screen.customer.controller;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.store.Store;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;

public class ViewStoreController {
    @FXML private GridPane gridPane;
    private Store store;
    private Cart cart;

    private static final String ITEM_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Item.fxml";
    private static final String CART_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Cart.fxml";

    public ViewStoreController(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
    }

    @FXML
    public void initialize() {
        int column = 0;
        int row = 1;

        for (int i = 0; i < store.getItemsInStore().size(); i++) {
            try {
                URL itemUrl = getClass().getResource(ITEM_FXML_FILE_PATH);
                if (itemUrl == null) {
                    throw new IOException("Cannot find " + ITEM_FXML_FILE_PATH);
                }
                FXMLLoader fxmlLoader = new FXMLLoader(itemUrl);
                ItemController itemController = new ItemController(cart);
                fxmlLoader.setController(itemController);

                AnchorPane anchorPane = fxmlLoader.load();
                itemController.setData(store.getItemsInStore().get(i));

                if (column == 3) {
                    column = 0;
                    row++;
                }

                gridPane.add(anchorPane, column++, row);
                GridPane.setMargin(anchorPane, new Insets(20, 10, 10, 10));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void btnViewCartPressed(ActionEvent event) {
        try {
            URL cartUrl = getClass().getResource(CART_FXML_FILE_PATH);
            if (cartUrl == null) {
                throw new IOException("Cannot find " + CART_FXML_FILE_PATH);
            }
            FXMLLoader fxmlLoader = new FXMLLoader(cartUrl);

            CartController cartController = new CartController(store, cart);
            fxmlLoader.setController(cartController);

            Parent root = fxmlLoader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("AIMS - Customer Cart");
            stage.show();

        } catch (IOException e) {
            System.err.println("Không thể mở màn hình Giỏ Hàng: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
