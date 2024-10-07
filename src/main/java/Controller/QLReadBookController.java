package Controller;

import ReadersView.ReaderBookView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QLReadBookController implements ActionListener {
    ReaderBookView readerBookView;
    public QLReadBookController(ReaderBookView readerBookView) {
        this.readerBookView = readerBookView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cm = e.getActionCommand();
        if(cm.equals("Mượn")){
            this.readerBookView.ThucHienChoMuon();
        } else if (cm.equals("Tìm")) {
            this.readerBookView.ThucHienTim();
        } else if (cm.equals("Huỷ")) {
            this.readerBookView.ThucHienHuyTim();
        }else if (cm.equals("Đăng Ký")){
            this.readerBookView.ShowDangKyView();
        } else if (cm.equals("Exit")) {
            this.readerBookView.ThucHienQuayLai();
        } else if (cm.equals("Trạng Thái")) {
            this.readerBookView.HienThiTrangThai();
        }
    }
}
