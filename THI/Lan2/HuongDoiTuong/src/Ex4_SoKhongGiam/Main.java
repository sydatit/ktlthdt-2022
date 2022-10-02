package Ex4_SoKhongGiam;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        ObjectOutputStream oos1 = new Obj

        ObjectInputStream oIS1 = new ObjectInputStream( new FileInputStream("DATA1.in"));
        ObjectInputStream oIS2 = new ObjectInputStream( new FileInputStream("DATA2.in"));
        ArrayList<Integer> listInput1 = (ArrayList<Integer>) oIS1.readObject();
        ArrayList<Integer> listInput2 = (ArrayList<Integer>) oIS2.readObject();
        solveProblem( listInput1, listInput2);
    }

    private static void solveProblem(ArrayList<Integer> listInput1, ArrayList<Integer> listInput2) {
        HashMap<Integer, Integer> resData1 = new HashMap<>();
        HashMap<Integer, Integer> resData2 = new HashMap<>();
        // Data 1 filter
        listInput1.forEach( integer -> {
            if(khongGiam(integer +"")){
                if( resData1.containsKey(integer)){
                    int oldValue = resData1.get(integer);
                    resData1.put(integer, ++oldValue);
                }else resData1.put( integer, 1);
            }
        });
        // Data 2 filter
        listInput2.forEach( integer -> {
            if(khongGiam(integer +"")){
                if( resData2.containsKey(integer)){
                    int oldValue = resData2.get(integer);
                    resData2.put(integer, ++oldValue);
                }else resData2.put( integer, 1);
            }
        });
        // Output
        TreeSet<Integer> outputSet = new TreeSet<>();
        outputSet.addAll( resData1.keySet());
        outputSet.addAll( resData2.keySet());
        outputSet.forEach( integer -> {
            System.out.printf(integer + " ");
            int res1 = resData1.containsKey(integer) ?  resData1.get(integer) : 0;
            int res2 = resData2.containsKey(integer) ?  resData2.get(integer)  : 0;
            System.out.printf("%d %d \n", res1, res2);
        });

    }
    private static boolean khongGiam(String number){
        if( number.length() < 2) return false;
        for (int i = 0; i < number.length() -1; i++) {
            if( number.charAt(i) > number.charAt(i + 1))
                return false;
        }
        return true;
    }
}
