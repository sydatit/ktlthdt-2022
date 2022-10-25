package huongdoituong.J07052_DanhSachTrungTuyen;

import java.util.StringTokenizer;

public class ThiSinh implements Comparable{
    private String maThiSinh;
    private String hoTen;
    private float diemToan;
    private float diemLy;
    private float diemHoa;
    private String trangThai;
    private String maKV;
    private float diemUT;

    public ThiSinh(String maThiSinh, String hoTen, String diemToan, String diemLy, String diemHoa) {
        this.maThiSinh = maThiSinh;
        this.hoTen = chuanHoaHoTen(hoTen);
        this.diemToan = Float.parseFloat(diemToan);
        this.diemLy = Float.parseFloat(diemLy);
        this.diemHoa = Float.parseFloat(diemHoa);
        this.maKV = maThiSinh.substring(0, 3);

        if( maKV.equals("KV1")){
            diemUT = 0.5f;
        }else if( maKV.equals("KV2")){
            diemUT = 1.0f;
        }else {
            diemUT = 2.5f;
        }
    }
    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    public float getTongDiem(){
        return diemToan * 2 + diemLy + diemHoa + diemUT ;
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

    @Override
    public String toString() {
        String diemUTStr = ((diemUT - (int) diemUT)!= 0 ? Float.toString(diemUT) : Integer.toString((int) diemUT));
        float tongDiem = getTongDiem();
        String tongDiemStr= ((tongDiem - (int)tongDiem)!= 0 ? Float.toString(tongDiem) : Integer.toString((int) tongDiem));

        return maThiSinh + " " + hoTen + " " + diemUTStr +
                " " + tongDiemStr + " " + trangThai;
    }

    @Override
    public int compareTo(Object o) {
        ThiSinh thiSinh = (ThiSinh) o;
        if( getTongDiem() < thiSinh.getTongDiem()) return 1;
        if( getTongDiem() > thiSinh.getTongDiem()) return -1;

        return maThiSinh.compareTo(thiSinh.maThiSinh);
    }
}
