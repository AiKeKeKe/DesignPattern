package com.aike.creationalpatterns.factorymethod;

/**
 * 具体创建者windows
 */
public class WindowsDialog extends Dialog{

    @Override
    Button createButton() {
        return new WindowsButton();
    }
}
