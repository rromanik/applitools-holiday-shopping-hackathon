package com.applitools.applifashion.pages;

import com.applitools.applifashion.pages.ui.AbstractGuiElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class ProductGrid extends AbstractGuiElement {

    @FindBy(css = ".grid_item")
    private List<WebElement> gritItems;

    public ProductGrid(WebElement root) {
        super(root);
    }

    public List<ProductGridItem> getItems() {
        return gritItems
                .stream()
                .map(ProductGridItem::new)
                .collect(toList());
    }

    public void selectItemByName(String itemName) {
        findItem(itemName).click();
    }

    private ProductGridItem findItem(String itemName) {
        return getItems()
                .stream()
                .filter(
                        item -> itemName.equals(item.getName()))
                .findFirst()
                .orElseThrow(() -> noSuchItemException(itemName));
    }

    private RuntimeException noSuchItemException(String itemName) {
        return new RuntimeException("There is no product item with name: " + itemName);
    }

}
