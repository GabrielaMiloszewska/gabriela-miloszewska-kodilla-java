package com.kodilla.testing2.rekrutacja;
import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class EnigmaTask2 {
    public static final String BASE_URL = "http://rekrutacja.tests.enigma.com.pl/";
    public static final String XPATH_LOG_IN = "//div[contains(@class, \"collapse navbar-collapse\")]/ul/li[2]/a";
    public static final String XPATH_LOG_OUT = "//div[contains(@class, \"collapse navbar-collapse\")]/ul/li[4]/a";
    public static final String ID_NUMBER = "22022";
    public static final String DATE = "2022-02-15";
    public static final String USER_NAME = "xxx";
    public static final String USER_ADDRESS = "yyyy";
    public static final String NIP = "12345";
    public static final String NET_PRICE = "100";
    public static final String PRODUCT_QUANTITY = "1";
    public static final String VAT_PER = "23";

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX);
        driver.get(BASE_URL);
        driver.findElement(By.xpath(XPATH_LOG_IN)).click();

        driver.findElement(By.id("id_username")).sendKeys("Automat");
        driver.findElement(By.id("id_password")).sendKeys("Testy2022");
        driver.findElement(By.xpath("/html/body/div/form/button")).submit();
        Thread.sleep(500);

        WebElement addInvoice = driver.findElement(By.xpath("//div[contains(@class, \"collapse navbar-collapse\")]/ul/li[3]/a"));
        addInvoice.click();

        WebElement id = driver.findElement(By.xpath("//div[contains(@id, \"div_id_numer\")]/div/input"));
        id.sendKeys(ID_NUMBER);
        Thread.sleep(500);

        WebElement issueDate = driver.findElement(By.xpath("//div[contains(@id, \"div_id_data_wystawienia\")]/div/input"));
        issueDate.sendKeys(DATE);

        while(!driver.findElement(By.xpath("//div[contains(@id, \"div_id_forma_platnosci\")]/div/select")).isDisplayed());
        WebElement selectCombo = driver.findElement(By.xpath("//div[contains(@id, \"div_id_forma_platnosci\")]/div/select"));
        Select selectOption = new Select(selectCombo);
        selectOption.selectByIndex(2);

        WebElement deliveryDate = driver.findElement(By.xpath("//div[contains(@id, \"div_id_data_dostawy\")]/div/input"));
        deliveryDate.sendKeys("2022-02-18");

        WebElement user = driver.findElement(By.xpath("//div[contains(@id, \"div_id_nabywca\")]/div/textarea"));
        user.sendKeys(USER_NAME);

        WebElement address = driver.findElement(By.xpath("//div[contains(@id, \"div_id_nabywca_adres\")]/div/textarea"));
        address.sendKeys(USER_ADDRESS);

        WebElement nip = driver.findElement(By.xpath("//div[contains(@id, \"div_id_nabywca_nip\")]/div/input"));
        nip.sendKeys(NIP);
        Thread.sleep(500);

        WebElement productName = driver.findElement(By.xpath("//table[@class=\"table\"]/tbody/tr[1]/td[1]/input[3]"));
        productName.sendKeys("ddddddddddddd");
        WebElement netPrice = driver.findElement(By.xpath("//table[@class=\"table\"]/tbody/tr[1]/td[2]/input"));
        netPrice.sendKeys(NET_PRICE);
        WebElement quantity = driver.findElement(By.xpath("//table[@class=\"table\"]/tbody/tr[1]/td[3]/input"));
        quantity.sendKeys(PRODUCT_QUANTITY);
        WebElement vat = driver.findElement(By.xpath("//table[@class=\"table\"]/tbody/tr[1]/td[4]/input"));
        vat.sendKeys(VAT_PER);
        Thread.sleep(500);

        //WebElement addButton = driver.findElement(By.xpath("/html/body/div/form/button"));
        //addButton.click();

        //WebElement logout = driver.findElement(By.xpath(XPATH_LOG_OUT));
        //logout.click();
    }


    /*
    private String whatIsTaxIdNumber(String invoiceNumber) {
        driver.navigate().refresh();
        WebElement allInvoices = driver.findElement(By.xpath("//div[contains(@class, \"collapse navbar-collapse\")]/ul/li[2]/a"));
        allInvoices.click();

        while (!driver.findElement(By.xpath("//a")).isDisplayed());

        driver.findElements(By.xpath("//tr")).stream()
                .filter(theTr -> theTr.findElement(By.xpath("//td[3]")).getText().equals(invoiceNumber))
                .forEach(theTd -> {
                    WebElement invoiceDetails = theTd.findElement(By.xpath("//td[8]/a"));
                    invoiceDetails.click();
                });
        String taxIdNumber = driver.findElement(By.xpath("/html/body/div/div[1]/text()[2]")).getText();

        return taxIdNumber;
    } */
}
