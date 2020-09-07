package com.frank.chapter.three;

import java.util.Scanner;

/**
 * @description: 算法笔记第三章 问题一
 * @author: LiGen
 * @version:
 * @date: 2020/4/22 15:51
 */
public class Question1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        while (n != 1) {
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = (3 * n + 1) / 2;
            }
            count++;
        }
        System.out.println(count);

    }
}
