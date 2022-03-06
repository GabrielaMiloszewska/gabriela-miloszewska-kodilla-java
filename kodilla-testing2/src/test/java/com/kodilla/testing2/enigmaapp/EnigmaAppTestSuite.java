package com.kodilla.testing2.enigmaapp;

import com.kodilla.testing2.config.WebDriverConfig;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;

public class EnigmaAppTestSuite {
    public static final String BASE_URL = "http://rekrutacja.tests.enigma.com.pl/";
    public static final String XPATH_LOG_IN = "//div[contains(@class, \"collapse navbar-collapse\")]/ul/li[2]/a";
    public static final String XPATH_LOG_OUT = "//div[contains(@class, \"collapse navbar-collapse\")]/ul/li[4]/a";
    public static final String ID_NUMBER = "5432";
    public static final String DATE = "2022-02-15";
    public static final String DEL_DATE = "2022-02-18";
    public static final String USER_NAME = "xxx";
    public static final String USER_ADDRESS = "yyyy";
    public static final String NIP = "12345";
    public static final String PRODUCT = "ddddddddddddd";
    public static final String NET_PRICE = "100";
    public static final String PRODUCT_QUANTITY = "1";
    public static final String VAT_PER = "23";
    private WebDriver driver;

    @BeforeEach
    public void initTests() {
        driver = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX);
        Objects.requireNonNull(driver).get(BASE_URL);

        driver.findElement(By.xpath(XPATH_LOG_IN)).click();

        driver.findElement(By.id("id_username")).sendKeys("Automat");
        driver.findElement(By.id("id_password")).sendKeys("Testy2022");
        driver.findElement(By.xpath("/html/body/div/form/button")).submit();
    }

    @AfterEach
    public void endTests() {
        WebElement addButton = driver.findElement(By.xpath("/html/body/div/form/button"));
        addButton.click();

        WebElement logout = driver.findElement(By.xpath(XPATH_LOG_OUT));
        logout.click();
    }

    private String createInvoice() throws InterruptedException {
        String invoiceNumber = ID_NUMBER.concat("/2022");
        Thread.sleep(1000);

        WebElement addInvoice = driver.findElement(By.xpath("//div[contains(@class, \"collapse navbar-collapse\")]/ul/li[3]/a"));
        addInvoice.click();

        WebElement id = driver.findElement(By.xpath("//div[contains(@id, \"div_id_numer\")]/div/input"));
        id.sendKeys(ID_NUMBER);
        Thread.sleep(1000);

        WebElement issueDate = driver.findElement(By.xpath("//div[contains(@id, \"div_id_data_wystawienia\")]/div/input"));
        issueDate.sendKeys(DATE);
        WebElement deliveryDate = driver.findElement(By.xpath("//div[contains(@id, \"div_id_data_dostawy\")]/div/input"));
        deliveryDate.sendKeys(DEL_DATE);

        while(!driver.findElement(By.xpath("//div[contains(@id, \"div_id_forma_platnosci\")]/div/select")).isDisplayed());
        WebElement selectCombo = driver.findElement(By.xpath("//div[contains(@id, \"div_id_forma_platnosci\")]/div/select"));
        Select selectOption = new Select(selectCombo);
        selectOption.selectByIndex(2);

        WebElement user = driver.findElement(By.xpath("//div[contains(@id, \"div_id_nabywca\")]/div/textarea"));
        user.sendKeys(USER_NAME);

        WebElement address = driver.findElement(By.xpath("//div[contains(@id, \"div_id_nabywca_adres\")]/div/textarea"));
        address.sendKeys(USER_ADDRESS);

        WebElement nipN = driver.findElement(By.xpath("//div[contains(@id, \"div_id_nabywca_nip\")]/div/input"));
        nipN.sendKeys(NIP);
        Thread.sleep(1000);

        WebElement productName = driver.findElement(By.xpath("//table[@class=\"table\"]/tbody/tr[1]/td[1]/input[3]"));
        productName.sendKeys(PRODUCT);
        WebElement netPrice = driver.findElement(By.xpath("//table[@class=\"table\"]/tbody/tr[1]/td[2]/input"));
        netPrice.sendKeys(NET_PRICE);
        WebElement quantity = driver.findElement(By.xpath("//table[@class=\"table\"]/tbody/tr[1]/td[3]/input"));
        quantity.sendKeys(PRODUCT_QUANTITY);
        WebElement vat = driver.findElement(By.xpath("//table[@class=\"table\"]/tbody/tr[1]/td[4]/input"));
        vat.sendKeys(VAT_PER);
        Thread.sleep(1000);

        return invoiceNumber;
    }

    private boolean checkWhetherInvoiceExists(String invoiceNumber) {
        driver.navigate().refresh();
        WebElement allInvoices = driver.findElement(By.xpath("//div[contains(@class, \"collapse navbar-collapse\")]/ul/li[2]/a"));
        allInvoices.click();
        while(!driver.findElement(By.xpath("//td[3]")).isDisplayed());

        boolean result = driver.findElements(By.xpath("//td[3]")).stream()
                .anyMatch(theTd -> theTd.getText().equals(invoiceNumber));

        return result;
    }

    private int howManyInvoicesWereCreatedWithTheSameNo(String invoiceNumber) {
        driver.navigate().refresh();
        WebElement allInvoices = driver.findElement(By.xpath("//div[contains(@class, \"collapse navbar-collapse\")]/ul/li[2]/a"));
        allInvoices.click();

        while(!driver.findElement(By.xpath("//td[3]")).isDisplayed());

        int createdInvoices = Math.toIntExact(driver.findElements(By.xpath("//td[3]")).stream()
                .filter(theTd -> theTd.getText().equals(invoiceNumber))
                .count());

        return createdInvoices;
    }

    @DisplayName("Test showing that the program creates an invoice with the given number")
    @Test
    public void shouldCreateInvoice() throws InterruptedException {
        String invoiceNumber = createInvoice();
        assertTrue(checkWhetherInvoiceExists(invoiceNumber));
    }

    @DisplayName("Test showing that the program works incorrectly" +
            " and adds an invoice with a number that already exists")
    @Test
    public void shouldNotCreateInvoiceWithTheSameNumber() throws InterruptedException {
        String invoiceNumber = createInvoice();
        int createdInvoices = howManyInvoicesWereCreatedWithTheSameNo(invoiceNumber);
        int expectedResult = 1;
        assertNotEquals(expectedResult, createdInvoices);
        System.out.println("The program creates: " + createdInvoices + " invoice(s)");
    }

}
