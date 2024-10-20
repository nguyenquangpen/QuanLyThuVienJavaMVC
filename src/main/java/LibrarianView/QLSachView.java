package LibrarianView;

import Controller.QLSachController;
import LoginRegisterView.FuntionLogin;
import dao.SachDAO;
import model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.border.LineBorder;


public class QLSachView extends JFrame {
    public JTable table;
    public JTextField textField_MaSach, textField_TenDauSach, textField_NamXuatBan, textFieldSoLuong, textField_TheLoai, textField_TacGia;
    public JButton btnHuyTim, btnTim;
    public JTextField textField_TenDauSachTimKiem;
    private JTextField textField_daMuon;

    public QLSachView() {
        this.inti();
        this.setVisible(true);
    }

    private void inti() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Quản lý đầu sách");
        this.setSize(800, 646);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        ActionListener ac = new QLSachController(this);

        Font font = new Font("Arial", Font.PLAIN, 15);
        // jMenu
        JMenuBar menuBar = new JMenuBar();
        JMenu jMenuFile = new JMenu("File");
        jMenuFile.setFont(font);
        jMenuFile.setIcon(new ImageIcon("D:\\Eclipse_java\\Final_prj\\Image\\google-docs.png"));
        
        JMenuItem jMenuItemExit = new JMenuItem("Exit");
        jMenuItemExit.setFont(font);
        jMenuFile.addSeparator();
        jMenuFile.add(jMenuItemExit);
		jMenuItemExit.setToolTipText("Nhan vao la thoat");
		jMenuItemExit.setIcon(new ImageIcon("D:\\Eclipse_java\\Final_prj\\Image\\logout.png"));
        jMenuItemExit.addActionListener(ac);

        JMenuItem jMenuItemSach = new JMenu("Sách");
        jMenuItemSach.setFont(font);
        jMenuItemSach.setIcon(new ImageIcon("D:\\Eclipse_java\\Final_prj\\Image\\bookshelf.png"));
        
        JMenuItem sachItem = new JMenuItem("Quản Lý Sách");
        sachItem.setFont(font);
        jMenuItemSach.add(sachItem);
        sachItem.addActionListener(ac);
        sachItem.setIcon(new ImageIcon("D:\\Eclipse_java\\Final_prj\\Image\\book.png"));
        
        JMenuItem jMenuItemDocGia = new JMenu("Độc Giả");
        jMenuItemDocGia.setFont(font);
        jMenuItemDocGia.setIcon(new ImageIcon("D:\\Eclipse_java\\Final_prj\\Image\\reading.png"));
        
        JMenuItem docGiaItem = new JMenuItem("Quản Lý Độc Giả");
        docGiaItem.setFont(font);
        jMenuItemDocGia.add(docGiaItem);
        docGiaItem.addActionListener(ac);
        docGiaItem.setIcon(new ImageIcon("D:\\Eclipse_java\\Final_prj\\Image\\magazine.png"));
        JMenuItem jMenuItemMuonTra = new JMenu("Mượn Trả");
        jMenuItemMuonTra.setFont(font);
        jMenuItemMuonTra.setIcon(new ImageIcon("D:\\Eclipse_java\\Final_prj\\Image\\transaction.png"));


