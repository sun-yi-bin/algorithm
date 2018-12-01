package com.search;

public class Search {
    /**
     * 顺序查找
     * @param arr   要查找的数组
     * @param key   要查找的数
     * @return      找到，返回值在数组的下标；没有找到，返回-1
     */
    public static int sequeueSearch(int [] arr,int key)
    {
        int i,res = -1;
        if (null == arr || arr.length <1)
        {
            return res;
        }

        for (i = 0; i < arr.length && arr[i] !=key; i++);
        if(i<arr.length)
        {
            res = i;
        }
        return res;
    }

    /**
     * 二分查找（针对有序的线性表）
     * @param arr   要查找的数组
     * @param key   要查找的数
     * @return 找到，返回值在数组的下标；没有找到，返回-1
     */
    public static int binarySearch(int[] arr ,int key)
    {

        if(null==arr || arr.length<1)
        {
            return -1;
        }
        int low =0;
        int high = arr.length-1;
        while(low<=high)
        {
            int mid = (low+high)/2;
            if(arr[mid]==key)
            {
                return mid;
            }
            if (arr[mid]>key)
            {
                high = mid-1;
            }
            if(arr[mid]<key)
            {
                low = mid+1;
            }
        }

        return -1;
    }

    /**
     * 插值法（适合于均匀分布的有序线性表）
     * @param arr   待查数组
     * @param key   要找的值
     * @param low
     * @param high
     * @return  找到，返回值在数组的下标；没有找到，返回-1
     */
    public static int insertionSearch(int[] arr, int key,int low,int high)
    {
        if(null==arr || arr.length<1 || low>high || low>arr.length-1 || high<0)
        {
            return -1;
        }
        int mid = low + (key-arr[low])/(arr[high]-arr[low])*(high-low);
        if(arr[mid]==key)
        {
            return mid;
        }
        if(arr[mid]<key)
        {
            return insertionSearch(arr, key, mid+1, high);
        }else{
            return insertionSearch(arr,key,low,mid-1);
        }

    }

    /**
     * 斐波那契查找
     * @param arr
     * @param key
     * @return
     */
    public static int fibonnacciSearch(int[] arr,int key)
    {
        if (null==arr || arr.length<1)
        {
            return -1;
        }
        int len = arr.length;
        int low = 0;
        int high = len-1;
        int[] fcc = Fibonacci(len);

        int k=0;

        while (len>fcc[k]-1)
        {
            ++k;
        }

        int[] temp = new int[fcc[k]-1];
        System.arraycopy(arr,0,temp,0,len);
        for (int i = len; i < fcc[k]-1; i++) {
            temp[i] = arr[len-1];
        }

        while (low<=high)
        {
            int mid = low+fcc[k-1]-1;

            if (key<temp[mid])
            {
                high = mid-1;
                k-=1;
            }else if(key>temp[mid])
            {
                low=mid+1;
                k-=2;
            }else if(key==temp[mid])
            {
                if (mid<len)
                {
                    return mid;
                }else{
                    return len-1;
                }
            }
        }
        return -1;
    }

    /**
     * 创建斐波那契数组
     * @param len   长度为待查数组的长度
     * @return
     */
    private static int[] Fibonacci(int len) {
        int[] fcc = new int[len];
        fcc[0]=0;
        fcc[1]=1;
        for (int i = 2; i < len; i++) {
            fcc[i]=fcc[i-1]+fcc[i-2];
        }
        return fcc;
    }


    public static void main(String[] args)
    {
        int[] arr = new int[]{10,20,30,40,50,60,70,80,90,100};
        int key = 10;

        System.out.println(sequeueSearch(arr,key));
        System.out.println(binarySearch(arr,key));
        System.out.println(insertionSearch(arr,key,0,arr.length-1));
        System.out.println(fibonnacciSearch(arr,key));
    }
}
