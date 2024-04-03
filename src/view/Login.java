
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Login extends JPanel {
    private JPanel pnTitlebg;
    private JLabel lbTitle, lbTaikhoan, lbMatkhau;
    private JTextField tfTaikhoan, tfMatkhau;
    private JButton btnForgot, btnLogin;

    public Login() {
        initComponents();
        setBackground(new Color(0xB3, 0xBE, 0xCB));
        setLayout(null);
        setVisible(true);
    }

    public void initComponents() {
        lbTitle = new JLabel();
        lbTitle.setText("ĐĂNG NHẬP");
        lbTitle.setForeground(new Color(255, 255, 255));
        lbTitle.setBounds(270, 10, 200, 20);

        pnTitlebg = new JPanel();
        pnTitlebg.setBounds(0, 0, 600, 30);
        Color color = Color.decode("#D8A3AB");
        pnTitlebg.setBackground(color);
        pnTitlebg.add(lbTitle);
        add(pnTitlebg);

        lbTaikhoan = new JLabel();
        lbTaikhoan.setText("Tài khoản:");
        lbTaikhoan.setBounds(50, 100, 300, 40);
        add(lbTaikhoan);

        lbMatkhau = new JLabel();
        lbMatkhau.setText("Mật khẩu:");
        lbMatkhau.setBounds(50, 150, 300, 40);
        add(lbMatkhau);

        tfTaikhoan = new JTextField();
        tfTaikhoan.setBackground(new Color(255, 255, 255));
        tfTaikhoan.setBounds(150, 105, 300, 30);
        add(tfTaikhoan);

        tfMatkhau = new JTextField();
        tfMatkhau.setBackground(new Color(255, 255, 255));
        tfMatkhau.setBounds(150, 155, 300, 30);
        add(tfMatkhau);

        btnForgot = new JButton("Quên mật khẩu");
        btnForgot.setBounds(150, 250, 140, 30);
        Color colorbtn1 = Color.decode("#009594");
        btnForgot.setBackground(colorbtn1);
        add(btnForgot);

        btnLogin = new JButton("Đăng nhập");
        btnLogin.setBounds(300, 250, 140, 30);
        Color colorbtn2 = Color.decode("#009594");
        btnLogin.setBackground(colorbtn2);
        add(btnLogin);
        
        Font font = new Font("Segoe UI", Font.PLAIN, 15); 
        Font font1 = new Font("Segoe UI", Font.BOLD, 15);  
        lbTitle.setFont(font1);  
        lbTaikhoan.setFont(font);  
        lbMatkhau.setFont(font);  
        tfTaikhoan.setFont(font);  
        tfMatkhau.setFont(font);  
        btnForgot.setFont(font);  
        btnLogin.setFont(font);  
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Login Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new Login());
        frame.setSize(600, 400);
        frame.setVisible(true);
    }
}
