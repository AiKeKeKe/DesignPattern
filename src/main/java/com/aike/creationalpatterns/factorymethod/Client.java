package com.aike.creationalpatterns.factorymethod;

/**
 * 工厂方法模式是一种创建型设计模式， 其在父类中提供一个创建对象的方法， 允许子类决定实例化对象的类型。
 * https://refactoringguru.cn/design-patterns
 */
public class Client {
    public static void main(String[] args) {
        Dialog dialog =null;
        String type = "window";
        if (type.equals("windows")) {
            dialog = new WindowsDialog();
        } else {
            dialog = new MacosDialog();
        }
        dialog.renderWindow();
    }
}
