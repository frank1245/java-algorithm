package test;

import map.MyHashMap;
import map.MyMap;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @description: 某产品的⽤用户注册邀请码为⼀一串串有⼩小写字⺟母和数字组成的字符串串，字符串串⻓长度为16。当⽤用户数据邀
 * 请码的时候，系统需要对邀请码做有效性验证，假设验证规则如下：
 * 1、 从序列列号最后⼀一位字符开始，逆向将奇数位(1、3、5等等)相加；
 * 2、从序列列号最后⼀一位数字开始，逆向将偶数位数字，先乘以2（如果乘积为两位数，则将其减去
 * 9），再求和；
 * 3、将奇数位总和加上偶数位总和，结果可以被10整除；
 * 4、⼩小写字⺟母对应数值，可由下⾯面键值对确定；
 * [(a,1), (b,2), (c,3)…,(i,9), (j,1), (k, 2)…]，亦即，按字⺟母顺序，1-9循环。
 * 输⼊入：输⼊入16位字符串串，表示邀请码
 * 输出：输出“ok”或者“error”
 * @author: LiGen
 * @version:
 * @date: 2020/4/19 11:58
 */

/**
 * 分析:1.将所有的字符放在一个map集合中
 * 2.将字符串转换成字符数组
 * 3.通过判断对应的字符,去map集合中取出对应的数字按要求计算
 * 4.判断是否符合要求
 */
public class Question2 {
    private static MyMap<Character, Integer> myMap = new MyHashMap<>();

    static {
        myMap.put('1', 1);
        myMap.put('2', 2);
        myMap.put('3', 3);
        myMap.put('4', 4);
        myMap.put('5', 5);
        myMap.put('6', 6);
        myMap.put('7', 7);
        myMap.put('8', 8);
        myMap.put('9', 9);
        myMap.put('0', 0);
        myMap.put('a', 1);
        myMap.put('b', 2);
        myMap.put('c', 3);
        myMap.put('d', 4);
        myMap.put('e', 5);
        myMap.put('f', 6);
        myMap.put('g', 7);
        myMap.put('h', 8);
        myMap.put('i', 9);
        myMap.put('j', 1);
        myMap.put('k', 2);
        myMap.put('l', 3);
        myMap.put('m', 4);
        myMap.put('n', 5);
        myMap.put('o', 6);
        myMap.put('p', 7);
        myMap.put('q', 8);
        myMap.put('r', 9);
        myMap.put('s', 1);
        myMap.put('t', 2);
        myMap.put('u', 3);
        myMap.put('v', 4);
        myMap.put('w', 5);
        myMap.put('x', 6);
        myMap.put('y', 7);
        myMap.put('z', 8);
    }

    public static void main(String[] args) {
        System.out.println("请输入邀请码(16位):");
        Scanner scanner = new Scanner(System.in);
        String code = scanner.nextLine();
        if(code.length()!=16){
            throw new RuntimeException("输入的邀请码不合法,请输入16位");
        }
        int oddNumber = 0;
        int evenNumber = 0;
        char[] inventionCode = code.toCharArray();
        for (int i = inventionCode.length - 1; i >= 0; i--) {
            //偶数角标
            if ((i + 1) % 2 == 0) {
                if (Character.isDigit(inventionCode[i]) || Character.isLowerCase(inventionCode[i])) {
                    evenNumber += myMap.get(inventionCode[i]) * 2 >= 10 ? myMap.get(inventionCode[i]) * 2 - 10 : myMap.get(inventionCode[i]) * 2;
                } else {
                    throw new RuntimeException("输入的邀请码不合法");
                }
                //奇数角标
            } else {
                if (Character.isDigit(inventionCode[i]) || Character.isLowerCase(inventionCode[i])) {
                    oddNumber += myMap.get(inventionCode[i]);
                } else {
                    throw new RuntimeException("输入的邀请码不合法");
                }
            }
        }
        if ((oddNumber + evenNumber) % 10 == 0) {
            System.out.println("OK");
        }else{
            System.out.println("ERROR");
        }
    }
}
