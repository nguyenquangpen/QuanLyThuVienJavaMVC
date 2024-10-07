package Controller;

import ReadersView.StatusView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StatusController implements ActionListener {
    private StatusView statusView;
    public StatusController(StatusView statusView) {
        this.statusView = statusView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cm = e.getActionCommand();
        if(cm.equals("Exit")){
            this.statusView.ThucHienThoat();
        } else if (cm.equals("Đăng Ký")){
            this.statusView.HienThiDangKy();
        }else if (cm.equals("Đầu Sách")){
            this.statusView.HienThiDauSach();
        } else if(cm.equals("Huỷ Mượn")){
            this.statusView.ThucHienHuyMuon();
        }
    }
}
