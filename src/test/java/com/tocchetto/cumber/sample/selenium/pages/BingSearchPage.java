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
public class BingSearchPage extends WebDriverPage implements SearchPage {

	@FindBy(name = "q")
	private WebElement searchBox;
	
	@FindBy(css = "#b_results h2 a")
	private List<WebElement> searchResults;
	
	public void open() {
		getDriver().get("https://www.bing.com");
	}
	
	public void search(String input) {
		searchBox.sendKeys(input);
		searchBox.submit();
		new WebDriverWait(getDriver(), 10)
			.until(ExpectedConditions.titleContains(input));
	}

	public List<String> viewResults() {
		return searchResults.stream()
				.map(element -> element.getText())
				.collect(Collectors.toList());
	}

}