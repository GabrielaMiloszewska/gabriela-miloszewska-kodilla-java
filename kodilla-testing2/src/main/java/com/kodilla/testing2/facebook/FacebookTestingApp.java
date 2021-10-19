package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {

    public static final String XPATH_COOKIE = "//div[contains(@class, \"_9xo5\")]/button[2]";
    public static final String XPATH_NEW_ACCOUNT = "//div[contains(@class, \"_6ltg\")]/a";
    public static final String XPATH_DAY = "//div[contains(@class, \"_5k_5\")]/span/span/select[1]";
    public static final String XPATH_MONTH = "//div[contains(@class, \"_5k_5\")]/span/span/select[2]";
    public static final String XPATH_YEAR = "//div[contains(@class, \"_5k_5\")]/span/span/select[3]";

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX);
        driver.get("https://www.facebook.com/");

        Thread.sleep(700);
        while (!driver.findElement(By.xpath(XPATH_COOKIE)).isDisplayed());
        WebElement cookie = driver.findElement(By.xpath(XPATH_COOKIE));
        cookie.click();

        Thread.sleep(700);
        while (!driver.findElement(By.xpath(XPATH_NEW_ACCOUNT)).isDisplayed());
        WebElement newAccountButton = driver.findElement(By.xpath(XPATH_NEW_ACCOUNT));
        newAccountButton.click();

        Thread.sleep(700);
        while (!driver.findElement(By.xpath(XPATH_DAY)).isDisplayed());
        WebElement day = driver.findElement(By.xpath(XPATH_DAY));
        Select selectDay = new Select(day);
        selectDay.selectByValue("15");

        Thread.sleep(700);
        while (!driver.findElement(By.xpath(XPATH_MONTH)).isDisplayed());
        WebElement month = driver.findElement(By.xpath(XPATH_MONTH));
        Select selectMonth = new Select(month);
        selectMonth.selectByIndex(2);

        Thread.sleep(700);
        while (!driver.findElement(By.xpath(XPATH_YEAR)).isDisplayed());
        WebElement year = driver.findElement(By.xpath(XPATH_YEAR));
        Select selectYear = new Select(year);
        selectYear.selectByValue("1987");
    }
}
