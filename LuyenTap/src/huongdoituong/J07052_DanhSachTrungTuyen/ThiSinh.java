package huongdoituong.J07052_DanhSachTrungTuyen;

import java.util.StringTokenizer;

public class ThiSinh implements Comparable{
    private String maThiSinh;
    private String hoTen;
    private float diemToan;
    private float diemLy;
    private float diemHoa;
    private String trangThai;

    public ThiSinh(String maThiSinh, String hoTen, String diemToan, String diemLy, String diemHoa) {
        this.maThiSinh = maThiSinh;
        this.hoTen = chuanHoaHoTen(hoTen);
        this.diemToan = Float.parseFloat(diemToan);
        this.diemLy = Float.parseFloat(diemLy);
        this.diemHoa = Float.parseFloat(diemHoa);
    }
    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    public float getTongDiem(){
        return diemToan * 2 + diemLy + diemHoa + getDiemUuTien() ;
    }
    public String getMaKhuVuc(){
        return maThiSinh.substring(0, 3);
    }
    private String chuanHoaHoTen( String hoTen){
        StringBuilder stringBuilder = new StringBuilder();
        StringTokenizer tokenizer = new StringTokenizer(hoTen);
        while (tokenizer.hasMoreTokens()){
            String word = tokenizer.nextToken();
            stringBuilder.append(Character.toUpperCase(word.charAt(0)));
            for (int i = 1; i < word.length(); i++) {
                stringBuilder.append(Character.toLowerCase(word.charAt(i)));
            }
            stringBuilder.append(" ");
        }
        return stringBuilder.toString().trim();
    }
    private float getDiemUuTien(){
        String maKhuVuc = getMaKhuVuc();
        float diemCong = 0;
        if( maKhuVuc.equals("KV1")){
            diemCong = 0.5f;
        }else if( maKhuVuc.equals("KV2")){
            diemCong = 1.0f;
        }else {
            diemCong = 2.5f;
        }
        return diemCong;
    }

    @Override
    public String toString() {
        return maThiSinh + " " + hoTen + " " + getDiemUuTien() +
                " " + getTongDiem() + " " + trangThai;
    }

    @Override
    public int compareTo(Object o) {
        if( o instanceof ThiSinh){
            ThiSinh thiSinh = (ThiSinh) o;
            if( getTongDiem() < thiSinh.getTongDiem()) return 1;
            if( getTongDiem() > thiSinh.getTongDiem()) return -1;

            return maThiSinh.compareTo(thiSinh.maThiSinh);
        }
        return 1;
    }
}
