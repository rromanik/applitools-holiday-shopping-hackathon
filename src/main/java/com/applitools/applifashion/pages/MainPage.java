package com.applitools.applifashion.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.applitools.applifashion.pages.AppliFashionApp.getDriver;

public class MainPage {

	@FindBy(id = "product_grid")
	private WebElement productGrid;

	@FindBy(id = "filter_col")
	private WebElement sideBarFilter;

	@FindBy(css = ".clearfix .open_filters")
	private WebElement openFiltersButton;

	public MainPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public SideBarFilterPane sideBarFilterPane() {
		return new SideBarFilterPane(this.sideBarFilter);
	}

	public ProductGrid productGrid() {
		return new ProductGrid(this.productGrid);
	}

	public MainPage filterBy(String filterCriteria) {
		openFilters();
		sideBarFilterPane().filter(filterCriteria);
		return this;
	}

	public void openFilters() {
		if(!sideBarFilter.isDisplayed())
			openFiltersButton.click();
		WebDriverWait wait = new WebDriverWait(getDriver(), 3);
		wait.until(d -> sideBarFilter.isDisplayed());
	}

}
