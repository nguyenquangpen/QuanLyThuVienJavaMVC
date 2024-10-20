package Controller;

import LoginRegisterView.LoginLibrarianView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibrarianLoginController implements ActionListener {
    private LoginLibrarianView loginView;

    public LibrarianLoginController(LoginLibrarianView loginView) {
        this.loginView = loginView;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String cm = e.getActionCommand();
        if(cm.equals("Login")){
            this.loginView.ThucHienDangNhapLibrarian();
        }
        else if(cm.equals("Back")) {
        	this.loginView.QuayLaiLogin();
        }
        
    }
}
