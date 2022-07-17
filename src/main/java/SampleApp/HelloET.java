package SampleApp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloET {
    public static void main(String[] args) {
        System.out.println("Hello ET. This project is for selenium: https://www.selenium.dev/");

         System.setProperty("webdriver.chrome.driver","C:\\Users\\enlem\\Downloads\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://google.com");
        driver.quit();
    }
}
