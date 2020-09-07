package com.frank.chapter.three;

import java.util.Scanner;

/**
 * @description: 3.2查找元素
 * @author: LiGen
 * @version:
 * @date: 2020/4/22 16:49
 */
public class Question3 {
    private static final int maxn = 200;

    public static void main(String[] args) {
        int[] arr = new int[maxn];
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNext("#")) {
            int n = sc.nextInt(); //输入多少个数字
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println("需要查询的数字");
            int x = sc.nextInt();
            int k;
            for (k = 0; k < n; k++) {
                if (arr[k] == x) { //如果找到了x
                    System.out.println(k);  //输出对应的下标
                    break;
                }
            }
            if (k == n) { //如果没有找到
                System.out.println("-1"); //输出-1
            }
        }


    }
}
