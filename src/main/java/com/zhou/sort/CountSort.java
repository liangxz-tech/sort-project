package com.zhou.sort;

/**
 * @description: 计数排序算法描述：
 * 1.找出待排序的数组中最大和最小的元素；
 * 2.统计数组中每个值为i的元素出现的次数，存入数组C的第i项；
 * 3.对所有的计数累加（从C中的第一个元素开始，每一项和前一项相加）；
 * 4. 反向填充目标数组：将每个元素i放在新数组的第C(i)项，每放一个元素就将C(i)减去1。
 * @author: lxz
 * @time: 2022/1/29
 */
public class CountSort {
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
        // 寻找数组的最大值
        for (int i = 1; i < n; i++) {
            if (max < arr[i]) max = arr[i];
        }
        //创建大小为max的临时数组
        int[] temp = new int[max + 1];
        //统计元素i出现的次数
        for (int i = 0; i < n; i++) {
            temp[arr[i]]++;
        }
        int k = 0;
        //把临时数组统计好的数据汇总到原数组
        for (int i = 0; i <= max; i++) {
            for (int j = temp[i]; j > 0; j--) {
                arr[k++] = i;
            }
        }
        return arr;
    }
}
