package com.tocchetto.cumber.sample.steps;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import com.tocchetto.cumber.sample.selenium.pages.DefaultPage;
import com.tocchetto.cumber.sample.selenium.pages.WebDriverPage;

import cucumber.api.Scenario;
import cucumber.api.java.AfterStep;
import cucumber.api.java.Before;

/**
 * @author Marcelo Tocchetto
 */
public class HookSteps {
	
	@Inject @DefaultPage
	private Instance<WebDriverPage> page;
	
	private WebDriverPage getPage() {
		return page.get();
	}
	
	@Before
	public void beforeScenario() {
		getPage().maximizeWindow();
	}
	
	@AfterStep
	public void afterStep(Scenario scenario){
		if (scenario.isFailed()) {
			byte[] screenshot = getPage().takeScreenshot();
			scenario.embed(screenshot, "image/png");
		}
	}

}