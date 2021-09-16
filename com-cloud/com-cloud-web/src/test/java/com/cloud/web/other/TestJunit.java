package com.cloud.web.other;

import com.sun.xml.internal.ws.api.server.AbstractServerAsyncTransport;
import org.junit.*;

public class TestJunit {

    @BeforeClass
    public static void beforeClass(){
        System.out.println("beforeClass");
    }

    @Before
    public void before(){
        System.out.println("before");
    }

    @Test(timeout = 500,expected = Exception.class)
    public void test1() throws InterruptedException {
        Thread.sleep(409);
        System.out.println("test1");
        System.out.println(2/0);
    }

    @Test
    public void test2(){
//        Assert.assertEquals("111",new String("112"));
        String message = "false";
        Assert.assertEquals(message,"111",new String("111"));
        System.out.println("test2");
    }

    @After
    public void after(){
        System.out.println("after");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("afterClass");
    }
}
