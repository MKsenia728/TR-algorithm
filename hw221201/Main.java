package org.example.hw221201;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
       int[] arr = {1,4,7,9,12,15,33,44,66,78,99,101};
       int last = arr.length - 1;
        for (int i: arr
             ) {
            System.out.println(binarySearch(arr, i, 0, last));
        }

//        Stack<Integer> s1 = new Stack<>();
//        Stack<Integer> s2 = new Stack<>();
//        Stack<Integer> s3 = new Stack<>();
//        s1.push(5);
//        s1.push(4);
//        s1.push(3);
//        s1.push(2);
//        s1.push(1);
//
//        moveRing(s1, s2, s3, 1);

    }
    public static int binarySearch(int[] arr, int key, int first, int last) {
        if (first == last) return first;
        int middleIndex = first + (last - first + 1) / 2;
//        return (arr[middleIndex] > key) ? binarySearch(arr, key, first, --middleIndex) : (arr[middleIndex] < key) ? binarySearch(arr, key, ++middleIndex, last) : middleIndex;
        if (arr[middleIndex] > key)
            return binarySearch(arr, key, first, --middleIndex);
        else if (arr[middleIndex] < key)
            return binarySearch(arr, key, ++middleIndex, last);
        else return middleIndex;
    }

    /* -. Получаем количество дисков n.
       -. Используем стрержни 1 - откуда,2 -помощник,3 -куда.
       1.Убираем (перекладываем) n-1 стержень в стек 2.
       2.Нижний стержень (n-й) перекладываем в стек 3.
       3.Теперь со стержня 2 перекладывает на стержень 1 (n-2) шт стержней в стек 1
       4. Оставшийся в стеке стержень (n-1) перекладываем в стек 3.
       5.Повторяем шаги 1 - 2  и 3-4, каждый раз уменьшая параметры n на 1.
       6.повторяем до тех пор, пока все n дисков не окажутся на стержне 3 (стек 1 и 2 не будут пустыми)
     */

    //код из интернета
//    public static void moveRing(Stack<Integer> firstPole, Stack<Integer> secondPole, Stack<Integer> thirdPole, int numOfRings) {
//        if (numOfRings > 0){
//            System.out.println(firstPole);
//            System.out.println(secondPole);
//            System.out.println(thirdPole);
//            moveRing(firstPole,thirdPole,secondPole,numOfRings-1); // перенести башню из n−1 диска на 2-й штырь
//            thirdPole.push(firstPole.pop()); // переносим самый большой диск на 3-й штырь
//            moveRing(secondPole,firstPole,thirdPole,numOfRings-1); // перенеси башню из n−1 диска на 3-й штырь
//        }
//    }

    public static int qqq(int a) {
        return (a > 0) ? 2 : 3;

    }
}
