package model;

import java.util.Date;

public class Sach {
    private String id;
    private String tenSach;
    private String TheLoai;
    private int namXuatBan;
    private String TenTacGia;
    private int SoLuong;
    private int DaMuon;
    private int TonKho;
    public Sach() {
    }
//    public Sach(String tenSach, String TenTacGia) {
//        this.tenSach = tenSach;
//        this.TenTacGia = TenTacGia;
//    }
    public Sach(String id, String tenSach, int namXuatBan, String TheLoai, String TenTacGia, int SoLuong, int DaMuon) {
        this.tenSach = tenSach;
        this.TheLoai = TheLoai;
        this.namXuatBan = namXuatBan;
        this.id = id;
        this.TenTacGia = TenTacGia;
        this.SoLuong = SoLuong;
        this.DaMuon = DaMuon;
        setTonKho();
    }
	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTheLoai() {
        return TheLoai;
    }

    public void setTheLoai(String TheLoai) {
        this.TheLoai = TheLoai;
    }

    public int getNamXuatBan() {
        return namXuatBan;
    }

    public void setNamXuatBan(int namXuatBan) {
        this.namXuatBan = namXuatBan;
    }

    public String getTenTacGia() {
        return TenTacGia;
    }

    public void setTenTacGia(String tenTacGia) {
        TenTacGia = tenTacGia;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int soLuong) {
        SoLuong = soLuong;
    }
    
    public int getDaMuon() {
		return DaMuon;
	}
	public void setDaMuon(int daMuon) {
		this.DaMuon = daMuon;
		setTonKho();
	}
	public void setTonKho() {
		this.TonKho = this.SoLuong - this.DaMuon;
	}
	public int getTonKho() {
		return TonKho;
	}
	
	@Override
	public String toString() {
		return "Sach [id=" + id + ", tenSach=" + tenSach + ", TheLoai=" + TheLoai + ", namXuatBan=" + namXuatBan
				+ ", TenTacGia=" + TenTacGia + ", SoLuong=" + SoLuong + ", DaMuon=" + DaMuon + ", TonKho=" + TonKho
				+ "]";
	}
}
