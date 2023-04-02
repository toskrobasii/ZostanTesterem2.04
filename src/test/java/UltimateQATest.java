import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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

}
