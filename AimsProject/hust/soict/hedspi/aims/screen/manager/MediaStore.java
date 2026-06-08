package hust.soict.hedspi.aims.screen.manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.playable;

public class MediaStore extends JPanel {
    private Media media;
    public MediaStore(Media media) {
        this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 15));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel("" + media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));
        // Trong file MediaStore.java
        if (media instanceof playable) {
            JButton playButton = new JButton("Play");
            container.add(playButton);

            playButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Tạo cửa sổ thông báo của Swing trước
                    JDialog dialog = new JDialog((Frame) SwingUtilities.getWindowAncestor(MediaStore.this), "Play Media", true);
                    dialog.setLayout(new FlowLayout());

                    try {
                        // Gọi phương thức play() ném ra PlayerException đã được import
                        ((playable) media).play();

                        // Nếu phát đĩa thành công (độ dài > 0), hiển thị thông báo lên JDialog
                        dialog.add(new JLabel("Playing: " + media.getTitle()));
                        dialog.setSize(300, 150);
                        dialog.setLocationRelativeTo(MediaStore.this);
                        dialog.setVisible(true);

                    } catch (PlayerException ex) {
                        // Bắt CHÍNH XÁC Checked Exception và hiển thị thông báo lỗi màu đỏ (Yêu cầu mục 11)
                        JOptionPane.showMessageDialog(
                                MediaStore.this,
                                ex.getMessage(),
                                "Illegal Media Length Error",
                                JOptionPane.ERROR_MESSAGE
                        );
                    }
                }
            });
        }
        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}