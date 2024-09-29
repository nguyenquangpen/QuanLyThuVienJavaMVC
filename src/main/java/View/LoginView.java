package View;

import Controller.QLLoginController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginView extends JFrame {
    public JTextField jtfUsername;
    public JPasswordField jtfPassword;
    public LoginView() {

        this.init();
        this.setVisible(true);
    }

    private void init() {
        this.setTitle("Login");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(280, 300);
        this.setLocationRelativeTo(null);

        ActionListener action = new QLLoginController(this);

        Font fontTitle = new Font("Times New Roman", Font.BOLD, 30);
        JLabel jLabelTitle = new JLabel("Login");
        jLabelTitle.setFont(fontTitle);
        jLabelTitle.setHorizontalAlignment(SwingConstants.CENTER); // chỉnh khoang cach title

        Font font = new Font("Arial", Font.PLAIN, 15);

        JLabel jLabelUsername = new JLabel("Username");
        jLabelUsername.setFont(font);
        jtfUsername = new JTextField(15);

        JLabel jLabelPassword = new JLabel("Password");
        jLabelPassword.setFont(font);
        jtfPassword = new JPasswordField(15);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(action);
        JButton registerButton = new JButton("Register");

        JPanel panelCenter = new JPanel(new GridLayout(4, 1, 5, 5));
        panelCenter.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelCenter.add(jLabelUsername);
        panelCenter.add(jtfUsername);
        panelCenter.add(jLabelPassword);
        panelCenter.add(jtfPassword);

        JPanel panelDow = new JPanel(new GridLayout(1, 2, 10, 0));
        panelDow.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelDow.add(loginButton);
        panelDow.add(registerButton);

        this.setLayout(new BorderLayout());
        this.add(jLabelTitle, BorderLayout.NORTH);
        this.add(panelCenter, BorderLayout.CENTER);
        this.add(panelDow, BorderLayout.SOUTH);
    }

    public void ThucHienDangNhap() {
        String username = jtfUsername.getText();
        String passwordStr = new String(jtfPassword.getPassword());
        if(username.equals("Amin") || passwordStr.equals("1234")) {
            System.exit(0);
        }
    }

    public void ChuyenSangRegister() {
        this.setVisible(false);
    }
}
