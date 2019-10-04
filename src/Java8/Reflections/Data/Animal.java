package Java8.Reflections.Data;

import java.util.Objects;

public class Animal implements DetailedInfo,EmptyInterface{

    private boolean vegetarian;

    private String eats;

    private int noOfLegs;

    public Animal(){}

    public Animal(boolean veg, String food, int legs){
        this.vegetarian = veg;
        this.eats = food;
        this.noOfLegs = legs;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public String getEats() {
        return eats;
    }

    public void setEats(String eats) {
        this.eats = eats;
    }

    public int getNoOfLegs() {
        return noOfLegs;
    }

    public void setNoOfLegs(int noOfLegs) {
        this.noOfLegs = noOfLegs;
    }

    @Override
    public void printDetails(){
        System.out.println(this.toString());
    }

    @Override
    public String toString(){
        return "Animal{" +
                "vegetarian=" + vegetarian +
                ", eats='" + eats + '\'' +
                ", noOfLegs=" + noOfLegs +
                '}';
    }

    @Override
    public boolean equals(Object o){

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return vegetarian == animal.vegetarian &&
                noOfLegs == animal.noOfLegs &&
                Objects.equals(eats, animal.eats);
    }

    @Override
    public int hashCode(){
        return Objects.hash(vegetarian, eats, noOfLegs);
    }
}
