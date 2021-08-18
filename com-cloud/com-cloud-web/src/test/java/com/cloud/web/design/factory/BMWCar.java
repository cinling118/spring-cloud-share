package com.cloud.web.design.factory;

/**
 * 生产宝马
 */
public class BMWCar implements Car{
    @Override
    public void drive() {
        System.out.println("今天开宝马");
    }
}
