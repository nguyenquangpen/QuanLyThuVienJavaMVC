package Controller;

import LibrarianView.QLSachView;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QLSachController implements ActionListener {
    private QLSachView view;

    public QLSachController(QLSachView view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cm = e.getActionCommand();
        if (cm.equals("Lưu")) {
            try {
                this.view.ThucHienThemSach();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        } else if (cm.equals("Cập Nhật")) {
            this.view.HienThiSinhVienDaChon();
        } else if (cm.equals("Xoá")) {
            this.view.ThucHienXoa();
        } else if (cm.equals("Tìm")) {
            this.view.ThucHienTim();
        } else if (cm.equals("Huỷ Tìm")) {
            this.view.ThucHienHuyTim();
        } else if (cm.equals("Exit")) {
            this.view.ThoatKhoiChuongTrinh();
        } else if (cm.equals("Quản Lý Độc Giả")) {
            this.view.HienThiDocGia();
        } else if (cm.equals("Duyệt Phiếu Mượn")) {
            this.view.HienThiPhieuMuon();
        }else if (cm.equals("Quản Lý Mượn Trả")) {
            this.view.HienThiMuonTra();
        }
    }
}
