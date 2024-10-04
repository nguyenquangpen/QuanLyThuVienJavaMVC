package Controller;

import LoginRegister.LoginView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QLLoginController implements ActionListener {
    private LoginView loginView;

    public QLLoginController(LoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cm = e.getActionCommand();
        if(cm.equals("Login")){
            this.loginView.ThucHienDangNhap();
        } else if (cm.equals("Sign Up")) {
            this.loginView.ThuchienDangKy();
        }
    }
}
