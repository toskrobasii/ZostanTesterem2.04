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

}
