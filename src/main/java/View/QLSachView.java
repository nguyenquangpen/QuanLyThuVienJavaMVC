package View;

import Controller.QLSachController;
import dao.SachDAO;
import model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class QLSachView extends JFrame {
    public JTable table;
    public JTextField textField_MaSach, textField_TenDauSach, textField_NamXuatBan, textField_MaDauSach_TimKiem, textField_TheLoai, textField_TacGia;
    public JButton btnHuyTim, btnTim;
    public JTextField textField_TenDauSachTimKiem;
//    public QLSachModel model;

    public QLSachView() {
//        model = new QLSachModel();
        this.inti();
        this.setVisible(true);
    }

    private void inti() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Quản lý đầu sách");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);

        ActionListener action = new QLSachController(this);

        Font font = new Font("Arial", Font.PLAIN, 15);
        // jMenu
        JMenuBar menuBar = new JMenuBar();
        JMenu jMenuFile = new JMenu("File");
        jMenuFile.setFont(font);


        JMenuItem jMenuItemExit = new JMenuItem("Exit");
        jMenuItemExit.addActionListener(action);
        jMenuItemExit.setFont(font);
        jMenuFile.addSeparator();
        jMenuFile.add(jMenuItemExit);


        // Tạo các JMenu như bình thường
        JMenu jMenuItemSach = new JMenu("Sách");
        jMenuItemSach.setFont(font);

        JMenu jMenuItemDocGia = new JMenu("Độc Giả");
        jMenuItemDocGia.setFont(font);

        JMenu jMenuItemMuonTra = new JMenu("Mượn Trả");
        jMenuItemMuonTra.setFont(font);

        JMenu jMenuItemTrangThai = new JMenu("Trạng Thái");
        jMenuItemTrangThai.setFont(font);

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
        JLabel label_TenDauSach = new JLabel("Tên Đầu Sách");
        label_TenDauSach.setFont(font);
        textField_TenDauSachTimKiem = new JTextField(15);
        textField_TenDauSachTimKiem.setFont(font);

        btnTim = new JButton("Tìm");
        btnTim.addActionListener(action);

        btnHuyTim = new JButton("Huỷ Tìm");
        btnHuyTim.addActionListener(action);

        JPanel panelNorth = new JPanel();
        panelNorth.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));
        panelNorth.add(label_TenDauSach);
        panelNorth.add(textField_TenDauSachTimKiem);
