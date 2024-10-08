package Controller;

import LoginRegisterView.RegisterLibrarianView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibrarianRegisterController implements ActionListener {
    private RegisterLibrarianView register;

    public LibrarianRegisterController(RegisterLibrarianView register) {
        this.register = register;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cm = e.getActionCommand();
        if(cm.equals("Sign Up")){
            this.register.ThucHienDangKyLibrarian();
        }else if(cm.equals("Back")) {
            this.register.ThucHienQuayLai();
        }
    }
}
