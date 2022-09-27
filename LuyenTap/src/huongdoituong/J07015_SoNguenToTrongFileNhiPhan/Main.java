package huongdoituong.J07015_SoNguenToTrongFileNhiPhan;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        OutputStream outputStream = new FileOutputStream("src/huongdoituong/J07015_SoNguenToTrongFileNhiPhan/SONGUYEN.in");
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
//        ArrayList<Integer> listInt = new ArrayList<>();
//        listInt.addAll(
//                Arrays.asList(
//                        Integer.valueOf("2"),
//                        Integer.valueOf("3"),
//                        Integer.valueOf("2"),
//                        Integer.valueOf("7"),
//                        Integer.valueOf("7"),
//                        Integer.valueOf("8"),
//                        Integer.valueOf("4"),
//                        Integer.valueOf("5"),
//                        Integer.valueOf("3")
//                )
//        );
//        objectOutputStream.writeObject(listInt);
//        objectOutputStream.flush();
        InputStream inputStream = new FileInputStream("SONGUYEN.in");
        ObjectInputStream ois = new ObjectInputStream(inputStream);


        ArrayList<Integer> list = (ArrayList<Integer>) ois.readObject();
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < list.size(); i++) {
            Integer item = list.get(i);
            if( isPrime(item)){
                if( treeMap.containsKey(item)){
                    int oldValue = treeMap.get(item);
                    treeMap.put(item, ++oldValue);
                }else {
                    treeMap.put(item, 1);
                }
            }
        }
        treeMap.forEach(( k, v) -> System.out.println(k + " " + v));

    }

    private static boolean isPrime(Integer item) {
        if( item < 2) return false;
        if( item == 2 || item == 3) return true;
        for (int i = 2; i <= Math.sqrt(item); i++) {
            if( item % i == 0)
                return false;
        }
        return true;
    }

}
