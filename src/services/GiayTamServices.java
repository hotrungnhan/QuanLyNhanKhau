/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import Bean.TamTruBean;
import Bean.TamVangBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;
import models.ChungMinhThuModel;
import models.NhanKhauModel;
import models.TamTruModel;
import models.TamVangModel;

/**
 *
 * @author Nhan
 */
public class GiayTamServices {

    public TamTruBean getListGiayTamTru(String cmt) throws SQLException, ClassNotFoundException {
        Vector<TamTruModel> tamtruvector = new Vector<TamTruModel>();
        Connection connection = MysqlConnection.getMysqlConnection();
        String query = "SELECT tam_tru.* FROM chung_minh_thu,nhan_khau,tam_tru "
                + " WHERE chung_minh_thu.idNhanKhau=nhan_khau.ID AND tam_tru.idNhanKhau =nhan_khau.ID AND chung_minh_thu.soCMT = " + cmt;

        PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            TamTruModel ttm = new TamTruModel();
            ttm.setID(rs.getInt("ID"));
            ttm.setIdNhanKhau(rs.getInt("idNhanKhau"));
            ttm.setMaGiayTamTru(rs.getString("maGiayTamtru"));
            ttm.setTuNgay(rs.getDate("tuNgay"));
            ttm.setDenNgay(rs.getDate("denNgay"));
            ttm.setLyDo(rs.getString("lyDo"));
            tamtruvector.add(ttm);
        }
        query = "SELECT nhan_khau.* FROM chung_minh_thu,nhan_khau "
                + " WHERE chung_minh_thu.idNhanKhau=nhan_khau.ID AND chung_minh_thu.soCMT= " + cmt + " LIMIT 1";
        preparedStatement = (PreparedStatement) connection.prepareStatement(query);
        rs = preparedStatement.executeQuery();
        NhanKhauModel nhanKhau = new NhanKhauModel();
        nhanKhau.setID(-1);
        while (rs.next()) {
            nhanKhau.setID(rs.getInt("ID"));
            nhanKhau.setHoTen(rs.getString("hoTen"));
        }
        if (nhanKhau.getID() == -1) {
            return null;
        } else {
            return new TamTruBean(nhanKhau, tamtruvector);
        }

    }

    public TamVangBean getListGiayTamVang(String cmt) throws SQLException, ClassNotFoundException {
        Vector<TamVangModel> tamvangvector = new Vector<TamVangModel>();
        Connection connection = MysqlConnection.getMysqlConnection();
        String query = "SELECT tam_vang.* FROM chung_minh_thu,nhan_khau,tam_vang "
                + " WHERE chung_minh_thu.idNhanKhau=nhan_khau.ID AND tam_vang.idNhanKhau =nhan_khau.ID AND chung_minh_thu.soCMT = " + cmt;
        PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
        ResultSet rs = preparedStatement.executeQuery();
        System.out.println("68");
        while (rs.next()) {
            TamVangModel ttv = new TamVangModel();

            ttv.setID(rs.getInt("ID"));
            ttv.setIdNhanKhau(rs.getInt("idNhanKhau"));
            ttv.setMaGiayTamVang(rs.getString("maGiayTamVang"));
            ttv.setTuNgay(rs.getDate("tuNgay"));
            ttv.setDenNgay(rs.getDate("denNgay"));
            ttv.setNoiTamTru(rs.getString("noiTamTru"));
            ttv.setLyDo(rs.getString("lyDo"));
            tamvangvector.add(ttv);
        }
        query = "SELECT nhan_khau.* FROM chung_minh_thu,nhan_khau "
                + " WHERE chung_minh_thu.idNhanKhau=nhan_khau.ID AND chung_minh_thu.soCMT= " + cmt + " LIMIT 1";
        preparedStatement = (PreparedStatement) connection.prepareStatement(query);
        rs = preparedStatement.executeQuery();
        NhanKhauModel nhanKhau = new NhanKhauModel();
        nhanKhau.setID(-1);
        while (rs.next()) {
            nhanKhau.setID(rs.getInt("ID"));
            nhanKhau.setHoTen(rs.getString("hoTen"));
        }

        System.out.println(tamvangvector.size());
        if (nhanKhau.getID() == -1) {
            return null;
        } else {
            return new TamVangBean(nhanKhau, tamvangvector);
        }
    }
}
