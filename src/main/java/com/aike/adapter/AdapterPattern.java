package com.aike.adapter;

import java.util.Arrays;

/**
 * 适配器模式(Adapter Pattern)：将一个接口转换成客户希望的另一个接口，使接口不兼容的那些类可以一起工作，
 * 其别名为包装器(Wrapper)。适配器模式既可以作为类结构型模式，也可以作为对象结构型模式。
 *
 * 适配器模式有两种形式，那就是类适配器模式和对象适配器模式
 * 类适配器模式和对象适配器模式最大的区别在于适配器和适配者之间的关系不同，对象适配器模式中适配器和适配者之间是关联关系，
 * 而类适配器模式中适配器和适配者是继承关系
 */

/**
 * 在对象适配器模式结构图中包含如下几个角色：
 * ● Target（目标抽象类）：目标抽象类定义客户所需接口，可以是一个抽象类或接口，也可以是具体类。
 * ● Adapter（适配器类）：适配器可以调用另一个接口，作为一个转换器，对Adaptee和Target进行适配，适配器类是适配器模式的核心，
 * 在对象适配器中，它通过继承Target并关联一个Adaptee对象使二者产生联系。
 * ● Adaptee（适配者类）：适配者即被适配的角色，它定义了一个已经存在的接口，这个接口需要适配，
 * 适配者类一般是一个具体类，包含了客户希望使用的业务方法，在某些情况下可能没有适配者类的源代码。
 */
public class AdapterPattern {
    public static void main(String[] args) {
        ScoreOperation operation = new OperationAdapter();
        int scores[] = {84,76,50,69,90,91,88,96}; //定义成绩数组
        int result[];
        result = operation.sort(scores);
        System.out.println(Arrays.toString(result));
        int score = operation.search(scores, 90);
        System.out.println(score);
    }
}

//抽象成绩操作类：目标接口
interface ScoreOperation {
    public int[] sort(int array[]); //成绩排序
    public int search(int array[],int key); //成绩查找
}

//快速排序类：适配者
class QuickSort {
    public int[] quickSort(int array[]) {
        sort(array,0,array.length-1);
        return array;
    }

    public void sort(int array[],int p, int r) {
        int q=0;
        if(p<r) {
            q=partition(array,p,r);
            sort(array,p,q-1);
            sort(array,q+1,r);
        }
    }

    public int partition(int[] a, int p, int r) {
        int x=a[r];
        int j=p-1;
        for (int i=p;i<=r-1;i++) {
            if (a[i]<=x) {
                j++;
                swap(a,j,i);
            }
        }
        swap(a,j+1,r);
        return j+1;
    }

    public void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}

//二分查找类：适配者
class BinarySearch {
    public int binarySearch(int array[],int key) {
        int low = 0;
        int high = array.length -1;
        while(low <= high) {
            int mid = (low + high) / 2;
            int midVal = array[mid];
            if(midVal < key) {
                low = mid +1;
            }
            else if (midVal > key) {
                high = mid -1;
            }
            else {
                return 1; //找到元素返回1
            }
        }
        return -1;  //未找到元素返回-1
    }
}

//操作适配器：适配器
class OperationAdapter implements ScoreOperation{
    private QuickSort sortObj; //定义适配者QuickSort对象
    private BinarySearch searchObj; //定义适配者BinarySearch对象

    public OperationAdapter() {
        sortObj = new QuickSort();
        searchObj = new BinarySearch();
    }


    @Override
    public int[] sort(int[] array) {
        return sortObj.quickSort(array);
    }

    @Override
    public int search(int[] array, int key) {
        return searchObj.binarySearch(array,key);
    }
}