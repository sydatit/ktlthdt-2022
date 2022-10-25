package huongdoituong.J07054_TinhDiemTrungBinh;

import java.util.StringTokenizer;

public class SinhVien implements Comparable{
    private String msv;
    private String hoTen;
    private float diemTB;
    private int xepHang;
    private int mon1;
    private int mon2;
    private int mon3;

    public SinhVien(int msv, String hoTen, String mon1, String mon2, String mon3) {
        this.msv = String.format("SV%02d", msv);
        this.hoTen = chuanHoaHoTen(hoTen);
        this.mon1 = Integer.parseInt(mon1);
        this.mon2 = Integer.parseInt(mon2);
        this.mon3 = Integer.parseInt(mon3);
        tinhDiemTrungBinh();
    }

    public void setXepHang(int xepHang) {
        this.xepHang = xepHang;
    }

    public float getDiemTB() {
        return diemTB;
    }

    private void tinhDiemTrungBinh() {
        diemTB = ( mon1 + mon2 + mon3) / 3f;
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
        return String.format("%s %s %.2f %d", msv, hoTen, diemTB, xepHang);
    }

    @Override
    public int compareTo(Object o) {
        SinhVien sinhVien = (SinhVien) o;
        if( diemTB > sinhVien.diemTB) return -1;
        if( diemTB < sinhVien.diemTB) return 1;

        return msv.compareTo(sinhVien.msv);
    }
}
