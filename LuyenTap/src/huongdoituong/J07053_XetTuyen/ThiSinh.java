package huongdoituong.J07053_XetTuyen;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.StringTokenizer;

public class ThiSinh {
    private String maThiTuyen;
    private String hoTen;
    private int namSinh;
    private float diemLT;
    private float diemTH;
    private int tuoi;
    private int diemTB;
    private String xepLoai;
    private float diemThuong;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public ThiSinh(int n, String hoTen, String ngaySinh, String diemLT, String diemTH) {
        this.maThiTuyen = String.format("PH%02d", n);
        this.hoTen = chuanHoaHT(hoTen);
        this.namSinh = Integer.parseInt( ngaySinh.substring( ngaySinh.lastIndexOf("/") + 1));
        this.diemLT = Float.parseFloat(diemLT);
        this.diemTH = Float.parseFloat(diemTH);

        // compute parameter
        LocalDate now = LocalDate.now();
        tuoi = now.getYear() - this.namSinh - 1;

        if( this.diemLT >= 8 && this.diemTH >= 8){
            diemThuong = 1;
        }
        diemThuong += this.diemLT >= 7.5f && this.diemTH >= 7.5f ? 0.5f : 0;
        float tongDiem = this.diemLT + this.diemTH + diemThuong;
        tongDiem = tongDiem > 20 ? 20 : tongDiem;

//        System.out.println("" + (this.diemLT + this.diemTH + diemThuong));
        diemTB = Math.round( tongDiem /2f);

        tinhXepLoai();

    }

    private void tinhXepLoai() {
        switch (diemTB){
            case 5:
            case 6:
                xepLoai = "Trung binh";
                break;
            case 7:
                xepLoai = "Kha"; break;
            case 8:
                xepLoai = "Gioi"; break;
            case 9:
            case 10:
                xepLoai = "Xuat sac"; break;
            default:
                xepLoai = "Truot";
        }
    }

    private String chuanHoaHT( String input){
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

    @Override
    public String toString() {
        return String.format("%s %s %d %d %s", maThiTuyen, hoTen, tuoi, diemTB, xepLoai);
    }
}
