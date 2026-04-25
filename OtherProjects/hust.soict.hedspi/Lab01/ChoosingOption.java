// Ex 6.1
// Write, compile and run the ChoosingOption program:

import javax.swing.JOptionPane;

public class ChoosingOption {
    public static void main(String[] args) {
        int option = JOptionPane.showConfirmDialog(null,"Do you want to change to the first class tickets?");
        JOptionPane.showMessageDialog(null,"You have chosen: " + (option==JOptionPane.YES_OPTION?"YES":"NO"));
        System.exit(0);
    }
}
