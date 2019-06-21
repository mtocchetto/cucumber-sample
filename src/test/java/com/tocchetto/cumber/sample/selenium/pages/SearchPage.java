package com.tocchetto.cumber.sample.selenium.pages;

import java.util.List;

/**
 * @author Marcelo Tocchetto
 */
public interface SearchPage {

	public void open();
	
	public void search(String input);

	public List<String> viewResults();

}