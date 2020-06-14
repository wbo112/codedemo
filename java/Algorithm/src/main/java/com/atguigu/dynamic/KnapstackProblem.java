package com.atguigu.dynamic;

/**
 * 0 1 背包
 */
public class KnapstackProblem {
    public static void main(String[] args) {
        int[] w = {1, 4, 3};//商品重量
        int[] v = {1500, 3000, 2000};//商品价值
        int m = 4;//背包的容量
        int n = v.length;//物品的数量

        int[][] vals = new int[n + 1][m + 1];
        int[][] path = new int[n + 1][m + 1];
        for (int i = 0; i < vals.length; i++) {
            vals[i][0] = 0;
        }
        for (int i = 0; i < vals[0].length; i++) {
            vals[0][i] = 0;

        }

        for (int i = 1; i < vals.length; i++) {
            for (int j = 1; j < vals[0].length; j++) {
                if (w[i - 1] > j) {
                    vals[i][j] = vals[i - 1][j];
                } else {
                    //vals[i][j] = Math.max(vals[i - 1][j], v[i - 1] + vals[i - 1][j - w[i - 1]]);
                    if (vals[i - 1][j] < v[i - 1] + vals[i - 1][j - w[i - 1]]) {
                        vals[i][j] = v[i - 1] + vals[i - 1][j - w[i - 1]];
                        path[i][j] = 1;
                    } else {
                        vals[i][j] = vals[i - 1][j];
                        path[i][j] = 0;
                    }
                }
            }
        }
        for (int i = 0; i < vals.length; i++) {
            for (int j = 0; j < vals[i].length; j++) {
                System.out.print(vals[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("=====================");
        for (int i = 0; i < path.length; i++) {
            for (int j = 0; j < path[i].length; j++) {

                System.out.print(path[i][j] + " ");
            }
            System.out.println();
        }
        int i=path.length-1;//行的最大下标
        int j=path[0].length-1;//列的最大下标

        while(i>0&&j>0){//从path的最后开始找
            if(path[i][j]==1){
                System.out.println("第 "+i+"个商品放入到背包中");
                j-=w[i-1];
            }
            i--;
        }
    }
}
