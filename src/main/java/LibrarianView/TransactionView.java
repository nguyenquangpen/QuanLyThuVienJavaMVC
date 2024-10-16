package LibrarianView;

import java.awt.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import Controller.TransactionController;
import LoginRegisterView.FuntionLogin;
import dao.AcceptNoDao;
import dao.StudentDAO;
import dao.TransactionDao;
import model.AcceptNo;
import model.Student;
import model.Transaction;

public class TransactionView extends JFrame {

    private static final long serialVersionUID = 1L;
    public JPanel contentPane;
    public static JTable table;
    public JLabel lblNewLabel, lblNewLabel_1, lblNewLabel_2, lblNewLabel_3, lblNewLabel_4, lblNewLabel_5, lblNewLabel_6;
    public JPanel panel, panel_1;
    public JTextField jtfDocGiaTraSach;
    public JTextField jtfDocGia;
    public JTextField jtfNgayMuon;
    public JTextField jtfMaSach;
    public JTextField jtfSoLuong;
    public JTextField jtfNgayTra;
    public JTextField jtfMaSachTra;
    public static JTextField jtfMaDocGiaBill;

    public TransactionView() {
        this.init();
        this.setVisible(true);
    }
    public void init() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 822, 702);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Quản Lý Mượn Trả");
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(new Color(230, 230, 230));

        ActionListener ac = new TransactionController(this);

        Font font = new Font("Arial", Font.PLAIN, 15);
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

        setContentPane(contentPane);
        contentPane.setLayout(null);

        table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "Mã sinh viên", "Mã Sách", "Số Lượng", "Ngày mượn", "Ngày trả", "Phí Phạt"
                }
        ));
        HienThiVaoBang();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 317, 790, 337);
        contentPane.add(scrollPane);

        lblNewLabel = new JLabel("Quản Lý Mượn Trả");
        lblNewLabel.setBounds(311, 26, 220, 27);
        contentPane.add(lblNewLabel);
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 23));

        panel = new JPanel();
        panel.setBounds(10, 69, 274, 237);
        contentPane.add(panel);
        panel.setLayout(null);
        panel.setBorder(new LineBorder(Color.GRAY, 1));

        lblNewLabel_2 = new JLabel("Mã Độc Giả");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_2.setBounds(10, 58, 72, 14);
        panel.add(lblNewLabel_2);

        lblNewLabel_1 = new JLabel("Mã Sách");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_1.setBounds(10, 111, 49, 14);
        panel.add(lblNewLabel_1);

        JLabel lblNewLabel_7 = new JLabel("Mượn Sách");
        lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 17));
        lblNewLabel_7.setBounds(79, 11, 106, 22);
        panel.add(lblNewLabel_7);

        jtfDocGia = new JTextField();
        jtfDocGia.setBounds(92, 56, 114, 20);
        panel.add(jtfDocGia);
        jtfDocGia.setColumns(10);

        jtfMaSach = new JTextField();
        jtfMaSach.setBounds(92, 109, 114, 20);
        panel.add(jtfMaSach);
        jtfMaSach.setColumns(10);

        JButton btnMuon = new JButton("Mượn");
        btnMuon.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnMuon.setBounds(96, 164, 89, 22);
        btnMuon.addActionListener(ac);
        panel.add(btnMuon);

        panel_1 = new JPanel();
        panel_1.setBounds(294, 69, 294, 237);
        contentPane.add(panel_1);
        panel_1.setLayout(null);
        panel_1.setBorder(new LineBorder(Color.GRAY, 1));

        lblNewLabel_5 = new JLabel("Trả Sách");
        lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 17));
        lblNewLabel_5.setBounds(117, 11, 96, 23);
        panel_1.add(lblNewLabel_5);

        lblNewLabel_6 = new JLabel("Mã Độc Giả");
        lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_6.setBounds(10, 60, 89, 14);
        panel_1.add(lblNewLabel_6);

        jtfDocGiaTraSach = new JTextField();
        jtfDocGiaTraSach.setBounds(117, 57, 149, 20);
        panel_1.add(jtfDocGiaTraSach);
        jtfDocGiaTraSach.setColumns(10);

        JButton btnTraSach = new JButton("Trả Sách");
        btnTraSach.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnTraSach.setBounds(83, 202, 89, 23);
        btnTraSach.addActionListener(ac);
        panel_1.add(btnTraSach);

        JButton btnTim = new JButton("Tìm");
        btnTim.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnTim.setBounds(20, 168, 89, 23);
        btnTim.addActionListener(ac);
        panel_1.add(btnTim);

        JLabel lblNewLabel_9 = new JLabel("Ngày Trả");
        lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_9.setBounds(10, 95, 89, 20);
        panel_1.add(lblNewLabel_9);

        jtfNgayTra = new JTextField();
        jtfNgayTra.setBounds(117, 96, 149, 20);
        panel_1.add(jtfNgayTra);
        jtfNgayTra.setColumns(10);

        JLabel lblNewLabel_10 = new JLabel("Mã Sách");
        lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_10.setBounds(10, 143, 65, 14);
        panel_1.add(lblNewLabel_10);

        jtfMaSachTra = new JTextField();
        jtfMaSachTra.setBounds(117, 141, 149, 20);
        panel_1.add(jtfMaSachTra);
        jtfMaSachTra.setColumns(10);

        JButton btnHuyTim = new JButton("Huỷ Tìm");
        btnHuyTim.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnHuyTim.setBounds(152, 169, 89, 23);
        btnHuyTim.addActionListener(ac);
        panel_1.add(btnHuyTim);

        JPanel panel_2 = new JPanel();
        panel_2.setBounds(598, 69, 202, 93);
        contentPane.add(panel_2);
        panel_2.setLayout(null);
        panel_2.setBorder(new LineBorder(Color.GRAY, 1));

        JLabel lblNewLabel_8 = new JLabel("Bảng Phiếu Duyệt");
        lblNewLabel_8.setBounds(17, 11, 148, 28);
        panel_2.add(lblNewLabel_8);
        lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 15));

        JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Hiện Bảng");
        rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        rdbtnNewRadioButton_1.setBounds(17, 62, 111, 23);
        rdbtnNewRadioButton_1.addActionListener(ac);
        panel_2.add(rdbtnNewRadioButton_1);

        JPanel panel_3 = new JPanel();
        panel_3.setBounds(598, 173, 202, 133);
        contentPane.add(panel_3);
        panel_3.setLayout(null);
        panel_3.setBorder(new LineBorder(Color.GRAY, 1));

        JButton btnNewButton = new JButton("Xuất Bill");
        btnNewButton.setBounds(111, 97, 85, 25);
        panel_3.add(btnNewButton);
        btnNewButton.addActionListener(ac);
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));

        JLabel lblNewLabel_11 = new JLabel("Mã Độc Giả");
        lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_11.setBounds(10, 33, 81, 25);
        panel_3.add(lblNewLabel_11);

        jtfMaDocGiaBill = new JTextField();
        jtfMaDocGiaBill.setBounds(10, 66, 147, 20);
        panel_3.add(jtfMaDocGiaBill);
        jtfMaDocGiaBill.setColumns(10);

        JLabel lblNewLabel_12 = new JLabel("Bill");
        lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_12.setBounds(76, 11, 44, 25);
        panel_3.add(lblNewLabel_12);
    }

    public void ThemTransactionVaoBang(Transaction transaction){
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
        model_table.addRow(new Object[]{
            transaction.getStudentID(),
            transaction.getBookID(),
            transaction.getAmount(),
            transaction.getDate(),
            transaction.getReturnDate(),
            transaction.getStatus()
        });
    }

    public static void XoaBang() {
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
        model_table.setRowCount(0);
    }

    public static void HienThiVaoBang(){
        XoaBang();
        TransactionDao transactionDao = new TransactionDao();
        ArrayList<Transaction> status = transactionDao.selectAll();
        for (Transaction s : status) {
            DefaultTableModel model_table = (DefaultTableModel) table.getModel();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String formattedReturnDate = sdf.format(s.getReturnDate());
            String formatterDate = sdf.format(s.getDate());
            model_table.addRow(new Object[]{s.getStudentID(), s.getBookID(), s.getAmount(), formatterDate, formattedReturnDate, s.getStatus()});
        }
    }

    public void ThucHienTinhPhi() {
        TransactionDao transactionDao = new TransactionDao();
        String returnDate = jtfNgayTra.getText();
        String studentID = jtfDocGiaTraSach.getText();
        String bookID = jtfMaSachTra.getText();

        // Lấy danh sách giao dịch theo điều kiện studentID và bookID
        ArrayList<Transaction> transactions = transactionDao.selectByCondition(studentID, "BookID" ,bookID);

        if (!transactions.isEmpty()) {
            for (Transaction transaction : transactions) {
                // Kiểm tra nếu ngày trả vẫn là "1970-01-01" (chưa trả sách)
                if (transaction.getReturnDate().toString().equals("1970-01-01")) {
                    // Định dạng ngày
                    SimpleDateFormat inputDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    SimpleDateFormat outputDateFormat = new SimpleDateFormat("yyyy-MM-dd");

                    try {
                        // Chuyển đổi returnDate từ String sang Date
                        java.util.Date returnDate1 = inputDateFormat.parse(returnDate);

                        // Chuyển đổi ngày mượn sang định dạng yyyy-MM-dd
                        String formattedDate = outputDateFormat.format(returnDate1);

                        // Tính số ngày mượn
                        long diff = returnDate1.getTime() - transaction.getDate().getTime();
                        long diffDays = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

                        // Tính tiền phạt (chuyển sang String)
                        String fine = "0";
                        if (diffDays > 7) {
                            fine = String.valueOf((diffDays - 7) * 1000);
                        }

                        transactionDao.update(studentID, bookID, formattedDate, fine);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


    public void ThucHienTraSachDocGia() {
        TransactionDao transactionDao = new TransactionDao();
        String studentID = jtfDocGiaTraSach.getText();
        String bookID = jtfMaSachTra.getText();

        if (studentID != null && !studentID.trim().isEmpty() && bookID != null && !bookID.trim().isEmpty()) {

            ThucHienTinhPhi();
            HienThiVaoBang();

            String status = "null";
            boolean result = transactionDao.delete(studentID, bookID, status);

            if (result) {
                JOptionPane.showMessageDialog(null, "Trả sách thất bại");
            } else {
                JOptionPane.showMessageDialog(null, "Trả sách thành công");
                HienThiVaoBang();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nhập Mã Độc Giả và Mã Sách để Trả Sách");
        }
    }


    public void ThucHienMuonSach() {
        String studentID = jtfDocGia.getText();
        String bookID = jtfMaSach.getText();

        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String returnDate = "1970-01-01";
        String status = "Null";
        TransactionDao transactionDao = new TransactionDao();

        AcceptNoDao acceptNoDao = new AcceptNoDao();
        AcceptNo acceptNo1 = acceptNoDao.selectByID(studentID, bookID);

        // Định dạng ngày
        SimpleDateFormat inputDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat outputDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if(acceptNo1 == null){
            JOptionPane.showMessageDialog(null, "Nhập Sai Dữ Liệu");
            return;

        }else{
            try {
                // Chuyển đổi date từ String sang Date
                java.util.Date borrowDate = inputDateFormat.parse(date);

                // Chuyển đổi ngày mượn sang định dạng yyyy-MM-dd
                String formattedDate = outputDateFormat.format(borrowDate);

                // Thực hiện chèn dữ liệu vào bảng mà không cần tính toán ngày trả ban đầu
                transactionDao.insert(studentID, bookID, acceptNo1.getAmount(), formattedDate, returnDate, status);

                JOptionPane.showMessageDialog(null, "Mượn sách thành công");

                HienThiVaoBang(); // Hiển thị giao dịch mới vào bảng

            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public void ThucHienTimKiem() {
        TransactionDao transactionDao = new TransactionDao();
        String studentID = jtfDocGiaTraSach.getText();
        XoaBang();
        if(!studentID.isEmpty()){
            ArrayList<Transaction> transactions = transactionDao.selectByName(studentID);
            if (transactions != null && !transactions.isEmpty()) {
                for (Transaction transaction : transactions) {
                    ThemTransactionVaoBang(transaction);
                }
            }
        }
    }

    public void ThucHienHuyTim() {
        HienThiVaoBang();
    }

    public void HienThiBill() {
        if(jtfMaDocGiaBill.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nhập Mã Độc Giả Để Xuất Bill");
        }else{
            new BillView();
        }
    }

    public void HienBangPhieuMuon() {
        new AcceptNoView();
    }

    public void ThucHienAnBangPhieuMuon() {
        new AcceptNoView().setVisible(false);
    }

    public static Student HienThiLabelVaoPhieu(){
        String MaDocGiaBill = jtfMaDocGiaBill.getText();
        if(MaDocGiaBill.isEmpty()){
            JOptionPane.showMessageDialog(null, "Nhập Mã Độc Giả Để Xuất Bill");
            return null;

        }else{
            StudentDAO studentDAO = new StudentDAO();
            return studentDAO.selectById(MaDocGiaBill);
        }
    }

    public void ThoatKhoiChuongTrinh() {
        this.dispose();
        new FuntionLogin();
    }

    public void HienThiDocGia() {
        this.dispose();
        new StudentView();
    }

    public void HienThiSach() {
        this.dispose();
        new QLSachView();
    }
}