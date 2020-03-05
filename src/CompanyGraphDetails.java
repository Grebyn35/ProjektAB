import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CompanyGraphDetails {
    public void getAbNamePrice() {

        //Oanvändbar i stunden, denna klass kommer användas vid själva handlandet

        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "C:/Users/ellio/OneDrive/Desktop/Chromemapp/chromedriver.exe");
        driver.get("https://www.avanza.se/aktier/om-aktien.html/843896/fluicell");
        WebElement elementLastPrice = driver.findElement(By.cssSelector(".roundCorners3.pushBox"));
        WebElement elementName = driver.findElement(By.cssSelector(".marginBottom10px.large"));
        System.out.println(elementLastPrice.getText());
        System.out.println(elementName.getText());
    }
}