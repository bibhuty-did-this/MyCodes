package Java8.Generics._04_BoundedTypeParameters;


import org.jetbrains.annotations.NotNull;

public class Box<T extends Double> implements Comparable<Box<T>>{
    T box;

    public T getBox() {
        return box;
    }

    public void setBox(T box) {
        this.box = box;
    }


    @Override
    public int compareTo(@NotNull Box<T> o) {
        return this.box.compareTo(o.box);
    }

    public <U extends Number> void inspect(U u){
        System.out.println("T: "+box.getClass().getSimpleName());
        System.out.println("U: "+u.getClass().getSimpleName());
    }



    public static <T extends Comparable<T>> int countGreaterThan(T[] anArray,T elem){
        int count=0;

        for(T e:anArray){
            if(e.compareTo(elem)>0){
                ++count;
            }
        }


        return count;
    }

    public static void main(String[] args) {
        Box<Double> doubleBox = new Box();
        doubleBox.setBox(10d);
        doubleBox.inspect(11);
        Box<Double>[] doubleBoxes=new Box[10];
        for(int i=0;i<10;++i){
            doubleBoxes[i]=new Box<>();
            doubleBoxes[i].setBox(i*9d);
            System.out.println(i*9d);
        }
        System.out.println(countGreaterThan(doubleBoxes,doubleBox));
    }

}