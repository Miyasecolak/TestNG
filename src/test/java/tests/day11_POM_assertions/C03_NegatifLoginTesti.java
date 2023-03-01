package tests.day11_POM_assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QdPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_NegatifLoginTesti {

    // qd anasayfaya gidin
// 3 test method'u olusturun ve
// asagidaki durumlarda giris yapilamadigini test edin
// 1- gecerli username, gecersiz password
// 2- gecersiz username, gecerli password
// 3- gecersiz username, gecersiz password
    QdPage qdPage = new QdPage();

    @Test
    public void negatifLogin() {

        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        qdPage.ilkloginLinki.click();
        qdPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
        qdPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecersizPassword"));
        qdPage.loginButonu.click();
        Assert.assertTrue(qdPage.emailKutusu.isEnabled());
        Driver.closeDriver();
    }

}
