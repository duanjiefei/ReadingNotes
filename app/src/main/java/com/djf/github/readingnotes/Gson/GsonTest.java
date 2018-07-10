package com.djf.github.readingnotes.Gson;

import com.google.gson.Gson;

/**
 * Created by Sky000 on 2018/7/10.
 */

public class GsonTest {

    public static void main(String[] args){

        //将基本数据类型JSON字符串进行Gson解析
/*        Gson gson =  new Gson();
        int i = gson.fromJson("100", int.class);              //100
        double d = gson.fromJson("\"99.99\"", double.class);  //99.99
        boolean b = gson.fromJson("true", boolean.class);     // true
        String str = gson.fromJson("String", String.class);   // String
        System.out.println("i = "+ i);
        System.out.println("d = "+ d);
        System.out.println("b = "+ b);
        System.out.println("str = "+ str);*/

        //利用Gson将基本数据类型生成JSON字符串
        Gson gson =  new Gson();
        String i = gson.toJson(100);              //100
        String d = gson.toJson(99.99);  //99.99
        String b = gson.toJson(true);     // true
        String str = gson.toJson("String");   // String
        System.out.println("i = "+ i);
        System.out.println("d = "+ d);
        System.out.println("b = "+ b);
        System.out.println("str = "+ str);
    }
}
