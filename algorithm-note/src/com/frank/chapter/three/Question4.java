package com.frank.chapter.three;

import java.util.Scanner;

/**
 * @description: 3.3图形输出
 * @author: LiGen
 * @version:
 * @date: 2020/4/22 19:22
 */
public class Question4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int col = scanner.nextInt();
        int row = col % 2 == 1 ? col / 2 + 1 : col / 2;
        String c = scanner.next();
        //1.解决第一行输出问题,并换行
        for (int i = 1; i <= col; i++) {
            System.out.print(c);
        }
        System.out.println();
        //2.第二行-第n-1行
        for (int j = 2; j < row; j++) {
            for (int i = 1; i <= col; i++) {
                if (i == 1 || i == col){
                    System.out.print(c);
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        //3.最后一行
        for (int i = 1; i <= col; i++) {
            System.out.print(c);
        }
    }
}
