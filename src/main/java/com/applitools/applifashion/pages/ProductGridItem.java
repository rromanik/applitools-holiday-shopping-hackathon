package com.applitools.applifashion.pages;

import com.applitools.applifashion.pages.ui.AbstractGuiElement;
import com.applitools.applifashion.pages.ui.Label;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductGridItem extends AbstractGuiElement {

    @FindBy(css = "a>h3")
    private WebElement nameLabel;

    public ProductGridItem(WebElement element) {
        super(element);;
    }

    public Label nameLabel() {
        return new Label(nameLabel);
    }

    public String getName() {
        return nameLabel().getText();
    }

}

