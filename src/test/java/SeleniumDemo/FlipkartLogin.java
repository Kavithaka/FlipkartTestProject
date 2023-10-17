package SeleniumDemo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipkartLogin{
 WebDriver driver;
	
@BeforeTest
public void setup()
{
 WebDriverManager.edgedriver().setup();
    driver = new EdgeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4000));
    driver.get("https://www.flipkart.com/");
    driver.manage().window().maximize();
 }
	
  @Test
  public void test1() throws Exception
  {   
       
        WebElement emailField = driver.findElement(By.xpath("(//input[@type=\"text\"])[2]"));
         emailField .sendKeys("9908789159") ;
         WebElement otpRequestButton = driver.findElement(By.xpath("//button[contains(text(), 'Request OTP')]"));
             otpRequestButton.click(); 
             Thread.sleep(20000);
             WebElement userprofile =driver.findElement(By.xpath("//span[text()='Account']"));
      Assert.assertTrue(userprofile.isDisplayed(),"Login was unsucessful");
   }
   
    
   @AfterTest
   public void tearDown()
   {
    driver.close();
   }

 }

    
     
  
 




