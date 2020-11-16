package br.com.seleniumtesting;

import org.junit.After;
import org.junit.Test;

import br.com.seleniumtesting.browser.Browser;
import br.com.seleniumtesting.browser.BrowserType;
import br.com.seleniumtesting.modelpage.google.ResultPage;
import br.com.seleniumtesting.modelpage.google.SearchPage;

public class SeleniumTest {

    private final Browser browser;

    public SeleniumTest() {
        this.browser = Browser.getInstance(BrowserType.CHROME, "src/test/resources/driver/chromedriver");
//        this.browser = Browser.getInstance(BrowserType.FIREFOX, "src/test/resources/driver/geckodriver");
    }

    @After
    public void after() {
        browser.getDriver().quit();
    }

    @Test
    public void searchForMaiorTorcidaDoMundoOnGooglePageThenReturnFlamengo() {

        SearchPage page = new SearchPage(browser.getDriver());
        page.isLoaded();

        ResultPage resultPage = page.searchFor("Time de maior torcida do mundo");
        resultPage.isLoaded();
        resultPage.containsResult("Flamengo", "Clube de Regatas do Flamengo");
    }

    @Test
    public void searchForTimeDeBambiOnGooglePageThenReturnSaoPaulo() {

        SearchPage page = new SearchPage(browser.getDriver());
        page.isLoaded();

        ResultPage resultPage = page.searchFor("Time de bambi");
        resultPage.isLoaded();
        resultPage.containsResult("São Paulo");
    }
}
