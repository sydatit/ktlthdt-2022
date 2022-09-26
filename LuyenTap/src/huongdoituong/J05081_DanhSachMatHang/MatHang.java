package huongdoituong.J05081_DanhSachMatHang;

public class MatHang implements Comparable{
    private String maMatHang;
    private String tenMatHang;
    private String donViTinh;
    private long giaMua;
    private long giaBan;
    private long loiNhuan;

    public MatHang(int n, String tenMatHang, String donViTinh, long giaMua, long giaBan) {
        this.maMatHang = String.format("MH%03d", n);
        this.tenMatHang = tenMatHang;
        this.donViTinh = donViTinh;
        this.giaMua = giaMua;
        this.giaBan = giaBan;
        loiNhuan = giaBan - giaMua;
    }

    public long getLoiNhuan() {
        return loiNhuan;
    }
    public String getMaMatHang() {
        return maMatHang;
    }

    @Override
    public int compareTo(Object o) {
        if( o instanceof MatHang ){
            MatHang matHang = (MatHang) o;
            if( this.loiNhuan > matHang.getLoiNhuan()) return 1;
            if( this.loiNhuan < matHang.getLoiNhuan()) return -1;

            return  maMatHang.compareTo(matHang.getMaMatHang());
        }
        return 0;
    }
}
