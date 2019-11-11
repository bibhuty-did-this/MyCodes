package Java8.Generics._02_GenericClasses._02_MultipleTypeParameter;

import Java8.Generics._02_GenericClasses._01_SingleTypeParameter.Box;

public class OrderedPair<K,V> implements Pair<K,V> {
    private K key;
    private V value;

    public OrderedPair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    public static void main(String[] args) {
        OrderedPair<String, Box<Integer>> parameterizedtypes = new OrderedPair<>("primes", new Box());
        OrderedPair<String, String>  p0 = new OrderedPair<>("hello", "world");
        Pair<String, Integer> p1 = new OrderedPair<>("Even", 8);

    }
}
