package task2;

import java.util.ArrayList;
import java.util.Arrays;

public class Task2 {
    public static <T> ArrayList<T> convertToArrayList(T[] arr){
        return new ArrayList<T>(Arrays.asList(arr));
    }
}
