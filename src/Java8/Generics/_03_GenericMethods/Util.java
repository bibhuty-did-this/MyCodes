package Java8.Generics._03_GenericMethods;

import Java8.Generics._02_GenericClasses._02_MultipleTypeParameter.OrderedPair;
import Java8.Generics._02_GenericClasses._02_MultipleTypeParameter.Pair;

public class Util {
    public static <K,V> boolean compare(Pair<K,V> pair1,Pair<K,V> pair2){
        return pair1.getKey().equals(pair2.getKey()) && pair1.getValue().equals(pair2.getValue());
    }

    public static void main(String[] args) {
        Pair<Integer, String> p1 = new OrderedPair<>(1, "apple");
        Pair<Integer, String> p2 = new OrderedPair<>(2, "pear");
        boolean same = Util.compare(p1, p2);
        System.out.println(same);
    }
}
