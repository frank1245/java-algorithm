package com.frank.chapter.three;

import java.util.Scanner;

/**
 * @description: 3.4日期处理
 * @author: LiGen
 * @version:
 * @date: 2020/4/22 19:57
 */
public class Question5 {
    static int[][] month = {{0, 0}, {31, 31}, {29, 28}, {31, 31}, {30, 30}, {31, 31}, {30, 30}, {31, 31}, {31, 31}, {30, 30}, {31, 31}, {30, 30}, {31, 31}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //使用多点测试
        while (!sc.hasNext("#")) {
            //1.输入两个时间按照:YYYYMMDD
            System.out.println("请输入两个时间:");
            int time1 = sc.nextInt();
            int time2 = sc.nextInt();
            //2.判断时间哪一个大,默认time1>time2
            if (time1 < time2) {
                //两数交换方法一
//                time1 = time1 + time2;
//                time2 = time1 - time2;
//                time1 = time1 - time2;
                //两数交换方法二
                time1 = time1 ^ time2;
                time2 = time1 ^ time2;
                time1 = time1 ^ time2;
            }
            //2.将时间分成年月日
            int year1 = time1 / 10000;
            int month1 = (time1 % 10000) / 100;
            int day1 = time1 % 100;
            int year2 = time2 / 10000;
            int month2 = (time2 % 10000) / 100;
            int day2 = time2 % 100;
            while (year2 < year1 || month2 < month1 || day2 < day1) {
                day2++;
                if (day2==month[month2][0]){

                }
            }

        }


    }

    public static Boolean isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;

    }
}
