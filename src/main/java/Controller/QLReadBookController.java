package Controller;

import ReadersView.ReaderBookView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QLReadBookController implements ActionListener {
    ReaderBookView readerBookView;
    public QLReadBookController(ReaderBookView readerBookView) {
        this.readerBookView = readerBookView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
