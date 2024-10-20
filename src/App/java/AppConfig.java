package AppConfig;

import javax.swing.UIManager;
import LibrarianView.QLSachView;
import LibrarianView.StudentView;
import LibrarianView.TransactionView;
import LoginRegisterView.FuntionLogin;
import LoginRegisterView.LoginView;
import ReadersView.PhieuDkyView;
import ReadersView.ReaderBookView;

public class AppConfig {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new FuntionLogin();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
