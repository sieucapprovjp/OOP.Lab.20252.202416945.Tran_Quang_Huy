package hust.soict.hedspi.aims.screen.manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.Media;

public class StoreManagerScreen extends JFrame {
    private Store store;

    public StoreManagerScreen(Store store) {
        this.store = store;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setTitle("Store Management System");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // Tạo cụm giao diện phía Bắc (Menu + Header)
    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    // Tạo thanh Menu Bar điều hướng hệ thống
    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenuItem viewStoreMenu = new JMenuItem("View store");
        menu.add(viewStoreMenu);

        // Sự kiện khi bấm "View Store" -> Vẽ lại màn hình chính
        viewStoreMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StoreManagerScreen(store);
                dispose(); // Đóng cửa sổ cũ
            }
        });

        JMenu smUpdateStore = new JMenu("Update Store");
        JMenuItem addBookMenu = new JMenuItem("Add Book");
        JMenuItem addCDMenu = new JMenuItem("Add CD");
        JMenuItem addDVDMenu = new JMenuItem("Add DVD");

        smUpdateStore.add(addBookMenu);
        smUpdateStore.add(addCDMenu);
        smUpdateStore.add(addDVDMenu);
        menu.add(smUpdateStore);

        // Thiết lập bộ lắng nghe chuyển màn hình cho các chức năng thêm mới vật phẩm
        addBookMenu.addActionListener(new AddItemListener("Book"));
        addCDMenu.addActionListener(new AddItemListener("CD"));
        addDVDMenu.addActionListener(new AddItemListener("DVD"));

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
        return menuBar;
    }

    // Tạo dải Header màu xanh Cyan chữ lớn thương hiệu
    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10, 10)));
        return header;
    }

    // Tạo lưới hiển thị danh sách Media ở Center
    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));

        ArrayList<Media> mediaInStore = store.getItemsInStore();
        // Hiển thị tối đa 9 item lên cấu trúc lưới 3x3
        int limit = Math.min(mediaInStore.size(), 9);
        for (int i = 0; i < limit; i++) {
            MediaStore cell = new MediaStore(mediaInStore.get(i));
            center.add(cell);
        }
        return center;
    }

    // Inner Class điều hướng chuyển sang các màn hình nhập liệu tương ứng
    private class AddItemListener implements ActionListener {
        private String type;
        public AddItemListener(String type) { this.type = type; }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (type.equals("Book")) {
                new AddBookToStoreScreen(store);
            } else if (type.equals("CD")) {
                new AddCompactDiscToStoreScreen(store);
            } else if (type.equals("DVD")) {
                new AddDigitalVideoDiscToStoreScreen(store);
            }
            dispose(); // Giải phóng màn hình hiển thị cũ nhằm tối ưu bộ nhớ
        }
    }
}