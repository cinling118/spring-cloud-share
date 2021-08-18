package com.cloud.web.design.factory;

/**
 * 测试简单工厂模式
 */
public class TestFactory {

    public static void main(String[] args) {
        CarFactory carFactory = new CarFactory();
        Car bmwCar = carFactory.getCar("BMW");
        bmwCar.drive();
        Car bcCar = carFactory.getCar("BC");
        bcCar.drive();
    }
}
