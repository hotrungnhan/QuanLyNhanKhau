/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import Bean.TamTruBean;
import Bean.TamVangBean;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import services.GiayTamServices;
import utility.ClassTableModel;

/**
 *
 * @author Nhan
 */
public class TimGiayPanelController {

    private JPanel jpPanel;
    private JTextField jtCmnd;
    private JTextField jtTen;
    private JComboBox<String> jtLoaiGiay;
    private ClassTableModel classTableModel = new ClassTableModel();
    private final String[] TamVangCOLUMNS = {"Mã Tạm Vắng", "Nơi Tạm Trú", "Từ Ngày", "Đến Ngày", "Lý Do"};
    private final String[] TamTruCOLUMNS = {"Mã Tạm Vắng", "Số điện thoại NDK ", "Từ Ngày", "Đến Ngày", "Lý Do"};
    private final String[] comboboxItem = {"Tạm Trú", "Tạm vắng"};
    private final GiayTamServices services = new GiayTamServices();
    private TamTruBean tamtruBean;
    private TamVangBean tamvangBean;

    public TimGiayPanelController(JPanel Panel, JTextField cmnd, JComboBox loaigiay, JTextField ten) {
        this.jpPanel = Panel;
        this.jtCmnd = cmnd;
        this.jtLoaiGiay = loaigiay;
        this.jtTen = ten;
        initCombobox();
        this.initAction();
    }

    private void getBean() {
        String type = jtLoaiGiay.getSelectedItem().toString();
        String cmnd = jtCmnd.getText();
        try {
            if (type == "Tạm Trú") {
                this.tamtruBean = services.getListGiayTamTru(cmnd);
            } else {
                this.tamvangBean = services.getListGiayTamVang(cmnd);
            }
        } catch (Exception err) {
            System.err.println(err.getMessage());
        }
    }

    private void refreshTable() {
        String type = jtLoaiGiay.getSelectedItem().toString();
        if (tamtruBean == null) {
            jtTen.setText("Không tìm thấy");
        } else {
            if (type == "Tạm Trú") {
                setTableTamTru();
                jtTen.setText(tamtruBean.getNhanKhau().getHoTen());
            } else if (type == "Tạm vắng") {
                setTableTamVang();
                jtTen.setText(tamvangBean.getNhanKhau().getHoTen());
            }
        }
    }

    private void refresh() {
        if (!jtCmnd.getText().isEmpty()) {
            getBean();
            refreshTable();
        }
    }

    private void initAction() {
        jtCmnd.setText("");
        jtTen.setText("");
        jtCmnd.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                System.out.println("cmnd change" + jtCmnd.getText());
                refresh();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                System.out.println("cmnd change" + jtCmnd.getText());
                refresh();

//                refresh();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
//                System.out.println("cmnd change" + jtCmnd.getText());
//                refresh();
            }
        });
        jtLoaiGiay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("loai change" + jtLoaiGiay.getSelectedItem().toString());
                refresh();
            }
        });
    }

    private void initCombobox() {
        DefaultComboBoxModel model = new DefaultComboBoxModel(comboboxItem);
        System.out.println(model.getElementAt(0) + String.valueOf(jtLoaiGiay == null));
        jtLoaiGiay.setModel(model);
        jtLoaiGiay.setEditable(false);
    }

    private void setTableTamVang() {
        System.out.println("set table tamvang");
        DefaultTableModel model = classTableModel.setTableTamVang(tamvangBean.getTamVang(), TamVangCOLUMNS);
        JTable table = new JTable(model);
        // thiet ke bang
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(100, 50));
        table.setRowHeight(50);
        table.validate();
        table.repaint();
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.getColumnModel().getColumn(0).setMaxWidth(80);
        table.getColumnModel().getColumn(0).setMinWidth(80);
        table.getColumnModel().getColumn(0).setPreferredWidth(80);
        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        scroll.setPreferredSize(new Dimension(1350, 400));
        jpPanel.removeAll();
        jpPanel.setLayout(new BorderLayout());
        jpPanel.add(scroll);
        jpPanel.validate();
        jpPanel.repaint();
    }

    private void setTableTamTru() {
        System.out.println("set table tamtru");
        DefaultTableModel model = classTableModel.setTableTamTru(tamtruBean.getTamTru(), TamTruCOLUMNS);
        JTable table = new JTable(model);
        // thiet ke bang
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(100, 50));
        table.setRowHeight(50);
        table.validate();
        table.repaint();
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.getColumnModel().getColumn(0).setMaxWidth(80);
        table.getColumnModel().getColumn(0).setMinWidth(80);
        table.getColumnModel().getColumn(0).setPreferredWidth(80);
        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        scroll.setPreferredSize(new Dimension(1350, 400));
        jpPanel.removeAll();
        jpPanel.setLayout(new BorderLayout());
        jpPanel.add(scroll);
        jpPanel.validate();
        jpPanel.repaint();
    }

}
