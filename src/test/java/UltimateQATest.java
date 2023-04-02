import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

// modyfikatory dostępu: public, private, protected w Java - hermetyzacja w Java (enkapsulacja)
public class UltimateQATest extends PageSetup {


    // zwracanie z funkcji: jakis typ, void - nic nie zwraca
    @Test
    public void testOne() {
        WebElement buttonUsingId = driver.findElement(By.id("idExample"));
        buttonUsingId.click();

//        driver.findElement(By.id("idExample")).click(); - rownowazne liniom 12-13

        // Jbehave - notacja Gherkin: Given, When, Then, kryteria akceptacji
        WebElement buttonSuccessText = driver.findElement(By.className("entry-title"));
        Assertions.assertEquals("Button success", buttonSuccessText.getText());
    }

    // dopisac przypadki testowe na button using ClassName i Name

    @Test
    public void testTwo() throws InterruptedException {
        // sposoby na wyszukiwanie elementów przez Selenium: xpath, className, id, selektory CSS
        WebElement nameInput = driver.findElement(By.id("et_pb_contact_name_0"));
        nameInput.sendKeys("Tester");

        WebElement emailInput = driver.findElement(By.id("et_pb_contact_email_0"));
        emailInput.sendKeys("tester@tester.pl");

        Thread.sleep(2000);

        // waity w Selenium: implicit wait, explicit wait, fluent wait i Thread.sleep(2000)
        WebElement emailMeButton = driver.findElement(By.name("et_builder_submit_button"));
        emailMeButton.click();

        Thread.sleep(2000);
        // ogólna postać xpath:     //*[]
        // odbijanie się od elementów: //*[@class='']/p     / - jeden poziom    // - 1 poziom i więcej
        WebElement thanksText = driver.findElement(By.xpath("//div[@class='et-pb-contact-message']/p"));
        Assertions.assertEquals("Thanks for contacting us", thanksText.getText());
    }

    //assertTrue(webElement.isDisplayed)
    //assertTrue(webElement.isSelected)

    @Test
    public void testThree() {

        //róźnica pomiędzy List, a ArrayList
        List<String> listOfCars = new ArrayList<>();
        // skrót Ctrl + D - kopiowanie linii
        listOfCars.add("volvo");
        listOfCars.add("saab");
        listOfCars.add("opel");
        listOfCars.add("audi");

        // xpath wyszukiwanie po tekscie:  //div[text()='Select an option and validate that it is selected']
        WebElement dropdown = driver.findElement(By.xpath("//div[text()='Select an option and validate that it is selected']"));

        for(int i = 0 ; i < listOfCars.size(); i++) {
            dropdown.click();

            WebElement dropdownOption = driver.findElement(By.xpath("//option[@value='" + listOfCars.get(i) +"']"));
            dropdownOption.click();
            // import static Assertions
            Assertions.assertTrue(dropdownOption.isSelected());
            Assertions.assertEquals(listOfCars.get(i), dropdownOption.getText().toLowerCase());
        }

        //równoważne:

        for (String listOfCar : listOfCars) {
            dropdown.click();

            WebElement dropdownOption = driver.findElement(By.xpath("//option[@value='" + listOfCar + "']"));
            dropdownOption.click();
            // import static Assertions
            Assertions.assertTrue(dropdownOption.isSelected());
            Assertions.assertEquals(listOfCar, dropdownOption.getText().toLowerCase());
        }
    }

    @Test
    public void testFour() {
        //assertTrue(webElement.isHighlighted())

        // postać xpath gdzie zawiera wyrażenie      //*[contains(@class, 'et_pb_module et_pb_cta_0 et_pb_prom')]
        WebElement blueField = driver.findElement(By.xpath("//*[contains(@class, 'et_pb_module et_pb_cta_0 et_pb_prom')]"));
        Assertions.assertTrue(blueField.isDisplayed());
        // zamiana HEX na RGB

        Assertions.assertEquals("rgba(46, 163, 242, 1)", blueField.getCssValue("background-color"));
    }

}
