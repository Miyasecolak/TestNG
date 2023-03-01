package tests.day11_POM_assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class C04_HardAssert_SoAssert {
    @Test
    public void hardAssertion() {
        Assert.assertTrue(15 > 8);
        Assert.assertFalse(8 == 9);
        Assert.assertEquals(5, 5);
        Assert.assertNotEquals(6, 8);
    }

    @Test
    public void softAssertionTesti() {

        /*
        JUnit'deki Assert class'i TstNG de de vardir.Ancak bir test metodunda birden fazla failed olan assertion
        varsa ilk failed olan assertion da calismayi durdurup exception firlattigindan tum hatayi
        bir defada gorup hepsini duzeltme sansimiz olmaz.
        TESTNG bunu asmak icin SoftNG class indan bir obje olusturup testleri yapar.

         */
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(15 > 8 ,"True testi failed");
        softAssert.assertFalse(8 == 9);
        softAssert.assertEquals(5, 5);
        softAssert.assertNotEquals(6, 8);

        softAssert.assertAll();


    }
}