package View;

import Controller.QLSachController;
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
    public QLSachModel model;

    public QLSachView() {
        model = new QLSachModel();
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

        JMenuItem jMenuItemOpen = new JMenuItem("Open");
        jMenuItemOpen.setFont(font);
        jMenuItemOpen.addActionListener(action);

        JMenuItem jMenuItemSave = new JMenuItem("Save");
        jMenuItemSave.setFont(font);
        jMenuItemSave.addActionListener(action);

        JMenuItem jMenuItemExit = new JMenuItem("Exit");
        jMenuItemExit.addActionListener(action);
        jMenuItemExit.setFont(font);
        jMenuItemSave.setFont(font);
        jMenuFile.add(jMenuItemOpen);
        jMenuFile.add(jMenuItemSave);
        jMenuFile.addSeparator();
        jMenuFile.add(jMenuItemExit);
        menuBar.add(jMenuFile);

        //North
        JLabel label_TenDauSach = new JLabel("Tên Đầu Sách");
        label_TenDauSach.setFont(font);
        textField_TenDauSachTimKiem = new JTextField(15);
        textField_TenDauSachTimKiem.setFont(font);

        JLabel label_maDauSAch = new JLabel("Mã Đầu Sách");
        label_maDauSAch.setFont(font);
        textField_MaDauSach_TimKiem = new JTextField(10);
        textField_MaDauSach_TimKiem.setFont(font);

        btnTim = new JButton("Tìm");
        btnTim.addActionListener(action);

        btnHuyTim = new JButton("Huỷ Tìm");
        btnHuyTim.addActionListener(action);

        JPanel panelNorth = new JPanel();
        panelNorth.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));
        panelNorth.add(label_TenDauSach);
        panelNorth.add(textField_TenDauSachTimKiem);
        panelNorth.add(label_maDauSAch);
        panelNorth.add(textField_MaDauSach_TimKiem);
        panelNorth.add(btnTim);
        panelNorth.add(btnHuyTim);
        // center
        table = new JTable();
        table.setFont(new Font("Tahoma", Font.PLAIN, 16));
        table.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{"Mã Đầu sách", "Tên Đầu Sách", "Năm xuất bản", "Thể Loại",
                        "Tác Giả"}));

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
        JButton btnThem = new JButton("Thêm");
        btnThem.addActionListener(action);

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
        panelSouth.add(btnThem);
        panelSouth.add(btnXoa);
        panelSouth.add(btnCapNhat);
        panelSouth.add(btnLuu);


        this.setJMenuBar(menuBar);
        this.setLayout(new BorderLayout());
        this.add(panelNorth, BorderLayout.NORTH);
        this.add(panelCenter, BorderLayout.CENTER);
        this.add(panelSouth, BorderLayout.SOUTH);
    }

    public void xoaForm() {
        textField_TacGia.setText("");
        textField_TenDauSach.setText("");
        textField_MaSach.setText("");
        textField_TheLoai.setText("");
        textField_NamXuatBan.setText("");
    }

    public void ThemSachVaoBang(Sach sach){
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
        model_table.addRow(new Object[]{
                sach.getMaSachID(),
                sach.getTenSach(),
                sach.getNamXB()+"",
                sach.getTacGia(),
                sach.getTacGia(),
        });
    }

    public void ThemHoacCapNhatSach(Sach sach) {
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
        if(!this.model.KiemTraTonTai(sach)){
            this.model.insert(sach);
            this.ThemSachVaoBang(sach);
        }else{
            this.model.update(sach);
            for(int i = 0; i < model_table.getRowCount(); i++){
                String str = model_table.getValueAt(i, 0)+"";
                if(str.equals(sach.getMaSachID() +"")){
                    model_table.setValueAt(sach.getMaSachID(), i, 0);
                    model_table.setValueAt(sach.getTenSach(), i, 1);
                    model_table.setValueAt(sach.getNamXB()+"", i, 2);
                    model_table.setValueAt(sach.getTheLoai(), i, 3);
                    model_table.setValueAt(sach.getTacGia(), i, 4);
                }
            }
        }
    }

    public void ThucHienThemSach() {
        String tacGia = this.textField_TacGia.getText();
        String tenDauSach = this.textField_TenDauSach.getText();
        int maSachID = Integer.valueOf(this.textField_MaSach.getText());
        String TheLoai = this.textField_TheLoai.getText();
        int NamXB = Integer.valueOf(this.textField_NamXuatBan.getText());
        Sach sach = new Sach(maSachID, tenDauSach, NamXB, TheLoai, tacGia);
        this.ThemHoacCapNhatSach(sach);
    }

    public Sach getSinhVienDaChon(){
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
        Sach sach = getSinhVienDaChon();
        this.textField_MaSach.setText(sach.getMaSachID()+"");
        this.textField_TacGia.setText(sach.getTenSach());
        this.textField_NamXuatBan.setText(sach.getNamXB()+"");
        this.textField_TheLoai.setText(sach.getTheLoai());
        this.textField_TenDauSach.setText(sach.getTenSach());
    }

    public void ThucHienXoa() {
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
        int i_row = table.getSelectedRow();
        model_table.removeRow(i_row);
    }

    public void ThucHienTim() {
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
        String TenDauSach = this.textField_TenDauSachTimKiem.getText();
        Set<Integer> idMaSachCanXoa = new TreeSet<Integer>();
        if(!TenDauSach.isEmpty()){
            for(int i = 0; i < model_table.getRowCount(); i++){
                String TenDauSachTrongTable = (String) model_table.getValueAt(i, 1);
                String id = model_table.getValueAt(i, 0).toString();
                if(!TenDauSachTrongTable.equals(TenDauSach)){
                    idMaSachCanXoa.add(Integer.parseInt(id));
                }
            }
        }
        String MaSachTimKiem = this.textField_MaDauSach_TimKiem.getText();
        if(!MaSachTimKiem.isEmpty()){
            for(int i = 0; i < model_table.getRowCount(); i++){
                String MaSachTimKiemTrongTable = model_table.getValueAt(i, 0)+"";
                if(!MaSachTimKiemTrongTable.equals(MaSachTimKiem)){
                    idMaSachCanXoa.add(Integer.parseInt(MaSachTimKiem));
                }
            }
        }
        for(Integer idCanXoa : idMaSachCanXoa){
            int soLuong = model_table.getRowCount();
            for(int i = 0; i < soLuong; i++){
                String idTrongTable = model_table.getValueAt(i, 0)+"";
                if(idTrongTable.equals(idCanXoa.toString())){
                    try{
                        model_table.removeRow(i);
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                    break;
                }
            }
        }
    }

    public void ThucHienHuyTim() {
        // xoa het data khoi bang
        while(true){
            DefaultTableModel model_table = (DefaultTableModel) table.getModel();
            int soLuong = model_table.getRowCount();
            if(soLuong == 0){
                break;
            }else{
                try {
                    model_table.removeRow(0);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        // them lai vao bang
        for(Sach sach : this.model.getDsSach()){
            this.ThemSachVaoBang(sach);
        }
    }

    public void ThoatKhoiChuongTrinh() {
        int luaChon = JOptionPane.showConfirmDialog(this, "thoải khỏi chương trình? ");
        if(luaChon == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }

    public void saveFile(String path){
        try {
            this.model.setTenFile(path);
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for(Sach ts: this.model.getDsSach()){
                oos.writeObject(ts);
            }
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ThucHienSaveFile() {
        if(!this.model.getTenFile().isEmpty()){
            saveFile(this.model.getTenFile());
        }else{
            JFileChooser fc = new JFileChooser();
            int returnVal = fc.showSaveDialog(this);
            if(returnVal == JFileChooser.APPROVE_OPTION){
                File file = fc.getSelectedFile();
                saveFile(file.getAbsolutePath());
            }
        }
    }

    public void openFile(File file){
        ArrayList<Sach> sach = new ArrayList<Sach>();
        try {
            this.model.setTenFile(file.getAbsolutePath());
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Sach ts = null;
            while ((ts = (Sach) ois.readObject()) != null){
                sach.add(ts);
            }
            ois.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        this.model.setDsSach(sach);
    }

    public void ThucHienOpenFile() {
        JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog(this);
        if(returnVal == JFileChooser.APPROVE_OPTION){
            File file = fc.getSelectedFile();
            openFile(file);
            ThucHienHuyTim();
        }
    }
}
