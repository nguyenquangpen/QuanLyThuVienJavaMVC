package LibrarianView;

import Controller.Studentcontroller;
import LoginRegisterView.FuntionLogin;
import dao.StudentDAO;
import model.Student;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StudentView extends JFrame {
    public JTextField textField_TenSinhVien_timKiem;
    public JTable table;
    public JTextField textField_ID, textField_HoVaTen, textField_Gmail, textField_DiaChi, textField_SDT;
    public JComboBox comboBox_queQuan;
    public JButton btnHuyTim, btnTim;

    public StudentView() {
        this.inti();
        this.setVisible(true);
    }

    private void inti() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Quản lý người mượn");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);

        ActionListener ac = new Studentcontroller(this);

        Font font = new Font("Arial", Font.PLAIN, 15);
        // jMenu
        JMenuBar menuBar = new JMenuBar();
        JMenu jMenuFile = new JMenu("File");
        jMenuFile.setFont(font);

        JMenuItem jMenuItemExit = new JMenuItem("Exit");
        jMenuItemExit.setFont(font);
        jMenuFile.addSeparator();
        jMenuFile.add(jMenuItemExit);
        jMenuItemExit.addActionListener(ac);

        JMenuItem jMenuItemSach = new JMenu("Sách");
        jMenuItemSach.setFont(font);

        JMenuItem sachItem = new JMenuItem("Quản Lý Sách");
        sachItem.setFont(font);
        jMenuItemSach.add(sachItem);
        sachItem.addActionListener(ac);

        JMenuItem jMenuItemDocGia = new JMenu("Độc Giả");
        jMenuItemDocGia.setFont(font);

        JMenuItem docGiaItem = new JMenuItem("Quản Lý Độc Giả");
        docGiaItem.setFont(font);
        jMenuItemDocGia.add(docGiaItem);
        docGiaItem.addActionListener(ac);

        JMenuItem jMenuItemMuonTra = new JMenu("Mượn Trả");
        jMenuItemMuonTra.setFont(font);

        JMenuItem muonTraItem = new JMenuItem("Quản Lý Mượn Trả");
        muonTraItem.setFont(font);
        jMenuItemMuonTra.add(muonTraItem);
        muonTraItem.addActionListener(ac);

        JMenuItem duytIteam = new JMenuItem("Duyệt Phiếu Mượn");
        duytIteam.setFont(font);
        jMenuItemMuonTra.add(duytIteam);
        duytIteam.addActionListener(ac);

        // Điều chỉnh khoảng cách giữa các menu item
        jMenuItemSach.setMargin(new Insets(0, 5, 0, 5));
        jMenuItemDocGia.setMargin(new Insets(0, 5, 0, 5));
        jMenuItemMuonTra.setMargin(new Insets(0, 5, 0, 5));

        menuBar.add(jMenuFile);
        menuBar.add(new JSeparator(SwingConstants.VERTICAL));
        menuBar.add(jMenuItemSach);
        menuBar.add(new JSeparator(SwingConstants.VERTICAL));
        menuBar.add(jMenuItemDocGia);
        menuBar.add(new JSeparator(SwingConstants.VERTICAL));
        menuBar.add(jMenuItemMuonTra);
        menuBar.add(new JSeparator(SwingConstants.VERTICAL));

        //North
        JLabel label_TenSinhVien = new JLabel("Tên Sinh Viên");
        label_TenSinhVien.setBounds(20, 23, 93, 18);
        label_TenSinhVien.setFont(font);

        textField_TenSinhVien_timKiem = new JTextField(15);
        textField_TenSinhVien_timKiem.setBounds(133, 20, 186, 24);
        textField_TenSinhVien_timKiem.setFont(font);

        btnTim = new JButton("Tìm");
        btnTim.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnTim.setBounds(339, 20, 67, 23);
        btnTim.addActionListener(ac);


        btnHuyTim = new JButton("Huỷ Tìm");
        btnHuyTim.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnHuyTim.addActionListener(ac);

        btnHuyTim.setBounds(457, 22, 93, 23);


        JPanel panelNorth = new JPanel();
        panelNorth.setBounds(10, 178, 766, 52);
        panelNorth.setLayout(null);
        panelNorth.add(label_TenSinhVien);
        panelNorth.add(textField_TenSinhVien_timKiem);
        panelNorth.add(btnTim);
        panelNorth.add(btnHuyTim);
        panelNorth.setBorder(new LineBorder(Color.GRAY, 1));
        // center
        table = new JTable();
        table.setFont(new Font("Tahoma", Font.PLAIN, 16));
        table.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{"Mã Mượn", "Họ Tên", "Địa Chỉ", "Số Điện Thoại",
                        "Gmail"}));
        HienThiSinhVienVaoBangMacDinh();

        table.setRowHeight(20);

        JScrollPane tableScrollPane = new JScrollPane(table);
        tableScrollPane.setBounds(0, 0, 765, 286);
        JPanel panelCenter = new JPanel();
        panelCenter.setBounds(10, 241, 776, 287);
        panelCenter.setLayout(null);
        panelCenter.add(tableScrollPane);

        this.setJMenuBar(menuBar);
        getContentPane().setLayout(null);
        getContentPane().add(panelNorth);
        getContentPane().add(panelCenter);
        JLabel jLabelGmail = new JLabel("Gmail");
        jLabelGmail.setBounds(36, 52, 39, 18);
        jLabelGmail.setFont(font);

        textField_Gmail = new JTextField(10);
        textField_Gmail.setBounds(120, 49, 126, 24);
        textField_Gmail.setFont(font);

        //bottom
        JButton btnXoa = new JButton("Xoá");
        btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnXoa.setBounds(493, 128, 66, 23);
        btnXoa.addActionListener(ac);


        JButton btnCapNhat = new JButton("Cập Nhật");
        btnCapNhat.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnCapNhat.setBounds(354, 128, 93, 23);
        btnCapNhat.addActionListener(ac);


        JButton btnLuu = new JButton("Lưu");
        btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnLuu.setBounds(613, 128, 66, 23);
        btnLuu.addActionListener(ac);

        JPanel panelSouth = new JPanel();
        panelSouth.setBounds(10, 10, 766, 162);
        getContentPane().add(panelSouth);
        panelSouth.setLayout(null);
        panelSouth.setBorder(new LineBorder(Color.GRAY, 1));

        panelSouth.add(jLabelGmail);
        panelSouth.add(textField_Gmail);
        panelSouth.add(btnXoa);
        panelSouth.add(btnCapNhat);
        panelSouth.add(btnLuu);

        //South
        JLabel jLabelMaSinhVien = new JLabel("Mã Mượn");
        jLabelMaSinhVien.setBounds(36, 93, 66, 24);
        panelSouth.add(jLabelMaSinhVien);
        jLabelMaSinhVien.setFont(font);
        JLabel jLabelHoTen = new JLabel("Họ Tên");
        jLabelHoTen.setBounds(36, 17, 66, 24);
        panelSouth.add(jLabelHoTen);
        jLabelHoTen.setFont(font);
        JLabel jLabeSDT = new JLabel("Số Điện Thoại");
        jLabeSDT.setBounds(354, 17, 114, 24);
        panelSouth.add(jLabeSDT);
        jLabeSDT.setFont(font);
        JLabel jLabelDiaChi = new JLabel("Địa Chỉ");
        jLabelDiaChi.setBounds(375, 49, 93, 24);
        panelSouth.add(jLabelDiaChi);
        jLabelDiaChi.setFont(font);

        textField_ID = new JTextField(10);
        textField_ID.setBounds(120, 93, 126, 24);
        panelSouth.add(textField_ID);
        textField_ID.setFont(font);
        textField_HoVaTen = new JTextField(10);
        textField_HoVaTen.setBounds(120, 14, 126, 24);
        panelSouth.add(textField_HoVaTen);
        textField_HoVaTen.setFont(font);

        textField_SDT = new JTextField(10);
        textField_SDT.setBounds(493, 17, 135, 24);
        panelSouth.add(textField_SDT);
        textField_SDT.setFont(font);

        textField_DiaChi = new JTextField(10);
        textField_DiaChi.setBounds(494, 49, 135, 24);
        panelSouth.add(textField_DiaChi);
        textField_DiaChi.setFont(font);
        jMenuFile.setIcon(new ImageIcon("D:\\Eclipse_java\\Final_prj\\Image\\google-docs.png"));
        jMenuItemExit.setIcon(new ImageIcon("D:\\Eclipse_java\\Final_prj\\Image\\logout.png"));
        jMenuItemSach.setIcon(new ImageIcon("D:\\Eclipse_java\\Final_prj\\Image\\bookshelf.png"));
        sachItem.setIcon(new ImageIcon("D:\\Eclipse_java\\Final_prj\\Image\\book.png"));
        jMenuItemDocGia.setIcon(new ImageIcon("D:\\Eclipse_java\\Final_prj\\Image\\reading.png"));
        docGiaItem.setIcon(new ImageIcon("D:\\Eclipse_java\\Final_prj\\Image\\magazine.png"));
        jMenuItemMuonTra.setIcon(new ImageIcon("D:\\Eclipse_java\\Final_prj\\Image\\transaction.png"));
        muonTraItem.setIcon(new ImageIcon("D:\\Eclipse_java\\Final_prj\\Image\\delivery-note.png"));
        duytIteam.setIcon(new ImageIcon("D:\\Eclipse_java\\Final_prj\\Image\\scan.png"));

    }

    public void ThemSVvaoBang(Student student){
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
        model_table.addRow(new Object[]{
                student.getId(),
                student.getName(),
                student.getLocation(),
                student.getSdt(),
                student.getGmail()
        });
    }

    public void XoaBang() {
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
        model_table.setRowCount(0);
    }

    public void HienThiSinhVienVaoBangMacDinh() {
        XoaBang();
        StudentDAO studentDAO = new StudentDAO();
        ArrayList<Student> arrayList = studentDAO.selectAll();
        for (Student student : arrayList) {
            ThemSVvaoBang(student);
        }
    }

    public void ThemHoacCapNhatStudent(Student student){
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
        StudentDAO studentDAO = new StudentDAO();
        String StudentID = student.getId();
        if(studentDAO.selectById(StudentID)==null){
            studentDAO.insert(student);
            ThemSVvaoBang(student);
        }else{
            studentDAO.update(student);
            for(int i = 0; i < table.getRowCount(); i++){
                String str =model_table.getValueAt(i, 0).toString();
                if(str.equals(student.getId())){
                    model_table.setValueAt(student.getId(), i, 0);
                    model_table.setValueAt(student.getName(), i, 1);
                    model_table.setValueAt(student.getLocation(), i, 2);
                    model_table.setValueAt(student.getSdt(), i, 3);
                    model_table.setValueAt(student.getGmail(), i, 4);
                }
            }
        }
    }

    public void ThucHienThemSV() {
        String StudentID = textField_ID.getText();
        String StudentName = textField_HoVaTen.getText();
        String StudentLocation = textField_DiaChi.getText();
        int StudentSDT = Integer.parseInt(textField_SDT.getText());
        String studentGmail = textField_Gmail.getText();
        Student student = new Student(StudentID, StudentName, StudentLocation, StudentSDT, studentGmail);
        this.ThemHoacCapNhatStudent(student);
    }

    public Student getSVDaChon(){
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
        int i_row = table.getSelectedRow();
        String StudentID = model_table.getValueAt(i_row, 0)+"";
        String StudentName = (String) model_table.getValueAt(i_row, 1);
        String StudentLocation = (String) model_table.getValueAt(i_row, 2);
        int StudentSDT = Integer.parseInt(model_table.getValueAt(i_row, 3)+"");
        String studentGmail = (String) model_table.getValueAt(i_row, 4);
        Student student = new Student(StudentID, StudentName, StudentLocation, StudentSDT, studentGmail);
        return student;
    }


    public void HienThiSinhVienDaChon() {
        Student student = getSVDaChon();
        this.textField_ID.setText(student.getId());
        this.textField_HoVaTen.setText(student.getName());
        this.textField_DiaChi.setText(student.getLocation());
        this.textField_SDT.setText(student.getSdt()+"");
        this.textField_Gmail.setText(student.getGmail());
    }

    public void ThucHienXoa() {
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
        StudentDAO studentDAO = new StudentDAO();
        int i_row = table.getSelectedRow();
        if (i_row != -1) {
            Student student = getSVDaChon();
            if (student != null) {
                int result = studentDAO.delete(student);
                if (result > 0) {
                    model_table.removeRow(i_row);
                }
            }
        }
    }

    public void ThucHienTim() {
        String TenSinhVien = textField_TenSinhVien_timKiem.getText();
        StudentDAO studentDAO = new StudentDAO();
        String column = "StudentName";
        XoaBang();
        if(!TenSinhVien.isEmpty()){
            ArrayList<Student> students = studentDAO.selectByCondition(TenSinhVien, column);
            if (students != null && !students.isEmpty()) {
                for (Student HS : students) {
                    ThemSVvaoBang(HS);
                }
            }
        }

    }

    public void ThucHienHuyTim() {
        HienThiSinhVienVaoBangMacDinh();
    }

    public void ThoatKhoiChuongTrinh() {
        int luaChon = JOptionPane.showConfirmDialog(this, "thoải khỏi chương trình? ");
        if(luaChon == JOptionPane.YES_OPTION){
            this.dispose();
            new FuntionLogin();
        }
    }

    public void HienThiSlideSach() {
        this.dispose();
        new QLSachView();
    }

    public void HienThiPhieuMuon() {
        this.dispose();
        new AcceptNoView();
    }

    public void HienThiMuonTra() {
        this.dispose();
        new TransactionView();
    }
}