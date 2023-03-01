package tests.day11_POM_assertions;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ZeroPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C06_softAssert {
//    1. “http://zero.webappsecurity.com/” Adresine gidin
// 2. Sign in butonuna basin
// 3. Login kutusuna “username” yazin
// 4. Password kutusuna “password” yazin
// 5. Sign in tusuna basin
// 6. Online banking menusu icinde Pay Bills sayfasina gidin
// 7. “Purchase Foreign Currency” tusuna basin
// 8. “Currency” drop down menusunden Eurozone’u secin
// 9. soft assert kullanarak "Eurozone (euro)" secildigini test edin
// 10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin "Select One", "Australia (dollar)",
// "Canada (dollar)","Switzerland (franc)","China (yuan)","Denmark (krone)","Eurozone (euro)",
// "Great Britain (pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand (dollar)",
// "Sweden (krona)","Singapore (dollar)","Thailand (baht)"

    @Test
    public void webappTesti(){
        Driver.getDriver().get(ConfigReader.getProperty("zeroUrl"));
        ZeroPage zeroPage=new ZeroPage();
        zeroPage.signInButonu.click();
        zeroPage.usernameKutusu.sendKeys("username");
        zeroPage.passwordKutusu.sendKeys("password");
        zeroPage.signInSubmitButonu.click();
        Driver.getDriver().navigate().back();
        zeroPage.onlineBanking.click();
        zeroPage.payBillLinki.click();
        zeroPage.purchaseFCButonu.click();
        Select select=new Select(zeroPage.currencyDropdown);
        select.deselectByVisibleText("Eurozone");
        SoftAssert softassert=new SoftAssert();
        String expectedSecim="Eurozone (euro)";
        String actualSecim=select.getFirstSelectedOption().getText();
        softassert.assertEquals(actualSecim,expectedSecim,"dropdownda eurozone secili degil");
    }


}
