package com.zhou.sort;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @description: 基数排序算法描述：
 * 1.取得数组中的最大数，并取得位数；
 * 2.arr为原始数组，从最低位开始取每个位组成radix数组；
 * 3.对radix进行计数排序（利用计数排序适用于小范围数的特点）；
 * @author: lxz
 * @time: 2022/1/29
 */
public class RadioSort {
    public static final int[] ARRAY = {24, 7, 43, 78, 62, 98, 82, 18, 54, 37, 73, 9};

    public static void main(String[] args) {
        print(ARRAY);
        System.out.println("====================================");
        print(sort(ARRAY));
    }

    private static void print(int[] array) {
        for (int i : array) {
            System.out.print(i + "  ");
        }
        System.out.println("");
    }

    public static int[] sort(int[] arr) {
        if (arr == null || arr.length < 2) return arr;

        int n = arr.length;
        int max = arr[0];
        // 找出最大值
        for (int i = 1; i < n; i++) {
            if (max < arr[i]) max = arr[i];
        }
        // 计算最大值是几位数
        int num = 1;
        while (max / 10 > 0) {
            num++;
            max = max / 10;
        }
        // 创建10个桶
        ArrayList<LinkedList<Integer>> bucketList = new ArrayList<>(10);
        //初始化桶
        for (int i = 0; i < 10; i++) {
            bucketList.add(new LinkedList<Integer>());
        }
        // 进行每一趟的排序，从个位数开始排
        for (int i = 1; i <= num; i++) {
            for (int j = 0; j < n; j++) {
                // 获取每个数最后第 i 位是数组
                int radio = (arr[j] / (int) Math.pow(10, i - 1)) % 10;
                //放进对应的桶里
                bucketList.get(radio).add(arr[j]);
            }
            //合并放回原数组
            int k = 0;
            for (int j = 0; j < 10; j++) {
                for (Integer t : bucketList.get(j)) {
                    arr[k++] = t;
                }
                //取出来合并了之后把桶清光数据
                bucketList.get(j).clear();
            }
        }
        return arr;
    }

}
