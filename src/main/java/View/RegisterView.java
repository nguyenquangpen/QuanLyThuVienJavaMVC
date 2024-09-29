package View;

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
        this.setSize(300, 400);
        this.setLocationRelativeTo(null);

        ActionListener action = new QLRegisterController(this);

        Font fontTitle = new Font("Times New Roman", Font.BOLD, 30);

        JLabel lblTitle = new JLabel("Register");
        lblTitle.setFont(fontTitle);
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);

        Font font = new Font("Arial", Font.PLAIN, 15);

        JLabel jtfUsername = new JLabel("Username");
        jtfUsername.setFont(font);
        JLabel jtfPassword = new JLabel("Password");
        jtfPassword.setFont(font);
        JLabel jtfConfirmPassword = new JLabel("Confirm Password");
        jtfConfirmPassword.setFont(font);

        jtfUsernameField = new JTextField();
        jtfPasswordField = new JPasswordField();
        jtfConfirmPasswordField = new JPasswordField();

        btnRegister = new JButton("Register");
        btnRegister.addActionListener(action);

        // Panel cho form nhập liệu
        JPanel panel = new JPanel(new GridLayout(7, 1, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.add(jtfUsername);
        panel.add(jtfUsernameField);
        panel.add(jtfPassword);
        panel.add(jtfPasswordField);
        panel.add(jtfConfirmPassword);
        panel.add(jtfConfirmPasswordField);

        // Panel cho nút
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(btnRegister);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        this.setLayout(new BorderLayout());
        this.add(lblTitle, BorderLayout.NORTH);
        this.add(panel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
    }

    public void ThucHienDangKy() {
        String username = jtfUsernameField.getText();
        String password = new String(jtfPasswordField.getPassword());
        String confirmPassword = new String(jtfConfirmPasswordField.getPassword());

        // Kiểm tra mật khẩu
        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(null, "Passwords Không giống nhau");
        }
        // Kiểm tra trường không được để trống
        else if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Không được để trống");
        }
        // Kiểm tra người dùng đã tồn tại
        else if (UserDAO.getInstance().selectByCondition(username) != null) {
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

}
