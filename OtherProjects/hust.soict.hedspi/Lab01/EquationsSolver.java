// Ex 2.2.6 Equations solver
// Press 1,2 or 3 to choose

import javax.swing.JOptionPane;

public class EquationsSolver {
    public static void main(String[] args) {
        String menu = "Chọn loại phương trình cần giải:\n"
                + "1. Phương trình bậc nhất một ẩn (ax + b = 0)\n"
                + "2. Hệ phương trình bậc nhất hai ẩn\n"
                + "3. Phương trình bậc hai một ẩn (ax^2 + bx + c = 0)";
        String choice = JOptionPane.showInputDialog(null, menu, "Equation Solver", JOptionPane.INFORMATION_MESSAGE);

        if (choice == null) {
            System.exit(0);
        }

        switch (choice) {
            case "1":
                solveLinearEquation();
                break;
            case "2":
                solveLinearSystem();
                break;
            case "3":
                solveQuadraticEquation();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Lựa chọn không hợp lệ!");
        }
        System.exit(0);
    }

    // 1. Giải phương trình bậc nhất một ẩn (ax + b = 0)
    private static void solveLinearEquation() {
        double a = Double.parseDouble(JOptionPane.showInputDialog("Nhập hằng số a:"));
        double b = Double.parseDouble(JOptionPane.showInputDialog("Nhập hằng số b:"));

        // Xử lý trường hợp a = 0
        if (a == 0) {
            if (b == 0) {
                JOptionPane.showMessageDialog(null, "Phương trình có vô số nghiệm.");
            } else {
                JOptionPane.showMessageDialog(null, "Phương trình vô nghiệm.");
            }
        } else {
            double x = -b / a;
            JOptionPane.showMessageDialog(null, "Nghiệm của phương trình là x = " + x);
        }
    }

    // 2. Giải hệ phương trình bậc nhất hai ẩn
    private static void solveLinearSystem() {
        double a11 = Double.parseDouble(JOptionPane.showInputDialog("Nhập a11:"));
        double a12 = Double.parseDouble(JOptionPane.showInputDialog("Nhập a12:"));
        double b1 = Double.parseDouble(JOptionPane.showInputDialog("Nhập b1:"));
        double a21 = Double.parseDouble(JOptionPane.showInputDialog("Nhập a21:"));
        double a22 = Double.parseDouble(JOptionPane.showInputDialog("Nhập a22:"));
        double b2 = Double.parseDouble(JOptionPane.showInputDialog("Nhập b2:"));
        // Tính các định thức D, D1, D2
        double D = a11 * a22 - a21 * a12;
        double D1 = b1 * a22 - b2 * a12;
        double D2 = a11 * b2 - a21 * b1;
        if (D != 0) {
            double x1 = D1 / D;
            double x2 = D2 / D;
            JOptionPane.showMessageDialog(null, "Hệ phương trình có nghiệm duy nhất:\nx1 = " + x1 + "\nx2 = " + x2);
        } else {
            // Xử lý trường hợp vô số nghiệm hoặc vô nghiệm
            if (D1 == 0 && D2 == 0) {
                JOptionPane.showMessageDialog(null, "Hệ phương trình có vô số nghiệm.");
            } else {
                JOptionPane.showMessageDialog(null, "Hệ phương trình vô nghiệm.");
            }
        }
    }

    // 3. Giải phương trình bậc hai một ẩn (ax^2 + bx + c = 0)
    private static void solveQuadraticEquation() {
        double a = Double.parseDouble(JOptionPane.showInputDialog("Nhập hằng số a:"));
        double b = Double.parseDouble(JOptionPane.showInputDialog("Nhập hằng số b:"));
        double c = Double.parseDouble(JOptionPane.showInputDialog("Nhập hằng số c:"));

        // Xử lý trường hợp a = 0 (trở thành phương trình bậc nhất bx + c = 0)
        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    JOptionPane.showMessageDialog(null, "Phương trình có vô số nghiệm.");
                } else {
                    JOptionPane.showMessageDialog(null, "Phương trình vô nghiệm.");
                }
            } else {
                double x = -c / b;
                JOptionPane.showMessageDialog(null, "Vì a = 0, phương trình trở thành bậc nhất. Nghiệm là x = " + x);
            }
        } else {
            // Sử dụng biệt thức Delta
            double delta = b * b - 4 * a * c;

            if (delta > 0) {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                JOptionPane.showMessageDialog(null, "Phương trình có 2 nghiệm phân biệt:\nx1 = " + x1 + "\nx2 = " + x2);
            } else if (delta == 0) {
                // Trường hợp nghiệm kép
                double x = -b / (2 * a);
                JOptionPane.showMessageDialog(null, "Phương trình có nghiệm kép: x = " + x);
            } else {
                // Trường hợp vô nghiệm thực
                JOptionPane.showMessageDialog(null, "Phương trình vô nghiệm thực.");
            }
        }
    }
}