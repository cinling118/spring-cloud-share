package com.cloud.web.design.factory;

/**
 * 工厂类
 */
public class CarFactory {
    public Car getCar(String carType){
        if (carType.equals("BC")) {
            return new BCCar();
        } else if (carType.equals("BMW")) {
            return new BMWCar();
        }
        return null;
    }
}
