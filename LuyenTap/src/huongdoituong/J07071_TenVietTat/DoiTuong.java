package huongdoituong.J07071_TenVietTat;

public class DoiTuong implements Comparable{
    private String hoVaTen;
    private String ho;
    private String ten;
    private String tenVietTat;

    public DoiTuong(String hoVaTen) {
        this.hoVaTen = hoVaTen.trim();
        tinhToan();
    }

    private void tinhToan() {
        String[] tu = hoVaTen.split(" ");
        this.ho = tu[0];
        this.ten = tu[tu.length - 1];
        this.tenVietTat = "";
        for (String item: tu) {
            if( item.length() > 0){
                tenVietTat += Character.toUpperCase(item.charAt(0));
            }
        }
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTenVietTat() {
        return tenVietTat;
    }

    public void setTenVietTat(String tenVietTat) {
        this.tenVietTat = tenVietTat;
    }

    @Override
    public String toString() {
        return hoVaTen;
    }

    @Override
    public int compareTo(Object o) {
        DoiTuong doiTuong = (DoiTuong) o;
        if( ten.compareTo(doiTuong.ten) > 0) return 1;
        if( ten.compareTo(doiTuong.ten) < 0) return -1;

        return ho.compareTo(doiTuong.ho);
    }
}
