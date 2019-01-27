package com.insert;

/**
 * @description:
 * 插入排序
 * 思路：
 * 1）将第一待排序序列第一个元素看做一个有序序列，把第二个元素到最后一个元素当成是未排序序列。
 *
 * 2）从头到尾依次扫描未排序序列，将扫描到的每个元素插入有序序列的适当位置。（如果待插入的元素与有序序列中的某个元素相等，则将待插入元素插入到相等元素的后面。）
 *
 * @author: abi
 * @date: 2019-01-27 17:15
 */
public class InsertSort {
    public static void insertSort(int[] array)
    {
        if (array==null && array.length<2)
        {
            return;
        }

        for (int i=1;i<array.length;i++)
        {
            int temp = array[i];
            int j=i;
            for (; j >0 && temp<array[j-1]; j--) {
                array[j]=array[j-1];
            }
            array[j]=temp;
        }
    }

    public static void print(int[] array)
    {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+"\t");
        }
    }

    public static void main(String[] args) {
        int[] array=new int[]{3,2,5,8,4,7,6,9};
        InsertSort.insertSort(array);
        InsertSort.print(array);
    }

}
