package Controller;

import LibrarianView.StudentView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Studentcontroller implements ActionListener {
    private StudentView view;

    public Studentcontroller(StudentView view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cm = e.getActionCommand();
//        JOptionPane.showMessageDialog(view, "ban vua nhan vao " + cm);
        if (cm.equals("Lưu")) {
            try {
                this.view.ThucHienThemSV();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }else if (cm.equals("Cập Nhật")) {
            this.view.HienThiSinhVienDaChon();
        } else if (cm.equals("Xoá")) {
            this.view.ThucHienXoa();
        } else if (cm.equals("Tìm")) {
            this.view.ThucHienTim();
        } else if (cm.equals("Huỷ Tìm")) {
            this.view.ThucHienHuyTim();
        } else if (cm.equals("Exit")) {
            this.view.ThoatKhoiChuongTrinh();
        } else if (cm.equals("Quản Lý Sách")) {
            this.view.HienThiSlideSach();
        }else if (cm.equals("Duyệt Phiếu Mượn")) {
            this.view.HienThiPhieuMuon();
        } else if (cm.equals("Quản Lý Mượn Trả")) {
            this.view.HienThiMuonTra();
        }
    }
}
