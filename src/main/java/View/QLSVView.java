package View;

import Controller.QLSVcontroller;
import model.QLSVModel;
import model.ThiSinh;
import model.Tinh;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;
import java.text.SimpleDateFormat;

public class QLSVView extends JFrame {
    public QLSVModel model;
    public JTextField textField_MaThiSinh_TimKiem;
    //    public JComboBox comboBox_queQuan_timKiem;
    public  JTable table;
    public JTextField textField_ID, textField_HoVaTen, textField_NgaySinh;
    public  JComboBox comboBox_queQuan;
    public ButtonGroup btn_gioiTinh;
    public JRadioButton radioButton_nu, radioButton_nam;
    public JButton btnHuyTim, btnTim;
    JTextField textField_TenSinhVien;

    public QLSVView() {
        model = new QLSVModel();
        this.inti();
        this.setVisible(true);
    }

    private void inti() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Quản lý người mượn");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);

        ActionListener action = new QLSVcontroller(this);

        Font font = new Font("Arial", Font.PLAIN, 15);
        // jMenu
        JMenuBar menuBar = new JMenuBar();
        JMenu jMenuFile = new JMenu("File");
        jMenuFile.addActionListener(action);
        jMenuFile.setFont(font);

        JMenuItem jMenuItemOpen = new JMenuItem("Open");
        jMenuItemOpen.addActionListener(action);
        jMenuItemOpen.setFont(font);

        JMenuItem jMenuItemSave = new JMenuItem("Save");
        jMenuItemSave.addActionListener(action);
        jMenuItemSave.setFont(font);

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
        JLabel label_TenSinhVien = new JLabel("Tên Sinh Viên");
        label_TenSinhVien.setFont(font);
//        comboBox_queQuan_timKiem = new JComboBox();
//        ArrayList listTinh = Tinh.getDSTinh();
//        comboBox_queQuan_timKiem.addItem(" ");
//        for(int i = 0; i < listTinh.size(); i++){
//            Tinh tinh = (Tinh) listTinh.get(i);
//            comboBox_queQuan_timKiem.addItem(tinh.getTenTinh());
//        }
//        comboBox_queQuan_timKiem.setPreferredSize(new Dimension(150, 25));
//        comboBox_queQuan_timKiem.setFont(font);
        textField_TenSinhVien = new JTextField(15);
        textField_TenSinhVien.setFont(font);

        JLabel label_maThiSinh = new JLabel("Mã Sinh Viên");
        label_maThiSinh.setFont(font);
        textField_MaThiSinh_TimKiem  = new JTextField(10);
        textField_MaThiSinh_TimKiem.setFont(font);

        btnTim = new JButton("Tìm");
        btnTim.addActionListener(action);

        btnHuyTim = new JButton("Huỷ Tìm");
        btnHuyTim.addActionListener(action);

