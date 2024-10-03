package View;

import Controller.Studentcontroller;
import dao.SachDAO;
import dao.StudentDAO;
import model.Sach;
import model.Student;

import javax.swing.*;
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
    public JComboBox<String> dateComboBox;

    public StudentView() {
        this.inti();
        this.setVisible(true);
    }

    private void inti() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Quản lý người mượn");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);

        ActionListener action = new Studentcontroller(this);

        Font font = new Font("Arial", Font.PLAIN, 15);
        // jMenu
        JMenuBar menuBar = new JMenuBar();
        JMenu jMenuFile = new JMenu("File");
        jMenuFile.addActionListener(action);
        jMenuFile.setFont(font);

        JMenuItem jMenuItemExit = new JMenuItem("Exit");
        jMenuItemExit.addActionListener(action);
        jMenuItemExit.setFont(font);
        jMenuFile.addSeparator();
        jMenuFile.add(jMenuItemExit);

        // Tạo các JMenu như bình thường
        JMenuItem jMenuItemSach = new JMenu("Sách");
        jMenuItemSach.setFont(font);

        JMenuItem sachItem = new JMenuItem("Quản Lý Sách");
        sachItem.setFont(font);
        sachItem.addActionListener(action);
        jMenuItemSach.add(sachItem);

        JMenuItem jMenuItemDocGia = new JMenu("Độc Giả");
        jMenuItemDocGia.setFont(font);

        JMenuItem docGiaItem = new JMenuItem("Quản Lý Độc Giả");
        docGiaItem.setFont(font);
        docGiaItem.addActionListener(action);
        jMenuItemDocGia.add(docGiaItem);

        JMenuItem jMenuItemMuonTra = new JMenu("Mượn Trả");
        jMenuItemMuonTra.setFont(font);

        JMenuItem muonTraItem = new JMenuItem("Quản Lý Mượn Trả");
        muonTraItem.setFont(font);
        muonTraItem.addActionListener(action);
        jMenuItemMuonTra.add(muonTraItem);

        JMenuItem jMenuItemTrangThai = new JMenu("Thống kê");
        jMenuItemTrangThai.setFont(font);

        JMenuItem trangThaiSach = new JMenuItem("Sách");
        trangThaiSach.setFont(font);
        trangThaiSach.addActionListener(action);
        jMenuItemTrangThai.add(trangThaiSach);

        JSeparator separator = new JSeparator();

        JMenuItem trangThaiUser = new JMenuItem("Độc Giả");
        trangThaiUser.setFont(font);
        trangThaiUser.addActionListener(action);
        jMenuItemTrangThai.add(trangThaiUser);

        jMenuItemTrangThai.add(separator);

        JMenuItem trangThaiMuonTra = new JMenuItem("Mượn Trả");
        trangThaiMuonTra.setFont(font);
        trangThaiMuonTra.addActionListener(action);
        jMenuItemTrangThai.add(trangThaiMuonTra);

        // Điều chỉnh khoảng cách giữa các menu item
        jMenuItemSach.setMargin(new Insets(0, 5, 0, 5));
        jMenuItemDocGia.setMargin(new Insets(0, 5, 0, 5));
        jMenuItemMuonTra.setMargin(new Insets(0, 5, 0, 5));
        jMenuItemTrangThai.setMargin(new Insets(0, 5, 0, 5));

        menuBar.add(jMenuFile);
        menuBar.add(new JSeparator(SwingConstants.VERTICAL));
        menuBar.add(jMenuItemSach);
        menuBar.add(new JSeparator(SwingConstants.VERTICAL));
        menuBar.add(jMenuItemDocGia);
        menuBar.add(new JSeparator(SwingConstants.VERTICAL));
        menuBar.add(jMenuItemMuonTra);
        menuBar.add(new JSeparator(SwingConstants.VERTICAL));
        menuBar.add(jMenuItemTrangThai);
        menuBar.add(new JSeparator(SwingConstants.VERTICAL));

        //North
        JLabel label_TenSinhVien = new JLabel("Tên Sinh Viên");
        label_TenSinhVien.setFont(font);

        textField_TenSinhVien_timKiem = new JTextField(15);
        textField_TenSinhVien_timKiem.setFont(font);

        btnTim = new JButton("Tìm");
        btnTim.addActionListener(action);

        btnHuyTim = new JButton("Huỷ Tìm");
        btnHuyTim.addActionListener(action);

        JPanel panelNorth = new JPanel();
        panelNorth.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));
        panelNorth.add(label_TenSinhVien);
        panelNorth.add(textField_TenSinhVien_timKiem);
        panelNorth.add(btnTim);
        panelNorth.add(btnHuyTim);
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
        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(new BoxLayout(panelCenter, BoxLayout.Y_AXIS));
        panelCenter.add(tableScrollPane);

        //South
        JLabel jLabelMaSinhVien = new JLabel("Mã Mượn");
        jLabelMaSinhVien.setFont(font);
        JLabel jLabelHoTen = new JLabel("Họ Tên");
        jLabelHoTen.setFont(font);
        JLabel jLabelDiaChi = new JLabel("Địa Chỉ");
        jLabelDiaChi.setFont(font);
        JLabel jLabeSDT = new JLabel("Số Điện Thoại");
        jLabeSDT.setFont(font);
        JLabel jLabelGmail = new JLabel("Gmail");
        jLabelGmail.setFont(font);

        textField_ID = new JTextField(10);
        textField_ID.setFont(font);
        textField_HoVaTen = new JTextField(10);
        textField_HoVaTen.setFont(font);

        textField_DiaChi = new JTextField(10);
        textField_DiaChi.setFont(font);

        textField_SDT = new JTextField(10);
        textField_SDT.setFont(font);

        textField_Gmail = new JTextField(10);
        textField_Gmail.setFont(font);

        JPanel panelCenterBottom = new JPanel();
        panelCenterBottom.setLayout(new GridLayout(2, 4));
        panelCenterBottom.add(jLabelMaSinhVien);
        panelCenterBottom.add(textField_ID);
        panelCenterBottom.add(jLabelHoTen);
        panelCenterBottom.add(textField_HoVaTen);
        panelCenterBottom.add(jLabeSDT);
        panelCenterBottom.add(textField_SDT);
        panelCenterBottom.add(jLabelDiaChi);
        panelCenterBottom.add(textField_DiaChi);
        panelCenter.add(panelCenterBottom, BorderLayout.SOUTH);

        //bottom
        JButton btnXoa = new JButton("Xoá");
        btnXoa.addActionListener(action);

        JButton btnCapNhat = new JButton("Cập Nhật");
        btnCapNhat.addActionListener(action);

        JButton btnLuu = new JButton("Lưu");
        btnLuu.addActionListener(action);

        Panel panelSouth = new Panel();
        panelSouth.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        panelSouth.add(jLabelGmail);
        panelSouth.add(textField_Gmail);
        panelSouth.add(btnXoa);
        panelSouth.add(btnCapNhat);
        panelSouth.add(btnLuu);

        this.setJMenuBar(menuBar);
        this.setLayout(new BorderLayout());
        this.add(panelNorth, BorderLayout.NORTH);
        this.add(panelCenter, BorderLayout.CENTER);
        this.add(panelSouth, BorderLayout.SOUTH);
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
        ArrayList<Student> arrayList = StudentDAO.getInstance().selectAll();
        for (Student student : arrayList) {
            ThemSVvaoBang(student);
        }
    }

    public void ThemHoacCapNhatStudent(Student student){
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
        if(StudentDAO.getInstance().selectById(student)==null){
            StudentDAO.getInstance().insert(student);
            ThemSVvaoBang(student);
        }else{
            StudentDAO.getInstance().update(student);
            for(int i = 0; i < table.getRowCount(); i++){
                String str =model_table.getValueAt(i, 0).toString();
                if(str.equals(student.getId() + "")){
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
        int StudentSDT = Integer.valueOf(model_table.getValueAt(i_row, 3)+"");
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
        int i_row = table.getSelectedRow();
        if (i_row != -1) {
            Student student = getSVDaChon();
            if (student != null) {
                int result = StudentDAO.getInstance().delete(student);
                if (result > 0) {
                    model_table.removeRow(i_row);
                }
            }
        }
    }

    public void ThucHienTim() {
        String TenSinhVien = textField_TenSinhVien_timKiem.getText();
        XoaBang();
        if(!TenSinhVien.isEmpty()){
            Student student = StudentDAO.getInstance().selectByCondition(TenSinhVien);
            ThemSVvaoBang(student);
        }
    }

    public void ThucHienHuyTim() {
        HienThiSinhVienVaoBangMacDinh();
    }

    public void ThoatKhoiChuongTrinh() {
        int luaChon = JOptionPane.showConfirmDialog(this, "thoải khỏi chương trình? ");
        if(luaChon == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }

    public void HienThiSlideSach() {
        this.dispose();
        new QLSachView();
    }
}