package huongdoituong.J07059_DanhSachCaThi;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class CaThi implements Comparable{
    private String maCaThi;
    private LocalDate ngayThi;
    private LocalTime gioThi;
    private String phongThi;

    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyy");
    private DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

    public CaThi(int n, String ngayThi, String gioThi, String phongThi) {

        this.maCaThi = String.format("C%03d", n );
        this.ngayThi = LocalDate.parse(ngayThi, dateFormatter);
        this.gioThi = LocalTime.parse(gioThi, timeFormatter);
        this.phongThi = phongThi;
    }

    public String getMaCaThi() {
        return maCaThi;
    }

    public LocalDate getNgayThi() {
        return ngayThi;
    }

    public LocalTime getGioThi() {
        return gioThi;
    }

    @Override
    public int compareTo(Object o) {
        CaThi caThi = (CaThi) o;
        if( ngayThi.compareTo(caThi.ngayThi) > 0 ) return 1;
        if( ngayThi.compareTo(caThi.ngayThi) < 0) return -1;

        if( gioThi.compareTo(caThi.gioThi) > 0) return 1;
        if( gioThi.compareTo(caThi.gioThi) < 0) return -1;

        return maCaThi.compareTo(caThi.maCaThi);
    }

    @Override
    public String toString() {
        return maCaThi + " " + dateFormatter.format(ngayThi) + " " + timeFormatter.format(gioThi) + " " +
                phongThi;
    }
}
