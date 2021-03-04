package task3.fruits;

public abstract class Fruit {
    private double weight;

    public Fruit() {
    }

    public abstract double getWeight();

    @Override
    public abstract String toString();
}
