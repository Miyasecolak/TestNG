package tests.day11_POM_assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QdPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_PozitifLoginTesti {
    @Test
    public void pozitifLoginTesti(){
        //qd anasayfaya gidin.Gecerli kullanici adi ve password ile giris yapin.Basarili bir sekilde giris yapildigini test edin
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        QdPage qdPage= new QdPage();
        qdPage.ilkloginLinki.click();

        qdPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
        qdPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));
        qdPage.loginButonu.click();
        Assert.assertTrue(qdPage.basariliGirisElementi.isDisplayed());

        Driver.closeDriver();



    }
}
