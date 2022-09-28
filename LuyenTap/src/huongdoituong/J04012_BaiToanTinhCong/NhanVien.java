package huongdoituong.J04012_BaiToanTinhCong;

public class NhanVien {
    private String maNhanVien;
    private String hoTen;
    private long luongCoBanNgay;
    private int soNgayCong;
    private String chucVu;
    private long tienLuong;
    private long thuong;
    private long phuCap;

    public NhanVien(int n, String hoTen, String luongCoBanNgay, String soNgayCong, String chucVu) {
        this.maNhanVien = String.format("NV%02d", n);
        this.hoTen = hoTen;
        this.luongCoBanNgay = Long.parseLong(luongCoBanNgay);
        this.soNgayCong = Integer.parseInt(soNgayCong);
        this.chucVu = chucVu;
        this.tienLuong = this.luongCoBanNgay* this.soNgayCong;
        // tien thuong
        if( this.soNgayCong >= 25) thuong = (long) (this.tienLuong * 0.2);
        else if( this.soNgayCong >= 22 && this.soNgayCong < 25) thuong = (long) (this.tienLuong * 0.1);
        else thuong = 0;
        // phu cap
        if( this.chucVu.equals("PGD"))
            phuCap = 200000;
        else if( this.chucVu.equals("GD"))
            phuCap = 250000;
        else if( this.chucVu.equals("TP"))
            phuCap = 180000;
        else phuCap = 150000;
    }

    @Override
    public String toString() {
        return String.format("%s %s %d %d %d %d", maNhanVien, hoTen, tienLuong, thuong, phuCap,
                ( tienLuong + thuong + phuCap) );
    }
}
