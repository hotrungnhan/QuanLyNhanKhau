package models;

import java.util.Date;

/**
 *
 * @author Nhan
 */
public class TamTruModel extends TamBaseModel {

    private String maGiayTamTru;
    private String soDienThoaiNguoiDangKy;

    public String getMaGiayTamTru() {
        return maGiayTamTru;
    }

    public void setMaGiayTamTru(String maGiayTamTru) {
        this.maGiayTamTru = maGiayTamTru;
    }

    public String getSoDienThoaiNguoiDangKy() {
        return soDienThoaiNguoiDangKy;
    }

    public void setSoDienThoaiNguoiDangKy(String soDienThoaiNguoiDangKy) {
        this.soDienThoaiNguoiDangKy = soDienThoaiNguoiDangKy;
    }

}
