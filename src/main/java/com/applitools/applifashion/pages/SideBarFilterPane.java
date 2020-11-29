package com.applitools.applifashion.pages;

import com.applitools.applifashion.pages.ui.AbstractGuiElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Optional;

public class SideBarFilterPane extends AbstractGuiElement {

	@FindBy(css = ".container_check")
	private List<WebElement> filterCheckmarks;

	@FindBy(id = "filterBtn")
	private WebElement filterButton;

	public SideBarFilterPane(WebElement root) {
		super(root);
	}

	public void filter() {
		filterButton.click();
	}

	public void filter(String filterCriteria) {
		select(filterCriteria);
		filter();
	}

	public SideBarFilterPane select(String filter) {
		Optional<WebElement> foundFilter = findFilter(filter);
		if (!foundFilter.isPresent())
			throw new IllegalArgumentException("There is not such filter option: <" + filter + ">");
		new FilterOption(foundFilter.get()).makeSelected();
		return this;
	}

	private Optional<WebElement> findFilter(String filter) {
		return filterCheckmarks
				.stream()
				.filter(
						f -> f.getText().startsWith(filter))
				.findFirst();
	}

}
