package com.testinium;

import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class FirsTest {
    public WebDriver driver;
    public String BaseUrl="https://www.gittigidiyor.com/";

    @Before
    public void start(){
        System.setProperty("webserver.chrome.driver","C\"C:\\Users\\Emel\\IdeaProjects\\ProjeTestinium\\drivers\\chromedriver.exe\"");
        this.driver=new ChromeDriver();
        this.driver.get(BaseUrl);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    public void clickXpath(String xpath){
        driver.findElement(By.xpath(xpath)).click();
    }

    public void clickId(String id){
        driver.findElement(By.id(id)).click();
    }
    public void sendByXpath(String xpath,String key){
        driver.findElement(By.xpath(xpath)).sendKeys(key);
    }
    public void Product(String product) throws InterruptedException {

        sendByXpath("//div[@data-cy='header-search-input']","bilgisayar");
        clickId("header-search-find-link");
        List<WebElement> products=driver.findElements(By.xpath("//div[@class='clearfix']//ul//li//a[@class='product-link']"));
        Random rd=new Random();
        int rdProduct=rd.nextInt(48);
        products.get(rdProduct).click();
        Thread.sleep(2000);
        clickXpath("//div[@id=\"sp-addbasket-button\"]//form//button//span[@class=\'action-text\']");
        Thread.sleep(3000);
    }

    @After
    public void tearDown()
    {
        this.driver.quit();
    }
}

