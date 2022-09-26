package huongdoituong.J04007_KhaiBaoLopNhanVien;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NhanVien {
    private String maNhanVien = "00001";
    private String hoTen;
    private String gioiTinh;
    private Date ngaySinh;
    private String diaChi;
    private String maSoThue;
    private Date ngayKyHopDong;

    public NhanVien(String hoTen, String gioiTinh, String ngaySinh, String diaChi, String maSoThue, String ngayKyHopDong) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = sdf.parse(ngaySinh);
        this.diaChi = diaChi;
        this.maSoThue = maSoThue;
        this.ngayKyHopDong = sdf.parse(ngayKyHopDong);
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return maNhanVien + " " + hoTen + " " + gioiTinh + " " + sdf.format(ngaySinh) + " " + diaChi + " "
                + maSoThue + " " + sdf.format(ngayKyHopDong);
    }
}
