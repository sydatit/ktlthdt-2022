package huongdoituong.J05003_DanhSachDoiTuongSV;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SinhVien {
    private String msv;
    private String hoTen;
    private Date ngaySinh;
    private String lop;
    private float gpa;
    private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    public SinhVien() {
        msv = hoTen = lop = "";
        ngaySinh = new Date();
        gpa = 0;
    }

    public SinhVien(int msv, String hoTen, String lop, String ngaySinh, String gpa) throws ParseException {
        this.msv = String.format("B20DCCN%03d", msv);
        this.hoTen = hoTen;
        this.lop = lop;
        this.ngaySinh = format.parse(ngaySinh);
        this.gpa = Float.parseFloat(gpa);
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %.2f", msv, hoTen, lop, format.format(ngaySinh), gpa);
    }
}
