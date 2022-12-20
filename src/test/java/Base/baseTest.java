package Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;

public class baseTest {
	public static WebDriver driver;
	public static Properties pro= new Properties();
	public static Properties loc= new Properties();

	@BeforeMethod
	public void setUp() throws IOException {
		if (driver==null) {
		FileInputStream input = new FileInputStream(
				System.getProperty("user.dir")+"\\src\\test\\resources\\configFiles\\config.properties");
		pro.load(input);
		FileInputStream input1 = new FileInputStream(
				System.getProperty("user.dir")+"\\src\\test\\resources\\configFiles\\locator.properties");
		loc.load(input1);
		}

		if (pro.getProperty("browser").equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(pro.getProperty("baseUrl"));

		} else if (pro.getProperty("browser").equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get(pro.getProperty("baseUrl"));
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}
}
