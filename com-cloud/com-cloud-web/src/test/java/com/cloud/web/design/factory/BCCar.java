package com.cloud.web.design.factory;

/**
 * 生产奔驰
 */
public class BCCar implements Car{

    @Override
    public void drive() {
        System.out.println("今天开奔驰");
    }
}
