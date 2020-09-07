package test;


import org.junit.Test;

import java.math.BigDecimal;

/**
 * @description:
 * @author: LiGen
 * @version:
 * @date: 2020/4/19 14:24
 */
public class TestMath {
    BigDecimal a;
    @Test
    public void test(){
        BigDecimal b = new BigDecimal("1.11");
        BigDecimal add = b.add(a);
        System.out.println(add);

    }
}
