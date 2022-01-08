package models;

import java.util.Date;

/**
 *
 * @author Nhan
 */
public class TamVangModel extends TamBaseModel {

    private String maGiayTamVang;
    private String noiTamTru;

    public String getMaGiayTamVang() {
        return maGiayTamVang;
    }

    public void setMaGiayTamVang(String maGiayTamVang) {
        this.maGiayTamVang = maGiayTamVang;
    }

    public String getNoiTamTru() {
        return noiTamTru;
    }

    public void setNoiTamTru(String noiTamTru) {
        this.noiTamTru = noiTamTru;
    }

}
