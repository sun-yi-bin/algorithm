package com.select;

/**
 * @description:
 * 选择排序
 * 1）首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置
 *
 * 2）再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
 *
 * 3）重复第二步，直到所有元素均排序完毕。
 * @author: abi
 * @date: 2019-01-27 17:35
 */
public class SelectSort {
    public static void selectSort(int[] array)
    {
        if (array==null && array.length<2)
        {
            return;
        }
        for (int i = 0; i < array.length-1; i++)
        {
            int flag = i;
            for (int j = i+1; j < array.length; j++)
            {
                if (array[flag]>array[j])
                {
                    flag = j;
                }
            }
            if (flag!=i)
            {
                int mid = array[flag];
                array[flag] = array[i];
                array[i]=mid;
            }

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
        SelectSort.selectSort(array);
        SelectSort.print(array);
    }
}
