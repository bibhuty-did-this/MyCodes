package Java8.Generics._06_Wildcards._05_WildcardCaptures;

import java.util.Arrays;
import java.util.List;

public class WildcardError {
    void errorFunction(List<?> list){
        // The compiler process `list` parameter as an object
        // list.set(0,list.get(0));

        // This will work
        listHelper(list);
    }

    private <T> void listHelper(List<T> list) {
        list.set(0,list.get(0));
    }
    static void swapFirst(List<? extends Number> l1, List<? extends Number> l2) {
        // This code is fundamentally wrong so there's no helper method
        // workaround here
        Number temp = l1.get(0);
        /*l1.set(0, l2.get(0));
        l2.set(0, temp);*/
    }

    public static void main(String[] args) {
        List<Integer> li = Arrays.asList(1, 2, 3);
        List<Double>  ld = Arrays.asList(10.10, 20.20, 30.30);
        swapFirst(li, ld);
    }
}
