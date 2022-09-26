package huongdoituong.J04005_KhaiBaoLopSinhVien;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Student {
    private String name;
    private float mark1, mark2, mark3, totalMark;
    private Date birthDay;

    public Student(String name, String birthDay , float mark1, float mark2, float mark3) throws ParseException {
        this.name = name;
        this.mark1 = mark1;
        this.mark2 = mark2;
        this.mark3 = mark3;
        this.totalMark = mark1 + mark2 + mark3;
        this.birthDay = new SimpleDateFormat("dd/MM/yyyy").parse(birthDay);
    }

    @Override
    public String toString() {
        return name + " " + ( new SimpleDateFormat("dd/MM/yyyy").format(birthDay)) + " " + totalMark;
    }
}
