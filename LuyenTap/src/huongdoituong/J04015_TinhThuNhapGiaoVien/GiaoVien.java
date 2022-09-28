package huongdoituong.J04015_TinhThuNhapGiaoVien;

public class GiaoVien {
    private String maNgach;
    private String hoTen;
    private long luongCoBan;
    private int heSoBacLuong;
    private String chucVu;

    public GiaoVien(String maNgach, String hoTen, long luongCoBan) {
        this.maNgach = maNgach;
        this.hoTen = hoTen;
        this.luongCoBan = luongCoBan;
        this.heSoBacLuong = Integer.parseInt(maNgach.substring( maNgach.length()/2));
        this.chucVu = maNgach.substring(0, 2);
    }

    @Override
    public String toString() {
        long phuCap = 0;
        if( chucVu.equals("HT")){
            phuCap = 2000000;
        }else if( chucVu.equals("HP")){
            phuCap = 900000;
        }else phuCap = 500000;
        return maNgach + " " + hoTen + " " + heSoBacLuong + " " + phuCap + " " + (luongCoBan*heSoBacLuong + phuCap);
    }
}
