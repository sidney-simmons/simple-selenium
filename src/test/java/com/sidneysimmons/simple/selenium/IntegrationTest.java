package com.sidneysimmons.simple.selenium;

import java.time.Duration;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Example integration tests using JUnit and Selenium.
 * 
 * @author Sidney Simmons
 */
public class IntegrationTest {

    private static WebDriver webDriver;
    private static WebDriverWait webDriverWait;

    /**
     * Configure the web driver objects before the tests begin.
     */
    @BeforeClass
    public static void setUpBeforeClass() {
        webDriver = new ChromeDriver();
        webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(10).toMillis());
    }

    /**
     * Close the web driver when the tests are finished.
     */
    @AfterClass
    public static void tearDownAfterClass() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }

    /**
     * Test a search for "turtle socks".
     * 
     * @throws InterruptedException thrown if something crazy happens
     */
    @Test
    public void findTurtleSocks() throws InterruptedException {
        searchAndSelectOne("turtle socks");
    }

    /**
     * Test a search for "beekeeper barbie".
     * 
     * @throws InterruptedException thrown if something crazy happens
     */
    @Test
    public void findBeekeeperBarbie() throws InterruptedException {
        searchAndSelectOne("beekeeper barbie");
    }

    /**
     * Test a search for "hershey kisses".
     * 
     * @throws InterruptedException thrown if something crazy happens
     */
    @Test
    public void findHersheyKisses() throws InterruptedException {
        searchAndSelectOne("hershey kisses");
    }

    /**
     * Navigate to the Amazon home page, search using the given query, and click on one of the product
     * images.
     * 
     * @param searchQuery the search query
     * @throws InterruptedException thrown if something crazy happens
     */
    private void searchAndSelectOne(String searchQuery) throws InterruptedException {
        // Navigate to the home page and initiate a search
        webDriver.get("https://www.amazon.com/");
        WebElement siteSearchBar = webDriver.findElement(By.name("site-search"));
        WebElement siteSearchInput = siteSearchBar.findElement(By.name("field-keywords"));
        siteSearchInput.sendKeys(searchQuery + Keys.ENTER);

        // Click a product
        WebElement firstProductInList = webDriverWait
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-image-index]")));
        firstProductInList.click();
        Thread.sleep(3000);
    }

}
