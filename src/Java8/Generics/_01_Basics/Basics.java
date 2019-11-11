package Java8.Generics._01_Basics;

import java.util.ArrayList;
import java.util.List;

public class Basics {
    public static void main(String[] args) {
        List castingRequiredList=new ArrayList();
        castingRequiredList.add("Hello");
        String s=(String) castingRequiredList.get(0); // Without casting it'll throw error

        List<String> castingNotRequiredList=new ArrayList<>();
        castingNotRequiredList.add("Hello");
        s=castingNotRequiredList.get(0);

    }
}
