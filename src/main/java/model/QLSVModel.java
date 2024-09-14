package model;

import java.util.ArrayList;

public class QLSVModel {
    private ArrayList<ThiSinh> dsThiSinh;
    private String luachon;
    private String TenFile;

    public QLSVModel() {
        this.dsThiSinh = new ArrayList<>();
        this.luachon = "";
        this.TenFile = "";
    }

    public QLSVModel(ArrayList<ThiSinh> dsThiSinh) {
        this.dsThiSinh = dsThiSinh;
    }

    public ArrayList<ThiSinh> getDsThiSinh() {
        return dsThiSinh;
    }

    public void setDsThiSinh(ArrayList<ThiSinh> ds) {
        this.dsThiSinh = ds;
    }

    public void insert(ThiSinh thiSinh) {
        this.dsThiSinh.add(thiSinh);
    }

    public void delete(ThiSinh thiSinh) {
        this.dsThiSinh.remove(thiSinh);
    }

    public void update(ThiSinh thiSinh) {
        this.dsThiSinh.remove(thiSinh);
        this.dsThiSinh.add(thiSinh);
    }

    public String getLuachon(){
        return this.luachon;
    }
    public void setLuachon(String luachon) {
        this.luachon = luachon;
    }
    public String getTenFile(){
        return this.TenFile;
    }
    public void setTenFile(String TenFile) {
        this.TenFile = TenFile;
    }
    public boolean KiemTraTonTai(ThiSinh ts) {
        for(ThiSinh thiSinh : dsThiSinh) {
            if(thiSinh.getMaThiSinh() == ts.getMaThiSinh()) {
                return true;
            }
        }
        return false;
    }
}
