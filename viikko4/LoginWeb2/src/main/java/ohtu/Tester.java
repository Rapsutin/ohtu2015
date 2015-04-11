package ohtu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Tester {
    public static void main(String[] args) {
        WebDriver driver = new HtmlUnitDriver();

        driver.get("http://localhost:8090");
        System.out.println( driver.getPageSource() );
        WebElement element = driver.findElement(By.linkText("register new user"));       
        element.click(); 
        
        System.out.println("==");
        
        System.out.println( driver.getPageSource() );
        element = driver.findElement(By.name("username"));
        element.sendKeys("ppekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("11akkepp");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("11akkepp");
        element = driver.findElement(By.name("add"));
        element.submit();
        
        driver.get("http://localhost:8090/ohtu");
        
        System.out.println("==");
        
        System.out.println(driver.getPageSource());
        
        System.out.println("==");
        
        element = driver.findElement(By.linkText("logout"));
        element.click();
        
        System.out.println("==");
        System.out.println( driver.getPageSource() );
        
    }
}
