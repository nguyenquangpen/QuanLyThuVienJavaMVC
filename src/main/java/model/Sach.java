package model;

public class Sach {
    private int id;
    private String tenSach;
    private String TheLoai;
    private int namXuatBan;
    private String TenTacGia;
    public Sach() {

    }
    public Sach(int id, String tenSach, int namXuatBan, String TheLoai, String TenTacGia) {
        this.tenSach = tenSach;
        this.TheLoai = TheLoai;
        this.namXuatBan = namXuatBan;
        this.id = id;
        this.TenTacGia = TenTacGia;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

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

    @Override
    public String toString() {
        return "Sach{" +
                "id=" + id +
                ", tenSach='" + tenSach + '\'' +
                ", TheLoai='" + TheLoai + '\'' +
                ", namXuatBan=" + namXuatBan +
                ", TenTacGia='" + TenTacGia + '\'' +
                '}';
    }
}
