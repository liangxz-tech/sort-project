package com.zhou.sort;

/**
 * @description: 插入排算法描述：
 * 1.从数组第2个元素开始抽取元素。
 * 2.把它与左边第一个元素比较，如果左边第一个元素比它大，则继续与左边第二个元素比较下去，直到遇到不比它大的元素，然后插到这个元素的右边。
 * 3.继续选取第3，4，….n个元素,重复步骤 2 ，选择适当的位置插入。
 * @author: lxz
 * @time: 2022/1/27
 */
public class InsertSort {
    public static final int[] ARRAY = {15, 51, 86, 70, 6, 42, 26, 61, 45, 81, 17, 1};

    public static void main(String[] args) {
        print(ARRAY);
        System.out.println("============================================");
        print(sort(ARRAY));
    }

    public static int[] sort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        int current;
        for (int i = 0; i < array.length - 1; i++) {
            //已被排序数据的索引
            int index = i;
            current = array[index + 1];
            //将当前元素后移一位
            while (index >= 0 && current < array[index]) {
                array[index + 1] = array[index];
                index--;
            }
            //插入
            array[index + 1] = current;
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
