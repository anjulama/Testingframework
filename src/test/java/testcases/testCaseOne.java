package testcases;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.baseTest;

public class testCaseOne extends baseTest {
	
	
	@DataProvider(name = "Login")
	public Object[][] dataset() {
		return new Object[][] { { "standard_user", "secret_sauce" },
			{ "locked_out_user", "secret_sauce" },
				{ "problem_user", "secret_sauce" },
				{ "performance_glitch_user", "secret_sauce" } 
				};

	}
	@Test(dataProvider = "Login")
	public static void login(String username, String password) {
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector(loc.getProperty("username"))).sendKeys(username);
		driver.findElement(By.cssSelector(loc.getProperty("password"))).sendKeys(password);
		driver.findElement(By.cssSelector(loc.getProperty("login_button"))).click();

	}
	@Test
	public static void CountItems() {
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector(loc.getProperty("username"))).sendKeys("standard_user");
		driver.findElement(By.cssSelector(loc.getProperty("password"))).sendKeys("secret_sauce");
		driver.findElement(By.cssSelector(loc.getProperty("login_button"))).click();
		
		List<WebElement> items= driver.findElements(By.className("inventory_item_name"));
		System.out.println(items.size());
		
	
	}
	@Test
	public static void GetTitle() {
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector(loc.getProperty("username"))).sendKeys("standard_user");
		driver.findElement(By.cssSelector(loc.getProperty("password"))).sendKeys("secret_sauce");
		driver.findElement(By.cssSelector(loc.getProperty("login_button"))).click();

		String title = driver.getTitle();
		System.out.println(title);
		
	}

}
