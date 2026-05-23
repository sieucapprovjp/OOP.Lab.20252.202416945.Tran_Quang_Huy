package hust.soict.hedspi.aims.screen.manager;

import javax.swing.*;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.Book;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfTitle;
    private JTextField tfCategory;
    private JTextField tfCost;

    public AddBookToStoreScreen(Store store) {
        super(store, "Add Book to Store");
    }

    @Override
    protected void addFormFields() {
        tfTitle = addFormField("Title:");
        tfCategory = addFormField("Category:");
        tfCost = addFormField("Cost ($):");
    }

    @Override
    protected void handleAdding() {
        String title = tfTitle.getText();
        String category = tfCategory.getText();
        float cost = Float.parseFloat(tfCost.getText());

        // Tạo instance đối tượng Book mới và đưa vào Store
        Book book = new Book(title, category, cost);
        store.addMedia(book);
        JOptionPane.showMessageDialog(this, "Book added to store successfully!");
    }
}