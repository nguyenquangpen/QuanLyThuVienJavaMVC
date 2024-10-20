package LoginRegisterView;

import Controller.FuntionController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class FuntionLogin extends JFrame {
    public static final long serialVersionUID = 1L;
    public JPanel contentPane;

    public FuntionLogin() {
        this.init();
        this.setVisible(true);
    }

    private void init() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 293, 352);

        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Register Librarian");
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        ActionListener ac = new FuntionController(this);

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnNewButton = new JButton("Thủ Thư");
        btnNewButton.addActionListener(ac);

        btnNewButton.setIcon(new ImageIcon("D:\\Eclipse_java\\Final_prj\\Image\\librarian.png"));
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnNewButton.setBounds(66, 132, 160, 41);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Độc Giả");
        btnNewButton_1.addActionListener(ac);
        btnNewButton_1.setIcon(new ImageIcon("D:\\Eclipse_java\\Final_prj\\Image\\graduated.png"));
        btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnNewButton_1.setBounds(66, 229, 160, 41);
        contentPane.add(btnNewButton_1);

        JLabel lblNewLabel = new JLabel("Nghề Nghiệp");
        lblNewLabel.setIcon(new ImageIcon("D:\\Eclipse_java\\Final_prj\\Image\\choose-2_102347.png"));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel.setBounds(50, 48, 185, 36);
        contentPane.add(lblNewLabel);
        /*
         * URL urlNew = QLSVView.class.getResource("books-icon.png");
		Image img = Toolkit.getDefaultToolkit().createImage(urlNew);
		this.setIconImage(img);
		*/
     try {
		// Tạo File từ đường dẫn tệp
		    File imageFile = new File("D:/Application/bookshelf.png");
		    // Chuyển File thành URL
		    URL imageUrl = imageFile.toURI().toURL();
		    
		    // Tạo Image từ URL bằng Toolkit
		    Image icon = Toolkit.getDefaultToolkit().createImage(imageUrl);
		    this.setIconImage(icon);  // Gán ảnh làm biểu tượng cho JFrame
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
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
