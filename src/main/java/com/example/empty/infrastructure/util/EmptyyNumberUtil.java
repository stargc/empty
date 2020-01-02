package com.example.empty.infrastructure.util;

import org.apache.commons.validator.routines.BigDecimalValidator;
import org.springframework.util.Assert;

import java.math.BigDecimal;

/**
 * @author created by guanchen on 2020/1/2 14:06
 */
public class EmptyyNumberUtil {

    /***
     * 判断value 是否在 min, max范围内
     * @param value
     * @param min
     * @param max
     * @return
     */
    private static boolean isInRange(String value,String min,String max){
        Assert.isTrue(BigDecimalValidator.getInstance().isValid(value),"value 不是数字类型");
        Assert.isTrue(BigDecimalValidator.getInstance().isValid(min),"min 不是数字类型");
        Assert.isTrue(BigDecimalValidator.getInstance().isValid(max),"max 不是数字类型");

        BigDecimal numberValue = new BigDecimal(value);
        BigDecimal minValue = new BigDecimal(min);
        BigDecimal maxValue = new BigDecimal(max);
        return BigDecimalValidator.getInstance().isInRange(numberValue,minValue.doubleValue(),maxValue.doubleValue());
    }

    public static void main(String[] args) {
        System.out.println(isInRange("0.232","01","0.23254856548"));
        System.out.println(isInRange("0.232","-01","0.23254856548"));
        System.out.println(isInRange("0.232","a","0.23254856548"));
    }
}
