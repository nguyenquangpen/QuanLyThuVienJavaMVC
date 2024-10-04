package ReadersView;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;


public class ReaderBookView extends JFrame {
    public static final long serialVersionUID = 1L;
    public JPanel contentPane;
    public JTable table;
    public JTextField jtfTimKiem;
    public JTextField jtfDauSach;
    public JTextField jtfTacGia;
    public JTextField jtfMaStudentID;
    public JTextField jtfStudentname;
    public JTextField jtfSoLuong;

    public ReaderBookView() {
        this.title();
        this.setVisible(true);
    }

    private void title() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 856, 550);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Danh Muc Sach");
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(25, 254, 236, 239);
        contentPane.add(panel);
        panel.setLayout(null);
        panel.setBorder(new LineBorder(Color.GRAY, 1));
        panel.setBackground(new Color(255, 255, 255));

        JLabel lblNewLabel_2 = new JLabel("Đầu Sách");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNewLabel_2.setBounds(10, 23, 62, 14);
        panel.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("Tác Giả");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNewLabel_3.setBounds(10, 69, 49, 14);
        panel.add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("Số Lượng");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNewLabel_4.setBounds(10, 113, 62, 25);
        panel.add(lblNewLabel_4);

        JButton btnMuonSach = new JButton("Mượn");
        btnMuonSach.setBounds(67, 205, 89, 23);
        panel.add(btnMuonSach);
        btnMuonSach.setFont(new Font("Tahoma", Font.PLAIN, 13));

        jtfDauSach = new JTextField();
        jtfDauSach.setFont(new Font("Tahoma", Font.PLAIN, 12));
        jtfDauSach.setBounds(82, 20, 114, 20);
        panel.add(jtfDauSach);
        jtfDauSach.setColumns(10);

        jtfTacGia = new JTextField();
        jtfTacGia.setFont(new Font("Tahoma", Font.PLAIN, 12));
        jtfTacGia.setBounds(82, 66, 114, 20);
        panel.add(jtfTacGia);
        jtfTacGia.setColumns(10);

        JLabel lblNewLabel_5 = new JLabel("Mã SV");
        lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNewLabel_5.setBounds(39, 149, 49, 14);
        panel.add(lblNewLabel_5);

        JLabel lblNewLabel_6 = new JLabel("Tên SV");
        lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNewLabel_6.setBounds(147, 149, 49, 14);
        panel.add(lblNewLabel_6);

        jtfMaStudentID = new JTextField();
        jtfMaStudentID.setFont(new Font("Tahoma", Font.PLAIN, 12));
        jtfMaStudentID.setBounds(10, 174, 96, 20);
        panel.add(jtfMaStudentID);
        jtfMaStudentID.setColumns(10);

        jtfStudentname = new JTextField();
        jtfStudentname.setFont(new Font("Tahoma", Font.PLAIN, 12));
        jtfStudentname.setBounds(130, 174, 96, 20);
        panel.add(jtfStudentname);
        jtfStudentname.setColumns(10);

        jtfSoLuong = new JTextField();
        jtfSoLuong.setBounds(82, 111, 114, 20);
        panel.add(jtfSoLuong);
        jtfSoLuong.setColumns(10);

        JLabel lblNewLabel = new JLabel("Danh Mục Sách");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
        lblNewLabel.setBounds(262, 32, 174, 31);
        contentPane.add(lblNewLabel);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(271, 92, 561, 401);
        contentPane.add(panel_1);
        panel_1.setLayout(null);
        panel_1.setBorder(new LineBorder(Color.GRAY, 1));
        panel_1.setBackground(new Color(255, 255, 255));

        JTable table = new JTable();
        table.setFont(new Font("Tahoma", Font.PLAIN, 16));
        table.setBounds(10, 11, 541, 369);
        table.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{"Mã Đầu sách", "Tên Đầu Sách", "Năm xuất bản", "Thể Loại",
                        "Tác Giả", "Số Lượng", "Đã Mượn", "Tồn kho"}
        ));
        table.setRowHeight(20);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 11, 541, 369);
        panel_1.add(scrollPane);


        JPanel panel_2 = new JPanel();
        panel_2.setBounds(25, 92, 236, 138);
        contentPane.add(panel_2);
        panel_2.setLayout(null);
        panel_2.setBorder(new LineBorder(Color.GRAY, 1));
        panel_2.setBackground(new Color(255, 255, 255));

        JLabel lblNewLabel_1 = new JLabel("Tìm Kiếm Đầu Sách");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel.setBounds(316, 30, 174, 31);
        panel_2.add(lblNewLabel_1);

        JRadioButton rdbtnTenSach = new JRadioButton("Tên Sách");
        rdbtnTenSach.setFont(new Font("Tahoma", Font.PLAIN, 12));
        rdbtnTenSach.setBounds(16, 39, 81, 23);
        panel_2.add(rdbtnTenSach);

        JRadioButton rdbtnTheLoai = new JRadioButton("Thể Loại");
        rdbtnTheLoai.setFont(new Font("Tahoma", Font.PLAIN, 12));
        rdbtnTheLoai.setBounds(119, 39, 81, 23);
        panel_2.add(rdbtnTheLoai);

        jtfTimKiem = new JTextField();
        jtfTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 12));
        jtfTimKiem.setBounds(16, 74, 194, 20);
        panel_2.add(jtfTimKiem);
        jtfTimKiem.setColumns(10);

        JButton btnTim = new JButton("Tìm");

        btnTim.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnTim.setBounds(16, 105, 89, 23);
        panel_2.add(btnTim);

        JButton btnHuyTim = new JButton("Huỷ");
        btnHuyTim.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnHuyTim.setBounds(121, 105, 89, 23);
        panel_2.add(btnHuyTim);

    }
}
