package Java8.Generics._05_TypeInference;


import java.util.ArrayList;
import java.util.List;

public class BoxDemo {
    public static <U> void addBox(U box, List<Box<U>> boxes){
        Box<U> newBox=new Box<>();
        newBox.setBox(box);
        boxes.add(newBox);
    }

    public static <U> void outputBoxes(List<Box<U>> boxes){
        int counter=0;
        for (Box<U> box : boxes) {
            U boxContents = box.getBox();
            System.out.println("Box #" + counter + " contains [" +
                    boxContents.toString() + "]");
            counter++;
        }
    }

    public static void main(String[] args) {
        List<Box<Integer>> boxes=new ArrayList<>();
        addBox(10,boxes);
        addBox(30,boxes);
        addBox(20,boxes);
        Box box=new Box(15);
        boxes.add(box);
        outputBoxes(boxes);
    }
}
