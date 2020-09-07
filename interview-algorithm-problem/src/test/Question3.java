package test;

import java.util.Scanner;

/**
 * @description: ⼩小明的抽屉⾥里里有n个游戏币，总⾯面值m，游戏币的设置有1分的，2分的，5分的，10分的，⽽而在⼩小明
 * 所拥有的游戏币中有些⾯面值的游戏币可能没有，求⼀一共有多少种可能的游戏币组合⽅方式？
 * 输⼊入：输⼊入两个数n(游戏币的个数)，m(总⾯面值)。
 * 输出：请输出可能的组合⽅方式数；
 * @author: LiGen
 * @version:
 * @date: 2020/4/19 17:10
 */
public class Question3 {
    static int count = 0;
    static int n;
    static int m;

    public static void main(String[] args) {
        System.out.println("请输入个数和面额:");
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        if (10 * n < m) {
            System.out.println("组合不出这种金额");
            return;
        }
        //调用普通方法
        countNum(n, m);
        System.out.println(count);
        count = 0;
        //调用深度优先遍历方法找到所有的可能
        dfs(0, 0);
        System.out.println(count);
    }

    public static void countNum(int n, int m) {
        int n1 = n;
        int n2 = m / 2 > n ? n : m / 2;
        int n3 = 5 / 2 > n ? n : m / 5;
        int n4 = m / 10 > n ? n : m / 10;
        for (int i = 0; i <= n1; i++) {
            for (int j = 0; j <= n2; j++) {
                for (int k = 0; k <= n3; k++) {
                    for (int z = 0; z <= n4; z++) {
                        if ((1 * i + 2 * j + 5 * k + 10 * z) == m && (i + j + k + z) == n) {
                            System.out.println("1*"+i+"+2*"+j+"+5*"+k+"+10*"+z+"="+m);
                            count++;
                        }
                    }
                }
            }
        }
    }

    public static void dfs(int sum, int n1) {
        if (sum > m && n1 < n) {
            return;
        }
        if (n1 == n) {
            if (sum == m) {
                count++;
                return;
            } else {
                return;
            }
        } else if (n1 > n) {
            return;
        }
        if ((m - sum) % 10 == 0) {
            dfs(sum + 10, n1 + 1);
        }else if ((m - sum) % 5 == 0) {
            dfs(sum + 5, n1 + 1);
        }
        if ((m - sum) % 2 == 0) {
            dfs(sum + 2, n1 + 1);
        }else{
            dfs(sum + 1, n1 + 1);
        }
    }
}
