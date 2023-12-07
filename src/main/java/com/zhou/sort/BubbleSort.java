package com.zhou.sort;

/**
 * @description: 冒泡排序算法描述：
 * 1.把第一个元素与第二个元素比较，如果第一个比第二个大，则交换他们的位置。接着继续比较第二个与第三个元素，如果第二个比第三个大，则交换他们的位置
 * 2.我们对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样一趟比较交换下来之后，排在最右的元素就会是最大的数。
 * 3.除去最右的元素，我们对剩余的元素做同样的工作，如此重复下去，直到排序完成。
 * @author: lxz
 * @time: 2022/1/27
 */
public class BubbleSort {
    public static final int[] ARRAY = {24, 7, 43, 78, 62, 98, 82, 18, 54, 37, 73, 9};

    public static void main(String[] args) {
        print(ARRAY);
        System.out.println("====================================");
        print(sort1(ARRAY));
    }

    // 优化前
    private static int[] sort1(int[] array) {
        if (array.length == 0) {
            return array;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j + 1] < array[j]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    // 优化后
    private static int[] sort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j + 1] < arr[j]) {
                    flag = false;
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
            }
            //一趟下来是否发生位置交换
            if (flag)
                break;
        }
        return arr;
    }

    private static void print(int[] array) {
        for (int i : array) {
            System.out.print(i + "  ");
        }
        System.out.println("");
    }
}
