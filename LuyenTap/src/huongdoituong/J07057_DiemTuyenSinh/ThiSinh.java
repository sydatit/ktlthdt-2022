package huongdoituong.J07057_DiemTuyenSinh;

import java.util.StringTokenizer;

public class ThiSinh implements Comparable{
    private String maThiSinh;
    private String hoTenChuanHoa;
    private float diemThi;
    private String danToc;
    private int khuVuc;
    private String trangThai;

    public ThiSinh(int maThiSinh, String hoTenChuanHoa, String diemThi, String danToc, String khuVuc) {
        this.maThiSinh = String.format("TS%02d",maThiSinh);
        this.hoTenChuanHoa = formatName(hoTenChuanHoa);
        this.diemThi = Float.parseFloat(diemThi);
        this.danToc = danToc;
        this.khuVuc = Integer.parseInt(khuVuc);
    }
    private String formatName(String input){
        StringBuilder sb = new StringBuilder();
        StringTokenizer tokenizer = new StringTokenizer(input);
        while (tokenizer.hasMoreTokens()){
            String word = tokenizer.nextToken();
            sb.append(Character.toUpperCase(word.charAt(0)));
            for (int i = 1; i < word.length(); i++) {
                sb.append(Character.toLowerCase(word.charAt(i)));
            }
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    public void setTrangThai(float diemChuan) {
        if( diemChuan > getTongDiem()) trangThai = "Truot";
        else trangThai = "Do";
    }

    public float getTongDiem(){
        float diemKV = 0;
        switch (khuVuc){
            case 1: diemKV = 1.5f;
            break;
            case 2: diemKV = 1f;
            break;
            default: diemKV = 0;
        }
        return diemThi + diemKV + (!danToc.equals("Kinh") ? 1.5f: 0);
    }

    @Override
    public String toString() {
        float tongD = getTongDiem();
        return maThiSinh + " " + hoTenChuanHoa + " " +
                String.format("%.1f", tongD ) + " "
                + trangThai;
    }

    @Override
    public int compareTo(Object o) {
        if( o instanceof ThiSinh){
            ThiSinh thiSinh = (ThiSinh) o;
            if( getTongDiem() < thiSinh.getTongDiem()) return 1;
            if( getTongDiem() > thiSinh.getTongDiem()) return -1;

            return maThiSinh.compareTo(thiSinh.maThiSinh);
        }
        return 0;
    }
}
