package org.example.hw221208;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        тестовые данные для задания 1
        int x = 2;
        int n = 5;
        System.out.println("Задание 1 возведение чисел в степень");
        System.out.println(PowRec1(x, n));
        System.out.println(PowRec2(x, n));

//        тестовые данные для задания 2
        System.out.println("Задание 2 найти элемент в соединенных массивах");
        int[] arr1 = new int[]{100, 112, 256, 349, 770};
        int[] arr2 = new int[]{72, 86, 113, 119, 265, 445, 892};
        int k = 7;
        System.out.println(findEl(arr1, arr2, k));

//        тестовые данные для задания 3
        System.out.println("Задание 3 найти количество одинаковых элементов в отсортированном массиве");
        int[] arr = {1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3};
        int x3 = 2;
        System.out.println(Arrays.toString(arr));
        System.out.println(countInArray(arr, x3, 0, arr.length - 1));

//        тестовые данные для задания 4
        System.out.println("Задание 4 найти пиковый элемент");
        int[][] array = {{10, 20, 15, 22, 10},
                         {21, 30, 14, 31, 12},
                          {7, 16, 32, 15, 99}}; /* ожидаем 30,31,32,99 */
        for (int peak: findPeakEl(array)) {
            System.out.println(peak);
        }


    }
//    Даны два целых числа x и n, напишите функцию для вычисления x^n
//    решение 1 - рекурсивно O(n)
//    решение 2 - улучшить решение 1 до O(lon n)

    public static int PowRec1(int x, int n) {
        if (n == 1) return x;
        else return x * PowRec1(x, n - 1);
    }

    public static int PowRec2(int x, int n) {
        if (n == 1) return x;
        else return PowRec2(x, n / 2) * PowRec2(x, n - n / 2);
    }

//    Имея два отсортированных массива размера m и n соответственно, вам нужно найти элемент, который будет находиться на k-й позиции в конечном отсортированном массиве.
//    Массив 1 - 100 112 256 349 770
//    Массив 2 - 72 86 113 119 265 445 892
//    к = 7
//    Вывод : 256
//    Окончательный отсортированный массив -
//            72, 86, 100, 112, 113, 119, 256, 265, 349, 445, 770, 892
//            7-й элемент этого массива равен 256.

    public static int findEl(int[] arr1, int[] arr2, int k) {
        return merge(arr1, arr2)[k];
    }

    private static int[] merge(int[] arr1, int[] arr2) {
        int lengthArr1 = arr1.length;
        int lengthArr2 = arr2.length;
        int[] res = new int[lengthArr1 + lengthArr2];
        int i = 0;
        int j = 0;
        while (i < lengthArr1 && j < lengthArr2)
            res[i + j] = (arr1[i] < arr2[j]) ? arr1[i++] : arr2[j++];
        while (i < lengthArr1) res[i + j] = arr1[i++];
        while (j < lengthArr2) res[i + j] = arr2[j++];
        return res;
    }

//    Имея отсортированный массив arr[] и число x, напишите функцию, которая подсчитывает вхождения x в arr[]. Ожидаемая временная сложность O(Log n)
//    arr[] = {1, 1, 2, 2, 2, 2, 3,}
//    x = 2
//    Вывод: 4 раза

    public static int countInArray(int[] arr, int x, int first, int last) {
        int res = 0;
        int middleIndex = first + (last - first) / 2;
        if (arr[first] == arr[last]) {
            if (arr[first] == x) res = last - first + 1;
            return res;
        }
        if (x > arr[middleIndex]) res = res + countInArray(arr, x, ++middleIndex, last);
        else if (x < arr[middleIndex]) res = res + countInArray(arr, x, first, middleIndex);
        else {
            res = res + countInArray(arr, x, middleIndex + 1, last) + countInArray(arr, x, first, middleIndex);
        }
        return res;
    }

    //    4* Найдите пиковый элемент в двумерном массиве
    public static List<Integer> findPeakEl(int[][] arr) {
        List<Integer> list = new ArrayList<>();
        int minInt = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                int[] tmp = new int[4];
                tmp[0] = (i == 0) ? minInt : arr[i-1][j];
                tmp[2] = (i == arr.length-1) ? minInt : arr[i+1][j];
                tmp[1] = (j == 0) ? minInt : arr[i][j-1];
                tmp[3] = (j == arr[0].length-1) ? minInt : arr[i][j+1];
                if (isMax(arr[i][j], tmp)) list.add(arr[i][j]);
            }
        }
        return list;
    }

    private static boolean isMax(int el, int[] arr) {
        boolean res = true;
        for (int number: arr) {
           res = res && el > number;
        }
        return res;
    }
}
