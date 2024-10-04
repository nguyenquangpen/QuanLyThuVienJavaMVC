package LoginRegister;

import LibrarianController.QLLoginController;
import LibrarianView.QLSachView;
import dao.UserDAO;
import model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginView extends JFrame {
    public JTextField jtfUsername;
    public JPasswordField jtfPassword;
    public JLabel jLabel_SignUp;
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
        jLabelTitle.setHorizontalAlignment(SwingConstants.CENTER);

        Font font = new Font("Arial", Font.PLAIN, 15);

        JLabel jLabelUsername = new JLabel("Username");
        jLabelUsername.setFont(font);
        jtfUsername = new JTextField(15);

        JLabel jLabelPassword = new JLabel("Password");
        jLabelPassword.setFont(font);
        jtfPassword = new JPasswordField(15);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(action);

        jLabel_SignUp = new JLabel("<html><u>Sign Up</u></html>");
        jLabel_SignUp.setForeground(Color.BLUE);
        AddSignUp();

        JPanel panelCenter = new JPanel(new GridLayout(5, 1, 5, 5));
        panelCenter.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        panelCenter.add(jLabelUsername);
        panelCenter.add(jtfUsername);
        panelCenter.add(jLabelPassword);
        panelCenter.add(jtfPassword);
        panelCenter.add(jLabel_SignUp);

        JPanel panelDow = new JPanel(new GridLayout(1, 2, 10, 0));
        panelDow.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelDow.add(loginButton);

        this.setLayout(new BorderLayout());
        this.add(jLabelTitle, BorderLayout.NORTH);
        this.add(panelCenter, BorderLayout.CENTER);
        this.add(panelDow, BorderLayout.SOUTH);
    }

    public void AddSignUp(){
        jLabel_SignUp.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ThuchienDangKy();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                jLabel_SignUp.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
        });
    }

    public void ThucHienDangNhap() {
        String username = jtfUsername.getText();
        String password = new String(jtfPassword.getPassword());
        User user = UserDAO.getInstance().selectByName(username);
        if(user.getUsername().equals(username) && user.getPassword().equals(password)){
            JOptionPane.showMessageDialog(null, "Đăng nhập Thành công");
            this.dispose();
            new QLSachView();
        }else {
            JOptionPane.showMessageDialog(null, "không thể đăng nhập");
        }
    }

    public void ThuchienDangKy() {
        this.dispose();
        new RegisterView();
    }
}
