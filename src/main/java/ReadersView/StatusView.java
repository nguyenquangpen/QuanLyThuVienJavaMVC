package ReadersView;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class StatusView extends JFrame {
    public static final long serialVersionUID = 1L;
    public JPanel contentPane;
    public JTable table;
    public JTextField jtfTenSV;
    public JTextField jtfMaSV;

    public StatusView() {
        this.init();
        this.setVisible(true);
    }

    private void init() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 509, 428);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Trạng Thái");
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setBounds(210, 87, 275, 269);
        contentPane.add(panel);
        panel.setLayout(null);

        table = new JTable();
        table.setBounds(10, 11, 241, 247);
        panel.add(table);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(255, 255, 255));
        panel_1.setBounds(10, 87, 168, 269);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        JButton btnNewButton = new JButton("Huỷ Mượn");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnNewButton.setBounds(24, 224, 114, 23);
        panel_1.add(btnNewButton);

        JLabel lblNewLabel_1 = new JLabel("Mã Sinh Viên");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNewLabel_1.setBounds(10, 57, 69, 23);
        panel_1.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Tên Sinh Viên");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNewLabel_2.setBounds(10, 140, 84, 14);
        panel_1.add(lblNewLabel_2);

        jtfTenSV = new JTextField();
        jtfTenSV.setFont(new Font("Tahoma", Font.PLAIN, 12));
        jtfTenSV.setBounds(10, 165, 128, 20);
        panel_1.add(jtfTenSV);
        jtfTenSV.setColumns(10);

        jtfMaSV = new JTextField();
        jtfMaSV.setFont(new Font("Tahoma", Font.PLAIN, 12));
        jtfMaSV.setBounds(10, 91, 128, 20);
        panel_1.add(jtfMaSV);
        jtfMaSV.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("Thông tin");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_3.setBounds(50, 11, 67, 23);
        panel_1.add(lblNewLabel_3);

        JLabel lblNewLabel = new JLabel("Trạng Thái");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 23));
        lblNewLabel.setBounds(183, 29, 121, 27);
        contentPane.add(lblNewLabel);
    }

}
