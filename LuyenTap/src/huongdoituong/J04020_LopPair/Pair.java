package huongdoituong.J04020_LopPair;

public class Pair<U, T> {
//    private static int[] nguyenToN = new int[1000000];
//    {
//
//    }
    private Integer firstNum;
    private Integer secondNum;

    public Pair(Integer firstNum, Integer secondNum) {
        this.firstNum = firstNum;
        this.secondNum = secondNum;
    }
    private boolean xetNT(Integer number){
        if( number < 2) return false;
        for (int i = 2; i <= Math.sqrt(number) ; i++) {
            if( number%i == 0) return false;
        }
        return true;
    }
    public boolean isPrime(){
        if( xetNT(firstNum) && xetNT(secondNum))
            return true;
        else return false;
    }

    @Override
    public String toString() {
        return firstNum +  " " + secondNum;
    }
}
