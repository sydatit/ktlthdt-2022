package huongdoituong.J05007_DSToiTuongNhanVien;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class NhanVien implements Comparable{
    private String mvn;
        private String hoTen;
    private String gioiTinh;
    private LocalDate ngaySinh;
    private String diaChi;
    private String maSoThue;
    private LocalDate ngayKiHD;
    private long tuoi;

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public NhanVien(int mvn, String hoTen, String gioiTinh, String ngaySinh, String diaChi, String maSoThue, String ngayKiHD) {
        this.mvn = String.format("%05d", mvn);
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = LocalDate.parse( ngaySinh, formatter);
        this.diaChi = diaChi;
        this.maSoThue = maSoThue;
        this.ngayKiHD = LocalDate.parse(ngayKiHD,formatter);
        tuoi = LocalDate.now().toEpochDay()  - this.ngaySinh.toEpochDay();
    }

    @Override
    public int compareTo(Object o) {
        NhanVien nhanVien = (NhanVien) o;
        if( tuoi > nhanVien.tuoi) return -1;
        if( tuoi < nhanVien.tuoi) return 1;
        return 0;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %s %s %s", mvn, hoTen, gioiTinh, formatter.format(ngaySinh),
                diaChi, maSoThue, formatter.format(ngayKiHD));
    }
}
