package hust.soict.hedspi.aims.screen.manager;

import javax.swing.*;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfTitle;
    private JTextField tfCategory;
    private JTextField tfDirector;
    private JTextField tfLength;
    private JTextField tfCost;

    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store, "Add DVD to Store");
    }

    @Override
    protected void addFormFields() {
        tfTitle = addFormField("Title:");
        tfCategory = addFormField("Category:");
        tfDirector = addFormField("Director:");
        tfLength = addFormField("Length (mins):");
        tfCost = addFormField("Cost ($):");
    }

    @Override
    protected void handleAdding() {
        String title = tfTitle.getText();
        String category = tfCategory.getText();
        String director = tfDirector.getText();
        int length = Integer.parseInt(tfLength.getText());
        float cost = Float.parseFloat(tfCost.getText());

        // Gọi Constructor đầy đủ từ file DigitalVideoDisc.java của bạn
        DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
        store.addMedia(dvd);
        JOptionPane.showMessageDialog(this, "DVD \"" + title + "\" đã được thêm vào kho thành công!");
    }
}