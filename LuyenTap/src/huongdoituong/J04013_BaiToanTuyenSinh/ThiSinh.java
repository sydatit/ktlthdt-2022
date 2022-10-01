package huongdoituong.J04013_BaiToanTuyenSinh;

public class ThiSinh {
    private String maThiSinh;
    private String hoVaTen;
    private float diemToan;
    private float diemLy;
    private float diemHoa;
    private String maKhuVuc;
    private float diemUuTien;
    private String trangThai;

    public ThiSinh(String maThiSinh, String hoVaTen, String diemToan, String diemLy, String diemHoa) {
        this.maThiSinh = maThiSinh;
        this.hoVaTen = hoVaTen;
        this.diemToan = Float.parseFloat(diemToan);
        this.diemLy = Float.parseFloat(diemLy);
        this.diemHoa = Float.parseFloat(diemHoa);
        maKhuVuc = maThiSinh.substring(0, 3);
        if( maKhuVuc.equals("KV1")){
            diemUuTien = 0.5f;
        }else if( maKhuVuc.equals("KV2")){
            diemUuTien = 1;
        }else diemUuTien = 2.5f;

    }
    private float getTongDiem(){
        return diemToan * 2 + diemLy + diemHoa + diemUuTien;
    }

    public void setTrangThai(float diemChuan) {
        if( diemChuan > getTongDiem())
            this.trangThai = "TRUOT";
        else this.trangThai = "TRUNG TUYEN";
    }

    @Override
    public String toString() {
        String diemUTStr = ((diemUuTien - (int) diemUuTien) != 0 ? String.format("%.1f", diemUuTien) :
                String.format("%d", (int)diemUuTien));
        float tongD = getTongDiem() - diemUuTien;
        String tDiemStr = ((tongD - (int) tongD) != 0 ? String.format("%.1f", tongD) :
                "" +String.format("%.0f", tongD) );
        return maThiSinh + " " + hoVaTen + " " + diemUTStr + " " + tDiemStr + " " + trangThai;
    }
}
