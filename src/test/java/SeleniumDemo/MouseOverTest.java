package SeleniumDemo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseOverTest {
     public static WebDriver driver;
	public static void main(String[] args)  {
	
		 WebDriverManager.edgedriver().setup();
		   WebDriver driver = new EdgeDriver();
		   driver.get("https://www.flipkart.com/");
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		   driver.manage().window().maximize();	
           WebElement fashionCategory = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div/div/div[1]/div/div[1]/div/div[2]/div[1]/div/div[1]/div/div/div/div/div[1]/a[5]/div/div/span/span]"));
             Actions action = new Actions(driver);
             action.moveToElement(fashionCategory).build().perform();
             //subcatergory Electronics
             WebElement subCategory = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/span[1]"));
             subCategory.click();
           
           
           
           
           
}
}