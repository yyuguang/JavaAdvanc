package com.lnzz.string;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * ClassName：StringTest
 *
 * @Author 冷暖自知
 * @Date 2020/8/24 20:52
 * @Version 1.0
 * @Description
 */
public class StringTest {
    /*
    String：字符串，使用一对""引起来表示
    1.String声明为final的，不可被继承
    2.String实现了Serializable接口：表示字符串是支持序列化的
            实现了Comparable接口：表示String可比较大小
    3.String内部定义了  final char value[] 用于存储字符串数据
    4.String代表不可变的字符序列。简称：不可变性
        体现:1.当对字符串重新复制时,需要重写指定内存区域赋值,不能使用原有的value进行赋值
            2.当对现有的字符进行连接操作时,也需要重新指定内存区域赋值,不能使用原有的value进行赋值
            3.当调用 string的 replace()方法修改字符或字符串事,也需要重新指定内存区域赋值,不能使用原有的value进行赋值
    5.通过字面量的方式(区别于new)给一个字符赋值,此时的字符值声明在字符单常量池中
    6.字符常量池中是不会存储相同内容的字符串的
    */

    @Test
    public void test1() {
        String s1 = "abc";
        String s2 = "abc";

        s1 = "hello";

        System.out.println(s1 == s2);
        System.out.println(s1);
        System.out.println(s2);

        System.out.println("*********************");
        String s3 = "abc";
        s3 += "def";
        System.out.println(s3);

        System.out.println("*********************");
        String s4 = "abc";
        String s5 = s4.replace("a", "m");
        System.out.println(s4);
        System.out.println(s5);
    }

    /**
     * String的实例化方式：
     * 方式一：通过字面量定义的方式
     * 方式二：通过new+构造器的方式
     */
    @Test
    public void test2() {
        //通过字面量定义的方式：此时的s1和s2的数据 javaEE 声明在方法区中的字符串常量池中
        String s1 = "javaEE";
        String s2 = "javaEE";

        //通过new+构造器的方式：此时的s3和s4保存的地址值，是数据在堆空间中开辟空间以后对应的地址值
        String s3 = new String("javaEE");
        String s4 = new String("javaEE");

        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1 == s4);
        System.out.println(s3 == s4);
    }

    /**
     * 1.常量与常量的拼接结果在常量池。且常量池中不会存在相同内容的常量
     * 2.只要其中有一个是变量,结果就在雄中
     * 3.如果拼接的结果调用 intern()方法,返回值就在常量池中
     */
    @Test
    public void test3() {
        String s1 = "javaEE";
        String s2 = "Go";
        String s3 = "javaEEGo";
        String s4 = "javaEE" + "Go";
        String s5 = s1 + "Go";
        String s6 = "javaEE" + s2;
        String s7 = s1 + s2;
        String s8 = s5.intern();

        System.out.println(s3 == s4);
        System.out.println(s3 == s5);
        System.out.println(s3 == s6);
        System.out.println(s5 == s6);
        System.out.println(s5 == s7);
        System.out.println(s6 == s7);
        System.out.println(s3 == s8);
    }

    /**
     * String 与 byte[]之间的转换
     * 编码：String --> byte[]:调用String的getBytes()
     * 解码：byte[] --> String:调用String的构造器
     * <p>
     * 编码：字符串 -->字节  (看得懂 --->看不懂的二进制数据)
     * 解码：编码的逆过程，字节 --> 字符串 （看不懂的二进制数据 ---> 看得懂）
     * <p>
     * 说明：解码时，要求解码使用的字符集必须与编码时使用的字符集一致，否则会出现乱码。
     *
     * @throws UnsupportedEncodingException
     */
    @Test
    public void test4() throws UnsupportedEncodingException {
        String str1 = "abc123中国";
        byte[] bytes = str1.getBytes();//使用默认的字符集，进行编码。
        System.out.println(Arrays.toString(bytes));

        byte[] gbks = str1.getBytes("gbk");//使用gbk字符集进行编码。
        System.out.println(Arrays.toString(gbks));

        System.out.println("******************");

        String str2 = new String(bytes);//使用默认的字符集，进行解码。
        System.out.println(str2);

        String str3 = new String(gbks);
        System.out.println(str3);//出现乱码。原因：编码集和解码集不一致！


        String str4 = new String(gbks, "gbk");
        System.out.println(str4);//没有出现乱码。原因：编码集和解码集一致！


    }

    /**
     * String 与 char[]之间的转换
     * <p>
     * String --> char[]:调用String的toCharArray()
     * char[] --> String:调用String的构造器
     */
    @Test
    public void test5() {
        //题目： a21cb3
        String str1 = "abc123";

        char[] charArray = str1.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            System.out.println(charArray[i]);
        }

        char[] arr = new char[]{'h', 'e', 'l', 'l', 'o'};
        String str2 = new String(arr);
        System.out.println(str2);
    }
}
