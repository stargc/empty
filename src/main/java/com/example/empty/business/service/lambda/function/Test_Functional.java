package com.example.empty.business.service.lambda.function;

/**
 * @author created by guanchen on 2020/10/12 16:50
 */
public class Test_Functional {
    // 定义一个含有函数式接口的方法
    private static void lambdaLog(int level, MyFunctionalInterface  myFunctionalInterface) {
        if (level == 1) {
            String result = myFunctionalInterface.function();
            System.out.println(result);// 实际上利用内部类 延迟的原理,代码不相关 无需进入到启动代理执行
        }
    }

    private static void commonLog(int level,String result) {
        if (level == 1) {
            System.out.println(result);// 实际上利用内部类 延迟的原理,代码不相关 无需进入到启动代理执行
        }
    }

    public static void main(String[] args) {
        String msgA = "Hello";
        String msgB = "World";
        String msgC = "Java";

        commonLog(2, msgA + msgB + msgC);
        System.out.println("《commonLog(2, msgA + msgB + msgC)》虽然级别不满足没有打印 但是 字符串连接操作还是执行了 那么字符串的拼接操作就白做了，存在性能浪费");

        lambdaLog(1,()->{
            System.out.println("lambda级别1  性能操作 执行");
            return msgA + msgB + msgC;
        });

        lambdaLog(2,()->{
            System.out.println("lambda级别2  性能操作 执行");
            return msgA + msgB + msgC;
        });
    }
}
