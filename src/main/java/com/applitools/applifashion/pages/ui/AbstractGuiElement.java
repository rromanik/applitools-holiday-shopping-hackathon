package com.applitools.applifashion.pages.ui;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class AbstractGuiElement {
	private final SearchContext root;

	protected AbstractGuiElement(WebElement root) {
		this.root = root;
		PageFactory.initElements(new DefaultElementLocatorFactory(root), this);
	}

	public void click() {
		getWrappedElement().click();
	}

	public WebElement getWrappedElement() {
		return (WebElement) root;
	}

}
