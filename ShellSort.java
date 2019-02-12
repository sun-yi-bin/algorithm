package com.shell;

/**
 * @description:
 * 对直接插入排序的优化
 * 先将整个待排元素序列分割成若干个子序列（相隔某个增量的元素组成）分别进行直接插入排序，
 * 然后依次缩减增量在进行排序，待整个序列元素基本有序（增量为1时），再对全体元素进行一次直接插入排序
 * @author: abi
 * @date: 2019-01-29 20:08
 */
public class ShellSort
{
    public static void shellSort01(int[] array)
    {
        if(array!=null && array.length==0)
        {
            return;
        }
        int gap = array.length/3;
        while (gap>0)
        {
            for (int i = gap; i < array.length; i++) {
                int j = i;
                while (j>=gap && array[j-gap]>array[j])
                {
                    int temp = array[j-gap]+array[j];
                    array[j-gap] = temp-array[j-gap];
                    array[j] = temp-array[j-gap];
                    j-=gap;
                }
            }
            gap /=2;
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
        ShellSort.shellSort01(array);
        ShellSort.print(array);
    }
}
