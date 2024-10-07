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
        } else if (cm.equals("Từ chối")) {
            this.accept_no.TuChoiMuon();
        }
    }
}
