package huongdoituong.J04003_PhanSo;

import java.math.BigInteger;

public class PhanSo {
    private String tuSo;
    private String mauSo;

    public PhanSo(String tuSo, String mauSo) {
        this.tuSo = tuSo;
        this.mauSo = mauSo;
    }
    public String toiGian(){
        BigInteger bigIntegerTuSo = new BigInteger(tuSo);
        BigInteger bigIntegerMauSo = new BigInteger(mauSo);
        BigInteger gcd = bigIntegerTuSo.gcd(bigIntegerMauSo);
        BigInteger tuSoToiGian = bigIntegerTuSo.divide(gcd);
        BigInteger mauSoToiGian = bigIntegerMauSo.divide(gcd);
        return tuSoToiGian +  "/" + mauSoToiGian;
    }
}
