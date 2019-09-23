package Java.enums;

public class OuncesEnumApplication {
    public static void main(String[] args) {
        Sizes sizes[]=Sizes.values();
        for(Sizes size:sizes){
            System.out.println(size.getName()+"-"+size.getValue());
        }
    }
}

enum Sizes{
    SMALL("SMALL",4),
    MEDIUM("MEDIUM",8),
    LARGE("LARGE",12);

    private String name;
    private int value;
    Sizes(String name, int value) {
        this.name=name;
        this.value=value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}