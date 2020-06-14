package com.atguigu.dac;

/**
 * 汉诺塔
 */
public class Hanoitower {
    public static void main(String[] args) {
        hanoiTower(3, 'a', 'b', 'c');
    }

    /**
     * num个塔从a移动到c
     *
     * @param num 盘子数量
     * @param a   起始盘
     * @param b
     * @param c   目标盘
     */
    public static void hanoiTower(int num, char a, char b, char c) {
        if (num == 1) {
            System.out.println("第1个盘从" + a + "->" + c);
        } else {
            //num-1个盘子从a移动到b
            hanoiTower(num - 1, a, c, b);

            System.out.println("第" + num + "个盘从" + a + "->" + c);

            //num-1个盘子从b移动到c
            hanoiTower(num - 1, b, a, c);

        }
    }
}
