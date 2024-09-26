package model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ThiSinh implements Serializable {
    private int maThiSinh;
    private String tenThiSinh;
    private Tinh queQuan;
    private String SĐT;
    private boolean gioiTinh;
    private Date NgayMuon;

    public ThiSinh() {

    }

    public ThiSinh(int maThiSinh, String tenThiSinh, Tinh queQuan, String SĐT, boolean gioiTinh, Date NgayMuon) {
        this.maThiSinh = maThiSinh;
        this.tenThiSinh = tenThiSinh;
        this.queQuan = queQuan;
        this.SĐT = SĐT;
        this.gioiTinh = gioiTinh;
        this.NgayMuon = NgayMuon;

    }
    public int getMaThiSinh() {
        return maThiSinh;
    }

    public void setMaThiSinh(int maThiSinh) {
        this.maThiSinh = maThiSinh;
    }

    public String getTenThiSinh() {
        return tenThiSinh;
    }

    public void setTenThiSinh(String tenThiSinh) {
        this.tenThiSinh = tenThiSinh;
    }

    public Tinh getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(Tinh queQuan) {
        this.queQuan = queQuan;
    }

    public String getSĐT() {
        return SĐT;
    }

    public void setSĐT(String ngaySinh) {
        this.SĐT = ngaySinh;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void setNgayMuon(Date ngayMuon) {
        this.NgayMuon = ngayMuon;
    }
    public Date getNgayMuon() {
        return NgayMuon;
    }

    @Override
    public String toString() {
        return "ThiSinh [maThiSinh=" + maThiSinh + ", tenThiSinh=" + tenThiSinh + ", queQuan=" + queQuan + ", SoDienThoai="
                + SĐT + ", gioiTinh=" + gioiTinh + "]";
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ThiSinh other = (ThiSinh) obj;
        return  gioiTinh == other.gioiTinh
                && maThiSinh == other.maThiSinh && Objects.equals(SĐT, other.SĐT)
                && Objects.equals(queQuan, other.queQuan) && Objects.equals(tenThiSinh, other.tenThiSinh);
    }

    public static ArrayList<Date> getDSDate() {
        ArrayList<Date> listDate = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        for (int year = 2024; year <= currentYear; year++) {
            for (int month = 1; month <= 12; month++) {
                int daysInMonth = getDaysInMonth(month, year);
                for (int day = 1; day <= daysInMonth; day++) {
                    String dateString = String.format("%02d/%02d/%d", day, month, year);
                    try {
                        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateString);
                        listDate.add(date);
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        return listDate;
    }

    public static int getDaysInMonth(int month, int year) {
        switch (month) {
            case 2:
                if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                    return 29;
                } else {
                    return 28;
                }
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                return 31;
        }
    }

    public static Date getDatebyStr(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date dateToFind = sdf.parse(dateStr);
            ArrayList<Date> listDate = getDSDate();
            for (Date date : listDate) {
                if (date.equals(dateToFind)) {
                    return date;
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
