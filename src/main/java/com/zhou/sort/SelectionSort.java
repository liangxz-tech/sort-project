package com.zhou.sort;

/**
 * @description: 选择排序算法描述：
 * 1.初始状态：无序区为R[1..n]，有序区为空；
 * 2.第i趟排序(i=1,2,3…n-1)开始时，当前有序区和无序区分别为R[1..i-1]和R(i..n）。该趟排序从当前无序区中-选出关键字最小的记录 R[k]，将它与无序区的第1个记录R交换，使R[1..i]和R[i+1..n)分别变为记录个数增加1个的新有序区和记录个数减少1个的新无序区；
 * 3.n-1趟结束，数组有序化了。
 * @author: lxz
 * @time: 2022/1/27
 */
public class SelectionSort {
    public static final int[] ARRAY = {24, 7, 43, 78, 62, 98, 82, 18, 54, 37, 73, 9};

    public static int[] sort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        for (int i = 0; i < array.length; i++) {
            //最小数的下标，每个循环开始总是假设第一个数最小
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                //找到最小索引
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            //最小索引的值
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        return array;
    }

    public static void print(int[] array) {
        for (int i : array) {
            System.out.print(i + "  ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        print(ARRAY);
        System.out.println("============================================");
        print(sort(ARRAY));
    }
}
