package LoginRegister;

import Controller.QLRegisterController;
import dao.UserDAO;
import model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class RegisterView extends JFrame {
    public JTextField jtfUsernameField;
    public JPasswordField jtfPasswordField, jtfConfirmPasswordField;
    public JButton btnRegister;

    public RegisterView() {
        this.init();
        this.setVisible(true);
    }

    private void init() {
        this.setTitle("Register");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 420);
        this.setLocationRelativeTo(null);

        ActionListener ac = new QLRegisterController(this);

        Font fontTitle = new Font("Times New Roman", Font.BOLD, 30);

        JLabel lblTitle = new JLabel("Register");
        lblTitle.setBounds(0, 0, 286, 35);
        lblTitle.setFont(fontTitle);
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);

        Font font = new Font("Arial", Font.PLAIN, 15);

        JLabel jtfUsername = new JLabel("Username");
        jtfUsername.setBounds(20, 22, 246, 36);
        jtfUsername.setFont(font);
        JLabel jtfPassword = new JLabel("Password");
        jtfPassword.setBounds(20, 104, 246, 36);
        jtfPassword.setFont(font);
        JLabel jtfConfirmPassword = new JLabel("Confirm Password");
        jtfConfirmPassword.setBounds(20, 186, 246, 36);
        jtfConfirmPassword.setFont(font);

        jtfUsernameField = new JTextField();
        jtfUsernameField.setBounds(20, 63, 246, 36);
        jtfPasswordField = new JPasswordField();
        jtfPasswordField.setBounds(20, 145, 246, 36);
        jtfConfirmPasswordField = new JPasswordField();
        jtfConfirmPasswordField.setBounds(20, 227, 246, 36);

        btnRegister = new JButton("Register");
        btnRegister.addActionListener(ac);

        btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnRegister.setBounds(32, 11, 82, 23);

        // Panel cho form nhập liệu
        JPanel panel = new JPanel();
        panel.setBounds(0, 35, 286, 289);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setLayout(null);
        panel.add(jtfUsername);
        panel.add(jtfUsernameField);
        panel.add(jtfPassword);
        panel.add(jtfPasswordField);
        panel.add(jtfConfirmPassword);
        panel.add(jtfConfirmPasswordField);

        // Panel cho nút
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBounds(0, 319, 286, 51);
        buttonPanel.setLayout(null);
        buttonPanel.add(btnRegister);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        getContentPane().setLayout(null);
        getContentPane().add(lblTitle);
        getContentPane().add(panel);
        getContentPane().add(buttonPanel);

        JButton btnNewButton = new JButton("Back");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnNewButton.setBounds(153, 11, 89, 23);
        btnNewButton.addActionListener(ac);
        buttonPanel.add(btnNewButton);
    }

    public void ThucHienDangKy() {
        String username = jtfUsernameField.getText();
        String password = new String(jtfPasswordField.getPassword());
        String confirmPassword = new String(jtfConfirmPasswordField.getPassword());
        String column = "username";

        // Kiểm tra mật khẩu
        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(null, "Passwords Không giống nhau");
        }
        // Kiểm tra trường không được để trống
        else if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Không được để trống");
        }
        // Kiểm tra người dùng đã tồn tại
        else if (UserDAO.getInstance().selectByCondition(username, column) != null) {
            JOptionPane.showMessageDialog(null, "Đã tồn tại, vui lòng nhập lại thông tin");
        }
        else {
            User user = new User(username, password);
            UserDAO.getInstance().insert(user);
            JOptionPane.showMessageDialog(null, "Đăng ký thành công");
            this.dispose();
            new LoginView();
        }
    }

    public void ThucHienQuayLai() {
        this.dispose();
        new LoginView();
    }
}
