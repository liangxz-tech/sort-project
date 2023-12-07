package com.zhou.sort;

/**
 * @description: 快速排序算法描述：
 * 1.从数列中挑出一个元素，称为 “基准”（pivot）；
 * 2.重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
 * 3.递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
 * @author: lxz
 * @time: 2022/1/29
 */
public class QuickSort {
    public static final int[] ARRAY = {8, 5, 6, 4, 3, 1, 7, 2};

    public static void main(String[] args) {
        print(ARRAY);
        System.out.println("============================================");
        print(sort(ARRAY, 0, ARRAY.length - 1));
    }

    private static int[] sort(int[] array, int left, int right) {

        if (array.length < 1 || left > right) {
            return null;
        }
        //拆分
        int partitionIndex = partition(array, left, right);
        //递归
        if (partitionIndex > left) {
            sort(array, left, partitionIndex - 1);
        }
        if (partitionIndex < right) {
            sort(array, partitionIndex + 1, right);
        }
        return array;
    }

    /**
     * 分区快排操作
     *
     * @param array 原数组
     * @param left  左侧头索引
     * @param right 右侧尾索引
     * @return 分区指示器  最后指向基准数
     */
    private static int partition(int[] array, int left, int right) {
        //基准数下标---随机方式取值，也就是数组的长度随机1-8之间
        int pivot = (int) (left + Math.random() * (right - left + 1));
        //分区指示器索引
        int partitionIndex = left - 1;
        //基准数和尾部元素交换
        swap(array, pivot, right);
        //按照规定，如果当前元素大于基准数不做任何操作；
        //小于基准数，分区指示器右移，且当前元素的索引大于分区指示器，交换
        for (int i = left; i <= right; i++) {
            if (array[i] <= array[right]) {//当前元素小于等于基准数
                partitionIndex++;
                if (i > partitionIndex) {//当前元素的索引大于分区指示器
                    //交换
                    swap(array, i, partitionIndex);
                }
            }
        }
        return partitionIndex;
    }

    //交换
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    private static void print(int[] array) {
        for (int i : array) {
            System.out.print(i + "  ");
        }
        System.out.println("");
    }
}
