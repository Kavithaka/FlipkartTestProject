package SeleniumDemo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

@Test
public class Flipkartsearch {
	

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
	  
		
	    //search product iphone
	          @Test
	       public void test2() {
	        WebElement searchBox=driver.findElement(By.xpath("//input[@title=\"Search for Products, Brands and More\"]"));
	                 searchBox.sendKeys("Iphone under 50000",Keys.ENTER);
	                 String expectedTitle="Iphone Under 50000- Buy Products Online at Best Price in India - All Categories | Flipkart.com";
	       SoftAssert softAssert = new SoftAssert();
	        String actualTitle = driver.getTitle();
	        softAssert.assertEquals(expectedTitle, actualTitle,"Search results are not appropriate");
	        String actualProductPrice = driver.findElement(By.xpath("(//div[@class=\"_30jeq3 _1_WHN1\"])[1]")).getText();
	        int exceptedTotalPrice =500000;
	        System.out.println(actualProductPrice.substring(1).replace(',', '0'));
	        int price=Integer.valueOf(actualProductPrice.substring(1).replace(',', '0'));
	        if(price>exceptedTotalPrice)
	        {
	        softAssert.assertTrue(false);
	        }
	        softAssert.assertAll(); 
	       
	       }
	   @AfterTest
	   public void tearDown()
	   {
	    
	    driver.quit();
	   }
}
	

	
			
	


			
	


