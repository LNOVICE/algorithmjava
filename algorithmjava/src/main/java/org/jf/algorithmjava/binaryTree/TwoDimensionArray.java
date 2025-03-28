package org.jf.algorithmjava.binaryTree;

import sun.applet.Main;

import java.util.Arrays;

/**
 * https://leetcode.cn/leetbook/read/array-and-string/cuxq3/
 * Given an m x n matrix mat, return an array of all the elements of the array in a diagonal order.
 */
public class TwoDimensionArray {

    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length; //m行
        int n = mat[0].length; // n 列
        int[] a = new int[m*n];
        int idx = 0;
        //对角线行数 m + n -1
        for(int i = 0; i < m + n -1; i++) {
            //偶数
            if(i % 2 == 0) {
                //限制行列范围  j∈[0,m-1]  i-j∈[0,n-1]
                for(int j = Math.min(i,m-1);j>=0 && i-j >=0 &&  i-j <n; j--) {
                    a[idx++] =  mat[j][i-j];

                }
            } else {
                //限制行列范围
                for(int j = Math.min(i,n-1); j>=0 && i-j >=0 &&i-j <m; j--) {
                    a[idx++] = mat[i-j][j];
                }
            }
        }
        return a;
    }


    public static void main(String[] args) {
        int[][] mat = new int[][]{
                {1,2,3},{4,5,6},{7,8,9}
        };
        System.out.println(Arrays.toString(new TwoDimensionArray().findDiagonalOrder(mat)));
    }
}
