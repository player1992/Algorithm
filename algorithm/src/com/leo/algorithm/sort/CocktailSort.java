package com.leo.algorithm.sort;

import java.util.Arrays;

/**
 * 鸡尾酒排序
 * 冒泡排序的变种优化
 * <p>
 * 在数组序列大部分有序的情况下，冒泡排序似乎有点憋屈。
 * 比如【2，3，4，5，6，7，8，1】
 * 应用场景也是比较特殊的
 * <p>
 * 思路：第一轮从左往右排序，第二轮从右往左排序，第三轮从左往右排序...
 * 类似钟摆，从两端排序
 */
public class CocktailSort {

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 5, 6, 7, 8, 1};
        sort2(arr);

    }

    private static void sort(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length / 2; i++) {
            boolean sorted = true;
            //从左往右排序
            for (int j = i; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    sorted = false;
                }
            }
            System.out.println(Arrays.toString(arr));
            if (sorted) break;
            //从右往左排序之前，重置sorted
            sorted = true;
            //从右往左
            for (int j = arr.length - i - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    sorted = false;
                }
            }
            System.out.println(Arrays.toString(arr));
            if (sorted) break;
        }
        //按照鸡尾酒排序思路，只需三次便可得到结果，最后一次排序为算法需要
/*
[2, 3, 4, 5, 6, 7, 1, 8]
[1, 2, 3, 4, 5, 6, 7, 8]
[1, 2, 3, 4, 5, 6, 7, 8]
*/
    }

    //维基百科上的写法
    private static void sort2(int [] arrs){
        int left = 0;
        int right = arrs.length -1;
        int temp;
        boolean sorted = true;
        while (left < right){
            for (int i = left; i < right; i++) {
                if (arrs[i] > arrs[i + 1]){
                    temp = arrs[i + 1];
                    arrs[i + 1] =arrs[i];
                    arrs[i] = temp;
                    sorted = false;
                }
            }
            if (sorted ){
                break;
            }
            sorted = true;
            System.out.println(">>>"+Arrays.toString(arrs));
            right --;//最大值到最右
            for (int i = right; i > left; i--) {
                if (arrs[i - 1] > arrs[i]){
                    temp = arrs[i - 1];
                    arrs[i - 1] = arrs[i ];
                    arrs[i ] = temp;
                    sorted = false;
                }
            }
            System.out.println("<<<"+Arrays.toString(arrs));
            left ++ ;
            if (sorted ){
                break;
            }
            sorted = true;
        }
    }
}
