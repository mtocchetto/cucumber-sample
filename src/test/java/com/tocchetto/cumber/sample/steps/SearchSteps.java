package com.tocchetto.cumber.sample.steps;

import java.util.List;

import javax.inject.Inject;

import org.junit.Assert;

import com.tocchetto.cumber.sample.selenium.pages.BingSearchPage;
import com.tocchetto.cumber.sample.selenium.pages.GoogleSearchPage;
import com.tocchetto.cumber.sample.selenium.pages.SearchPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author Marcelo Tocchetto
 */
public class SearchSteps {
	
	@Inject
	private GoogleSearchPage googleSearchPage;
	
	@Inject
	private BingSearchPage bingSearchPage;
	
	private SearchPage getSearchPage(String target) {
		return "google".equals(target) ? googleSearchPage : bingSearchPage;
	}
	
	@Given("que ao acessar o site do {string}")
	public void openPage(String searchPage) {
		getSearchPage(searchPage).open();
	}

	@When("eu pesquisar no {string} por {string}")
	public void executeSearch(String searchPage, String text) {
		getSearchPage(searchPage).search(text);
	}

	@Then("nos resultados do {string} deve existir o item {string}")
	public void validateSearchResults(String searchPage, String expectedResult) {
		List<String> foundResults = getSearchPage(searchPage).viewResults();
		Assert.assertTrue("Deveria encontrar o resultado: " + expectedResult, foundResults.contains(expectedResult));
	}
	
}