package collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CollectionsTask1 {
    public static void main(String[] args) {
        ArrayList<Character> arr = new ArrayList<>();
        arr.add('a');
        arr.add('A');
        arr.add('5');
        arr.add('Z');
        arr.forEach(ele -> System.out.println(ele));

        Set<Integer> set = new HashSet<>();
        Iterator<Character> itr = arr.iterator();
        while (itr.hasNext()) {
            set.add(itr.next());
        }
    }
}
