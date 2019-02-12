package com.heap;

/**
 * @description:
 * 堆排序
 * @author: abi
 * @date: 2019-02-12 22:59
 */
public class HeapSort
{
    /**
     * 交换数组元素
     * @param array
     * @param start
     * @param end
     */
    public static void swap(int[] array,int start,int end)
    {
        if (array!=null)
        {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
        }
    }

    public static void heapSort(int[] array)
    {
        if (array==null || array.length<2)
        {
            return;
        }
        //循环建堆
        for (int i = 0; i < array.length; i++)
        {
            buildHeapSort(array,array.length-1-i);
            swap(array,0,array.length-1-i);
        }
    }

    /**
     * 对数组进行从0到i建立大顶堆
     * @param array
     * @param i
     */
    public static void buildHeapSort(int[] array, int i)
    {
        //从i处节点（最后一个节点）的父节点开始
        for (int j=(i-1)/2;j>-1;j--)
        {
            //k保存正在判断的节点
            int k = j;
            //如果当前k节点的子节点存在
            while (k*2+1<=i)
            {
                //k节点的左子节点的索引
                int biggerIndex = 2*k+1;
                //如果biggerIndex小于i，则biggerIndex代表的k节点的右节点存在
                if (biggerIndex<i)
                {
                    //若右节点的值比较大
                    if (array[biggerIndex]<array[biggerIndex+1])
                    {
                        //biggerIndex总是记录较大节点的索引
                        biggerIndex++;
                    }
                }
                //若k节点的值小于其较大的子节点的值
                if (array[k]<array[biggerIndex])
                {
                    //交换他们
                    swap(array,k,biggerIndex);
                    //将biggerIndex赋予k，开始while循环的下一次循环，重新保证k节点的值大于其左右子节点的值
                    k = biggerIndex;
                }else {
                    break;
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
        heapSort(array);
        print(array);
    }

}
