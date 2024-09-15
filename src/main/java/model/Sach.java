package model;

import java.io.Serializable;

public class Sach implements Serializable {
    private int MaSachID;
    private String TenSach;
    private int NamXB;
    private String TheLoai;
    private String TacGia;
    public Sach(int MaSachID, String TenSach, int NamXB, String TheLoai, String TacGia) {
        this.MaSachID = MaSachID;
        this.TenSach = TenSach;
        this.NamXB = NamXB;
        this.TheLoai = TheLoai;
        this.TacGia = TacGia;
    }
    public int getMaSachID() {
        return MaSachID;
    }
    public void setMaSachID(int MaSachID) {
        this.MaSachID = MaSachID;
    }
    public String getTenSach() {
        return TenSach;
    }
    public void setTenSach(String TenSach) {
        this.TenSach = TenSach;
    }
    public int getNamXB() {
        return NamXB;
    }
    public void setNamXB(int NamXB) {
        this.NamXB = NamXB;
    }
    public String getTheLoai() {
        return TheLoai;
    }
    public void setTheLoai(String TheLoai) {
        this.TheLoai = TheLoai;
    }
    public String getTacGia() {
        return TacGia;
    }
    public void setTacGia(String TacGia) {
        this.TacGia = TacGia;
    }
    @Override
    public String toString() {
        return "Sach [MaSachID=" + MaSachID + ", TenSach=" + TenSach + ", NamXB=" +
                NamXB + ", TheLoai=" + TheLoai + ", TacGia=" + TacGia + "]";
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Sach other = (Sach) obj;
        return MaSachID == other.MaSachID && TenSach.equals(other.TenSach) &&
                NamXB == other.NamXB && TheLoai.equals(other.TheLoai) && TacGia.equals(other.TacGia);
    }
}
