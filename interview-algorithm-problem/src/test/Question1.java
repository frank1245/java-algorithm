package test; /**
 * @description: 部门优化:某公司内有 4 个项⽬目组，项⽬目组 A、B、C、D，项⽬目组A现有10⼈人，项⽬目组B现有7⼈人，项⽬目组C现
 * 有5⼈人，项⽬目组D现有4⼈人。为了了实现跨项⽬目组协作，公司决定每⽉月从⼈人数最多的项⽬目组中抽调 3 ⼈人
 * 出来，到其他剩下 3 组中，每组 1 ⼈人，这称之为⼀一次调整优化（亦即经过第⼀一次调整后，A组有7
 * ⼈人，B组有8⼈人，C组有6⼈人，D组有5⼈人）。
 * 那么请问，经过⼗十年年的优化调整后，各项⽬目组各有⼏几⼈人？
 * @author: LiGen
 * @version:
 * @date: 2020/4/19 11:13
 */

import java.util.Arrays;
import java.util.Scanner;

/**
 * 解法:首先找到规律,从人数最多的项目组抽调3人,在第一次之后就变成了[7,8,6,5]
 * 经过第一次以后就变成了一个周期函数,以4!=24为周期T的排列,8就是这个排列的最大值
 */
public class Question1 {
    public static void main(String[] args) {
        //定义一个公司的项目组的人数数组
        int[] arr = {10, 7, 5, 4};
        System.out.println("请输入经过的月份:");
        Scanner scanner = new Scanner(System.in);
        int month = scanner.nextInt();
        //1.判断是经过一次还是多次
        if (0 == month) {
            System.out.println(Arrays.toString(arr));
        } else {
            //2.通过月份%4!得到需要计算的次数
            int factorial = factorial(4);
            int count = (month - 1) % factorial;
            for (int i = 0; i <= count; i++) {
                optimize(arr);
            }
            System.out.println(Arrays.toString(arr));
        }

    }

    /**
     * 优化部门
     */
    public static void optimize(int[] arr) {
        int maxNumber = getMaxNumber(arr);
        for (int i = 0; i < arr.length; i++) {
            if (maxNumber > arr[i]) {
                arr[i] = arr[i] + 1;
            } else {
                arr[i] = arr[i] - 3;
            }
        }
    }

    /**
     * 获取最大值
     *
     * @param arr
     * @return
     */
    public static int getMaxNumber(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }

    /**
     * 获取阶乘
     *
     * @param num
     * @return
     */
    public static int factorial(int num) {
        if (num == 1) {
            return num;
        }
        return num * factorial(num - 1);
    }
}
