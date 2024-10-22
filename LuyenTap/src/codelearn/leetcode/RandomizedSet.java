package codelearn.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class RandomizedSet {
    public static void main(String[] args) {
        RandomizedSet r = new RandomizedSet();
        System.out.println(r.insert(1));
        System.out.println(r.remove(2));
        System.out.println(r.insert(2));
        System.out.println(r.getRandom());
        System.out.println(r.remove(1));
        System.out.println(r.insert(2));
        System.out.println(r.getRandom());
    }
    private List<Integer> list;
    private Map<Integer, Integer> map;
    private Random random;
    public RandomizedSet() {
        list = new LinkedList<>();
        map = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            map.put(val, list.size());
            list.add(val);
            return true;
        }
        return false;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val))
            return false;
        int i = map.get(val);
        int lastIndex = list.get(val) - 1;
        if ( i != lastIndex) {
            list.set(i, list.get(lastIndex));
            map.put(list.get(lastIndex), i);
        }

        map.remove(val);
        list.remove(lastIndex);
        return true;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