        JMenuItem muonTraItem = new JMenuItem("Quản Lý Mượn Trả");
        muonTraItem.setFont(font);
        jMenuItemMuonTra.add(muonTraItem);
        muonTraItem.addActionListener(ac);
        muonTraItem.setIcon(new ImageIcon("D:\\Eclipse_java\\Final_prj\\Image\\delivery-note.png"));

        
        JMenuItem duytIteam = new JMenuItem("Duyệt Phiếu Mượn");
        duytIteam.setFont(font);
        jMenuItemMuonTra.add(duytIteam);
        duytIteam.addActionListener(ac);
        duytIteam.setIcon(new ImageIcon("D:\\Eclipse_java\\Final_prj\\Image\\scan.png"));


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
        // center
        table = new JTable();
        table.setFont(new Font("Tahoma", Font.PLAIN, 16));
        table.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{"Mã Đầu sách", "Tên Đầu Sách", "Năm xuất bản", "Thể Loại",
                        "Tác Giả", "Số Lượng", "Đã Mượn", "Tồn kho"}));
        HienThiSachBangMacDinh();
        table.setRowHeight(20);

        JScrollPane tableScrollPane = new JScrollPane(table);
        tableScrollPane.setBounds(10, 67, 766, 269);

        JPanel panelCenter = new JPanel();
        panelCenter.setBounds(0, 236, 786, 379);
        panelCenter.setLayout(null);
        panelCenter.add(tableScrollPane);

        this.setJMenuBar(menuBar);
        getContentPane().setLayout(null);
        getContentPane().add(panelCenter);

        //North
        JLabel label_TenDauSach = new JLabel("Tên Đầu Sách");
        label_TenDauSach.setFont(font);
        textField_TenDauSachTimKiem = new JTextField(15);
        textField_TenDauSachTimKiem.setFont(font);

        btnTim = new JButton("Tìm");
        btnTim.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnTim.addActionListener(ac);

        btnHuyTim = new JButton("Huỷ Tìm");
        btnHuyTim.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnHuyTim.addActionListener(ac);

        JPanel panelNorth = new JPanel();
        panelNorth.setBounds(10, -2, 766, 58);
        panelCenter.add(panelNorth);
        panelNorth.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));
        panelNorth.add(label_TenDauSach);
        panelNorth.add(textField_TenDauSachTimKiem);
        panelNorth.setBorder(new LineBorder(Color.GRAY, 1));

        panelNorth.add(btnTim);
        panelNorth.add(btnHuyTim);
        JLabel jLabelSoLuong = new JLabel("Số Lượng");
        jLabelSoLuong.setBounds(383, 23, 98, 18);
        jLabelSoLuong.setFont(font);
        textFieldSoLuong = new JTextField(10);
        textFieldSoLuong.setBounds(509, 20, 197, 24);
        textFieldSoLuong.setFont(font);

        //bottom
        JButton btnXoa = new JButton("Xoá");
        btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnXoa.setBounds(124, 164, 76, 23);
        btnXoa.addActionListener(ac);

        JButton btnCapNhat = new JButton("Cập Nhật");
        btnCapNhat.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnCapNhat.addActionListener(ac);

        btnCapNhat.setBounds(319, 164, 106, 23);

        JButton btnLuu = new JButton("Lưu");
        btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnLuu.setBounds(535, 163, 83, 23);
        btnLuu.addActionListener(ac);

        JLabel jLabeTheLoai = new JLabel("Thể Loại");
        jLabeTheLoai.setBounds(20, 23, 59, 18);
        jLabeTheLoai.setFont(font);
        textField_TheLoai = new JTextField(10);
        textField_TheLoai.setBounds(124, 20, 197, 24);
        textField_TheLoai.setFont(font);

        JPanel panelSouth = new JPanel();
        panelSouth.setBounds(10, 10, 766, 208);
        getContentPane().add(panelSouth);
        panelSouth.setLayout(null);
        panelSouth.add(jLabeTheLoai);
        panelSouth.add(textField_TheLoai);
        panelSouth.add(btnXoa);
        panelSouth.add(btnCapNhat);
        panelSouth.add(btnLuu);
        panelSouth.add(jLabelSoLuong);
        panelSouth.add(textFieldSoLuong);
        panelSouth.setBorder(new LineBorder(Color.GRAY, 1));

        //South
        JLabel jLabelMaDauSach = new JLabel("Mã Đầu sách");
        jLabelMaDauSach.setBounds(20, 67, 106, 24);
        panelSouth.add(jLabelMaDauSach);
        jLabelMaDauSach.setFont(font);

        textField_MaSach = new JTextField(10);
        textField_MaSach.setBounds(124, 67, 197, 24);
        panelSouth.add(textField_MaSach);
        textField_MaSach.setFont(font);

        JLabel jLabelTenDauSach = new JLabel("Tên Đầu Sách");
        jLabelTenDauSach.setBounds(20, 117, 106, 24);
        panelSouth.add(jLabelTenDauSach);
        jLabelTenDauSach.setFont(font);

        textField_TenDauSach = new JTextField(10);
        textField_TenDauSach.setBounds(124, 117, 197, 24);
        panelSouth.add(textField_TenDauSach);
        textField_TenDauSach.setFont(font);

        JLabel jLabelNamXuatBan = new JLabel("Năm xuất bản");
        jLabelNamXuatBan.setBounds(383, 51, 111, 24);
        panelSouth.add(jLabelNamXuatBan);
        jLabelNamXuatBan.setFont(font);

        JLabel jLabelTacGia = new JLabel("Tác Giả");
        jLabelTacGia.setBounds(383, 85, 111, 24);
        panelSouth.add(jLabelTacGia);
        jLabelTacGia.setFont(font);

        textField_NamXuatBan = new JTextField(10);
        textField_NamXuatBan.setBounds(509, 54, 197, 24);

        panelSouth.add(textField_NamXuatBan);
        textField_NamXuatBan.setFont(font);
        textField_TacGia = new JTextField(10);
        textField_TacGia.setBounds(509, 85, 197, 24);

        panelSouth.add(textField_TacGia);
        textField_TacGia.setFont(font);		
        
        JLabel jLabel_daMuon = new JLabel("Đã Mượn");
        jLabel_daMuon.setFont(new Font("Arial", Font.PLAIN, 15));
        jLabel_daMuon.setBounds(383, 117, 111, 24);
        panelSouth.add(jLabel_daMuon);
        
        textField_daMuon = new JTextField(10);
        textField_daMuon.setFont(new Font("Arial", Font.PLAIN, 15));
        textField_daMuon.setBounds(509, 117, 197, 24);
        panelSouth.add(textField_daMuon);
        

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

    public void XoaBang() {
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
        model_table.setRowCount(0); 
    }

    public void HienThiSachBangMacDinh() {
        XoaBang();
        SachDAO sachDAO = new SachDAO();
        ArrayList<Sach> arrayList = sachDAO.selectAll();
        for (Sach sach : arrayList) {
            ThemSachVaoBang(sach);
        }
    }

    public void ThemHoacCapNhatSach(Sach sach){
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
        String maSachId = sach.getId();
        SachDAO sachDAO = new SachDAO();
        if(sachDAO.selectById(maSachId)==null){
            sachDAO.insert(sach);
            ThemSachVaoBang(sach);
        }else{
            sachDAO.update(sach);
            for(int i = 0; i < table.getRowCount(); i++){
                String str =model_table.getValueAt(i, 0).toString();
                if(str.equals(sach.getId())){
                    model_table.setValueAt(sach.getId(), i, 0);
                    model_table.setValueAt(sach.getTenSach(), i, 1);
                    model_table.setValueAt(sach.getNamXuatBan()+"", i, 2);
                    model_table.setValueAt(sach.getTheLoai(), i, 3);
                    model_table.setValueAt(sach.getTenTacGia(), i, 4);
                    model_table.setValueAt(sach.getSoLuong(), i, 5);
                    model_table.setValueAt(sach.getDaMuon(), i, 6);
                    model_table.setValueAt(sach.getTonKho(), i, 7);
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
        int DaMuon = Integer.parseInt(textField_daMuon.getText());
        Sach sach = new Sach(maSachId, tenDauSach, namXuatBan, theLoai, tacGia, SoLuong, DaMuon);
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
        int DaMuon = Integer.parseInt(model_table.getValueAt(i_row, 6).toString());
        Sach sach = new Sach(MaSachID, TenDauSach, NamXB, TheLoai, TacGia, SoLuong, DaMuon);
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
        this.textField_daMuon.setText(sach.getDaMuon()+"");
    }


    public void ThucHienXoa() {
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
        SachDAO sachDAO = new SachDAO();
        int i_row = table.getSelectedRow();
        if (i_row != -1) {
            Sach sach = getSachDaChon();
            if (sach != null) {
                int result = sachDAO.delete(sach);
                if (result > 0) {
                    model_table.removeRow(i_row);
                }
            }
        }
    }

    public void ThucHienTim() {
        String tenDauSach = textField_TenDauSachTimKiem.getText();
        SachDAO sachDAO = new SachDAO();
        String column = "TenSach";
        XoaBang();
        if (!tenDauSach.isEmpty()) {
            ArrayList<Sach> sach = sachDAO.selectByCondition(tenDauSach, column);
            if (sach != null && !sach.isEmpty()) {
                for (Sach book : sach) {
                    ThemSachVaoBang(book);
                }
            }
        }
    }

    public void ThucHienHuyTim() {
        HienThiSachBangMacDinh();
    }

    public void ThoatKhoiChuongTrinh() {
        int luaChon = JOptionPane.showConfirmDialog(this, "thoải khỏi chương trình? ");
        if(luaChon == JOptionPane.YES_OPTION){
            this.dispose();
            new FuntionLogin();
        }
    }

    public void HienThiDocGia() {
        this.dispose();
        new StudentView();
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
