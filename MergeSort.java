package com.merge;

/**
 * @description:
 * 归并（Merge）排序法是将两个（或两个以上）有序表合并成一个新的有序表，即把待排序序列分为若干个子序列，每个子序列是有序的。
 * 然后再把有序子序列合并为整体有序序列。
 * @author: abi
 * @date: 2019-01-31 11:26
 */
public class MergeSort
{

    public static void sort(int[] array)
    {
        if(array==null || array.length<2)
        {
            return;
        }
        //创建一个临时数组
        int[] temp = new int[array.length];
        mergeSort(array,0,array.length-1,temp);
    }

    public static void mergeSort(int[] array,int start,int end,int[] temp)
    {
        if (start < end)
        {
            int mid = (start+end)/2;
            //左边归并排序，使得左子序列有序
            mergeSort(array,start,mid,temp);
            //右边归并排序，使得右子序列有序
            mergeSort(array,mid+1,end,temp);
            //将两个有序子数组合并操作
            merge(array,start,mid,end,temp);
        }
    }

    private static void merge(int[] array, int start,int mid,int end,int[] temp)
    {
        //左子序列指针
        int i =start;
        //右子序列指针
        int j = mid+1;
        //临时数组指针
        int t = 0;
        //将左边剩余元素填充进temp
        while(i<mid+1 && j<end+1)
        {
            if(array[i]<=array[j])
            {
                temp[t++] = array[i++];
            }else{
                temp[t++] = array[j++];
            }
        }
        //将左边剩余元素填充进temp
        while (i<mid+1)
        {
            temp[t++] = array[i++];
        }
        //将右边剩余元素填充进temp
        while (j<end+1)
        {
            temp[t++]=array[j++];
        }
        //将temp中的元素全部拷贝到原数组
        System.arraycopy(temp,0,array,start,end-start+1);
    }

    public static void print(int[] array)
    {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+"\t");
        }
    }

    public static void main(String[] args) {
        int[] array=new int[]{3,2,5,8,4,7,6,9};
        sort(array);
        print(array);
    }
}
