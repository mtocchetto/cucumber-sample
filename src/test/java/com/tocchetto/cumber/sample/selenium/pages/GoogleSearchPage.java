package com.tocchetto.cumber.sample.selenium.pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Marcelo Tocchetto
 */
public class GoogleSearchPage extends WebDriverPage implements SearchPage {

	@FindBy(name = "q")
	private WebElement searchBox;

	@FindBy(css = "#search a h3")
	private List<WebElement> searchResults;

	public void open() {
		getDriver().get("https://www.google.com");
	}

	public void search(String input) {
		searchBox.sendKeys(input);
		searchBox.submit();
		new WebDriverWait(getDriver(), 10).until(ExpectedConditions.titleContains(input));
	}

	public List<String> viewResults() {
		return searchResults.stream().map(element -> element.getText()).collect(Collectors.toList());
	}

}