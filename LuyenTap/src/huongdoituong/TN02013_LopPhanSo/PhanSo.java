package huongdoituong.TN02013_LopPhanSo;

import java.math.BigInteger;

public class PhanSo {
    private long tuSo;
    private long mauSo;

    public PhanSo(String lineNumber) {
        String[] strings = lineNumber.split(" ");
        tuSo = Integer.parseInt(strings[0]);
        mauSo = Integer.parseInt(strings[1]);
    }
    PhanSo cong(PhanSo phanSo){
        long tuSoM = tuSo * phanSo.mauSo + mauSo * phanSo.tuSo;
        long mauSoM = mauSo * phanSo.mauSo;
        PhanSo res = new PhanSo(tuSoM + " " + mauSoM);
        return rutGon( res);
    }
    PhanSo nhan(PhanSo phanSo){
        long tuSoM = tuSo * phanSo.tuSo;
        long mauSoM = mauSo * phanSo.mauSo;
        PhanSo res = new PhanSo(tuSoM + " " + mauSoM);
        return rutGon( res);
    }
    private PhanSo rutGon(PhanSo phanSo){
        long ucln = ucln( phanSo.tuSo, phanSo.mauSo);
        ucln = ucln == 0? 1: ucln;
        return new PhanSo(phanSo.tuSo/ucln + " " + phanSo.mauSo/ucln);
    }
    private long ucln(long soA, long soB){
        BigInteger bigInteger = new BigInteger(soA + "");
        BigInteger otherBigInteger = new BigInteger(soB + "");
        return bigInteger.gcd(otherBigInteger).intValue();
    }

    @Override
    public String toString() {
        if( tuSo != 0 && mauSo < 0){
            tuSo = -tuSo;
            mauSo = -mauSo;
        }
        return tuSo +"/" + mauSo ;
    }
}
