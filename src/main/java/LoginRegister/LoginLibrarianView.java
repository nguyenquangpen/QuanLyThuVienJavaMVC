package LoginRegister;

import Controller.LibrarianLoginController;
import LibrarianView.QLSachView;
import dao.LibrarianDao;
import model.Librarian;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
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
        setBounds(100, 100, 285, 331);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Login Librarian");
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        ActionListener ac = new LibrarianLoginController(this);

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel LoginTitle = new JLabel("Login Librarian");
        LoginTitle.setFont(new Font("Georgia", Font.BOLD, 20));
        LoginTitle.setBounds(64, 30, 173, 29);
        contentPane.add(LoginTitle);

        jtfUserName = new JTextField();
        jtfUserName.setFont(new Font("Tahoma", Font.PLAIN, 13));
        jtfUserName.setBounds(114, 98, 123, 20);
        contentPane.add(jtfUserName);
        jtfUserName.setColumns(10);

        jtfPassword = new JPasswordField();
        jtfPassword.setBounds(114, 175, 123, 20);
        contentPane.add(jtfPassword);

        JLabel lblNewLabel_1 = new JLabel("Username");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_1.setBounds(10, 101, 74, 14);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Password");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_2.setBounds(10, 177, 68, 14);
        contentPane.add(lblNewLabel_2);

        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(110, 216, 89, 23);
        contentPane.add(btnLogin);
        btnLogin.addActionListener(ac);

        JLabel lblNewLabel_3 = new JLabel("New Librarian ?");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_3.setBounds(64, 269, 92, 14);
        contentPane.add(lblNewLabel_3);

        jlabel_Register = new JLabel("<html><u>Sign Up</u></html>");
        jlabel_Register.setFont(new Font("Tahoma", Font.PLAIN, 13));
        jlabel_Register.setBounds(166, 269, 49, 14);
        jlabel_Register.setForeground(Color.BLUE);
        contentPane.add(jlabel_Register);
        AddSignUp();

        JLabel lblNewLabel = new JLabel("Librarian ID");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel.setBounds(10, 139, 74, 14);
        contentPane.add(lblNewLabel);

        jtfLibrarianID = new JTextField();
        jtfLibrarianID.setFont(new Font("Tahoma", Font.PLAIN, 13));
        jtfLibrarianID.setBounds(114, 136, 123, 20);
        contentPane.add(jtfLibrarianID);
        jtfLibrarianID.setColumns(10);
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
        int librarianID;

        try {
            librarianID = Integer.parseInt(jtfLibrarianID.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "LibrarianID phải là số!");
            return;
        }

        Librarian librarian = LibrarianDao.getInstance().selectByName(username);

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
}
