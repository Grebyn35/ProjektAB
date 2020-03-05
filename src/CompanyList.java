import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CompanyList {
    static List<WebElement> cmpName = new ArrayList<WebElement>();
    static List<WebElement> cmpLastPrice = new ArrayList<WebElement>();
    static ArrayList<String> cmpNameFinal = new ArrayList<>();
    static ArrayList<String> cmpLastPriceFinal = new ArrayList<String>();



    public void getList(){
        Date currentDate = new Date();
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
        String date = timeFormat.format(currentDate);

        System.out.println(date);
        System.setProperty("webdriver.chrome.driver","C:/Users/Grebyn/Desktop/Tjena/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.avanza.se/aktier/lista.html");

        for(int i = 1; i<1;i++) {
            try {
                driver.findElement(By.xpath("//button[contains(text(),'\n" +
                        "\t\t\t+ Visa fler\n" +
                        "\t\t')]")).click();
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }

        //while(//time == 08:00:00-18:00:00) {
        cmpName = driver.findElements(By.cssSelector("a.ellipsis"));
        cmpLastPrice = driver.findElements(By.cssSelector("span.pushBox"));
        for (WebElement webElement : cmpName) {
            cmpNameFinal.add(webElement.getText());
        }
        for (WebElement webElement : cmpLastPrice) {
            cmpLastPriceFinal.add(webElement.getText());
        }
        //}
    }
    public void logIn(){
        System.setProperty("webdriver.chrome.driver","C:/Users/Grebyn/Desktop/Tjena/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.avanza.se/sidan-kraver-inloggning.html");
        WebElement logInClick = driver.findElement(By.xpath("/html/body/aza-app/div/main/div/aza-authentication-required/div/aza-card/div[1]/aza-login/div/aza-toggle-switch-view/div/aza-bank-id/form/div[1]/div[2]/input"));
        logInClick.sendKeys("9906060919");
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){

        }
        WebElement logInButton = driver.findElement(By.xpath("/html/body/aza-app/div/main/div/aza-authentication-required/div/aza-card/div[1]/aza-login/div/aza-toggle-switch-view/div/aza-bank-id/form/div[1]/div[2]/button[1]"));
        logInButton.click();
        System.out.println("Waiting for BankID login");
    }

}