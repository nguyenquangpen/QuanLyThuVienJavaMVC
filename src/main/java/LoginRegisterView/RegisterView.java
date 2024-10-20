package LoginRegisterView;

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
        this.setSize(392, 472);
        this.setLocationRelativeTo(null);

        ActionListener ac = new QLRegisterController(this);

        Font fontTitle = new Font("Times New Roman", Font.BOLD, 30);

        JLabel lblTitle = new JLabel("Register");
        lblTitle.setBounds(88, 11, 209, 35);
        lblTitle.setFont(fontTitle);
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);

        Font font = new Font("Arial", Font.PLAIN, 15);

        JLabel jtfUsername = new JLabel("Username");
        jtfUsername.setIcon(new ImageIcon("D:\\Eclipse_java\\Final_prj\\Image\\22_104877.png"));
        jtfUsername.setBounds(10, 11, 131, 36);
        jtfUsername.setFont(font);
        JLabel jtfPassword = new JLabel("Password");
        jtfPassword.setIcon(new ImageIcon("D:\\Eclipse_java\\Final_prj\\Image\\40_104848.png"));
        jtfPassword.setBounds(10, 104, 118, 36);
        jtfPassword.setFont(font);
        JLabel jtfConfirmPassword = new JLabel("Confirm Password");
        jtfConfirmPassword.setIcon(new ImageIcon("D:\\Eclipse_java\\Final_prj\\Image\\11_104884.png"));
        jtfConfirmPassword.setBounds(10, 186, 160, 36);
        jtfConfirmPassword.setFont(font);

        // Panel cho form nhập liệu
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setBounds(10, 78, 176, 240);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setLayout(null);
        panel.add(jtfUsername);
        panel.add(jtfPassword);
        panel.add(jtfConfirmPassword);
        getContentPane().setLayout(null);
        getContentPane().add(lblTitle);
        getContentPane().add(panel);

        JButton btnNewButton = new JButton("Back");
        btnNewButton.setBounds(219, 364, 89, 23);
        btnNewButton.addActionListener(ac);
        getContentPane().add(btnNewButton);
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));

        btnRegister = new JButton("Register");
        btnRegister.addActionListener(ac);

        btnRegister.setBounds(61, 364, 96, 23);
        getContentPane().add(btnRegister);

        btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 13));
        jtfConfirmPasswordField = new JPasswordField();
        jtfConfirmPasswordField.setBounds(196, 267, 157, 36);
        getContentPane().add(jtfConfirmPasswordField);
        jtfPasswordField = new JPasswordField();
        jtfPasswordField.setBounds(196, 188, 157, 36);
        getContentPane().add(jtfPasswordField);

        jtfUsernameField = new JTextField();
        jtfUsernameField.setBounds(196, 94, 157, 36);
        getContentPane().add(jtfUsernameField);
    }

    public void ThucHienDangKy() {
        String username = jtfUsernameField.getText();
        String password = new String(jtfPasswordField.getPassword());
        String confirmPassword = new String(jtfConfirmPasswordField.getPassword());
        String column = "username";
        UserDAO userDAO = new UserDAO();

        // Kiểm tra mật khẩu
        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(null, "Passwords Không giống nhau");
        }
        // Kiểm tra trường không được để trống
        else if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Không được để trống");
        }
        // Kiểm tra người dùng đã tồn tại
        else if (userDAO.selectByName(username) != null) {
            JOptionPane.showMessageDialog(null, "Tên Đã tồn tại, vui lòng nhập lại thông tin");
        }
        else {
            User user = new User(username, password);
            userDAO.insert(user);
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
