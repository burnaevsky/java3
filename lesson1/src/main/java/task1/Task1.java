package task1;

public class Task1 {
    public static void swap(Object[] arr, int index1, int index2) {
        Object tempObj = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tempObj;
    }
}
