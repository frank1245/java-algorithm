package test;

import java.util.Scanner;

/**
 * @description: 有数学家发现一些两位数很有意思，比如，
 * 34 * 86 = 43 * 68
 * 也就是说，如果把他们的十位数和个位数交换，二者乘积不不变。
 * 编程求出满足该性质的两位数组合。
 * 提示，暴力解法非最优解。
 * @author: LiGen
 * @version:
 * @date: 2020/4/19 17:10
 */
public class Question4 {

    /**
     * 思路:由于10反转之后是01,和任何数字相乘都不相等,所以从11开始
     * 1.排除掉11,22,33...这种类型的数字,因为左右对换还是同样的
     *
     * @param args
     */
    public static void main(String[] args) {
        for (int i = 11; i <= 98; i++) {
            int leftNumberI = i / 10;
            int rightNumberI = i % 10;
            //判断十位 和个位是否相等
            if (leftNumberI == rightNumberI) {
                continue;
            }
            for (int j = i + 1; j <= 98; j++) {
                int leftNumberJ = j / 10;
                int rightNumberJ = j % 10;
                if (leftNumberJ == rightNumberJ) {
                    continue;
                }
                int newNumber1 = rightNumberI * 10 + leftNumberI;
                int newNumber2 = rightNumberJ * 10 + leftNumberJ;
                if (i * j == newNumber1 * newNumber2) {
                    System.out.println(i+"*"+j+"="+newNumber1+"*"+newNumber2);
                }
            }
        }
    }
}
