package LibrarianView;

import Controller.AcceptNoController;
import LoginRegister.FuntionLogin;
import dao.AcceptNoDao;
import dao.SachDAO;
import dao.StudentDAO;
import model.Sach;
import model.Status;
import model.Student;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AcceptNoView extends JFrame {
    public static final long serialVersionUID = 1L;
    public JPanel contentPane;
    public JTable table;

    public AcceptNoView() {
        this.init();
        this.setVisible(true);
    }
    public void init(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 524, 476);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Duyệt Phiếu Mượn");

        ActionListener ac = new AcceptNoController(this);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

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

        this.setJMenuBar(menuBar);
        getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(10, 79, 490, 262);
        panel.setBackground(new Color(255, 255, 255));
        contentPane.add(panel);
        panel.setLayout(null);

        table = new JTable();
        table.setBounds(10, 11, 470, 240);
        table.setFont(new Font("Tahoma", Font.PLAIN, 16));
        table.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{"Mã Sinh Viên", "Mã Sách", "Số Lượng", "Cho Mượn"}));
        HienThiVapBangMacDinh();

        JScrollPane tableScrollPane = new JScrollPane(table);
        tableScrollPane.setBounds(10, 11, 470, 240);
        panel.add(tableScrollPane);

        JLabel lblNewLabel = new JLabel("Duyệt Phiếu Mượn");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 23));
        lblNewLabel.setBounds(150, 24, 213, 37);
        contentPane.add(lblNewLabel);

        JButton bntChapNhan = new JButton("Chấp Nhận");
        bntChapNhan.setFont(new Font("Tahoma", Font.PLAIN, 13));
        bntChapNhan.setBounds(198, 367, 108, 23);
        bntChapNhan.addActionListener(ac);
        contentPane.add(bntChapNhan);

        JButton btnTuChoi = new JButton("Từ Chối");
        btnTuChoi.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnTuChoi.setBounds(370, 367, 89, 23);
        btnTuChoi.addActionListener(ac);
        contentPane.add(btnTuChoi);

        JButton btnXoa = new JButton("Xoá");
        btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnXoa.setBounds(34, 367, 89, 23);
        btnXoa.addActionListener(ac);
        contentPane.add(btnXoa);
    }

    public void XoaBang() {
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
        model_table.setRowCount(0);
    }

    public void HienThiVapBangMacDinh(){
        XoaBang();
        AcceptNoDao acceptNoDao = new AcceptNoDao();
        ArrayList<Status> status = acceptNoDao.selectAll();
        for (Status s : status) {
            DefaultTableModel model_table = (DefaultTableModel) table.getModel();
            model_table.addRow(new Object[]{s.getStudentID(), s.getBookID(), s.getAmount(), s.getStatus()});
        }
    }

    public Status getDanhSachMuonTra(){
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
        int i_row = table.getSelectedRow();
        if (i_row == -1) {
            return null;
        }
        String studentID = model_table.getValueAt(i_row, 0).toString();
        String bookID = model_table.getValueAt(i_row, 1).toString();
        int amount = Integer.parseInt(model_table.getValueAt(i_row, 2).toString());
        String status1 = model_table.getValueAt(i_row, 3).toString();
        Status status = new Status(studentID, bookID, amount, status1);
        return status;
    }

    public void TuChoiMuon() {
        final String REJECTED = "Declined";
        Status status = getDanhSachMuonTra();

        if (status.getBookID() == null || status.getStudentID() == null) {
            JOptionPane.showMessageDialog(null, "Chọn Mã Học Sinh và Mã Sách hợp lệ.");
            return;
        }
        String studentID = status.getStudentID();
        String bookID = status.getBookID();
        int amount = status.getAmount();
        AcceptNoDao acceptNoDao = new AcceptNoDao();
        acceptNoDao.update(studentID, bookID, amount, REJECTED);
        int result = checkStudentIDAndSachID();
        if (result == 2) {
            HienThiVapBangMacDinh();
            JOptionPane.showMessageDialog(null, "Sách đã được từ chối mượn");
        } else if (result == 0) {
            HienThiVapBangMacDinh();
            JOptionPane.showMessageDialog(null, "Từ chối mượn thành công"); // không cần thông báo
        }
        else {
            JOptionPane.showMessageDialog(null, "Sách đã được chấp nhận mượn"); //không cần thông báo
        }
    }

    public void ChapNhanMuon() {
        final String ACCEPTED = "Accepted";
        Status status = getDanhSachMuonTra();

        if (status.getBookID() == null || status.getStudentID() == null) {
            JOptionPane.showMessageDialog(null, "Chọn Mã Học Sinh và Mã Sách hợp lệ.");
            return;
        }
        String studentID = status.getStudentID();
        String bookID = status.getBookID();
        int amount = status.getAmount();
        AcceptNoDao acceptNoDao = new AcceptNoDao();
        acceptNoDao.update(studentID, bookID, amount, ACCEPTED);

        int result = checkStudentIDAndSachID();
        if (result == 1) {
            HienThiVapBangMacDinh();
            JOptionPane.showMessageDialog(null, "Sách đã được chấp nhận mượn");
        } else if (result == 0) {
            HienThiVapBangMacDinh();
            JOptionPane.showMessageDialog(null, "Chấp nhận mượn thành công");  //không cần thông báo
        }else{
            JOptionPane.showMessageDialog(null, "Sách đã được từ chối mượn"); //không cần thông báo
        }
    }

    public int checkStudentIDAndSachID(){
        int ketqua = 0;
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
        int i_row = table.getSelectedRow();

        String studentID = model_table.getValueAt(i_row, 0).toString();
        String bookID = model_table.getValueAt(i_row, 1).toString();
        AcceptNoDao acceptNoDao = new AcceptNoDao();
        Status status = acceptNoDao.selectByID(studentID, bookID);
        if("Accepted".equals(status.getStatus())){
            return 1;
        }
        if("Declined".equals(status.getStatus())){
            return 2;
        }
        return ketqua;
    }

    public void ThucHienXoa() {
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
        AcceptNoDao acceptNoDao = new AcceptNoDao();
        int i_row = table.getSelectedRow();
        if (i_row != -1) {
            Status status = getDanhSachMuonTra();
            if (status != null) {
                int result = acceptNoDao.delete(status.getStudentID(), status.getBookID());
                if (result > 0) {
                    model_table.removeRow(i_row);
                }
            }
        }
    }

    public void HienThiDocGia() {
        this.dispose();
        new StudentView();
    }

    public void HienThiSach() {
        this.dispose();
        new QLSachView();
    }

    public void ThucHienThoat() {
        this.dispose();
        new FuntionLogin();
    }
}
