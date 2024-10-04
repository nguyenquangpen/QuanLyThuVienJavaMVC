package LibrarianView;

import LibrarianController.QLSachController;
import dao.SachDAO;
import model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class QLSachView extends JFrame {
    public JTable table;
    public JTextField textField_MaSach, textField_TenDauSach, textField_NamXuatBan, textFieldSoLuong, textField_TheLoai, textField_TacGia;
    public JButton btnHuyTim, btnTim;
    public JTextField textField_TenDauSachTimKiem;

    public QLSachView() {
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

        JSeparator separator = new JSeparator();

        JMenuItem trangThaiSach = new JMenuItem("Sách");
        trangThaiSach.setFont(font);
        trangThaiSach.addActionListener(action);
        jMenuItemTrangThai.add(trangThaiSach);

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

        panelNorth.add(btnTim);
        panelNorth.add(btnHuyTim);
        // center
        table = new JTable();
        table.setFont(new Font("Tahoma", Font.PLAIN, 16));
        table.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{"Mã Đầu sách", "Tên Đầu Sách", "Năm xuất bản", "Thể Loại",
                        "Tác Giả", "Số Lượng", "Đã Mượn", "Tồn kho"}));

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
        JLabel jLabelSoLuong = new JLabel("Số Lượng");
        jLabelSoLuong.setFont(font);

        textField_MaSach = new JTextField(10);
        textField_MaSach.setFont(font);
        textField_TenDauSach = new JTextField(10);
        textField_TenDauSach.setFont(font);
        textField_NamXuatBan = new JTextField(10);
        textField_NamXuatBan.setFont(font);
        textField_TacGia = new JTextField(10);
        textField_TacGia.setFont(font);
        textFieldSoLuong = new JTextField(10);
        textFieldSoLuong.setFont(font);


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
        panelSouth.add(jLabelSoLuong);
        panelSouth.add(textFieldSoLuong);


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
            sach.getTenTacGia(),
            sach.getSoLuong()
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
                if(str.equals(sach.getId())){
                    model_table.setValueAt(sach.getId(), i, 0);
                    model_table.setValueAt(sach.getTenSach(), i, 1);
                    model_table.setValueAt(sach.getNamXuatBan()+"", i, 2);
                    model_table.setValueAt(sach.getTheLoai(), i, 3);
                    model_table.setValueAt(sach.getTenTacGia(), i, 4);
                    model_table.setValueAt(sach.getSoLuong(), i, 5);
                }
            }
        }
    }

    public void ThucHienThemSach() {
        String maSachId = textField_MaSach.getText();
        String tenDauSach = textField_TenDauSach.getText();
        int namXuatBan = Integer.parseInt(textField_NamXuatBan.getText());
        String tacGia = textField_TacGia.getText();
        String theLoai = textField_TheLoai.getText();
        int SoLuong = Integer.parseInt(textFieldSoLuong.getText());
        Sach sach = new Sach(maSachId, tenDauSach, namXuatBan, theLoai, tacGia, SoLuong);
        this.ThemHoacCapNhatSach(sach);
    }

    public Sach getSachDaChon() {
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
        int i_row = table.getSelectedRow();

        if (i_row == -1) {
            return null;
        }
        String MaSachID = model_table.getValueAt(i_row, 0).toString();
        String TenDauSach = (String) model_table.getValueAt(i_row, 1);
        int NamXB = Integer.parseInt(model_table.getValueAt(i_row, 2).toString());
        String TheLoai = (String) model_table.getValueAt(i_row, 3);
        String TacGia = (String) model_table.getValueAt(i_row, 4);
        int SoLuong = Integer.parseInt(model_table.getValueAt(i_row, 5).toString());
        Sach sach = new Sach(MaSachID, TenDauSach, NamXB, TheLoai, TacGia, SoLuong);
        return sach;
    }


    public void HienThiSinhVienDaChon() {
        Sach sach = getSachDaChon();
        this.textField_MaSach.setText(sach.getId());
        this.textField_TacGia.setText(sach.getTenTacGia());
        this.textField_NamXuatBan.setText(sach.getNamXuatBan()+"");
        this.textField_TheLoai.setText(sach.getTheLoai());
        this.textField_TenDauSach.setText(sach.getTenSach());
        this.textFieldSoLuong.setText(sach.getSoLuong()+"");
    }


    public void ThucHienXoa() {
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
        int i_row = table.getSelectedRow();
        if (i_row != -1) {
            Sach sach = getSachDaChon();
            if (sach != null) {
                int result = SachDAO.getInstance().delete(sach);
                if (result > 0) {
                    model_table.removeRow(i_row);
                }
            }
        }
    }

    public void ThucHienTim() {
        String tenDauSach = textField_TenDauSachTimKiem.getText();
        XoaBang();
        if (!tenDauSach.isEmpty()) {
            ArrayList<Sach> sach = SachDAO.getInstance().selectByCondition(tenDauSach);
            if (sach != null && !sach.isEmpty()) {
                for (Sach book : sach) {
                    ThemSachVaoBang(book);
                }
            }
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

    public void HienThiDocGia() {
        this.dispose();
        new StudentView();
    }
}
