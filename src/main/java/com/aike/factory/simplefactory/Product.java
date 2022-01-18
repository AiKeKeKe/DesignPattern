package com.aike.factory.simplefactory;

public abstract class Product {
    public void methodSame(){
        System.out.println("欢迎");
    }

    public abstract void methodDiff();
}
