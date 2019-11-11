package Java8.Generics._02_GenericClasses._01_SingleTypeParameter;

public class Box<T> { // Type parameter
    private T box;

    public T getBox() {
        return box;
    }

    public void setBox(T box) {
        this.box = box;
    }

    public static void main(String[] args) {
        Box<Integer> box=new Box<>();// Type argument
        box.setBox(new Integer(10));
        System.out.println(box.getBox());
    }
}
