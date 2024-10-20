package LoginRegisterView;

import Controller.LibrarianLoginController;
import LibrarianView.QLSachView;
import dao.LibrarianDao;
import model.Librarian;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginLibrarianView extends JFrame {
    public static final long serialVersionUID = 1L;
    public JPanel contentPane;
    public JTextField jtfUserName;
    public JPasswordField jtfPassword;
    public JTextField jtfLibrarianID;
    public JLabel jlabel_Register;

    public LoginLibrarianView() {
        this.init();
        this.setVisible(true);
    }
    private void init() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 310, 373);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Login Librarian");
        ActionListener ac = new LibrarianLoginController(this);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel LoginTitle = new JLabel("Login Librarian");
        LoginTitle.setFont(new Font("Georgia", Font.BOLD, 23));
        LoginTitle.setBounds(64, 26, 189, 33);
        contentPane.add(LoginTitle);

        jtfUserName = new JTextField();
        jtfUserName.setFont(new Font("Tahoma", Font.PLAIN, 13));
        jtfUserName.setBounds(166, 81, 123, 33);
        contentPane.add(jtfUserName);
        jtfUserName.setColumns(10);

        jtfPassword = new JPasswordField();
        jtfPassword.setBounds(166, 206, 123, 33);
        contentPane.add(jtfPassword);

        JButton btnLogin = new JButton("Login");
        btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnLogin.setBounds(41, 269, 89, 23);
        btnLogin.addActionListener(ac);
        contentPane.add(btnLogin);

        JLabel lblNewLabel_3 = new JLabel("New Librarian ?");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_3.setBounds(64, 311, 92, 14);
        contentPane.add(lblNewLabel_3);

        jlabel_Register = new JLabel("<html><u>Sign Up</u></html>");
        jlabel_Register.setFont(new Font("Tahoma", Font.PLAIN, 13));
        jlabel_Register.setBounds(166, 311, 49, 14);
        jlabel_Register.setForeground(Color.BLUE);
        AddSignUp();
        contentPane.add(jlabel_Register);

        jtfLibrarianID = new JTextField();
        jtfLibrarianID.setFont(new Font("Tahoma", Font.PLAIN, 13));
        jtfLibrarianID.setBounds(166, 143, 123, 33);
        contentPane.add(jtfLibrarianID);
        jtfLibrarianID.setColumns(10);

        JPanel panel = new JPanel();
        panel.setBounds(10, 71, 132, 168);
        panel.setBackground(new Color(255, 255, 255));
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel jlbpassworld = new JLabel("Password");
        jlbpassworld.setIcon(new ImageIcon("D:\\Eclipse_java\\Final_prj\\Image\\40_104848.png"));
        jlbpassworld.setBounds(4, 125, 104, 32);
        panel.add(jlbpassworld);
        jlbpassworld.setFont(new Font("Tahoma", Font.PLAIN, 13));

        JLabel jldlibrarianID = new JLabel("Librarian ID");
        jldlibrarianID.setIcon(new ImageIcon("D:\\Eclipse_java\\Final_prj\\Image\\11_104884.png"));
        jldlibrarianID.setBounds(4, 69, 118, 36);
        panel.add(jldlibrarianID);
        jldlibrarianID.setFont(new Font("Tahoma", Font.PLAIN, 13));

        JLabel jldusername = new JLabel("Username");
        jldusername.setIcon(new ImageIcon("D:\\Eclipse_java\\Final_prj\\Image\\22_104877.png"));
        jldusername.setBounds(4, 11, 104, 37);
        panel.add(jldusername);
        jldusername.setFont(new Font("Tahoma", Font.PLAIN, 13));
        
        JButton btnback = new JButton("Back");
        btnback.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnback.setBounds(164, 269, 89, 23);
        contentPane.add(btnback);
        btnback.addActionListener(ac);

    }

    public void AddSignUp(){
        jlabel_Register.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ThuchienDangKy();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                jlabel_Register.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
        });
    }

    public void ThucHienDangNhapLibrarian() {
        String username = jtfUserName.getText();
        String password = new String(jtfPassword.getPassword());
        LibrarianDao librarianDao = new LibrarianDao();
        int librarianID;

        try {
            librarianID = Integer.parseInt(jtfLibrarianID.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "LibrarianID phải là số!");
            return;
        }

        Librarian librarian = librarianDao.selectByName(username);

        if (librarian == null) {
            JOptionPane.showMessageDialog(null, "Tên đăng nhập không tồn tại.");
            return;
        }
        if (username.equals(librarian.getUsername())
                && librarian.getPassword().equals(password)
                && librarian.getLibrarianID() == librarianID) {

            JOptionPane.showMessageDialog(null, "Đăng nhập thành công!");
            this.dispose();
            new QLSachView();

        } else {
            if (!username.equals(librarian.getUsername())) {
                JOptionPane.showMessageDialog(null, "Tên đăng nhập không đúng!");
            } else if (!librarian.getPassword().equals(password)) {
                JOptionPane.showMessageDialog(null, "Mật khẩu không đúng!");
            } else if (librarian.getLibrarianID() != librarianID) {
                JOptionPane.showMessageDialog(null, "LibrarianID không đúng!");
            }
        }
    }


    public void ThuchienDangKy(){
        this.dispose();
        new RegisterLibrarianView();
    }
    
    public void QuayLaiLogin() {
    	this.dispose();
    	new FuntionLogin();
    }
}
