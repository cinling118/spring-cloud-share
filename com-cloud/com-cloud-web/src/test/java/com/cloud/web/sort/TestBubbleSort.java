package com.cloud.web.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class TestBubbleSort {
    public static void main(String[] args) {
//        int[] arr = { 2, 8, 7, 9, 4, 1, 5, 0 };
//        bubbleSort(arr);
        int[] arr = {3,5,2,9,1,0};
        bubbleSort(arr);
    }

    public static void bubbleSort(int[] arr) {
        int size = arr.length;
        for (int i=0 ;i<size-1;i++) {
            for (int j=0;j<size-1-i;j++) {
                arr[j]^=arr[j+1];
                arr[j+1]^=arr[j];
                arr[j]^=arr[j+1];
            }
        }
        System.out.println(Arrays.toString(arr));

//        //控制多少轮
//        for (int i = 0; i < arr.length-1; i++) {
//            //控制每一轮的次数
//            for (int j = 0; j < arr.length -1 - i; j++) {
//                if (arr[j] > arr[j + 1]) {
////                    int temp;
////                    temp = arr[j];
////                    arr[j] = arr[j + 1];
////                    arr[j + 1] = temp;
//                    arr[j]=arr[j]^arr[j+1];
//                    arr[j+1]^=arr[j];
//                    arr[j]^=arr[j+1];
//                }
//            }
//        }
//        System.out.println(Arrays.toString(arr));
    }
}