import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class Assignment {


    public static void main(String[] args) throws InterruptedException {




     System.setProperty("webdriver.chrome.driver","/Users/afaggadimova/Desktop/untitled folder/driver/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("http://qa-duotify.us-east-2.elasticbeanstalk.com/register.php");

        String actualTitle= driver.getTitle();
        String expectedTitle="Welcome to Duotify!";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15000));
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        Thread.sleep(4000);
        driver.findElement(By.id("hideLogin")).click();
       int b= (int) ((int)3+Math.random()*999);
        driver.findElement(By.name("username")).sendKeys("Afonya"+b);
        driver.findElement(By.name("firstName")).sendKeys("Afa");

        driver.findElement(By.id("lastname")).sendKeys("Gadimova");
        int a= (int) ((int)3+Math.random()*999);
        driver.findElement(By.name("email")).sendKeys("afa"+a+"gadimova"+a+"@gmail.com");
        driver.findElement(By.name("email2")).sendKeys("afa"+a+"gadimova"+a+"@gmail.com");
        Thread.sleep(4000);
        driver.findElement(By.name("password")).sendKeys("Gadimova16");
        driver.findElement(By.name("password2")).sendKeys("Gadimova16");

        driver.findElement(By.name("registerButton")).click();
        String actualUrl= driver.getPageSource();
        String expectedUrl="http://qa-duotify.us-east-2.elasticbeanstalk.com/browse.php?";
       Assert.assertFalse(actualUrl.contains(expectedUrl));

        String username=driver.findElement(By.id("nameFirstAndLast")).getText();

        Assert.assertTrue(username.contains("Afa Gadimova"));
        Thread.sleep(2000);
       driver.findElement(By.id("nameFirstAndLast")).click();
        Thread.sleep(2000);
       username= driver.findElement(By.className("userInfo")).getText();
        Assert.assertTrue(username.contains("Afa Gadimova"));
        Thread.sleep(2000);
        driver.findElement(By.id("rafael")).click();

        actualUrl=driver.getPageSource();
        expectedUrl="http://qa-duotify.us-east-2.elasticbeanstalk.com/register.php";
       Assert.assertFalse(actualUrl.contains(expectedUrl));
       Thread.sleep(2000);
       driver.findElement(By.id("loginUsername")).sendKeys("Afonya"+b);
        driver.findElement(By.id("loginPassword")).sendKeys("Gadimova16");
       driver.findElement(By.name("loginButton")).click();
       String title= driver.getTitle();
       Assert.assertFalse(title.contains("You Might Also Like"));
        driver.findElement(By.id("nameFirstAndLast")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("rafael")).click();
        driver.quit();






    }

}
