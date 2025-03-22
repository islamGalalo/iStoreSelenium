package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.github.javafaker.Faker;

public class loginTest
{
  public static WebDriver driver ;

    public static void main(String[] args) {
       driver = new ChromeDriver() ;
       driver.navigate().to("https://www.itoucheg.com/");
       
       driver.findElement(By.partialLinkText("Login")).click();
       // register
       Faker faker = new Faker();
       String email = faker.internet().emailAddress(); 
        driver.findElement(By.id("reg_email")).sendKeys(email);
        driver.findElement(By.id("reg_password")).sendKeys("12345678");
        driver.findElement(By.xpath("//button[text()='Register']")).click();
        // login
        // driver.findElement(By.id("username")).sendKeys("isla222m@gmail.com"); 
        // driver.findElement(By.id("password")).sendKeys("12345678");
        // driver.findElement(By.xpath("//button[text()='Log in']")).click();
        // search
       WebElement search =  driver.findElement(By.id("woocommerce-product-search-field-0"));  
        search.sendKeys("iPhone 16");
        search.submit();
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@name='orderby']")));
        dropdown.selectByValue("popularity");

        //select product
        driver.findElement(By.xpath("//img[@alt='AirPods (2nd generation)']")).click();
        //add to cart
        driver.findElement(By.xpath("//button[text()='Add to cart']")).click();
        //view cart
        driver.findElement(By.xpath("//a[text()='View cart']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//a[text()='AirPods (2nd generation)']")).getText(), "AirPods (2nd generation)");

        //checkout
        driver.findElement(By.xpath("//a[text()='Proceed to checkout']")).click();
    }
}
