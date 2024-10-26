package ReadersView;

import Controller.StatusController;
import LoginRegisterView.FuntionLogin;
import dao.AcceptNoDao;
import dao.StudentDAO;
import model.AcceptNo;
import model.Student;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StatusView extends JFrame {
    public static final long serialVersionUID = 1L;
    public JPanel contentPane;
    public JTable table;
    public JTextField jtfTenSV;
    public JTextField jtfMaSV;

    public StatusView() {
        this.init();
        this.setVisible(true);
    }

    private void init() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 538, 428);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Trạng Thái");
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        ActionListener ac = new StatusController(this);

        setContentPane(contentPane);
        contentPane.setLayout(null);

        Font font = new Font("Arial", Font.PLAIN, 15);
        JMenuBar menuBar = new JMenuBar();
        JMenu jMenuFile = new JMenu("File");
        jMenuFile.setFont(font);

        JMenuItem jMenuItemExit = new JMenuItem("Exit");
        jMenuItemExit.setFont(font);
        jMenuFile.addSeparator();
        jMenuFile.add(jMenuItemExit);
        jMenuItemExit.addActionListener(ac);

        JMenuItem jMenuItemPhieu = new JMenu("Phiếu");
        jMenuItemPhieu.setFont(font);

        JMenuItem sachItem = new JMenuItem("Đăng Ký");
        sachItem.setFont(font);
        jMenuItemPhieu.add(sachItem);
        sachItem.addActionListener(ac);

        JMenuItem StatusView = new JMenuItem("Trạng Thái");
        StatusView.setFont(font);
        jMenuItemPhieu.add(StatusView);
        StatusView.addActionListener(ac);

        JMenuItem jMenuItemBook = new JMenu("Sách");
        jMenuItemBook.setFont(font);

        JMenuItem BookView = new JMenuItem("Đầu Sách");
        BookView.setFont(font);
        jMenuItemBook.add(BookView);
        BookView.addActionListener(ac);

        menuBar.add(jMenuFile);
        menuBar.add(new JSeparator(SwingConstants.VERTICAL));
        menuBar.add(jMenuItemPhieu);
        menuBar.add(new JSeparator(SwingConstants.VERTICAL));
        menuBar.add(jMenuItemBook);

        this.setJMenuBar(menuBar);
        getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setBounds(188, 87, 326, 269);
        contentPane.add(panel);
        panel.setLayout(null);

        table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{"Mã Sinh Viên", "Mã Sách", "Số Lượng", "Cho Mượn"}));
        HienThiVaoBangMacDinh();

        JScrollPane tableScrollPane = new JScrollPane(table);
        tableScrollPane.setBounds(10, 11, 306, 247);
        panel.add(tableScrollPane);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(255, 255, 255));
        panel_1.setBounds(10, 87, 168, 269);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        JButton btnNewButton = new JButton("Huỷ Mượn");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnNewButton.setBounds(24, 224, 114, 23);
        btnNewButton.addActionListener(ac);
        panel_1.add(btnNewButton);

        JLabel lblNewLabel_1 = new JLabel("Mã Sinh Viên");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNewLabel_1.setBounds(10, 57, 69, 23);
        panel_1.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Tên Sinh Viên");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNewLabel_2.setBounds(10, 140, 84, 14);
        panel_1.add(lblNewLabel_2);

        jtfTenSV = new JTextField();
        jtfTenSV.setFont(new Font("Tahoma", Font.PLAIN, 12));
        jtfTenSV.setBounds(10, 165, 128, 20);
        panel_1.add(jtfTenSV);
        jtfTenSV.setColumns(10);

        jtfMaSV = new JTextField();
        jtfMaSV.setFont(new Font("Tahoma", Font.PLAIN, 12));
        jtfMaSV.setBounds(10, 91, 128, 20);
        panel_1.add(jtfMaSV);
        jtfMaSV.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("Thông tin");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_3.setBounds(50, 11, 67, 23);
        panel_1.add(lblNewLabel_3);

        JLabel lblNewLabel = new JLabel("Trạng Thái");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 23));
        lblNewLabel.setBounds(183, 29, 121, 27);
        contentPane.add(lblNewLabel);
        
        //set them icon cho cac menu 
        jMenuFile.setIcon(new ImageIcon("D:\\Academic\\lap-trinh\\Project\\IdeaProject\\library_management_Project\\Image\\google-docs.png"));
        jMenuItemExit.setIcon(new ImageIcon("D:\\Academic\\lap-trinh\\Project\\IdeaProject\\library_management_Project\\Image\\logout.png"));
        jMenuItemBook.setIcon(new ImageIcon("D:\\Academic\\lap-trinh\\Project\\IdeaProject\\library_management_Project\\Image\\bookshelf.png"));
        BookView.setIcon(new ImageIcon("D:\\Academic\\lap-trinh\\Project\\IdeaProject\\library_management_Project\\Image\\book.png"));
        jMenuItemPhieu.setIcon(new ImageIcon("D:\\Academic\\lap-trinh\\Project\\IdeaProject\\library_management_Project\\Image\\check-list.png"));
        sachItem.setIcon(new ImageIcon("D:\\Academic\\lap-trinh\\Project\\IdeaProject\\library_management_Project\\Image\\register.png"));
        StatusView.setIcon(new ImageIcon("D:\\Academic\\lap-trinh\\Project\\IdeaProject\\library_management_Project\\Image\\verified.png"));
    }

    public void ThucHienThoat() {
        this.dispose();
        new FuntionLogin();
    }

    public void HienThiDangKy() {
        this.dispose();
        new PhieuDkyView();
    }

    public void HienThiDauSach() {
        this.dispose();
        new ReaderBookView();
    }

    public void XoaBang() {
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
        model_table.setRowCount(0);
    }

    public void HienThiVaoBangMacDinh(){
        XoaBang();
        AcceptNoDao acceptNoDao = new AcceptNoDao();
        ArrayList<AcceptNo> acceptNos = acceptNoDao.selectAll();
        for (AcceptNo s : acceptNos) {
            DefaultTableModel model_table = (DefaultTableModel) table.getModel();
            model_table.addRow(new Object[]{s.getStudentID(), s.getBookID(), s.getAmount(), s.getStatus()});
        }
    }

    public AcceptNo getDanhSachMuonTra(){
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
        int i_row = table.getSelectedRow();
        if (i_row == -1) {
            return null;
        }
        String studentID = model_table.getValueAt(i_row, 0).toString();
        String bookID = model_table.getValueAt(i_row, 1).toString();
        int amount = Integer.parseInt(model_table.getValueAt(i_row, 2).toString());
        String status1 = model_table.getValueAt(i_row, 3).toString();
        AcceptNo acceptNo = new AcceptNo(studentID, bookID, amount, status1);
        return acceptNo;
    }

    public boolean KiemTraStudentID(){
        String jtfstudentID = jtfMaSV.getText();
        String StudentName = jtfTenSV.getText();
        AcceptNo acceptNo = getDanhSachMuonTra();

        String StudentId = acceptNo.getStudentID();
        if (jtfstudentID.isEmpty() || StudentName.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Không được để trống");
            return false;
        }
        StudentDAO studentDAO = new StudentDAO();

        Student student = studentDAO.selectById(jtfstudentID);
        if(student == null) {
            JOptionPane.showMessageDialog(null, "Không tồn tại");
            return false;
        }
        if(!StudentId.equals(jtfstudentID) || !student.getName().equals(StudentName)){
            JOptionPane.showMessageDialog(null, "Sai thông tin");
            return false;
        }
        return true;
    }

    public void ThucHienXoa() {
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
        AcceptNoDao acceptNoDao = new AcceptNoDao();
        int i_row = table.getSelectedRow();
        if (i_row != -1) {
            AcceptNo acceptNo = getDanhSachMuonTra();
            if (acceptNo != null) {
                int result = acceptNoDao.delete(acceptNo.getStudentID(), acceptNo.getBookID());
                if (result > 0) {
                    model_table.removeRow(i_row);
                }
            }
        }
    }

    public void ThucHienHuyMuon() {
        boolean check = KiemTraStudentID();
        if(check){
            ThucHienXoa();
            HienThiVaoBangMacDinh();
        }
    }
}
