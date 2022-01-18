package com.aike.creationalpatterns.factorymethod;

/**
 * 基础创建者
 */
public abstract class Dialog {

    public void renderWindow(){
        Button button = createButton();
        button.render();
    }

    abstract Button createButton();
}
