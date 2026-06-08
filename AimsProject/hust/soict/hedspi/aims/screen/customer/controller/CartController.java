package hust.soict.hedspi.aims.screen.customer.controller;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.playable;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;

public class CartController {

    private Store store;
    private Cart cart;
    private FilteredList<Media> filteredItems;
    private static final String STORE_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";

    @FXML private TableView<Media> tblMedia;
    @FXML private TableColumn<Media, Integer> colMediaId;
    @FXML private TableColumn<Media, String> colMediaTitle;
    @FXML private TableColumn<Media, String> colMediaCategory;
    @FXML private TableColumn<Media, Float> colMediaCost;
    @FXML private Button btnPlay;
    @FXML private Button btnRemove;
    @FXML private TextField tfFilter;
    @FXML private RadioButton radioBtnFilterId;
    @FXML private RadioButton radioBtnFilterTitle;
    @FXML private ToggleGroup filterCategory;
    @FXML private Label costLabel;

    public CartController(Cart cart) {
        this(null, cart);
    }

    public CartController(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
    }

    @FXML
    public void initialize() {
        colMediaId.setCellValueFactory(new PropertyValueFactory<Media, Integer>("id"));
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));

        filteredItems = new FilteredList<Media>(cart.getItemsOrdered(), media -> true);
        tblMedia.setItems(filteredItems);
        updateTotalCost();

        btnPlay.setVisible(false);
        btnPlay.setManaged(false);
        btnRemove.setVisible(false);
        btnRemove.setManaged(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
            @Override
            public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                if (newValue != null) {
                    updateButtons(newValue);
                } else {
                    hideButtons();
                }
            }
        });

        cart.getItemsOrdered().addListener(new ListChangeListener<Media>() {
            @Override
            public void onChanged(Change<? extends Media> change) {
                updateTotalCost();
            }
        });

        if (tfFilter != null) {
            tfFilter.textProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    showFilteredMedia();
                }
            });
        }

        if (radioBtnFilterId != null) {
            radioBtnFilterId.selectedProperty().addListener((observable, oldValue, newValue) -> showFilteredMedia());
        }
        if (radioBtnFilterTitle != null) {
            radioBtnFilterTitle.selectedProperty().addListener((observable, oldValue, newValue) -> showFilteredMedia());
        }
    }

    private void updateButtons(Media media) {
        btnRemove.setVisible(true);
        btnRemove.setManaged(true);
        boolean canPlay = media instanceof playable;
        btnPlay.setVisible(canPlay);
        btnPlay.setManaged(canPlay);
    }

    private void hideButtons() {
        btnPlay.setVisible(false);
        btnPlay.setManaged(false);
        btnRemove.setVisible(false);
        btnRemove.setManaged(false);
    }

    private void updateTotalCost() {
        if (costLabel != null) {
            costLabel.setText(String.format("%.2f $", cart.totalCost()));
        }
    }

    private void showFilteredMedia() {
        if (filteredItems == null) {
            return;
        }

        final String keyword = tfFilter == null || tfFilter.getText() == null
                ? ""
                : tfFilter.getText().trim().toLowerCase();

        filteredItems.setPredicate(media -> {
            if (keyword.isEmpty()) {
                return true;
            }
            if (radioBtnFilterId != null && radioBtnFilterId.isSelected()) {
                return String.valueOf(media.getId()).contains(keyword);
            }
            return media.isMatch(keyword);
        });
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media != null) {
            cart.removeMedia(media);
            tblMedia.getSelectionModel().clearSelection();
            hideButtons();
        }
    }

    @FXML
    void btnPlayPressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media instanceof playable) {
            try {
                ((playable) media).play();
            } catch (PlayerException e) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Playback Error");
                alert.setHeaderText("Cannot play this media");
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }
        }
    }

    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
        if (cart.getItemsOrdered().isEmpty()) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Place Order");
            alert.setHeaderText(null);
            alert.setContentText("Your cart is empty.");
            alert.showAndWait();
            return;
        }

        cart.clear();
        tblMedia.getSelectionModel().clearSelection();
        hideButtons();

        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Place Order");
        alert.setHeaderText(null);
        alert.setContentText("Your order has been placed successfully.");
        alert.showAndWait();
    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {
        if (store == null) {
            return;
        }

        try {
            URL storeUrl = getClass().getResource(STORE_FXML_FILE_PATH);
            if (storeUrl == null) {
                throw new IOException("Cannot find " + STORE_FXML_FILE_PATH);
            }
            FXMLLoader fxmlLoader = new FXMLLoader(storeUrl);
            ViewStoreController viewStoreController = new ViewStoreController(store, cart);
            fxmlLoader.setController(viewStoreController);

            Parent root = fxmlLoader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("AIMS - Customer Store");
            stage.show();
        } catch (IOException e) {
            System.err.println("Cannot open Store screen: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
