package com.testinium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import org.junit.Assert;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;



public class ControlTest extends FirsTest {

    @Test
    public void Test() throws InterruptedException {

        driver.get("https://www.gittigidiyor.com/uye-girisi");

        clickXpath("//div[@data-cy='header-user-menu']");
        Thread.sleep(2000);
        clickXpath("//a[@data-cy='header-login-button']");
        Thread.sleep(2000);
        sendByXpath("//div[@class=\"gg-d-24 gg-m-24 posr\"]/div[2]","emelsimsek782@gmail.com");
        Thread.sleep(2000);
        sendByXpath("//div[@class=\"normal-login gg-label gg-d-24 padding-none\"]","125258e");
        clickId("gg-login-enter");

        List<WebElement> control = driver.findElements(By.xpath("//span[@class='gg-m-24 gg-t-24 gg-d-24 gg-w-24 gg-input-error-text']"));
        if(control.size() == 0){
            fail("Şifre Hatalı Değil");
        }

        assertTrue(driver.getPageSource().contains("Geçersiz kullanıcı adı ve/veya şifre."));
        Assert.assertEquals("Üye Girişi - GittiGidiyor", driver.getTitle());
        Assert.assertEquals("Üye Girişi", driver.getTitle());
        Assert.assertNotNull(driver.getTitle());


    }


}

