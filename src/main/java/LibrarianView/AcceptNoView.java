package LibrarianView;

import Controller.AcceptNoController;
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
        setBounds(100, 100, 524, 449);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Duyệt Phiếu Mượn");

        ActionListener ac = new AcceptNoController(this);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(10, 79, 490, 262);
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
        for (Status s: status) {
            DefaultTableModel model_table = (DefaultTableModel) table.getModel();
            model_table.addRow(new Object[]{s.getStudentID(), s.getBookID(), s.getAmount(), s.getStatus()});
        }
    }

    public Sach getDanhSachChonSach(){
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
        int i_row = table.getSelectedRow();
        if (i_row == -1) {
            return null;
        }
        String MaSach = model_table.getValueAt(i_row, 2).toString();
        ArrayList<Sach> sach = SachDAO.getInstance().selectByCondition(MaSach, "MaSachID");
        return sach.get(0);
    }

    public Student getDanhSachSinhVien(){
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
        int i_row = table.getSelectedRow();
        if (i_row == -1) {
            return null;
        }
        String MaSinhVien = model_table.getValueAt(i_row, 1).toString();
        ArrayList<Student> student = StudentDAO.getInstance().selectByCondition(MaSinhVien, "StudentID");
        return student.get(0);
    }

    public void TuChoiMuon() {
        String cm = "Không";
        Sach sach = getDanhSachChonSach();
        Student student = getDanhSachSinhVien();
        String studentID = student.getId();
        String BookID = sach.getId();
        int amount = sach.getSoLuong();
        AcceptNoDao acceptNoDao = new AcceptNoDao();
        acceptNoDao.update(studentID, BookID, amount, cm);

        if(checkStudentIDAndSachID(studentID, BookID)){
            JOptionPane.showMessageDialog(null, "Sách đã được từ chối mượn");
        }else {
            HienThiVapBangMacDinh();
            JOptionPane.showMessageDialog(null, "Từ chối mượn thành công");
        }
    }

    public void ChapNhanMuon() {
        String cm = "Có";
        Sach sach = getDanhSachChonSach();
        Student student = getDanhSachSinhVien();
        String studentID = student.getId();
        String BookID = sach.getId();
        int amount = sach.getSoLuong();
        AcceptNoDao acceptNoDao = new AcceptNoDao();
        acceptNoDao.update(studentID, BookID, amount, cm);

        if(checkStudentIDAndSachID(studentID, BookID)) {
            JOptionPane.showMessageDialog(null, "Sách đã được chấp nhận mượn");
        }
        else {
            HienThiVapBangMacDinh();
            JOptionPane.showMessageDialog(null, "Chấp nhận mượn thành công");
        }
    }

    public boolean checkStudentIDAndSachID(String studentID, String sachID){
        AcceptNoDao acceptNoDao = new AcceptNoDao();
        Status status =  acceptNoDao.selectByID(studentID, sachID);
        if (status.getStatus().equals("Có") || status.getStatus().equals("Không")){
            return true;
        }
        return false;
    }
}
