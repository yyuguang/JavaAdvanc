package com.lnzz.date;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * ClassName：DateTest
 *
 * @Author 冷暖自知
 * @Date 2020/9/5 22:57
 * @Version 1.0
 * @Description JDK 8之前日期和时间的API测试
 */
public class DateTest {
    /**
     * System类中的currentTimeMillis()
     */
    @Test
    public void test1() {
        long time = System.currentTimeMillis();
        //返回当前时间与1970年1月1日0时0分0秒之间以毫秒为单位的时间差。
        //称为时间戳
        System.out.println(time);
    }

    /**
     * java.util.Date类
     * |---java.sql.Date类
     * <p>
     * 1.两个构造器的使用
     * >构造器一：Date()：创建一个对应当前时间的Date对象
     * >构造器二：创建指定毫秒数的Date对象
     * 2.两个方法的使用
     * >toString():显示当前的年、月、日、时、分、秒
     * >getTime():获取当前Date对象对应的毫秒数。（时间戳）
     * <p>
     * 3. java.sql.Date对应着数据库中的日期类型的变量
     * >如何实例化
     * >如何将java.util.Date对象转换为java.sql.Date对象
     */
    @Test
    public void test2() {
        //构造器一：Date()：创建一个对应当前时间的Date对象
        Date date1 = new Date();
        System.out.println(date1.toString());

        System.out.println(date1.getTime());

        //构造器二：创建指定毫秒数的Date对象
        Date date2 = new Date(155030620410L);
        System.out.println(date2.toString());

        //创建java.sql.Date对象
        java.sql.Date date3 = new java.sql.Date(35235325345L);
        System.out.println(date3);

        //如何将java.util.Date对象转换为java.sql.Date对象
        //情况一：
//        Date date4 = new java.sql.Date(2343243242323L);
//        java.sql.Date date5 = (java.sql.Date) date4;
        //情况二：
        Date date6 = new Date();
        java.sql.Date date7 = new java.sql.Date(date6.getTime());


    }

    /**
     * SimpleDateFormat的使用：SimpleDateFormat对日期Date类的格式化和解析
     * <p>
     * 1.两个操作：
     * 1.1 格式化：日期 --->字符串
     * 1.2 解析：格式化的逆过程，字符串 ---> 日期
     * <p>
     * 2.SimpleDateFormat的实例化
     *
     * @throws ParseException
     */
    @Test
    public void testSimpleDateFormat() throws ParseException {
        //实例化SimpleDateFormat:使用默认的构造器
        SimpleDateFormat sdf = new SimpleDateFormat();

        //格式化：日期 --->字符串
        Date date = new Date();
        System.out.println(date);

        String format = sdf.format(date);
        System.out.println(format);

        //解析：格式化的逆过程，字符串 ---> 日期
        String str = "19-12-18 上午11:43";
        Date date1 = sdf.parse(str);
        System.out.println(date1);

        //*************按照指定的方式格式化和解析：调用带参的构造器*****************
//        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyy.MMMMM.dd GGG hh:mm aaa");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        //格式化
        String format1 = sdf1.format(date);
        System.out.println(format1);
        //解析:要求字符串必须是符合SimpleDateFormat识别的格式(通过构造器参数体现),
        //否则，抛异常
        Date date2 = sdf1.parse("2020-02-18 11:48:27");
        System.out.println(date2);
    }

    /**
     * 练习一：字符串"2020-09-08"转换为java.sql.Date
     * <p>
     * 练习二："三天打渔两天晒网"   1990-01-01  xxxx-xx-xx 打渔？晒网？
     * <p>
     * 举例：2020-09-08 ？ 总天数
     * <p>
     * 总天数 % 5 == 1,2,3 : 打渔
     * 总天数 % 5 == 4,0 : 晒网
     * <p>
     * 总天数的计算？
     * 方式一：( date2.getTime() - date1.getTime()) / (1000 * 60 * 60 * 24) + 1
     * 方式二：1990-01-01  --> 2019-12-31  +  2020-01-01 -->2020-09-08
     *
     * @throws ParseException
     */
    @Test
    public void test3() throws ParseException {
        String birth = "2020-09-08";

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf1.parse(birth);
//        System.out.println(date);

        java.sql.Date birthDate = new java.sql.Date(date.getTime());
        System.out.println(birthDate);
    }


    /**
     * Calendar日历类(抽象类）的使用
     */
    @Test
    public void testCalendar() {
        //1.实例化
        //方式一：创建其子类（GregorianCalendar）的对象
        //方式二：调用其静态方法getInstance()
        Calendar calendar = Calendar.getInstance();
//        System.out.println(calendar.getClass());

        //2.常用方法
        //get()
        int days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));

        //set()
        //calendar可变性
        calendar.set(Calendar.DAY_OF_MONTH, 22);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //add()
        calendar.add(Calendar.DAY_OF_MONTH, -3);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //getTime():日历类---> Date
        Date date = calendar.getTime();
        System.out.println(date);

        //setTime():Date ---> 日历类
        Date date1 = new Date();
        calendar.setTime(date1);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

    }
}
