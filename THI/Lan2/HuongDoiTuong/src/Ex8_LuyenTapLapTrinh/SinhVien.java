package Ex8_LuyenTapLapTrinh;

public class SinhVien implements Comparable{
    private String hoTen;
    private long soBaiDung;
    private long soSubmit;

    public SinhVien(String hoTen, String soBaiDung, String soSubmit) {
        this.hoTen = hoTen;
        this.soBaiDung = Long.parseLong(soBaiDung);
        this.soSubmit = Long.parseLong(soSubmit);
    }

    @Override
    public int compareTo(Object o) {
        SinhVien sinhVien = (SinhVien) o;
        if( soBaiDung > sinhVien.soBaiDung) return -1;
        if( soBaiDung < sinhVien.soBaiDung) return 1;

        if( soSubmit > sinhVien.soSubmit) return 1;
        if( soSubmit < sinhVien.soSubmit) return -1;

        return hoTen.compareTo(sinhVien.hoTen);
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", hoTen, soBaiDung, soSubmit);
    }
}
