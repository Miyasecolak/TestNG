package tests.day11_POM_assertions;

import org.openqa.selenium.Keys;
import org.testng.asserts.SoftAssert;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C05_SoftAssert {

    public void amazonTesti() {

        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        String expectedIcerik = "amazon";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(actualUrl.contains(expectedIcerik),"url amazon icermiyor");

        AmazonPage amazonPage =new AmazonPage();
        amazonPage.aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

//        String expectedIcerik = "Nutella";
        String actualAramasonucYazisi = amazonPage.aramaSonucElementi.getText();
        softAssert.assertTrue(actualAramasonucYazisi.contains(expectedIcerik));

        String actualIlkUrun = amazonPage.ilkUrunIsimElementi.getText();

        softAssert.assertAll();
        Driver.closeDriver();

    }
}
