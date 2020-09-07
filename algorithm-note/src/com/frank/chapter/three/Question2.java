package com.frank.chapter.three;

import java.util.Scanner;

/**
 * @description:
 * @author: LiGen
 * @version:
 * @date: 2020/4/22 16:14
 */
public class Question2 {
    private static final int maxn = 100010;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] school = new int[maxn];
        for (int i = 1; i <= n; i++) {
            int schId = sc.nextInt();
            int score = sc.nextInt();
            school[schId] += score;
        }
        int k = 1, max = -1;
        for (int i = 1; i <= n; i++) { //从所有学校中选出一个总分最高的
            if (school[i] > max) {
                max = school[i];
                k = i;
            }
        }
        System.out.println(k + " " + max);//输出最高总分的学校id及其总分
    }
}
