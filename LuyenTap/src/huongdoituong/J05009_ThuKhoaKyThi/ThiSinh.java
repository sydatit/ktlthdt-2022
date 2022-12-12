package huongdoituong.J05009_ThuKhoaKyThi;

public class ThiSinh implements Comparable {
    private int ma;
    private String ten;
    private String ngaySinh;
    private float diem1;
    private float diem2;
    private float diem3;
    private float tongDiem;
    public ThiSinh(int ma, String ten, String ngaySinh, String diem1, String diem2, String diem3) {
        this.ma = ma;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.diem1 = Float.parseFloat(diem1);
        this.diem2 = Float.parseFloat(diem2);
        this.diem3 = Float.parseFloat(diem3);
        tongDiem = this.diem1 + this.diem2 + this.diem3;
    }

    public float getTongDiem() {
        return tongDiem;
    }

    @Override
    public String toString() {
        return String.format("%d %s %s %.1f", ma, ten, ngaySinh, tongDiem);
    }

    @Override
    public int compareTo(Object o) {
        ThiSinh thiSinh = (ThiSinh) o;
        if( tongDiem > thiSinh.tongDiem) return -1;
        if( tongDiem < thiSinh.tongDiem) return 1;
        if(  ma > thiSinh.ma ) return 1;
        if( ma < thiSinh.ma)
            return -1;
        return 0;
    }
}
