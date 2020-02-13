package com.wenliang.demo.test;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @description:
 * @author: cwl
 * @createDate: 2020/2/11
 */
public class Demo01 {

    public static void main(String[] arys){
       // int sum = add(2, 3);
        test01();

    }

    public static int add( int a,int b){
        if(a<=0){
            return 0;
        }else{
            HashMap map = new HashMap();
        }
        return a+b;
    }

    public static void test01(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入： ");
        String next = scanner.next();
        if(next .equals("ss") ){
            System.out.println("s");

        }
    }
}
