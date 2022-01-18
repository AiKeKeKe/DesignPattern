package com.aike.factory.simplefactory;

/**
 * 简单工厂模式(Simple Factory Pattern)：
 * 定义一个工厂类，它可以根据参数的不同返回不同类的实例，被创建的实例通常都具有共同的父类。
 * 因为在简单工厂模式中用于创建实例的方法是静态(static)方法，
 * 因此简单工厂模式又被称为静态工厂方法(Static Factory Method)模式，它属于类创建型模式。
 */
public class SimpleFactory {
    public static Product getProduct(String type){
        Product product = null;
        if ("a".equalsIgnoreCase(type)){
            return new Apple();
        }else if ("b".equalsIgnoreCase(type)){
            return new Huawei();
        }
        return product;
    }

}

class Apple extends Product{
    @Override
    public void methodDiff() {
        System.out.println("苹果");
    }
}

class Huawei extends Product{
    @Override
    public void methodDiff() {
        System.out.println("华为");
    }
}

class Client{
    public static void main(String[] args) {
        Product a = SimpleFactory.getProduct("a");
        a.methodSame();
        a.methodDiff();
        Product b = SimpleFactory.getProduct("b");
        b.methodSame();
        b.methodDiff();
    }
}




