package SeleniumDemo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

@Test
public class buyproduct {
	WebDriver driver;
    @BeforeTest

	public void setup() {
	 WebDriverManager.edgedriver().setup();
	   WebDriver driver = new EdgeDriver();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4000));
		driver.get("https://www.flipkart.com/");
    }
    
    //buyproduct
     public void test3(){
    	 
    	WebElement searchBox = driver .findElement(By.name("q"));
    	searchBox.sendKeys("smartwatch");
    	searchBox.submit();
    	WebElement addTocartButton = driver.findElement(By.xpath("//button[contains(text(),'Add to Cart')]"));
    	addTocartButton.click();
    	SoftAssert softAssert1 = new SoftAssert();
    	softAssert1.assertTrue(driver.getTitle().contains("shopping cart"), "Title does not contain 'shopping cart'");
    	softAssert1.assertAll();
    	
}
     @AfterTest
	   public void tearDown()
	   {
	    
	    driver.quit();
	   }
}