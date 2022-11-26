package org.example.hw221125;

public class Main {

    //    1) Вычислить сложность следующих алгоритмов

    //    t O(n) ~ O(n+1)
    //    s O(1)
    void test1(int n) {
        if (n == 1)
            return;
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++) {
                System.out.println("*");
                break;
            }
    }

    //    t O(n^2)
    //    s O(1)
    void test2(int n) {
        if (n == 1)
            return;
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                System.out.println("*");
    }

    //    t O(n^2) ~ O(n^2 - 3n + 2)/2
    //    s O(1)
    void test3(int n) {
        int a = 0;
        for (int i = 0; i < n; i++)
            for (int j = n; j > i; j--)
                a = a + i + j;

    }

    //    t O(n log n) ~ O(n/2 log n (основание 2))
    //    s O(1)
    void test4(int n) {
        int i, j, a = 0;
        for (i = n / 2; i <= n; i++)
            for (j = 2; j <= n; j = j * 2)
                a = a + n / 2;

    }

//    2) Find the element that appears once in a sorted array
//    Given a sorted array in which all elements occur twice (one after the other) and one element appears only once.
//
//    Простое решение состоит в обходе массива слева направо. Поскольку массив отсортирован, мы легко можем найти нужный элемент.


    //    t O(n) ~ O(n/2)
    //    s O(1)
    public static int searchOnceElement(int[] arr) throws Exception {
        int res = 0;
        int length = arr.length;
        if (length % 2 == 0) throw new Exception("no once element or array is empty");
        else {
            if (length == 1) res = arr[0];
            else
                for (int i = 0; i < length - 2; i += 2) {
                    if (arr[i] != arr[i + 1]) {
                        res = arr[i];
                        break;
                    }
                    if (i == length - 3) res = arr[length - 1];
                }
        }
        return res;

    }

//    Задачки со звёздочкой - вычислить сложность в лучшем и худшем случае.

    //   best t O(1)
    //   worst t O(log n) основание 2
    //    s O(1)
    void test5(int n) {
        int a = 0, i = n;
        while (i > 0) {
            a += i;
            i /= 2;
        }
    }

    //   best t O(1)
    //   worst t O(n) n - max a|b
    //   worse then worst - бесконечный цикл (если хотя бы один из элементов меньше 1 и они не равны)
    void method(int a, int b) {
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
    }

    //   best t O(1)
    //   worst t O(n^2 log n) ~ O(n/2 * n/2 log n по основанию 2)
    void method2(int n) {
        for (int i = 0; i < n / 2; i++) {
            for (int j = 1; j + n / 2 <= n; j++) {
                for (int k = 1; k <= n; k = k * 2) {
                    System.out.println("I am expert!");
                }
            }
        }
    }

    //   best t O(1)
    //   worst t O(n) ~ O(~5*n)
    void method3(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j = j + i) {
                System.out.println("I am expert!");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        int[] arr = {0, 0, 1, 1, 2, 2, 3, 3, 3, 3, 5, 5, 5};
        System.out.println(searchOnceElement(arr));
        int a = -1;
        int b = -2;

        System.out.println(a - b);

    }
}
