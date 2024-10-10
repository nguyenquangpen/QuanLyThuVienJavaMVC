package Controller;

import LibrarianView.BillView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BillController implements ActionListener {
    private BillView billView;
    public BillController(BillView billView) {
        this.billView = billView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        if(src.equals("Hoàn Tất")){
            this.billView.ThucHienHoanTat();
        }
    }
}
