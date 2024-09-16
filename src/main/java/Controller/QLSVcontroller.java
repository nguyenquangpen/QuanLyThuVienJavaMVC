package Controller;

import View.QLSVView;
import model.ThiSinh;
import model.Tinh;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class QLSVcontroller implements ActionListener {
    private QLSVView view;

    public QLSVcontroller(QLSVView view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cm = e.getActionCommand();
//        JOptionPane.showMessageDialog(view, "ban vua nhan vao " + cm);
        if(cm.equals("Xoá Text")){
            view.xoaForm();
        }
        else if(cm.equals("Lưu")){
            try{
                this.view.ThucHienThemSinhVien();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        } else if (cm.equals("Cập Nhật")) {
            this.view.HienThiSinhVienDaChon();
        } else if (cm.equals("Xoá")) {
            this.view.ThucHienXoa();
        } else if (cm.equals("Tìm")) {
            this.view.ThucHienTim();
        } else if (cm.equals("Huỷ Tìm")) {
            this.view.ThucHienHuyTim();
        } else if (cm.equals("Exit")) {
            this.view.ThoatKhoiChuongTrinh();
        } else if (cm.equals("Save")) {
            this.view.ThucHienSaveFile();
        }else if (cm.equals("Open")){
            this.view.ThucHienOpenFile();
        }
    }
}
