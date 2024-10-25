package ReadersView;

import Controller.PhieuDkyController;
import dao.StudentDAO;
import model.Student;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class PhieuDkyView extends JFrame {
    public static final long serialVersionUID = 1L;
    public JPanel contentPane;
    public JTextField jtfStudentID;
    public JTextField jtfStudentLocation;
    public JTextField jtfStudentName;
    public JTextField jtfStudentSDT;
    public JTextField jtfStudentGmail;
	private Student student;

    public PhieuDkyView() {
        init();
        this.setVisible(true);
    }

    private void init() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 327);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Phiếu Đăng Ký Mượn");

        ActionListener ac = new PhieuDkyController(this);

        // Khởi tạo JPanel chính
        contentPane = new JPanel();
        contentPane.setBorder(new LineBorder(Color.GRAY, 1));
        contentPane.setLayout(null);
        contentPane.setDoubleBuffered(true);
        setContentPane(contentPane);

        // Label tiêu đề
        JLabel lblNewLabel = new JLabel("Đăng Ký Thẻ Mượn");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
        lblNewLabel.setBounds(127, 11, 162, 29);
        contentPane.add(lblNewLabel);

        // Panel thông tin sinh viên
        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(Color.GRAY, 1));
        panel.setBounds(18, 54, 211, 186);
        panel.setLayout(null);
        contentPane.add(panel);

        JLabel lblNewLabel_1 = new JLabel("Mã Sinh Viên");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_1.setBounds(10, 33, 77, 16);
        panel.add(lblNewLabel_1);

        jtfStudentID = new JTextField();
        jtfStudentID.setBounds(105, 32, 96, 20);
        panel.add(jtfStudentID);
        jtfStudentID.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("Tên Sinh Viên");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_2.setBounds(10, 88, 82, 14);
        panel.add(lblNewLabel_2);

        jtfStudentName = new JTextField();
        jtfStudentName.setBounds(105, 86, 96, 20);
        panel.add(jtfStudentName);
        jtfStudentName.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("Địa Chỉ");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_3.setBounds(10, 137, 49, 14);
        panel.add(lblNewLabel_3);

        jtfStudentLocation = new JTextField();
        jtfStudentLocation.setBounds(105, 135, 96, 20);
        panel.add(jtfStudentLocation);
        jtfStudentLocation.setColumns(10);

        // Panel thông tin khác
        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new LineBorder(Color.GRAY, 1));
        panel_1.setBounds(258, 51, 168, 189);
        panel_1.setLayout(null);
        contentPane.add(panel_1);

        JLabel lblNewLabel_4 = new JLabel("Số ĐT");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_4.setBounds(10, 34, 49, 14);
        panel_1.add(lblNewLabel_4);

        jtfStudentSDT = new JTextField();
        jtfStudentSDT.setBounds(62, 31, 96, 20);
        panel_1.add(jtfStudentSDT);
        jtfStudentSDT.setColumns(10);

        JLabel lblNewLabel_5 = new JLabel("Gmail");
        lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_5.setBounds(10, 93, 49, 14);
        panel_1.add(lblNewLabel_5);

        jtfStudentGmail = new JTextField();
        jtfStudentGmail.setBounds(62, 90, 96, 20);
        panel_1.add(jtfStudentGmail);
        jtfStudentGmail.setColumns(10);

        JLabel lblNewLabel_6 = new JLabel("Năm Học");
        lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_6.setBounds(10, 144, 62, 19);
        panel_1.add(lblNewLabel_6);

        JComboBox<String> comboBox_NamHoc = new JComboBox<>(new String[]{"K18", "K17", "K16", "K15", "K14", "K13", "Không học tại trường"});
        comboBox_NamHoc.setBounds(82, 143, 76, 22);
        panel_1.add(comboBox_NamHoc);

        // Nút Đăng ký
        JButton btnDangKy = new JButton("Đăng Ký");
        btnDangKy.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnDangKy.setBounds(108, 256, 89, 23);
        contentPane.add(btnDangKy);
        btnDangKy.addActionListener(ac);

        JButton btnNewButton = new JButton("Quay Lại");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnNewButton.setBounds(232, 257, 89, 23);
        contentPane.add(btnNewButton);
        btnNewButton.addActionListener(ac);
        
        
    }

    public void ThucHienDangKy() {
        String studentID;
		String studentName;
		String studentLocation;
		int studentSDT;
		String studentGmail ;
		try {
			studentID = jtfStudentID.getText();
			studentName = jtfStudentName.getText();
			studentLocation = jtfStudentLocation.getText();
			//studentSDT = Integer.parseInt(jtfStudentSDT.getText());
			String stringSdt = jtfStudentSDT.getText();
			if(stringSdt.length()!=10 || !stringSdt.startsWith("0")) {
				throw new Exception("Nhập vào không đúng số điện thoại!");
			}
			else {
				studentSDT = Integer.parseInt(stringSdt);
			}
			studentGmail = jtfStudentGmail.getText();
			if(!studentGmail.endsWith("@gmail.com")) {
				throw new Exception("Gmail không hợp lệ! Vui lòng nhập địa chỉ kết thúc bằng @gmail.com.");
			} 
			Student student = new Student(studentID, studentName, studentLocation, studentSDT, studentGmail);
			StudentDAO studentDAO = new StudentDAO();
	        Student existing_student = studentDAO.selectById(studentID);
	        if(existing_student == null) {
	            studentDAO.insert(student);
	            JOptionPane.showMessageDialog(null, "Hoàn tất đăng ký");
	        }else{
	            JOptionPane.showMessageDialog(null, "Đã tồn tại");
	        }
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Nhập sai dữ liệu", "Lỗi", JOptionPane.ERROR_MESSAGE);
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
		}

    }

    public void ThucHienQuayLai() {
        this.dispose();
        new ReaderBookView();
    }
}
