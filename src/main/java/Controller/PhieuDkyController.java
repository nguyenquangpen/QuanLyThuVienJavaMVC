package Controller;

import ReadersView.PhieuDkyView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PhieuDkyController implements ActionListener {
    public PhieuDkyView phieuDkyView;

    public PhieuDkyController(PhieuDkyView phieuDkyView) {
            this.phieuDkyView = phieuDkyView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cm = e.getActionCommand();
        if(cm.equals("Đăng Ký")){
            this.phieuDkyView.ThucHienDangKy();
        } else if (cm.equals("Quay Lại")) {
            this.phieuDkyView.ThucHienQuayLai();
        }
    }
}
