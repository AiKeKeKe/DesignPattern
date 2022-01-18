package com.aike.creationalpatterns.factorymethod;

/**
 * 具体产品windows
 */
public class WindowsButton implements Button{
    @Override
    public void render() {
        System.out.println("windows-button");
        onClick();

    }

    @Override
    public void onClick() {
        System.out.println("hello windows");
    }
}
