package LoginRegister;

import Controller.LibrarianRegisterController;
import dao.LibrarianDao;
import model.Librarian;

import javax.swing.*;

import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class RegisterLibrarianView extends JFrame {
    public static final long serialVersionUID = 1L;
    public JPanel contentPane;
    public JTextField jtfusername;
    public JTextField jtfLibraianID;
    public JTextField jtfCardID;
    public JPasswordField jtfPassword;

    public RegisterLibrarianView() {
        this.init();
        this.setVisible(true);
    }

    private void init() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 280, 361);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Register Librarian");

        ActionListener ac = new LibrarianRegisterController(this);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel jtfRegisterTitle = new JLabel("Register");
        jtfRegisterTitle.setFont(new Font("Gadugi", Font.BOLD, 20));
        jtfRegisterTitle.setBounds(93, 29, 84, 39);
        contentPane.add(jtfRegisterTitle);

        JLabel lblNewLabel_1 = new JLabel("Username");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_1.setBounds(20, 93, 66, 18);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Password");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_2.setBounds(20, 143, 66, 20);
        contentPane.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("LibraianID");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_3.setBounds(20, 191, 66, 20);
        contentPane.add(lblNewLabel_3);

        jtfusername = new JTextField();
        jtfusername.setBounds(118, 93, 96, 20);
        contentPane.add(jtfusername);
        jtfusername.setColumns(10);

        jtfLibraianID = new JTextField();
        jtfLibraianID.setBounds(118, 192, 96, 20);
        contentPane.add(jtfLibraianID);
        jtfLibraianID.setColumns(10);

        JLabel lblNewLabel_4 = new JLabel("CardID");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_4.setBounds(20, 244, 66, 20);
        contentPane.add(lblNewLabel_4);

        jtfCardID = new JTextField();
        jtfCardID.setBounds(118, 245, 96, 20);
        contentPane.add(jtfCardID);
        jtfCardID.setColumns(10);

        jtfPassword = new JPasswordField();
        jtfPassword.setBounds(118, 144, 96, 20);
        contentPane.add(jtfPassword);

        JButton btnSignUp = new JButton("Sign Up");
        btnSignUp.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnSignUp.setBounds(74, 290, 89, 23);
        btnSignUp.addActionListener(ac);
        contentPane.add(btnSignUp);

    }

    public void ThucHienDangKyLibrarian() {
        String username = jtfusername.getText();
        String password = new String(jtfPassword.getPassword());
        int libraianID = Integer.parseInt(String.valueOf(jtfLibraianID.getText()));
        String cardID = jtfCardID.getText();
        Librarian librarian1 = new Librarian(username, password, libraianID);
        if(ThucHienKiemTraLibrarian()){
            LibrarianDao.getInstance().insert(librarian1);
            JOptionPane.showMessageDialog(null, "Hoàn tất đăng ký");
            this.dispose();
            new LoginLibrarianView();
        }else {
            if(librarian1.getLibrarianID() != libraianID){
                JOptionPane.showMessageDialog(null, "libraianID không khớp !");
            }
            else if (!librarian1.getEmployeeCard().equals(cardID)) {
                JOptionPane.showMessageDialog(null, "mã thẻ không khớp !");
            }
        }
    }

//    public boolean ThucHienKiemTraLibrarian() {
//        int libraianID = Integer.parseInt(String.valueOf(jtfLibraianID.getText()));
//        String cardID = jtfCardID.getText();
//        Librarian librarian = new Librarian(libraianID, cardID);
//        Librarian condition = LibrarianDao.getInstance().selectById(librarian);
//
//        if(condition.getEmployeeCard().equals(cardID) && condition.getLibrarianID() == libraianID) {
//            return true;
//        }
//        return false;
//    }
    public boolean ThucHienKiemTraLibrarian() {
        int librarianID = Integer.parseInt(jtfLibraianID.getText());
        String cardID = jtfCardID.getText();
        Librarian librarian = new Librarian(librarianID, cardID);
        Librarian condition = LibrarianDao.getInstance().selectById(librarian);

        return condition != null && condition.getEmployeeCard().equals(cardID) && condition.getLibrarianID() == librarianID;
    }
}
