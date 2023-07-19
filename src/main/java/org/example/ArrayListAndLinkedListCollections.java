package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ArrayListAndLinkedListCollections {
    public static void main(String[] args) {

        var arr = new ArrayList<Integer>(Arrays.asList(-1,-2,3,5,7,9));
        var averages = getRollingAverage(arr, 2);
        System.out.println("Source array : " + arr);
        System.out.println("Averages of subarrays averages of length " + 2 + ": " + averages);
        averages = getRollingAverage(arr, 3);
        System.out.println("Averages of subarrays averages of length " + 3 + ": " + averages);
        averages = getRollingAverage(arr, 4);
        System.out.println("Averages of subarrays averages of length " + 4 + ": " + averages);
        averages = getRollingAverage(arr, 5);
        System.out.println("Averages of subarrays averages of length " + 5 + ": " + averages);

    }

    /**
     * Возвращает массив средних значений для всех подмассивов длиной k, входящих в указанный массив arr.
     * @param arr исходный массив
     * @param k длина подмассивов
     * @return массив средних значений подмассивов
     */
    private static List<Double> getRollingAverage(List<Integer> arr, int k) {
        var subArray = new LinkedList<Integer>();
        var ret = new LinkedList<Double>();

        for (int i = 0; i < k; i++) subArray.add(arr.get(i));
        ret.add(subArray.stream().mapToInt(a -> a).average().orElse(0));

        for (int i = k; i < arr.size(); i++) {
            subArray.add(arr.get(i));
            subArray.remove();
            ret.add(subArray.stream().mapToInt(a -> a).average().orElse(0));
        }

        return ret;
    }
}
