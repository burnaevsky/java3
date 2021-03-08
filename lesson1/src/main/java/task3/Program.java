package task3;

import task3.boxes.Box;
import task3.fruits.Apple;
import task3.fruits.Orange;

public class Program {
    public static void main(String[] args) {
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Orange orange1 = new Orange();
        Orange orange2 = new Orange();
        Orange orange3 = new Orange();

        Box<Apple> appleBox = new Box<>();
        appleBox.addFruit(apple1);
        appleBox.addFruit(apple2);

        Box<Orange> orangeBox = new Box<>();
        orangeBox.addFruit(orange1);
        orangeBox.addFruit(orange2);

        Box<Orange> anotherOrangeBox = new Box<>();
        anotherOrangeBox.addFruit(orange3);

        orangeBox.pourOverFrom(anotherOrangeBox);
        System.out.println(orangeBox);
        System.out.println("----");
        System.out.println(anotherOrangeBox);

    }
}
