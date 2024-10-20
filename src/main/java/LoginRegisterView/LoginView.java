package LoginRegisterView;

import Controller.QLLoginController;
import LibrarianView.QLSachView;
import LibrarianView.StudentView;
import ReadersView.ReaderBookView;
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
        getContentPane().setBackground(new Color(223, 225, 221));
        this.setTitle("Login");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(297, 342);
        this.setLocationRelativeTo(null);

        ActionListener ac = new QLLoginController(this);

        Font fontTitle = new Font("Times New Roman", Font.BOLD, 30);
        JLabel jLabelTitle = new JLabel("Login");
        jLabelTitle.setBounds(0, 0, 266, 35);
        jLabelTitle.setFont(fontTitle);
        jLabelTitle.setHorizontalAlignment(SwingConstants.CENTER);

        Font font = new Font("Arial", Font.PLAIN, 15);

        JLabel jLabelUsername = new JLabel("Username");
        jLabelUsername.setBounds(10, 19, 246, 32);
        jLabelUsername.setIcon(new ImageIcon("D:\\Eclipse_java\\Final_prj\\Image\\22_104877.png"));
        jLabelUsername.setFont(font);
        jtfUsername = new JTextField(15);
        jtfUsername.setFont(new Font("Tahoma", Font.PLAIN, 13));
        jtfUsername.setBounds(10, 62, 246, 32);

        JLabel jLabelPassword = new JLabel("Password");
        jLabelPassword.setBounds(10, 105, 246, 32);
        jLabelPassword.setIcon(new ImageIcon("D:\\Eclipse_java\\Final_prj\\Image\\40_104848.png"));
        jLabelPassword.setFont(font);
        jtfPassword = new JPasswordField(15);
        jtfPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
        jtfPassword.setBounds(10, 148, 246, 32);

        JPanel panelCenter = new JPanel();
        panelCenter.setBackground(new Color(239, 240, 238));
        panelCenter.setBounds(10, 41, 266, 185);
        panelCenter.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        panelCenter.setLayout(null);
        panelCenter.add(jLabelUsername);
        panelCenter.add(jtfUsername);
        panelCenter.add(jLabelPassword);
        panelCenter.add(jtfPassword);
        getContentPane().setLayout(null);
        getContentPane().add(jLabelTitle);
        getContentPane().add(panelCenter);

        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
        loginButton.setBounds(30, 270, 102, 23);
        loginButton.addActionListener(ac);
        getContentPane().add(loginButton);

        jLabel_SignUp = new JLabel("<html><u>Sign Up</u></html>");
        jLabel_SignUp.setBounds(20, 237, 68, 23);
        AddSignUp();
        getContentPane().add(jLabel_SignUp);
        jLabel_SignUp.setForeground(Color.BLUE);
        
        JButton btnback = new JButton("Back");
        btnback.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnback.setBounds(164, 272, 102, 23);
        btnback.addActionListener(ac);
        getContentPane().add(btnback);
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
        UserDAO userDAO = new UserDAO();
        User user = userDAO.selectByName(username);
        try {
        	if (username.isEmpty() || password.isEmpty()) {
        		JOptionPane.showMessageDialog(null, "Vui lòng nhập đầu đủ thông tin", "Lỗi", JOptionPane.ERROR_MESSAGE);
        	}
        	else if (!user.getUsername().equals(username) || !user.getPassword().equals(password)) {
                JOptionPane.showMessageDialog(null, "Sai tên đăng nhập hoặc mật khẩu", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        	else {
                JOptionPane.showMessageDialog(null, "Đăng nhập thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                this.dispose(); 
                new ReaderBookView(); 
            }
        }catch(NullPointerException e) {
        	JOptionPane.showMessageDialog(null,"Người dùng không tồn tại", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }catch (Exception e) {
        	JOptionPane.showMessageDialog(null,"Lỗi nhập thông tin sai", "Lỗi", JOptionPane.ERROR_MESSAGE);
		}
    }

    public void ThuchienDangKy() {
        this.dispose();
        new RegisterView();
    }
    
    public void QuayLaiLogin() {
    	this.dispose();
    	new FuntionLogin();
    }
}
