import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static CompanyController compCont;

    public static void main(String[] args) {
        start();

    }
    public static void start(){
        compCont = new CompanyController();
        compCont.run();
    }

}