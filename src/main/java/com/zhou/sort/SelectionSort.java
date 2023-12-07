package com.zhou.sort;

/**
 * @description: 选择排序工作原理：首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素，
 * 然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
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
