package com.aike.creationalpatterns.factorymethod;

/**
 * 具体创建者macos
 */
public class MacosDialog extends Dialog{
    @Override
    Button createButton() {
        return new MacosButton();
    }
}
