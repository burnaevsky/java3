package task3.fruits;

import task3.fruits.Fruit;

public class Apple extends Fruit {
    private static double weight = 1;

    public Apple() {
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Apple";
    }
}
