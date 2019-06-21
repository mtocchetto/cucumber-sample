package com.tocchetto.cumber.sample.selenium.pages;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Marcelo Tocchetto
 */
@DefaultPage
public class WebDriverPage {

	@Inject
	private Instance<WebDriver> driver;

	@PostConstruct
	private void postConstruct() {
		PageFactory.initElements(getDriver(), this);
	}
	
	protected WebDriver getDriver() {
		return driver.get();
	}
	
	public byte[] takeScreenshot() {
		return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
	}
	
	public void maximizeWindow() {
		getDriver().manage().window().maximize();
	}

}