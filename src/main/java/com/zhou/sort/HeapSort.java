package com.zhou.sort;

/**
 * @description: 堆排序算法描述：
 * 1.将初始待排序关键字序列(R1,R2….Rn)构建成大顶堆，此堆为初始的无序区；
 * 2.将堆顶元素R[1]与最后一个元素R[n]交换，此时得到新的无序区(R1,R2,……Rn-1)和新的有序区(Rn),且满足R[1,2…n-1]<=R[n]；
 * 3.由于交换后新的堆顶R[1]可能违反堆的性质，因此需要对当前无序区(R1,R2,……Rn-1)调整为新堆，然后再次将R[1]与无序区最后一个元素交换，
 * 得到新的无序区(R1,R2….Rn-2)和新的有序区(Rn-1,Rn)。不断重复此过程直到有序区的元素个数为n-1，则整个排序过程完成。
 * @author: lxz
 * @time: 2022/1/27
 */
public class HeapSort {
    public static final int[] ARRAY = {24, 7, 43, 78, 62, 98, 82, 18, 54, 37, 73, 9};

    public static void main(String[] args) {
        print(ARRAY);
        System.out.println("====================================");
        print(sort(ARRAY));
    }

    // 堆排序
    public static int[] sort(int[] arr) {
        int n = arr.length;
        //构建大顶堆
        for (int i = (n - 2) / 2; i >= 0; i--) {
            downAdjust(arr, i, n - 1);
        }
        //进行堆排序
        for (int i = n - 1; i >= 1; i--) {
            // 把堆顶元素与最后一个元素交换
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            // 把打乱的堆进行调整，恢复堆的特性
            downAdjust(arr, 0, i - 1);
        }
        return arr;
    }

    //下沉操作
    public static void downAdjust(int[] arr, int parent, int n) {
        //临时保存要下沉的元素
        int temp = arr[parent];
        //定位左孩子节点的位置
        int child = 2 * parent + 1;
        //开始下沉
        while (child <= n) {
            // 如果右孩子节点比左孩子大，则定位到右孩子
            if (child + 1 <= n && arr[child] < arr[child + 1])
                child++;
            // 如果孩子节点小于或等于父节点，则下沉结束
            if (arr[child] <= temp) break;
            // 父节点进行下沉
            arr[parent] = arr[child];
            parent = child;
            child = 2 * parent + 1;
        }
        arr[parent] = temp;
    }

    private static void print(int[] array) {
        for (int i : array) {
            System.out.print(i + "  ");
        }
        System.out.println("");
    }
}
