package com.buddle;

import com.shell.ShellSort;

/**
 * @description:
 * @author: abi
 * @date: 2019-01-29 22:46
 */
public class Buddle_flag
{
    public static void buddleSort(int[] array)
    {
        boolean flag = true;
        for (int i=0;i<array.length-1 && flag;i++)
        {
            flag = false;
            for(int j=i+1;j<array.length;j++)
            {
                if(array[j-1]>array[j])
                {
                    int temp = array[j-1];
                    array[j-1]=array[j];
                    array[j] = temp;
                    flag = true;
                }
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
        Buddle_flag.buddleSort(array);
        Buddle_flag.print(array);
    }
}
