package com.cloud.web.loader;

/**
 * Class.forName和Classloader的区别
 * （1）class.forName()除了将类的.class文件加载到jvm中之外，还会对类进行解释，执行类中的static块。当然还可以指定是否执行静态块。
 * （2）classLoader只干一件事情，就是将.class文件加载到jvm中，不会执行static中的内容,只有在newInstance才会去执行static块。
 */
public class TestLoad {
    public static void main(String[] args) {
        test("com.cloud.web.loader.TestUser");
    }

    public static void test(String className) {
        try {
            //方式一：ClassLoader 加载类
            ClassLoader classLoader = ClassLoader.getSystemClassLoader();
            System.out.println("ClassLoader test ....");
            Class<?> loaderUser = classLoader.loadClass(className);
            //loaderUser.newInstance();
            System.out.println("ClassLoader user :" + loaderUser.getName());
            System.out.println("----------分隔线-----------");

            //方式二：Class.forName 加载类
            Class forNameUser = Class.forName(className);//默认true：执行static的代码即静态代码，也就是默认实现类的初始化。
            System.out.println("forNameUser test ....");
            System.out.println("forNameUser user :" + forNameUser.getName());
            System.out.println("----------分隔线2-----------");

            Class forNameUser2 = Class.forName(className,false,classLoader);//传参false：不执行static的代码即静态代码。
            System.out.println("forNameUser2 test ....");
            System.out.println("forNameUser2 user :" + forNameUser2.getName());

            //方式三：类的Class;
            System.out.println(TestUser.class.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class TestUser{
    private static int a=10;

    {
        System.out.println("普通代码块");
    }

    static {
        System.out.println("静态变量a:" + a);
        System.out.println("静态代码块");
    }
}