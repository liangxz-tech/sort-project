package com.zhou.sort;

/**
 * @description: 希尔排序算法描述：
 * 1.选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；
 * 2.按增量序列个数k，对序列进行k 趟排序；
 * 3.每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
 * @author: lxz
 * @time: 2022/1/27
 */
public class ShellSort {
    public static final int[] ARRAY = {24, 7, 43, 78, 62, 98, 82, 18, 54, 37, 73, 9};

    public static void main(String[] args) {
        print(ARRAY);
        System.out.println("============================================");
        print(sort(ARRAY));
    }

    private static int[] sort(int[] array) {
        int len = array.length;
        if (len < 2) {
            return array;
        }
        int current;
        //定义增量
        int gap = len / 2;
        while (gap > 0) {
            for (int i = 0; i < len; i++) {
                current = array[i];
                //前面有序序列的索引
                int index = i - gap;
                while (index >= 0 && current < array[index]) {
                    array[index + gap] = array[index];
                    //有序序列的下一个
                    index -= gap;
                }
                //插入
                array[index + gap] = current;
            }
            //int相除取整
            gap = gap / 2;
        }
        return array;
    }

    private static void print(int[] array) {
        for (int i : array) {
            System.out.print(i + "  ");
        }
        System.out.println("");
    }
}
