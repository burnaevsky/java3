package task3.fruits;

public class Orange extends Fruit{
    private static double weight = 1.5;

    public Orange() {
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Orange";
    }


}
