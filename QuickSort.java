package com.quickSort;

/**
 * @description:
 * 先从数列中取出一个数作为基准数，记为x。分区过程，将不小于x的数全放到它的右边，不大于x的数全放到它的左边。
 * （这样key的位置左边的没有大于key的，右边的没有小于key的，只需对左右区间排序即可。
 * 再对左右区间重复第二步，直到各区间只有一个数。
 * @author: abi
 * @date: 2019-01-31 10:21
 */
public class QuickSort
{
    public static void quickSort(int[] array,int start,int end)
    {

        if (start > end || array==null || array.length<2)
        {
            return;
        }
        int base = array[start];
        int i = start;
        int j = end;

        while (i!=j)
        {
            while (array[j]>=base && i<j)
            {
                j--;
            }
            while (array[i]<=base && i<j)
            {
                i++;
            }
            if (i<j)
            {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        array[start] = array[i];
        array[i] = base;
        quickSort(array,start,i-1);
        quickSort(array,i+1,end);
    }

    public static void print(int[] array)
    {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+"\t");
        }
    }

    public static void main(String[] args) {
        int[] array=new int[]{3,2,5,8,4,7,6,9};
        quickSort(array,0,array.length-1);
        print(array);
    }
}
