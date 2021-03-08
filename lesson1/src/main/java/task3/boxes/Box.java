package task3.boxes;

import task3.fruits.Fruit;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private double weight;
    private ArrayList<T> fruits;

    public Box() {
        this.fruits = new ArrayList<>();
    }

    public boolean addFruit(T fruit){
        if(fruits.contains(fruit)){
            System.out.println("The fruit is already in the box");
            return false;
        }
        this.fruits.add(fruit);
        this.weight += fruit.getWeight();
        return true;
    }

    public double getWeight(){
        return this.weight;
    }

    public boolean compareWeight(Box anotherBox){
        return Math.abs(this.getWeight() - anotherBox.getWeight()) < 0.0001;
    }

    public void pourOverFrom(Box<T> anotherBox){
        if(anotherBox == this){
            System.out.println("You can't pour over from this box");
            return;
        }
        this.fruits.addAll(anotherBox.fruits);
        anotherBox.fruits.clear();
    }

    @Override
    public String toString() {
        return "Box{" +
                "fruits=" + fruits +
                '}';
    }
}
