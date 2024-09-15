package model;

import java.util.ArrayList;

public class QLSachModel {
    ArrayList<Sach> dsSach;
    private String TenFile;

    public QLSachModel() {
        this.dsSach = new ArrayList<>();
        this.TenFile = "";
    }
    public  QLSachModel(ArrayList<Sach> dsSach) {
        this.dsSach = dsSach;
    }
    public ArrayList<Sach> getDsSach() {
        return dsSach;
    }
    public void setDsSach(ArrayList<Sach> dsSach) {
        this.dsSach = dsSach;
    }
    public void insert(Sach sach) {
        this.dsSach.add(sach);
    }
    public void delete(Sach sach) {
        this.dsSach.remove(sach);
    }
    public void update(Sach sach) {
        this.dsSach.remove(sach);
        this.dsSach.add(sach);
    }
    public void setTenFile(String TenFile) {
        this.TenFile = TenFile;
    }
    public String getTenFile() {
        return TenFile;
    }

    public boolean KiemTraTonTai(Sach sach) {
        for(Sach ts : dsSach) {
            if(sach.getMaSachID() == ts.getMaSachID()) {
                return true;
            }
        }
        return false;
    }
}
