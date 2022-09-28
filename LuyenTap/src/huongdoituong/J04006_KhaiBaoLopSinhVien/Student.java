package huongdoituong.J04006_KhaiBaoLopSinhVien;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Student {
    private String name;
    private float gpa;
    private String studentId;
    private String studentClass;
    private Date birthDay;

    public Student(String name, String studentClass, String birthDay , float gpa) throws ParseException {
        this.name = name;
        this.gpa = gpa;
        this.studentClass = studentClass;
        this.studentId = "B20DCCN001";
        this.birthDay = new SimpleDateFormat("dd/MM/yyyy").parse(birthDay);
    }

    @Override
    public String toString() {
        return studentId + " " +  name + " " + studentClass + " " +
                ( new SimpleDateFormat("dd/MM/yyyy").format(birthDay))
                + " " + String.format("%.2f", gpa);
    }
}
