package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import LibrarianView.BillView;
import LibrarianView.TransactionView;
import LibrarianView.AcceptNoView;


public class TransactionController implements ActionListener {
	private TransactionView transactionView;
	public TransactionController(TransactionView transactionView) {
		this.transactionView = transactionView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if (src.equals("Mượn")) {
	        this.transactionView.ThucHienMuonSach();
		} else if (src.equals("Trả Sách")) {
			this.transactionView.ThucHienTraSachDocGia();
		} else if (src.equals("Tìm")) {
			this.transactionView.ThucHienTimKiem();
		} else if (src.equals("Xuất Bill")) {
			this.transactionView.HienThiBill();
		} else if (src.equals("Hiện Bảng")) {
			this.transactionView.HienBangPhieuMuon();
		} else if (src.equals("Ẩn Bảng")) {
			this.transactionView.ThucHienAnBangPhieuMuon();
		} else if (src.equals("Huỷ Tìm")) {
			this.transactionView.ThucHienHuyTim();
		} else if (src.equals("Exit")) {
			this.transactionView.ThoatKhoiChuongTrinh();
		} else if (src.equals("Quản Lý Độc Giả")) {
			this.transactionView.HienThiDocGia();
		} else if (src.equals("Duyệt Phiếu Mượn")) {
			new AcceptNoView();
		} else if (src.equals("Quản Lý Sách")){
			this.transactionView.HienThiSach();
		}
	}
}
