package ncc.contest;

import java.util.*;

public class DragonBall {
    static ArrayList<Integer> dske[];
    static boolean[] isEnough;
    static List<City> cities;
    static Map<Integer, Integer> relationships;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int q = scanner.nextInt();
        dske = new ArrayList[k + 1];
        isEnough = new boolean[k + 1];
        cities = new ArrayList<>();
        relationships = new HashMap<>();
        for (int i = 1; i <= k; i++) {
            dske[i] = new ArrayList<>();
            isEnough[i] = false;
        }
        cities.add(new City(new HashSet<>(), new HashSet<>()));
        for (int i = 0; i < k; i++) {
            HashSet<Integer> set = new HashSet<>();
            set.add(scanner.nextInt());
            cities.add(new City(new HashSet<>(), set));
        }
        for (int i = 0; i < k - 1; i++) {
            int first = scanner.nextInt();
            int second = scanner.nextInt();
            if( first < second){
                dske[first].add(second);
                relationships.put(second, first);
            }else {
                dske[second].add(first);
                relationships.put(first, second);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 2; i <= k; i++) {
            if( dske[i].isEmpty()){
                queue.add(i);
            }
        }
        traverseBFS(queue, q);
        // lay ket qua
        for (int i = 1; i <= k; i++) {
            if( isEnough[i]){
                System.out.print("1");
            }else {
                System.out.print("0");
            }
        }
        System.out.println();
    }

    private static void traverseBFS(Queue<Integer> queue, int q) {
        while (!queue.isEmpty()){
            try {
                int child = queue.poll();
                int dad = relationships.get(child);

                HashSet<Integer> childSet = cities.get(child).getDragonBalls();
                HashSet<Integer> dadSet = cities.get(dad).getDragonBalls();
                HashSet<Integer> childs = cities.get(dad).getChildCitys();
                childs.add(child);
                dadSet.addAll(childSet);
                if( dadSet.size() == q){
                    isEnough[dad] = true;
                }
                if( dad != 1 && childs.size() == dske[dad].size()){
                    queue.add(dad);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
//            System.out.println("dad: " + dad + ", dadSet: " + dadSet + " -------- child:" + child + ", childSet: "
//            + childSet);
//            System.out.println("dad: " + cities.get(dad).getDragonBalls().size() + ", child: " + cities.get(child).getDragonBalls().size());
        }
    }
}
class City{
    private HashSet<Integer> childCitys;
    private HashSet<Integer> dragonBalls;

    public City() {
    }

    public City(HashSet<Integer> childCitys, HashSet<Integer> dragonBalls) {
        this.childCitys = childCitys;
        this.dragonBalls = dragonBalls;
    }

    public HashSet<Integer> getChildCitys() {
        return childCitys;
    }

    public void setChildCitys(HashSet<Integer> childCitys) {
        this.childCitys = childCitys;
    }

    public HashSet<Integer> getDragonBalls() {
        return dragonBalls;
    }

    public void setDragonBalls(HashSet<Integer> dragonBalls) {
        this.dragonBalls = dragonBalls;
    }
}
/*
7 2
1 2 2 1 1 2 1
1 2
2 3
2 4
1 5
5 6
4 7
 */
