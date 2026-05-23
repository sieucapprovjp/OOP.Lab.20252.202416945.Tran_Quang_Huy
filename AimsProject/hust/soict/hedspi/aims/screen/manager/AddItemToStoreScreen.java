package hust.soict.hedspi.aims.screen.manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import hust.soict.hedspi.aims.store.Store;

public abstract class AddItemToStoreScreen extends JFrame {
    protected Store store;
    protected JPanel centerPanel;

    public AddItemToStoreScreen(Store store, String title) {
        this.store = store;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        // Tái sử dụng thanh điều hướng giống hệt màn hình chính
        cp.add(createNorth(title), BorderLayout.NORTH);

        // Khung trung tâm dùng BoxLayout để xếp các hàng Label + TextField
        centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        cp.add(centerPanel, BorderLayout.CENTER);

        // Gọi phương thức bổ sung các trường dữ liệu riêng của từng lớp con
        addFormFields();

        // Nút bấm xác nhận lưu vật phẩm vào kho
        JButton btnAdd = new JButton("Add Item");
        centerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        centerPanel.add(btnAdd);

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleAdding();
                // Sau khi thêm thành công, tự động quay về màn hình Store chính
                new StoreManagerScreen(store);
                dispose();
            }
        });

        setTitle(title);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private JPanel createNorth(String titleText) {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));

        // Thiết lập Menu Bar
        JMenu menu = new JMenu("Options");
        JMenuItem viewStoreMenu = new JMenuItem("View store");
        menu.add(viewStoreMenu);
        viewStoreMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StoreManagerScreen(store);
                dispose();
            }
        });

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
        north.add(menuBar);

        // Thiết lập Header dòng chữ tiêu đề form
        JPanel header = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel title = new JLabel(titleText);
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 30));
        title.setForeground(Color.BLUE);
        header.add(title);
        north.add(header);

        return north;
    }

    // Hàm tiện ích giúp các lớp con nhanh chóng dựng cặp nhãn - ô nhập liệu
    protected JTextField addFormField(String labelName) {
        JPanel row = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel label = new JLabel(labelName);
        label.setPreferredSize(new Dimension(120, 20));
        JTextField textField = new JTextField(40);
        row.add(label);
        row.add(textField);
        centerPanel.add(row);
        return textField;
    }

    // Phương thức bắt buộc các lớp con phải ghi đè để vẽ Form cám biệt
    protected abstract void addFormFields();

    // Phương thức định nghĩa logic đóng gói đối tượng để đẩy vào kho lưu trữ
    protected abstract void handleAdding();
}