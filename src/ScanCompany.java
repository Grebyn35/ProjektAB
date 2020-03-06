import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class ScanCompany {
    static List<String> tempCompanyName = new ArrayList<String>();
    static List<WebElement> cmpLastPrice = new ArrayList<WebElement>();
    static List<WebElement> showMore = new ArrayList<WebElement>();
    static ArrayList<String> cmpNameFinal = new ArrayList<>();
    static ArrayList<String> cmpLastPriceFinal = new ArrayList<String>();



    public void getList(){

        System.setProperty("webdriver.chrome.driver","C:/Users/Grebyn/Desktop/Tjena/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.avanza.se/sidan-kraver-inloggning.html");
        WebElement logInClick = driver.findElement(By.xpath("/html/body/aza-app/div/main/div/aza-authentication-required/div/aza-card/div[1]/aza-login/div/aza-toggle-switch-view/div/aza-bank-id/form/div[1]/div[2]/input"));
        logInClick.sendKeys("9906060919");

        //login

        WebElement logInButton = driver.findElement(By.xpath("/html/body/aza-app/div/main/div/aza-authentication-required/div/aza-card/div[1]/aza-login/div/aza-toggle-switch-view/div/aza-bank-id/form/div[1]/div[2]/button[1]"));
        logInButton.click();
        try {
            Thread.sleep(10000);
        }catch (InterruptedException e){

        }

        //Get list of Stocks
        driver.get("https://www.avanza.se/aktier/lista.html");
        //driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div[5]/div/div[5]/div[3]/button")).click();


        //Get names and values of stocks
        WebElement result = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div[5]/div/div[3]/label/span"));
        //String[] resultNumber = result.getText().split(" ");
        //int currentHits = Integer.parseInt(resultNumber[0]);
        //System.out.println(currentHits);
        while(true) {
            System.out.println("Adding values...\n");
            for (int i = 0; i < 100; i++) {
                WebElement companyName = driver.findElement(By.xpath("//*[@id=" + i + "]/td[2]/a"));
                WebElement companyValue = driver.findElement(By.xpath("//*[@id=" + i + "]/td[1]/span"));

                if (tempCompanyName.contains(companyName.getText())) {
                    Company.companyList.get(i).addValue(companyValue.getText());
                } else {
                    tempCompanyName.add(companyName.getText());
                    Company company = new Company(companyName.getText());
                    Company.companyList.get(i).addValue(companyValue.getText());
                }

            }
            System.out.println(Company.companyList.toString());
            try {
                Thread.sleep(5000);
            }catch (InterruptedException e){

            }
        }


    }





}