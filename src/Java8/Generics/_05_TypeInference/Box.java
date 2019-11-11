package Java8.Generics._05_TypeInference;

public class Box<T> {
    T box;

    Box(T box){
        this.box=box;
    }

    public Box() {

    }

    public T getBox() {
        return box;
    }

    public void setBox(T box) {
        this.box = box;
    }
}
