package huongdoituong.J05011_TinhGio;

public class GameThu implements Comparable{
    private String ma;
    private String hoTen;
    private String gioVao;
    private String gioRa;
    private long soPhut;

    public GameThu() {
    }

    public GameThu(String ma, String hoTen, String gioVao, String gioRa) {
        this.ma = ma;
        this.hoTen = hoTen;
        this.gioVao = gioVao;
        this.gioRa = gioRa;
        tinhSoPhut();
    }

    private void tinhSoPhut() {
        String[] vaoStr = gioVao.split(":");
        String[] raStr = gioRa.split(":");

        long vaoPhut = Long.parseLong(vaoStr[0]) * 60 + Long.parseLong(vaoStr[1]);
        long raPhut = Long.parseLong(raStr[0]) * 60 + Long.parseLong(raStr[1]);
//        System.out.println(vaoPhut + " ----------- " + raPhut);
        soPhut = raPhut - vaoPhut;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", ma, hoTen, ( soPhut/60 + " gio " + soPhut%60 + " phut" ) );
    }

    @Override
    public int compareTo(Object o) {
        GameThu gameThu = (GameThu) o;
        return (int) (gameThu.soPhut - soPhut);
    }
}
