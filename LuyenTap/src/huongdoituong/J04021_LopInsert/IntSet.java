package huongdoituong.J04021_LopInsert;

import java.util.Iterator;
import java.util.TreeSet;

public class IntSet {
    private TreeSet<Integer> treeSet = new TreeSet<>();

    public IntSet(int[] array) {
        for (int item :array) {
            treeSet.add(item);
        }
    }
    public IntSet(TreeSet<Integer> input) {
        treeSet.addAll(input);
    }

    public IntSet union(IntSet otherInset){
        TreeSet<Integer> myTreeSet = new TreeSet<>();
        myTreeSet.addAll(treeSet);
        myTreeSet.addAll(otherInset.treeSet);

        return new IntSet(myTreeSet );
    }

    @Override
    public String toString() {
        StringBuilder outputString = new StringBuilder();
        treeSet.forEach( item -> outputString.append(item).append(" "));
        return outputString.toString().trim();
    }
}
