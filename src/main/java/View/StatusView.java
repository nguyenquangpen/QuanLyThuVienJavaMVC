//package View;
//
//import Controller.QLSachController;
//import model.QLSachModel;
//
//import javax.swing.*;
//import javax.swing.table.DefaultTableModel;
//import java.awt.*;
//import java.awt.event.ActionListener;
//
//public class StatusView extends JFrame {
//    public JTable table;
//    public JTextField textField_MaSach, textField_TenDauSach, textField_NamXuatBan, textField_MaDauSach_TimKiem, textField_TheLoai, textField_TacGia;
//    public JButton btnHuyTim, btnTim;
//    public JTextField textField_TenDauSachTimKiem;
//    public QLSachModel model;
//
//    public StatusView() {
//        model = new QLSachModel();
//        this.inti();
//        this.setVisible(true);
//    }
//
//    private void inti() {
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setTitle("Quản lý đầu sách");
//        this.setSize(800, 600);
//        this.setLocationRelativeTo(null);
//
////        ActionListener action = new QLSachController(this);
//
//        Font font = new Font("Arial", Font.PLAIN, 15);
//        // jMenu
//        JMenuBar menuBar = new JMenuBar();
//        JMenu jMenuFile = new JMenu("File");
//        jMenuFile.setFont(font);
//
//        JMenuItem jMenuItemOpen = new JMenuItem("Open");
//        jMenuItemOpen.setFont(font);
//        jMenuItemOpen.addActionListener(action);
//
//        JMenuItem jMenuItemSave = new JMenuItem("Save");
//        jMenuItemSave.setFont(font);
//        jMenuItemSave.addActionListener(action);
//
//        JMenuItem jMenuItemExit = new JMenuItem("Exit");
//        jMenuItemExit.addActionListener(action);
//        jMenuItemExit.setFont(font);
//        jMenuItemSave.setFont(font);
//        jMenuFile.add(jMenuItemOpen);
//        jMenuFile.add(jMenuItemSave);
//        jMenuFile.addSeparator();
//        jMenuFile.add(jMenuItemExit);
//
//
//        // Tạo các JMenu như bình thường
//        JMenu jMenuItemSach = new JMenu("Sách");
//        jMenuItemSach.setFont(font);
//
//        JMenu jMenuItemDocGia = new JMenu("Độc Giả");
//        jMenuItemDocGia.setFont(font);
//
//        JMenu jMenuItemMuonTra = new JMenu("Mượn Trả");
//        jMenuItemMuonTra.setFont(font);
//
//        JMenu jMenuItemTrangThai = new JMenu("Trạng Thái");
//        jMenuItemTrangThai.setFont(font);
//
//        // Điều chỉnh khoảng cách giữa các menu item
//        jMenuItemSach.setMargin(new Insets(0, 5, 0, 5));
//        jMenuItemDocGia.setMargin(new Insets(0, 5, 0, 5));
//        jMenuItemMuonTra.setMargin(new Insets(0, 5, 0, 5));
//        jMenuItemTrangThai.setMargin(new Insets(0, 5, 0, 5));
//
//        menuBar.add(jMenuFile);
//        menuBar.add(new JSeparator(SwingConstants.VERTICAL));
//        menuBar.add(jMenuItemSach);
//        menuBar.add(new JSeparator(SwingConstants.VERTICAL));
//        menuBar.add(jMenuItemDocGia);
//        menuBar.add(new JSeparator(SwingConstants.VERTICAL));
//        menuBar.add(jMenuItemMuonTra);
//        menuBar.add(new JSeparator(SwingConstants.VERTICAL));
//        menuBar.add(jMenuItemTrangThai);
//        menuBar.add(new JSeparator(SwingConstants.VERTICAL));
//
//        //North
//        JLabel label_TenDauSach = new JLabel("Tên Đầu Sách");
//        label_TenDauSach.setFont(font);
//        textField_TenDauSachTimKiem = new JTextField(15);
//        textField_TenDauSachTimKiem.setFont(font);
//
//        JLabel label_maDauSAch = new JLabel("Mã Đầu Sách");
//        label_maDauSAch.setFont(font);
//        textField_MaDauSach_TimKiem = new JTextField(10);
//        textField_MaDauSach_TimKiem.setFont(font);
//
//        btnTim = new JButton("Tìm");
//        btnTim.addActionListener(action);
//
//        btnHuyTim = new JButton("Huỷ Tìm");
//        btnHuyTim.addActionListener(action);
//
//        JPanel panelNorth = new JPanel();
//        panelNorth.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));
//        panelNorth.add(label_TenDauSach);
//        panelNorth.add(textField_TenDauSachTimKiem);
//        panelNorth.add(label_maDauSAch);
//        panelNorth.add(textField_MaDauSach_TimKiem);
//        panelNorth.add(btnTim);
//        panelNorth.add(btnHuyTim);
//        // center
//        table = new JTable();
//        table.setFont(new Font("Tahoma", Font.PLAIN, 16));
//        table.setModel(new DefaultTableModel(
//                new Object[][]{},
//                new String[]{"Mã Đầu sách", "Tên Đầu Sách", "Năm xuất bản", "Thể Loại",
//                        "Tác Giả"}));
//
//        table.setRowHeight(20);
//
//        JScrollPane tableScrollPane = new JScrollPane(table);
//        JPanel panelCenter = new JPanel();
//        panelCenter.setLayout(new BoxLayout(panelCenter, BoxLayout.Y_AXIS));
//        panelCenter.add(tableScrollPane);
//
//        //South
//        JLabel jLabelMaDauSach = new JLabel("Mã Đầu sách");
//        jLabelMaDauSach.setFont(font);
//        JLabel jLabelTenDauSach = new JLabel("Tên Đầu Sách");
//        jLabelTenDauSach.setFont(font);
//        JLabel jLabelNamXuatBan = new JLabel("Năm xuất bản");
//        jLabelNamXuatBan.setFont(font);
//        JLabel jLabelTacGia = new JLabel("Tác Giả");
//        jLabelTacGia.setFont(font);
//
//        textField_MaSach = new JTextField(10);
//        textField_MaSach.setFont(font);
//        textField_TenDauSach = new JTextField(10);
//        textField_TenDauSach.setFont(font);
//        textField_NamXuatBan = new JTextField(10);
//        textField_NamXuatBan.setFont(font);
//        textField_TacGia = new JTextField(10);
//        textField_TacGia.setFont(font);
//
//
//        JPanel panelCenterBottom = new JPanel();
//        panelCenterBottom.setLayout(new GridLayout(2, 4));
//        panelCenterBottom.add(jLabelMaDauSach);
//        panelCenterBottom.add(textField_MaSach);
//        panelCenterBottom.add(jLabelTenDauSach);
//        panelCenterBottom.add(textField_TenDauSach);
//        panelCenterBottom.add(jLabelNamXuatBan);
//        panelCenterBottom.add(textField_NamXuatBan);
//        panelCenterBottom.add(jLabelTacGia);
//        panelCenterBottom.add(textField_TacGia);
//        panelCenter.add(panelCenterBottom, BorderLayout.SOUTH);
//
//        //bottom
//        JButton btnThem = new JButton("Xoá Text");
//        btnThem.addActionListener(action);
//
//        JButton btnXoa = new JButton("Xoá");
//        btnXoa.addActionListener(action);
//
//        JButton btnCapNhat = new JButton("Cập Nhật");
//        btnCapNhat.addActionListener(action);
//
//        JButton btnLuu = new JButton("Lưu");
//        btnLuu.addActionListener(action);
//
//        JLabel jLabeTheLoai = new JLabel("Thể Loại");
//        jLabeTheLoai.setFont(font);
//        textField_TheLoai = new JTextField(10);
//        textField_TheLoai.setFont(font);
//
//        Panel panelSouth = new Panel();
//        panelSouth.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));
//        panelSouth.add(jLabeTheLoai);
//        panelSouth.add(textField_TheLoai);
//        panelSouth.add(btnThem);
//        panelSouth.add(btnXoa);
//        panelSouth.add(btnCapNhat);
//        panelSouth.add(btnLuu);
//
//
//        this.setJMenuBar(menuBar);
//        this.setLayout(new BorderLayout());
//        this.add(panelNorth, BorderLayout.NORTH);
//        this.add(panelCenter, BorderLayout.CENTER);
//        this.add(panelSouth, BorderLayout.SOUTH);
//    }