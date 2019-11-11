package Java8.Generics._06_Wildcards._04_WildcardAndSubtyping;

import java.util.ArrayList;
import java.util.List;

public class Subtyping {
    public static void main(String[] args) {
        List<? extends Integer> integers=new ArrayList<>();
        List<? extends Number> doubles=integers;
    }
}
