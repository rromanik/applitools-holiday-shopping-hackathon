package com.applitools.applifashion.pages.ui;

import org.openqa.selenium.WebElement;

public class Label extends AbstractGuiElement {

    public Label(WebElement element) {
        super(element);
    }

    public String getText() {
        return getWrappedElement().getText();
    }

}