//        panelNorth.add(label_maDauSAch);
//        panelNorth.add(textField_MaDauSach_TimKiem);
        panelNorth.add(btnTim);
        panelNorth.add(btnHuyTim);
        // center
        table = new JTable();
        table.setFont(new Font("Tahoma", Font.PLAIN, 16));
        table.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{"Mã Đầu sách", "Tên Đầu Sách", "Năm xuất bản", "Thể Loại",
                        "Tác Giả"}));

        HienThiSinhVienBangMacDinh();
        table.setRowHeight(20);

        JScrollPane tableScrollPane = new JScrollPane(table);
        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(new BoxLayout(panelCenter, BoxLayout.Y_AXIS));
        panelCenter.add(tableScrollPane);

        //South
        JLabel jLabelMaDauSach = new JLabel("Mã Đầu sách");
        jLabelMaDauSach.setFont(font);
        JLabel jLabelTenDauSach = new JLabel("Tên Đầu Sách");
        jLabelTenDauSach.setFont(font);
        JLabel jLabelNamXuatBan = new JLabel("Năm xuất bản");
        jLabelNamXuatBan.setFont(font);
        JLabel jLabelTacGia = new JLabel("Tác Giả");
        jLabelTacGia.setFont(font);

        textField_MaSach = new JTextField(10);
        textField_MaSach.setFont(font);
        textField_TenDauSach = new JTextField(10);
        textField_TenDauSach.setFont(font);
        textField_NamXuatBan = new JTextField(10);
        textField_NamXuatBan.setFont(font);
        textField_TacGia = new JTextField(10);
        textField_TacGia.setFont(font);


        JPanel panelCenterBottom = new JPanel();
        panelCenterBottom.setLayout(new GridLayout(2, 4));
        panelCenterBottom.add(jLabelMaDauSach);
        panelCenterBottom.add(textField_MaSach);
        panelCenterBottom.add(jLabelTenDauSach);
        panelCenterBottom.add(textField_TenDauSach);
        panelCenterBottom.add(jLabelNamXuatBan);
        panelCenterBottom.add(textField_NamXuatBan);
        panelCenterBottom.add(jLabelTacGia);
        panelCenterBottom.add(textField_TacGia);
        panelCenter.add(panelCenterBottom, BorderLayout.SOUTH);

        //bottom

        JButton btnXoa = new JButton("Xoá");
        btnXoa.addActionListener(action);

        JButton btnCapNhat = new JButton("Cập Nhật");
        btnCapNhat.addActionListener(action);

        JButton btnLuu = new JButton("Lưu");
        btnLuu.addActionListener(action);

        JLabel jLabeTheLoai = new JLabel("Thể Loại");
        jLabeTheLoai.setFont(font);
        textField_TheLoai = new JTextField(10);
        textField_TheLoai.setFont(font);

        Panel panelSouth = new Panel();
        panelSouth.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));
        panelSouth.add(jLabeTheLoai);
        panelSouth.add(textField_TheLoai);
        panelSouth.add(btnXoa);
        panelSouth.add(btnCapNhat);
        panelSouth.add(btnLuu);


        this.setJMenuBar(menuBar);
        this.setLayout(new BorderLayout());
        this.add(panelNorth, BorderLayout.NORTH);
        this.add(panelCenter, BorderLayout.CENTER);
        this.add(panelSouth, BorderLayout.SOUTH);
    }

    public void ThemSachVaoBang(Sach sach){
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
        model_table.addRow(new Object[]{
            sach.getId(),
            sach.getTenSach(),
            sach.getNamXuatBan(),
            sach.getTheLoai(),
            sach.getTenTacGia()
        });
    }

    public void XoaBang() {
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
        model_table.setRowCount(0); 
    }

    public void HienThiSinhVienBangMacDinh() {
        XoaBang();
        ArrayList<Sach> arrayList = SachDAO.getInstance().selectAll();
        for (Sach sach : arrayList) {
            ThemSachVaoBang(sach);
        }
    }

    public void ThemHoacCapNhatSach(Sach sach){
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
        if(SachDAO.getInstance().selectById(sach)==null){
            SachDAO.getInstance().insert(sach);
            ThemSachVaoBang(sach);
        }else{
            SachDAO.getInstance().update(sach);
            for(int i = 0; i < table.getRowCount(); i++){
                String str =model_table.getValueAt(i, 0).toString();
                if(str.equals(sach.getId() + "")){
                    model_table.setValueAt(sach.getId(), i, 0);
                    model_table.setValueAt(sach.getTenSach(), i, 1);
                    model_table.setValueAt(sach.getNamXuatBan()+"", i, 2);
                    model_table.setValueAt(sach.getTheLoai(), i, 3);
                    model_table.setValueAt(sach.getTenTacGia(), i, 4);
                }
            }
        }
    }

    public void ThucHienThemSach() {
        int maSachId = Integer.parseInt(textField_MaSach.getText());
        String tenDauSach = textField_TenDauSach.getText();
        int namXuatBan = Integer.parseInt(textField_NamXuatBan.getText());
        String tacGia = textField_TacGia.getText();
        String theLoai = textField_TheLoai.getText();
        Sach sach = new Sach(maSachId, tenDauSach, namXuatBan, theLoai, tacGia);
        this.ThemHoacCapNhatSach(sach);
    }
    
    public  Sach getSachDaChon(){
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
        int i_row = table.getSelectedRow();
        int MaSachID = Integer.valueOf(model_table.getValueAt(i_row, 0)+"");
        String TenDauSach = (String) model_table.getValueAt(i_row, 1);
        int NamXB = Integer.valueOf(model_table.getValueAt(i_row, 2)+"");
        String TheLoai = (String) model_table.getValueAt(i_row, 3);
        String TacGia = (String) model_table.getValueAt(i_row, 4);
        Sach sach = new Sach(MaSachID, TenDauSach, NamXB, TheLoai, TacGia);
        return sach;
    }

    public void HienThiSinhVienDaChon() {
        Sach sach = getSachDaChon();
        this.textField_MaSach.setText(sach.getId()+"");
        this.textField_TacGia.setText(sach.getTenTacGia());
        this.textField_NamXuatBan.setText(sach.getNamXuatBan()+"");
        this.textField_TheLoai.setText(sach.getTheLoai());
        this.textField_TenDauSach.setText(sach.getTenSach());
    }


    public void ThucHienXoa() {
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
        int i_row = table.getSelectedRow();

        if (i_row != -1) {
            model_table.removeRow(i_row);
            SachDAO.getInstance().delete(getSachDaChon());
        }
    }

    public void ThucHienTim() {
        String tenDauSach = textField_TenDauSachTimKiem.getText();
        XoaBang();
        if(!tenDauSach.isEmpty()){
            Sach sach = SachDAO.getInstance().selectByCondition(tenDauSach);
            ThemSachVaoBang(sach);
        }
    }

    public void ThucHienHuyTim() {
        HienThiSinhVienBangMacDinh();
    }

    public void ThoatKhoiChuongTrinh() {
        int luaChon = JOptionPane.showConfirmDialog(this, "thoải khỏi chương trình? ");
        if(luaChon == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }
}
