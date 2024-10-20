package LibrarianView;

import Controller.BillController;
import com.google.protobuf.Value;
import dao.TransactionDao;
import model.Student;
import model.Transaction;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;


public class BillView extends JFrame {

    private static final long serialVersionUID = 1L;
    public JPanel contentPane;
    public JTable table;
    public JLabel jlbMaDocGiaID, jlbTenDocGia, jlbTongTien;

    public BillView() {
        this.init();
        this.setVisible(true);
    }
    public void init() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 413, 478);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Bill Thanh Toán");
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        ActionListener ac = new BillController(this);

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Bill Thanh Toán ");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel.setBounds(139, 11, 174, 25);
        contentPane.add(lblNewLabel);

        JPanel panel = new JPanel();
        panel.setBounds(10, 47, 381, 385);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("Mã Độc Giả: ");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_1.setBounds(10, 22, 84, 22);
        panel.add(lblNewLabel_1);

        JLabel jlbMaDocGiaID = new JLabel("..");
        jlbMaDocGiaID.setText(Objects.requireNonNull(TransactionView.HienThiLabelVaoPhieu(), "Mã độc giả Bị null").getId());
        jlbMaDocGiaID.setFont(new Font("Tahoma", Font.PLAIN, 13));
        jlbMaDocGiaID.setBounds(104, 27, 110, 14);
        panel.add(jlbMaDocGiaID);

        JLabel lblNewLabel_3 = new JLabel("Tên Độc Giả :");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_3.setBounds(10, 68, 84, 22);
        panel.add(lblNewLabel_3);

        JLabel jlbTenDocGia = new JLabel("..");
        jlbTenDocGia.setText(Objects.requireNonNull(TransactionView.HienThiLabelVaoPhieu(), "Tên độc giả Bị null").getName());
        jlbTenDocGia.setFont(new Font("Tahoma", Font.PLAIN, 13));
        jlbTenDocGia.setBounds(104, 68, 148, 19);
        panel.add(jlbTenDocGia);

        table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "Mã Sách", "Số Lượng", "Giá Tiền"
                }
        ));
        HienThiVaoBangMacDinh();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 101, 361, 130);
        panel.add(scrollPane);

        String imagePath = "D:\\Eclipse_java\\Final_prj\\Image\\MaQr.jpg";

        // Tạo ImageIcon từ ảnh gốc
        ImageIcon originalIcon = new ImageIcon(imagePath);

        // Lấy đối tượng Image từ ImageIcon
        Image originalImage = originalIcon.getImage();

        // Thay đổi kích thước của ảnh (73x122)
        Image resizedImage = originalImage.getScaledInstance(211, 122, Image.SCALE_SMOOTH);

        // Tạo ImageIcon mới từ ảnh đã được thay đổi kích thước
        ImageIcon resizedIcon = new ImageIcon(resizedImage);

        // Tạo JLabel và đặt icon là ảnh đã thay đổi kích thước
        JLabel lblNewLabel_5 = new JLabel("New label");
        lblNewLabel_5.setIcon(resizedIcon);
        lblNewLabel_5.setBounds(160, 242, 211, 137);
        panel.add(lblNewLabel_5);

        JLabel lblNewLabel_6 = new JLabel("Tổng Tiền: ");
        lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_6.setBounds(10, 276, 74, 22);
        panel.add(lblNewLabel_6);

        jlbTongTien = new JLabel("..");
        jlbTongTien.setText(HienThiTongTien());
        jlbTongTien.setFont(new Font("Tahoma", Font.PLAIN, 13));
        jlbTongTien.setBounds(86, 281, 64, 14);
        panel.add(jlbTongTien);

        JButton btnNewButton = new JButton("Hoàn Tất");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnNewButton.setBounds(35, 331, 89, 23);
        btnNewButton.addActionListener(ac);
        
        panel.add(btnNewButton);
    }

    public void XoaBang() {
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
        model_table.setRowCount(0);
    }

    public void HienThiVaoBangMacDinh(){
        XoaBang();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        TransactionDao transactionDao = new TransactionDao();
        String StudentID = Objects.requireNonNull(TransactionView.HienThiLabelVaoPhieu()).getId();
        ArrayList<Transaction> list = transactionDao.selectByName(StudentID, "Status");
        for(Transaction s : list){
            model.addRow(new Object[]{
                s.getBookID(),
                s.getAmount(),
                s.getStatus()
            });
        }
    }

    public String HienThiTongTien(){
        TransactionDao transactionDao = new TransactionDao();
        String StudentID = Objects.requireNonNull(TransactionView.HienThiLabelVaoPhieu()).getId();
        ArrayList<Transaction> list = transactionDao.selectByName(StudentID, "Status");
        int BookPrice = 0;
        for(Transaction s : list){
           try{
                BookPrice += Integer.parseInt(s.getStatus());
           }catch (NumberFormatException e){
               System.out.println(e);
           }
        }
        return  String.valueOf(BookPrice);
    }

    public void ThucHienHoanTat() {
        TransactionDao transactionDao = new TransactionDao();
        String StudentID = Objects.requireNonNull(TransactionView.HienThiLabelVaoPhieu()).getId();
        boolean status = transactionDao.delete_Book(StudentID);
        if(status) {
            JOptionPane.showMessageDialog(this, "Thanh Toán Thành Công");
            this.dispose();
            TransactionView.HienThiVaoBang();
        }
    }
}
