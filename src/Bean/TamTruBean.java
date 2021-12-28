/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bean;

import java.util.List;
import models.NhanKhauModel;
import models.TamTruModel;

/**
 *
 * @author Nhan
 */
public class TamTruBean {

    private NhanKhauModel nhanKhauModel;
    private List<TamTruModel> listTamTruModels;

    public TamTruBean(NhanKhauModel nhanKhauModel, List<TamTruModel> listTamTruModels) {
        this.nhanKhauModel = nhanKhauModel;
        this.listTamTruModels = listTamTruModels;
    }

    public NhanKhauModel getNhanKhau() {
        return this.nhanKhauModel;
    }

    public void setNhanKhau(NhanKhauModel nhanKhauModel) {
        this.nhanKhauModel = nhanKhauModel;
    }

    public List<TamTruModel> getTamTru() {
        return this.listTamTruModels;
    }

    public void setTamTru(List<TamTruModel> listTamTru) {
        this.listTamTruModels = listTamTru;
    }
}
