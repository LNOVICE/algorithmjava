package org.jf.algorithmjava.union_find_sets;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;


/**
 * 并查集
 * 输入样例 
 */
public class UnionFindDemo {
    private static final int NUM = 6;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer[] setType = new Integer[NUM];
        String input =  scanner.next();
        initialization(setType);
        System.out.println(Arrays.asList(setType));
        do {
            switch(input){
                case "I":
                    inputConnection(setType,scanner); break;
                case "C":
                    checkConnection(setType, scanner);break;
                case "S":
                    checkNetWork(setType);break;
            }
        }while (!"S".equals(input));
    }

    /**
     * 将输入的两个机器连接
     * @param setType
     * @param scanner
     */
    private static void inputConnection(Integer[] setType, Scanner scanner) {
        String u = scanner.next();
        String v = scanner.next();
        Integer root1 = find(setType, Integer.valueOf(u) - 1);
        Integer root2 = find(setType, Integer.valueOf(v) - 1);
        if (root1 != root2) {
            union(setType, root1, root2);
        }
    }

    /**
     * 合并两个集合 根结点存放的是树高的负数 按秩归并 把矮树贴到高树上
     * @param setType
     * @param root1
     * @param root2
     */
    private static void union(Integer[] setType, Integer root1, Integer root2) {
            if(setType[root2] < setType[root1]) {
                setType[root1] = root2;
                return;
            }
            if(setType[root1] == setType[root2]) {
                setType[root1] -= 1;
            }
            setType[root2] = root1;
    }

    /**
     * 查找 i的父节点
     * @param setType 放集合的数组
     * @param i 需要查找父节点的元素
     * @return
     */
    private static Integer find(Integer[] setType, int i) {
        for(; setType[i] >= 0; i = setType[i]);
        return i;
    }

    /**
     * {@link UnionFindDemo#find(Integer[],int)}方法路径压缩实现
     * @param setType 存放集合的数组
     * @param i  需要查找父节点的元素
     * @return
     */
    private static Integer findUsePathComppression(Integer[] setType, int i) {
        if (setType[i] < 0) {
            return  i;
        }
        return  setType[i] = findUsePathComppression(setType, setType[i]);
    }




    /**
     * 检查网络是否连通
     * @param setType
     */
    private static void checkNetWork(Integer[] setType) {
        int counter = 0;
        for (Integer i:setType) {
            if(i < 0) {
               counter ++;
            }
        }
        if(counter == 1) {
            System.out.println("The network is conneted");
            return;
        }
        System.out.println(String.format("There are %s components.",counter));
    }

    /**
     * 检查输入的两台机器是否属于一个集合
     * @param setType
     * @param scanner
     */
    private static void checkConnection(Integer[] setType, Scanner scanner) {
        String u = scanner.next();
        String v = scanner.next();
        Integer root1 = find(setType, Integer.valueOf(u) - 1);
        Integer root2 = find(setType, Integer.valueOf(v) - 1);
        if (root1 == root2) {
            System.out.println("yes");
            return;
        }
        System.out.println("no");
    }

    /**
     *  初始化  起始都是单个节点
     * @param setType
     */
    private static void initialization(Integer[] setType) {
        for (int i = 0 ;i < setType.length ; i ++) {
            setType[i] = -1;
        }
    }
}
