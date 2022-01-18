package com.aike.creationalpatterns.factorymethod;

/**
 * 具体的产品macos
 */
public class MacosButton implements Button{
    @Override
    public void render() {
        System.out.println("macos-button");
        onClick();
    }

    @Override
    public void onClick() {
        System.out.println("hello macos");
    }
}
