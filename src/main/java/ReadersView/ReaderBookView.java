package ReadersView;

import Controller.QLReadBookController;
import LoginRegisterView.FuntionLogin;
import dao.AcceptNoDao;
import dao.SachDAO;
import dao.StudentDAO;
import model.Sach;
import model.Student;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.awt.event.MouseEvent;


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
    public ButtonGroup btnGroup;
    public JRadioButton rdbtnTenSach, rdbtnTheLoai;

    public ReaderBookView() {
        this.title();
        this.setVisible(true);
    }

    private void title() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1101, 580);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Danh Muc Sach");

        ActionListener ac = new QLReadBookController(this);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        Font font = new Font("Arial", Font.PLAIN, 15);
        JMenuBar menuBar = new JMenuBar();
        JMenu jMenuFile = new JMenu("File");
        jMenuFile.setFont(font);

        JMenuItem jMenuItemExit = new JMenuItem("Exit");
        jMenuItemExit.setFont(font);
        jMenuFile.addSeparator();
        jMenuFile.add(jMenuItemExit);
        jMenuItemExit.addActionListener(ac);

        JMenuItem jMenuItemPhieu = new JMenu("Phiếu");
        jMenuItemPhieu.setFont(font);
        
        JMenuItem sachItem = new JMenuItem("Đăng Ký");
        sachItem.setFont(font);
        jMenuItemPhieu.add(sachItem);
        sachItem.addActionListener(ac);

        JMenuItem StatusView = new JMenuItem("Trạng Thái");
        StatusView.setFont(font);
        jMenuItemPhieu.add(StatusView);
        StatusView.addActionListener(ac);

        JMenuItem jMenuItemBook = new JMenu("Sách");
        jMenuItemBook.setFont(font);

        JMenuItem BookView = new JMenuItem("Đầu Sách");
        BookView.setFont(font);
        jMenuItemBook.add(BookView);


        menuBar.add(jMenuFile);
        menuBar.add(new JSeparator(SwingConstants.VERTICAL));
        menuBar.add(jMenuItemPhieu);
        menuBar.add(new JSeparator(SwingConstants.VERTICAL));
        menuBar.add(jMenuItemBook);

        this.setJMenuBar(menuBar);
        getContentPane().setLayout(null);

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
        btnMuonSach.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnMuonSach.addActionListener(ac);
        panel.add(btnMuonSach);

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
        lblNewLabel.setBounds(494, 30, 174, 31);
        contentPane.add(lblNewLabel);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(271, 92, 806, 401);
        contentPane.add(panel_1);
        panel_1.setLayout(null);
        panel_1.setBorder(new LineBorder(Color.GRAY, 1));
        panel_1.setBackground(new Color(255, 255, 255));

        table = new JTable();
        table.setFont(new Font("Tahoma", Font.PLAIN, 16));
        table.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{"Mã Đầu sách", "Tên Đầu Sách", "Năm xuất bản", "Thể Loại",
                        "Tác Giả", "Số Lượng", "Đã Mượn", "Tồn kho"}));
        HienThiSachMAcDinh();
        table.setRowHeight(20);

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                HienThiSach();
            }
        });

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 11, 786, 369);
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

        rdbtnTenSach = new JRadioButton("Tên Sách");
        rdbtnTenSach.setFont(new Font("Tahoma", Font.PLAIN, 12));
        rdbtnTenSach.setBounds(16, 39, 81, 23);
        panel_2.add(rdbtnTenSach);

        rdbtnTheLoai = new JRadioButton("Thể Loại");
        rdbtnTheLoai.setFont(new Font("Tahoma", Font.PLAIN, 12));
        rdbtnTheLoai.setBounds(119, 39, 81, 23);
        panel_2.add(rdbtnTheLoai);

        btnGroup = new ButtonGroup();
        btnGroup.add(rdbtnTenSach);
        btnGroup.add(rdbtnTheLoai);

        jtfTimKiem = new JTextField();
        jtfTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 12));
        jtfTimKiem.setBounds(16, 74, 194, 20);
        panel_2.add(jtfTimKiem);
        jtfTimKiem.setColumns(10);

        JButton btnTim = new JButton("Tìm");
        btnTim.addActionListener(ac);

        btnTim.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnTim.setBounds(16, 105, 89, 23);
        panel_2.add(btnTim);

        JButton btnHuyTim = new JButton("Huỷ");
        btnHuyTim.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnHuyTim.setBounds(121, 105, 89, 23);
        btnHuyTim.addActionListener(ac);
        panel_2.add(btnHuyTim);
        
      //set them icon cho cac menu 
        jMenuFile.setIcon(new ImageIcon("D:\\Eclipse_java\\Final_prj\\Image\\google-docs.png"));
        jMenuItemExit.setIcon(new ImageIcon("D:\\Eclipse_java\\Final_prj\\Image\\logout.png"));
        jMenuItemBook.setIcon(new ImageIcon("D:\\Eclipse_java\\Final_prj\\Image\\bookshelf.png"));
        BookView.setIcon(new ImageIcon("D:\\Eclipse_java\\Final_prj\\Image\\book.png"));
        jMenuItemPhieu.setIcon(new ImageIcon("D:\\Eclipse_java\\Final_prj\\Image\\check-list.png"));
        sachItem.setIcon(new ImageIcon("D:\\Eclipse_java\\Final_prj\\Image\\register.png"));
        StatusView.setIcon(new ImageIcon("D:\\Eclipse_java\\Final_prj\\Image\\verified.png"));
    }

    public void ThemSachVaoBang(Sach sach){
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
        model_table.addRow(new Object[]{
                sach.getId(),
                sach.getTenSach(),
                sach.getNamXuatBan(),
                sach.getTheLoai(),
                sach.getTenTacGia(),
                sach.getSoLuong(),
                sach.getDaMuon(), 
                sach.getTonKho()
        });
    }

    public void XoaBang(){
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
        model_table.setRowCount(0);
    }

    public void HienThiSachMAcDinh(){
        XoaBang();
        SachDAO sachDAO = new SachDAO();
        ArrayList<Sach> arrayList = sachDAO.selectAll();
        for (Sach sach : arrayList) {
            ThemSachVaoBang(sach);
        }
    }

    public Sach getSachDaChon() {
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
        int i_row = table.getSelectedRow();
        if (i_row == -1) {
            return null;
        }
        String MaSachID = (String) model_table.getValueAt(i_row, 0);
        String TenDauSach = (String) model_table.getValueAt(i_row, 1);
        int  NamXB = (int) model_table.getValueAt(i_row, 2);
        String TheLoai = (String) model_table.getValueAt(i_row, 3);
        String TacGia = (String) model_table.getValueAt(i_row, 4);
        int amout = (int) model_table.getValueAt(i_row, 5);
        int DaMuon = (int) model_table.getValueAt(i_row, 6);
        Sach sach = new Sach(MaSachID, TenDauSach, NamXB, TheLoai, TacGia, amout, DaMuon);
        return sach;
    }

    public void HienThiSach() {
        Sach sach = getSachDaChon();
        if (sach != null) {
            jtfDauSach.setText(sach.getTenSach());
            jtfTacGia.setText(sach.getTenTacGia());
        }
    }
    public boolean ThucHienKiemTra() {
        Sach sach = getSachDaChon(); 
        if (sach == null) { 
            JOptionPane.showMessageDialog(this, "Chưa chọn sách!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return false; 
        }
        SachDAO sachDAO = new SachDAO();
        int amount;
        try {
            amount = Integer.parseInt(jtfSoLuong.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng hợp lệ!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        String column = "MaSachId"; 
        ArrayList<Sach> arrayList = sachDAO.selectByCondition(sach.getId(), column); 

        if (arrayList.isEmpty()) { 
            JOptionPane.showMessageDialog(this, "Không tìm thấy sách!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        for (Sach sach1 : arrayList) {
            if (sach1.getTonKho() < amount) {
                JOptionPane.showMessageDialog(this, "Mượn quá số lượng tồn kho. Tồn kho hiện tại: " + sach1.getTonKho(), "Thông báo", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        }

        return true; // All checks passed
    }


    public boolean ThucHienKiemTraSV(){
        String studentID = jtfMaStudentID.getText();
        String studentName = jtfStudentname.getText();

        StudentDAO studentDAO = new StudentDAO();
        Student student = studentDAO.selectById(studentID);

        if(studentID.isEmpty() || studentName.isEmpty()){
            JOptionPane.showMessageDialog(this, "Không được để trống");
            return false;
        }
        if(student == null){
            JOptionPane.showMessageDialog(this, "Không tồn tại Phiếu Mượn");
            return false;
        }
        if(!student.getName().equals(studentName)){
            JOptionPane.showMessageDialog(this, "Sai thông tin");
            return false;
        }
        return true;
    }

    public void ThucHienChoMuon() {
        boolean statusBook = ThucHienKiemTra();
        boolean statusSV = ThucHienKiemTraSV();
        AcceptNoDao acceptNoDao = new AcceptNoDao();
        SachDAO sachDAO = new SachDAO();
        if (statusBook && statusSV) {
        	JOptionPane.showMessageDialog(this, "Hoàn tất Mượn Sách!");
            String studentID = jtfMaStudentID.getText();
            Sach selectedBook = getSachDaChon();
            String bookID = selectedBook.getId();
            int amount = Integer.parseInt(jtfSoLuong.getText());
            
            // Update the borrowing status
            String statusBorrow = "Waiting";
            acceptNoDao.insert(studentID, bookID, amount, statusBorrow);
            
            // Update the book stock and borrowed count
            int newTonKho = selectedBook.getTonKho() - amount; // Decrease inventory
            int newDaMuon = selectedBook.getDaMuon() + amount;  // Increase borrowed count

            // Update the book in the database with new values
            sachDAO.updateStockAndBorrowed(bookID, newTonKho, newDaMuon);
            
            // Refresh the table to show the updated stock
            HienThiSachMAcDinh();
        }
    }


    public void ThucHienTim() {
        String book = jtfTimKiem.getText();
        String column;
        SachDAO sachDAO = new SachDAO();
        if(rdbtnTenSach.isSelected()){
            column = "TenSach";
        }else {
            column = "TheLoai";
        }

        XoaBang();

        if (book != null && !book.trim().isEmpty()) {
            ArrayList<Sach> sach = sachDAO.selectByCondition(book, column);
            if (sach != null && !sach.isEmpty()) {
                for (Sach bookItem : sach) {
                    ThemSachVaoBang(bookItem);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Không tìm thấy sách nào.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên sách hoặc thể loại để tìm kiếm.", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void ThucHienHuyTim() {
        HienThiSachMAcDinh();
    }

    public void ShowDangKyView() {
        this.dispose();
        new PhieuDkyView();
    }

    public void ThucHienQuayLai() {
        int luaChon = JOptionPane.showConfirmDialog(this, "thoải khỏi chương trình? ");
        if(luaChon == JOptionPane.YES_OPTION){
            this.dispose();
            new FuntionLogin();
        }
    }

    public void HienThiTrangThai() {
        this.dispose();
        new StatusView();
    }
}
