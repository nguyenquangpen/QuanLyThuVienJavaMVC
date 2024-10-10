package Controller;

import LibrarianView.AcceptNoView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AcceptNoController implements ActionListener {
    private AcceptNoView accept_no;
    public AcceptNoController(AcceptNoView accept_no) {
        this.accept_no = accept_no;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cm = e.getActionCommand();
        if(cm.equals("Chấp Nhận")) {
            this.accept_no.ChapNhanMuon();
        } else if (cm.equals("Từ Chối")) {
            this.accept_no.TuChoiMuon();
        } else if (cm.equals("Xoá")) {
            this.accept_no.ThucHienXoa();
        } else if (cm.equals("Exit")) {
            this.accept_no.ThucHienThoat();
        } else if (cm.equals("Quản Lý Sách")) {
            this.accept_no.HienThiSach();
        } else if (cm.equals("Quản Lý Độc Giả")) {
            this.accept_no.HienThiDocGia();
        } else if (cm.equals("Quản Lý Mượn Trả")) {
            this.accept_no.HienThiMuonTra();
        }
    }
}
