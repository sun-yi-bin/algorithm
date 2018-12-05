package com.search;

/**
 * 同义链表结点类
 */
class Node{
    private Integer value;//数值
    private int pos;//数值在数组的下标
    private Node parent;//父亲节点
    private Node child;//孩子结点

    public Node(Integer value,int pos)
    {
        this.pos = pos;
        this.value = value;
        this.parent = null;
        this.child = null;
    }
    public Node(Integer value,int pos,Node parent,Node child)
    {
        this.pos = pos;
        this.value = value;
        this.child = child;
        this.parent = parent;
    }

    public Integer getValue() {
        return value;
    }

    public Node getChild() {
        return child;
    }




    public void setChild(Node child) {
        this.child = child;
    }

    public int getPos() {
        return pos;
    }

}

public class HashTable {

    private Node[] arr;//哈希数组
    private int hash_length;//哈希表的长度
    private int prime_num;//素数
    private int[] array;//待查数组
    public HashTable(int[] array)
    {
        this.array = array;
        this.hash_length = array.length;
        this.arr = new Node[hash_length];
        this.prime_num = getPrime(hash_length);
    }

    /**
     * 获取素数
     * @param hash_length   哈希表的查找
     * @return
     */
    public int getPrime(int hash_length) {
        if(hash_length < 3)
        {
            return hash_length;
        }

        int i,j;
        for (i = hash_length; i > 0; i--)
        {
            for (j = 2; j < hash_length && (i%j!=0); j++);
            if (i==j)
            {
                break;
            }
        }
        return i;
    }

    /**
     * 构建哈希表
     * @return 哈希表
     */
    public Node[] init(){
        Node[] arr = this.arr;
        int yushu;//余数
        for (int i = 0; i < array.length; i++)
        {
            yushu = array[i]%prime_num;
            if (arr[yushu] == null) {
                arr[yushu] = new Node(array[i],i);
            }else{
                putLink(array[i],i,arr[yushu]);
            }
        }
        return arr;
    }

    /**
     * 解决冲突的同义链表
     * @param num 数值
     * @param i 数值在数组的下标
     * @param node  余数在哈希表的头结点
     */
    private void putLink(int num,int i, Node node) {
        Node p,q;
        p=q=node;
        while(p!=null){
            q=p;
            p = p.getChild();
        }
        Node child = new Node(num,i,q,null);
        q.setChild(child);
    }

    /**
     * 搜索
     * @param key   搜索值
     * @return  数组下标，没有找到返回-1
     */
    public int search(int key)
    {
        int  yushu = key%prime_num;
        Node node = arr[yushu];
        Node i;
        for (i = node; i != null && key!=node.getValue(); i=i.getChild());
        if (i!=null)
        {
            return i.getPos();
        }
        return -1;

    }
    //测试
    public static void main(String[] args) {
        int [] array = new int[]{6,9};
        HashTable hash = new HashTable(array);
        hash.init();
        System.out.println(hash.search(3));
    }
}
