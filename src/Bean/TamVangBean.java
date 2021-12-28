/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bean;

import java.util.List;
import java.util.Vector;
import models.NhanKhauModel;
import models.TamVangModel;

/**
 *
 * @author Nhan
 */
public class TamVangBean {

    private NhanKhauModel nhanKhauModel;
    private List<TamVangModel> listTamVangModels;

    public TamVangBean(NhanKhauModel nhanKhauModel, List<TamVangModel> listTamVangModels) {
        this.nhanKhauModel = nhanKhauModel;
        this.listTamVangModels = listTamVangModels;
    }

    public NhanKhauModel getNhanKhau() {
        return this.nhanKhauModel;
    }

    public void setNhanKhau(NhanKhauModel nhanKhauModel) {
        this.nhanKhauModel = nhanKhauModel;
    }

    public List<TamVangModel> getTamVang() {
        return this.listTamVangModels;
    }

    public void setTamVang(List<TamVangModel> listTamTru) {
        this.listTamVangModels = listTamTru;
    }
}
