package huongdoituong.J07058_DanhSachMonThi;

public class MonHoc{
    private String maMon;
    private String tenMonHoc;
    private String hinhThucThi;

    public MonHoc(String maMon, String tenMonHoc, String hinhThucThi) {
        this.maMon = maMon;
        this.tenMonHoc = tenMonHoc;
        this.hinhThucThi = hinhThucThi;
    }

    public String getMaMon() {
        return maMon;
    }

    @Override
    public String toString() {
        return maMon + " " + tenMonHoc + " " + hinhThucThi;
    }

}
