package Controller;

import View.LoginView;

import javax.swing.*;
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
        JOptionPane.showMessageDialog(loginView, "ban vua nhan vao " + cm);
        if(cm.equals("Login")){
            this.loginView.ThucHienDangNhap();
        } else if (cm.equals("Register")) {
            this.loginView.ChuyenSangRegister();
        }
    }
}
