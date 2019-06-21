package com.tocchetto.cumber.sample.selenium.config;

import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Singleton;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
/**
 * @author Marcelo Tocchetto
 * @see <a href="https://cucumber.io/docs/guides/browser-automation/">Cucumber - Browser Automation</a> 
 * @see <a href="https://docs.jboss.org/weld/reference/2.4.4.Final/en-US/html_single/#_the_singleton_pseudo_scope">Weld - The singleton pseudo-scope</a> 
 */
public class WebDriverFactory {

	@Produces
	@Singleton
	public WebDriver createWebDriver() {
		String browser = System.getProperty("browser", "firefox");
		switch (browser) {
		case "firefox":
			return new FirefoxDriver();
		case "chrome":
			return new ChromeDriver();
		default:
			throw new RuntimeException("Unsupported browser: " + browser);
		}
	}

	public void close(@Disposes WebDriver driver) {
		driver.quit();
	}

}