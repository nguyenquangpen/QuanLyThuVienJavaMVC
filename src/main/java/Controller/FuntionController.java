package Controller;

import LoginRegisterView.FuntionLogin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FuntionController implements ActionListener {
    private FuntionLogin funtionLogin;
    public FuntionController(FuntionLogin funtionLogin) {
        this.funtionLogin = funtionLogin;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cm = e.getActionCommand();
        if(cm.equals("Thủ Thư")){
            this.funtionLogin.ThuchienChuyenThuThu();
        } else if (cm.equals("Độc Giả")) {
            this.funtionLogin.ThuchienChuyenDocGia();
        }
    }

}
