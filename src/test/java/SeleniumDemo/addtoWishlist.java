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
@Test
public class addtoWishlist {
	WebDriver driver;
	@BeforeTest
	public void setup() {
		 WebDriverManager.edgedriver().setup();
		   WebDriver driver = new EdgeDriver();
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4000));
    	driver.get("https://www.flipkart.com/");
	}
	@Test
	   public void test4() {
    	WebElement searchBox1 = driver .findElement(By.name("q"));
    	searchBox1.sendKeys("Women Viscose rayon kurta pant set");
    	searchBox1.submit();
    	WebElement productLink = driver .findElement(By.cssSelector("a._1fQZEK"));
    	productLink.click();
    	WebElement addToWishlistButton = driver.findElement(By.xpath("//button[contains(text(),'Add to Wishlist')]"));
    		addToWishlistButton.click();
    		WebElement wishlistIcon = driver.findElement(By.className("Wishlist"));
    		Assert.assertTrue(wishlistIcon.isDisplayed(),"product was not added to the wishlist!");
    	
	}
	 @AfterTest
	   public void tearDown()
	   {
	    
	    driver.quit();
	   }

}
