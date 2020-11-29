package com.applitools.applifashion.pages;

import com.applitools.applifashion.pages.ui.AbstractGuiElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FilterOption extends AbstractGuiElement {
    private static final String SELECTED_COLOR = "rgba(0, 77, 218, 1);";

    @FindBy(css = ".checkmark")
    private WebElement checkmark;

    public FilterOption(WebElement root) {
        super(root);
    }

    private boolean isSelected() {
        String backgroundColor = checkmark.getCssValue("background-color");
        return SELECTED_COLOR.equalsIgnoreCase(backgroundColor);
    }

    public void makeSelected() {
        if(!isSelected())
            checkmark.click();
    }

}
