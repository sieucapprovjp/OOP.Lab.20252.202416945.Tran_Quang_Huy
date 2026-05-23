package hust.soict.hedspi.aims.screen.manager;

import javax.swing.*;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.CompactDisc;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfTitle;
    private JTextField tfCategory;
    private JTextField tfDirector;
    private JTextField tfArtist;
    private JTextField tfLength;
    private JTextField tfCost;

    public AddCompactDiscToStoreScreen(Store store) {
        super(store, "Add CD to Store");
    }

    @Override
    protected void addFormFields() {
        tfTitle = addFormField("Title:");
        tfCategory = addFormField("Category:");
        tfDirector = addFormField("Director:");
        tfArtist = addFormField("Artist:");
        tfLength = addFormField("Initial Length:");
        tfCost = addFormField("Cost ($):");
    }

    @Override
    protected void handleAdding() {
        String title = tfTitle.getText();
        String category = tfCategory.getText();
        String director = tfDirector.getText();
        String artist = tfArtist.getText();
        int length = Integer.parseInt(tfLength.getText());
        float cost = Float.parseFloat(tfCost.getText());

        // Khởi tạo CD dựa trên constructor từ file CompactDisc.java của bạn
        CompactDisc cd = new CompactDisc(title, category, cost, length, director, artist);
        store.addMedia(cd);
        JOptionPane.showMessageDialog(this, "CD \"" + title + "\" đã được thêm vào kho thành công!");
    }
}