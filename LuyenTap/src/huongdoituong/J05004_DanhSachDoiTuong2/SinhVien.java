package huongdoituong.J05004_DanhSachDoiTuong2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

public class SinhVien {
    private String msv;
    private String hoTen;
    private Date ngaySinh;
    private String lop;
    private float gpa;
    private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    public SinhVien() {
        msv = hoTen = lop = "";
        ngaySinh = new Date();
        gpa = 0;
    }

    public SinhVien(int msv, String hoTen, String lop, String ngaySinh, String gpa) throws ParseException {
        this.msv = String.format("B20DCCN%03d", msv);
        this.hoTen = chuanHoa(hoTen);
        this.lop = lop;
        this.ngaySinh = format.parse(ngaySinh);
        this.gpa = Float.parseFloat(gpa);
    }

    private String chuanHoa(String hoTen) {
        StringBuilder sb = new StringBuilder();
        StringTokenizer tokenizer = new StringTokenizer(hoTen);
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
        return String.format("%s %s %s %s %.2f", msv, hoTen, lop, format.format(ngaySinh), gpa);
    }
}
