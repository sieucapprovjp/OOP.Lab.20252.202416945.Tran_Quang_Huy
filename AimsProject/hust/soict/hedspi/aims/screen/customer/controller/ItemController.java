package hust.soict.hedspi.aims.screen.customer.controller;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.playable;
import hust.soict.hedspi.aims.exception.PlayerException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ItemController {
    @FXML private Label lblTitle;
    @FXML private Label lblCost;
    @FXML private Button btnAddToCart;
    @FXML private Button btnPlay;

    private Media media;
    private Cart cart;

    public ItemController(Cart cart) {
        this.cart = cart;
    }

    public void setData(Media media) {
        this.media = media;
        lblTitle.setText(media.getTitle());
        lblCost.setText(media.getCost() + " $");

        boolean canPlay = media instanceof playable;
        btnPlay.setVisible(canPlay);
        btnPlay.setManaged(canPlay);
    }

    @FXML
    void btnAddToCartClicked(ActionEvent event) {
        cart.addMedia(media);
    }

    @FXML
    void btnPlayClicked(ActionEvent event) {
        if (media instanceof playable) {
            try {
                ((playable) media).play();
            } catch (PlayerException e) {
                // Mục 11: Tạo hộp thoại trực quan ném lỗi cho người dùng đồ họa
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Playback Error");
                alert.setHeaderText("Illegal Media Length Caught!");
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }
        }
    }
}
