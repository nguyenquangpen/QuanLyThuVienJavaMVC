package Controller;

import LoginRegisterView.RegisterView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QLRegisterController implements ActionListener {
    private RegisterView registerView;

    public QLRegisterController(RegisterView registerView) {
        this.registerView = registerView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cm = e.getActionCommand();
        if(cm.equals("Register")){
            this.registerView.ThucHienDangKy();
        } else if (cm.equals("Back")) {
            this.registerView.ThucHienQuayLai();

        }
    }
}