        JPanel panelNorth = new JPanel();
        panelNorth.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));
        panelNorth.add(label_TenSinhVien);
        panelNorth.add(textField_TenSinhVien);
        panelNorth.add(label_maThiSinh);
        panelNorth.add(textField_MaThiSinh_TimKiem);
        panelNorth.add(btnTim);
        panelNorth.add(btnHuyTim);
        // center
        table = new JTable();
        table.setFont(new Font("Tahoma", Font.PLAIN, 16));
        table.setModel(new DefaultTableModel(
                new Object[][] {},
                new String[] { "Mã Sinh Viên", "Họ Tên", "Quê Quán", "Số Điện Thoại",
                        "Giới Tính"}));

        table.setRowHeight(20);

        JScrollPane tableScrollPane = new JScrollPane(table);
        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(new BoxLayout(panelCenter, BoxLayout.Y_AXIS));
        panelCenter.add(tableScrollPane);

        //South
        JLabel jLabelMaSinhVien = new JLabel("Mã Sinh Viên");
        jLabelMaSinhVien.setFont(font);
        JLabel jLabelHoTen = new JLabel("Họ Tên");
        jLabelHoTen.setFont(font);
        JLabel jLabelQuan = new JLabel("Quê Quán");
        jLabelQuan.setFont(font);
        JLabel jLabeData =  new JLabel("Số Điện Thoại");
        jLabeData.setFont(font);
        JLabel jLabelGioiTinh = new JLabel("Giới Tính");
        jLabelGioiTinh.setFont(font);

        textField_ID = new JTextField(10);
        textField_ID.setFont(font);
        textField_HoVaTen = new JTextField(10);
        textField_HoVaTen.setFont(font);

        comboBox_queQuan = new JComboBox();
        comboBox_queQuan.setFont(font);
        comboBox_queQuan.addItem(" ");
        ArrayList listTinh = Tinh.getDSTinh();
        for(int i = 0; i < listTinh.size(); i++){
            Tinh tinh = (Tinh) listTinh.get(i);
            comboBox_queQuan.addItem(tinh.getTenTinh());
        }
        textField_NgaySinh = new JTextField(10);
        textField_NgaySinh.setFont(font);

        radioButton_nam  = new JRadioButton("Nam");
        radioButton_nam.setFont(font);
        radioButton_nu = new JRadioButton("Nu");
        radioButton_nu.setFont(font);

        btn_gioiTinh = new ButtonGroup();
        btn_gioiTinh.add(radioButton_nam );
        btn_gioiTinh.add(radioButton_nu);

        radioButton_nam.setSelected(true);
        radioButton_nu.setSelected(false);

        JPanel panelCenterBottom = new JPanel();
        panelCenterBottom.setLayout(new GridLayout(2, 4));
        panelCenterBottom.add(jLabelMaSinhVien);
        panelCenterBottom.add(textField_ID);
        panelCenterBottom.add(jLabelHoTen);
        panelCenterBottom.add(textField_HoVaTen);
        panelCenterBottom.add(jLabelQuan);
        panelCenterBottom.add(comboBox_queQuan);
        panelCenterBottom.add(jLabeData);
        panelCenterBottom.add(textField_NgaySinh);
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

        Panel panelSouth = new Panel();
        panelSouth.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));
        panelSouth.add(jLabelGioiTinh);
        Panel paneltmp = new Panel();
        paneltmp.setLayout(new GridLayout(2, 1));
        paneltmp.add(radioButton_nam );
        paneltmp.add(radioButton_nu);
        panelSouth.add(paneltmp);
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
        textField_ID.setText("");
        textField_NgaySinh.setText("");
        textField_HoVaTen.setText("");
        comboBox_queQuan.setSelectedIndex(0);
        btn_gioiTinh.clearSelection();
    }


    public void themThiSinhVaoTable(ThiSinh ts){
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
        model_table.addRow(new Object[]{
                ts.getMaThiSinh() + "",
                ts.getTenThiSinh(),
                ts.getQueQuan().getTenTinh(),
                ts.getSĐT(),
                (ts.isGioiTinh() ? "Nam" : "Nữ"),
        });
    }

    public void themHoaCapNhatSinhVien(ThiSinh ts) {
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
        if(!this.model.KiemTraTonTai(ts)) {
            this.model.insert(ts);  // them data vao array
            this.themThiSinhVaoTable(ts);
        }else{
            this.model.update(ts);
            for (int i = 0; i < model_table.getRowCount(); i++) {
                String str = (String) model_table.getValueAt(i, 0);
                if (str.equals(ts.getMaThiSinh()+"")){
                    model_table.setValueAt(ts.getMaThiSinh()+"",i,0);
                    model_table.setValueAt(ts.getTenThiSinh(),i,1);
                    model_table.setValueAt(ts.getQueQuan().getTenTinh(),i,2);

                    model_table.setValueAt(ts.getSĐT(),i,3);
                    model_table.setValueAt((ts.isGioiTinh() ? "Nam" : "Nữ"),i,4);
                }
            }
        }
    }

    public ThiSinh GetSinhVienDaChon(){
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
        int i_row = table.getSelectedRow();

        int maThiSinh = Integer.valueOf(model_table.getValueAt(i_row, 0)+"");
        String tenThiSinh = model_table.getValueAt(i_row, 1)+"";
        Tinh tinh = Tinh.getTinhByTen(model_table.getValueAt(i_row, 2)+"");
        String s_ngaySinh = model_table.getValueAt(i_row, 3)+"";
        String SDT = model_table.getValueAt(i_row, 3)+"";
        String textGioiTinh = model_table.getValueAt(i_row, 4)+"";
        boolean gioitinh = textGioiTinh.equals("Nam");
        ThiSinh ts = new ThiSinh(maThiSinh, tenThiSinh, tinh, SDT, gioitinh);
        return ts;
    }

    public void HienThiSinhVienDaChon() {
        ThiSinh ts = GetSinhVienDaChon();
        if (ts.isGioiTinh()) {
            radioButton_nam.setSelected(true);
        }else{
            radioButton_nu.setSelected(true);
        }
        this.textField_ID.setText(ts.getMaThiSinh()+"");
        this.textField_HoVaTen.setText(ts.getTenThiSinh());
        this.textField_NgaySinh.setText(ts.getSĐT());
        this.comboBox_queQuan.setSelectedItem(ts.getQueQuan().getTenTinh());

    }

    public void ThucHienXoa() {
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
        int i_row = table.getSelectedRow();
        int luaChon = JOptionPane.showConfirmDialog(this, "Xoa dong dang chon?");
        if(luaChon == JOptionPane.YES_OPTION){
            ThiSinh ts = GetSinhVienDaChon();
            this.model.delete(ts);
            model_table.removeRow(i_row);
        }
    }

    public void ThucHienThemSinhVien() {
        // luu thong tin nhap tu nguoi dung
        int maThiSinh = Integer.valueOf(this.textField_ID.getText());
        String tenThiSinh = this.textField_HoVaTen.getText();
        int queQuan = this.comboBox_queQuan.getSelectedIndex()-1;
        Tinh tinh = Tinh.getTinhById(queQuan);
        String SDT = this.textField_NgaySinh.getText();
        boolean GioiTinh = true;
        if(this.radioButton_nam.isSelected()){
            GioiTinh = true;
        } else if (this.radioButton_nu.isSelected()) {
            GioiTinh = false;
        }
        ThiSinh ts = new ThiSinh(maThiSinh, tenThiSinh, tinh, SDT, GioiTinh);
        this.themHoaCapNhatSinhVien(ts);
    }

    public void ThucHienTim() {
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
        String tenTs = this.textField_TenSinhVien.getText();
        int SoLuong = model_table.getRowCount();
        Set<Integer> idCuaThiSinhCanXoa = new TreeSet<Integer>();
        if(!tenTs.isEmpty()){
            for(int i = 0; i < SoLuong; i++){
                String tenThiSinhTrongTable = model_table.getValueAt(i, 1).toString();
                String id = model_table.getValueAt(i, 0).toString();
                if(!tenThiSinhTrongTable.equals(tenTs)){
                    idCuaThiSinhCanXoa.add(Integer.parseInt(id));
                }
            }
        }
        String MaTinhSinhTimKiem = this.textField_MaThiSinh_TimKiem.getText();
        if(!MaTinhSinhTimKiem.isEmpty()){
            for(int i = 0; i < SoLuong; i++){
                String id = model_table.getValueAt(i, 0).toString();
                if(!id.equals(MaTinhSinhTimKiem)){
                    idCuaThiSinhCanXoa.add(Integer.parseInt(id));
                }
            }
        }

        for(Integer idCanXoa : idCuaThiSinhCanXoa){
            int soLuongDong = model_table.getRowCount();
            for(int i = 0; i < soLuongDong; i++){
                String idTrongTable = model_table.getValueAt(i, 0).toString();
                if(idTrongTable.equals(idCanXoa.toString())){
                    try {
                        model_table.removeRow(i);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
        }
    }

    public void ThucHienHuyTim() {
        //thuc hien huy tim
        while(true){
            DefaultTableModel model_table = (DefaultTableModel) table.getModel();
            int SoLuong = model_table.getRowCount();
            if(SoLuong == 0){
                break;
            }else{
                try {
                    model_table.removeRow(0);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        //thuc hien tim kiem
        for(ThiSinh ts: this.model.getDsThiSinh()){
            this.themThiSinhVaoTable(ts);
        }
    }

    public void ThoatKhoiChuongTrinh() {
        int luaChon = JOptionPane.showConfirmDialog(this, "thoải khỏi chương trình? ");
        if(luaChon == JOptionPane.YES_OPTION){
            this.setVisible(false);
        }
    }
    public void saveFile(String path){
        try {
            this.model.setTenFile(path);
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for(ThiSinh ts: this.model.getDsThiSinh()){
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
        ArrayList<ThiSinh> ds = new ArrayList<ThiSinh>();
        try {
            this.model.setTenFile(file.getAbsolutePath());
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            ThiSinh ts = null;
            while ((ts = (ThiSinh) ois.readObject()) != null){
                ds.add(ts);
            }
            ois.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        this.model.setDsThiSinh(ds);
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
