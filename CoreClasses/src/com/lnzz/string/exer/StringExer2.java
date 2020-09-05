package com.lnzz.string.exer;

import org.junit.Test;

import java.util.Arrays;

/**
 * ClassName：StringExer2
 *
 * @Author 冷暖自知
 * @Date 2020/8/31 21:11
 * @Version 1.0
 * @Description
 */
public class StringExer2 {

    /**
     * 模拟一个trim方法，去除字符串两端的空格
     */
    @Test
    public void test1() {
        String str = " a ";
        System.out.println(myTrim(str));
    }

    private static String myTrim(String str) {
        int start = 0;
        int end = str.length() - 1;
        while (start <= end && str.charAt(start) == ' ') {
            start++;
        }
        while (start <= end && str.charAt(end) == ' ') {
            end--;
        }

        return str.substring(start, end + 1);
    }


    /**
     * 将一个字符串进行反转。将字符串中指定部分进行反转。比如“abcdefg”反转为 “abfedcg”
     */
    @Test
    public void test2() {
        String str = "abcdefg";
        System.out.println(str);
        System.out.println(reverse(str, 2, 5));
    }

    public String reverse(String str, int beginIndex, int endIndex) {
        if (str != null) {
            char[] chars = str.toCharArray();
            for (int i = beginIndex, j = endIndex; i < j; i++, j--) {
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
            }
            return String.valueOf(chars);
        }
        return null;
    }

    /**
     * 获取一个字符串在另一个字符串中出现的次数。
     * 比如:获取“ab”在“abkkcadkabkebfkabkskab"中出现的次数
     */

    @Test
    public void test3() {
        String s1 = "abkkcadkabkebfkabkskab";
        String s2 = "ab";
        count(s1, s2);
    }

    public void count(String s1, String s2) {
        int count = 0;
        while (s1.contains(s2)) {
            s1 = s1.substring(s1.indexOf(s2) + s2.length());
            count++;
        }
        System.out.println("指定字符串在原字符串中出现：" + count + "次");
    }

    /**
     * 获取两个字符串中最大相同子串。比如
     * str1 ="abcwerthelloyuiodef" str2="cvhellobnm"
     */
    @Test
    public void test4() {
        String str1 = "abcwerthelloyuiodef";
        String str2 = "cvhellobnm";
        System.out.println(getMaxSubString(str1, str2));
    }

    public String getMaxSubString(String s1, String s2) {
        String max = "", min = "";
        max = (s1.length() > s2.length()) ? s1 : s2;
        min = (max.equals(s1)) ? s2 : s1;

        for (int i = 0; i < min.length(); i++) {
            for (int j = 0, k = min.length() - i; k != min.length() + 1; j++, k++) {
                String temp = min.substring(j, k);
                if (max.contains(temp)) {
                    return temp;
                }
            }
        }
        return null;
    }

    /**
     * 对字符串中字符进行自然顺序排序
     */
    @Test
    public void test5(){
        String str ="abcwerthelloyuiodef";
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        System.out.println(chars);
    }
}
