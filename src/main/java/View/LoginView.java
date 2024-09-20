package View;

import javax.swing.*;
import java.awt.*;

public class LoginView extends JFrame {
    private JTextField jtfUsername;
    private JPasswordField jtfPassword;
    public LoginView() {
        this.init();
        this.setVisible(true);
    }

    private void init() {
        this.setTitle("Login");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);

        Font fontTitle = new Font("Times New Roman", Font.BOLD, 20);
        JLabel jLabelTitle = new JLabel("Login");
        jLabelTitle.setFont(fontTitle);

        JLabel jLabelUsername = new JLabel("Username");
        jtfUsername = new JTextField(10);

        JLabel jLabelPassword = new JLabel("Password");
        jtfPassword = new JPasswordField(10);

        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Register");
        Panel panel = new Panel();
        panel.add(jLabelTitle);
    }
}
