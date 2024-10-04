package LoginRegister;

import LibrarianController.FuntionController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class FuntionLogin extends JFrame {
    public static final long serialVersionUID = 1L;
    public JPanel contentPane;

    public FuntionLogin() {
        this.setVisible(true);
        this.init();
    }

    private void init() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 243, 295);

        ActionListener ac = new FuntionController(this);

        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Register Librarian");
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnNewButton = new JButton("Thủ Thư");
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnNewButton.setBounds(53, 109, 119, 23);
        btnNewButton.addActionListener(ac);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Độc Giả");
        btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnNewButton_1.setBounds(53, 165, 119, 23);
        btnNewButton_1.addActionListener(ac);
        contentPane.add(btnNewButton_1);

        JLabel lblNewLabel = new JLabel("Nghề Nghiệp");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel.setBounds(34, 36, 165, 36);
        contentPane.add(lblNewLabel);
    }

    public void ThuchienChuyenThuThu() {
        this.dispose();
        new LoginLibrarianView();
    }

    public void ThuchienChuyenDocGia() {
        this.dispose();
        new LoginView();
    }
}
