package com.aike.factory.factorymethod;

/**
 * 问题：
 *   简单工厂模式虽然简单，但存在一个很严重的问题。
 *   当系统中需要引入新产品时，由于静态工厂方法通过所传入参数的不同来创建不同的产品，这必定要修改工厂类的源代码，将违背“开闭原则”，
 *   如何实现增加新产品而不影响已有代码？工厂方法模式应运而生，本文将介绍第二种工厂模式——工厂方法模式。
 */

import com.aike.factory.simplefactory.Product;

/**
 * 定义：
 *  工厂方法模式(Factory Method Pattern)：定义一个用于创建对象的接口，让子类决定将哪一个类实例化。
 *  工厂方法模式让一个类的实例化延迟到其子类。工厂方法模式又简称为工厂模式(Factory Pattern)，
 *  又可称作虚拟构造器模式(Virtual Constructor Pattern)或多态工厂模式(Polymorphic Factory Pattern)。
 *  工厂方法模式是一种类创建型模式。
 *  在工厂方法模式中，我们不再提供一个统一的工厂类来创建所有的产品对象，而是针对不同的产品提供不同的工厂，
 *  系统提供一个与产品等级结构对应的工厂等级结构。
 */
public class FactoryMethod {
    public static void main(String[] args) {
        Factory factory;
        Product product;
        factory = new FileFactory();
        product = factory.createProduct();
        product.methodDiff();
        factory = new DataFactory();
        product = factory.createProduct();
        product.methodDiff();
    }
}


class FileProduct extends Product{
    @Override
    public void methodDiff() {
        System.out.println("FileProduct");
    }
}
class DataFactory implements Factory{
    @Override
    public Product createProduct() {
        return new DataProduct();
    }
}
class DataProduct extends Product{
    @Override
    public void methodDiff() {
        System.out.println("DataProduct");
    }
}
class FileFactory implements Factory{
    @Override
    public Product createProduct() {
        return new FileProduct();
    }
}
