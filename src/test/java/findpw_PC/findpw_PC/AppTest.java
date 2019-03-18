package findpw_PC.findpw_PC;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.screenshot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.codeborne.selenide.WebDriverRunner;

public class AppTest extends pushbullet_login {
	public static WebDriver driver;

	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		WebDriverRunner.setWebDriver(driver);
	}

	@Test
	public void findID() throws Exception {
		open("https://front.wemakeprice.com/user/find/pw");
		Mclick();

		$(By.xpath("//div[2]/div/a/span")).click();

		$(By.id("_name")).sendKeys("이승재");
		$(By.id("_id")).sendKeys("wmtest04@yopmail.com");
		$(By.id("_phone")).sendKeys("01026989109");

		$(By.xpath("//span[contains(.,'인증번호 발송')]")).click();
		Pb();
		$(By.xpath("//span[contains(.,'확인')]")).click();

		$(By.id("_password")).sendKeys("qwer1234");
		$(By.id("_pwConfirm")).sendKeys("qwer1234");

		$(By.xpath("//span[contains(.,'확인')]")).click();
	}

	@AfterMethod
	public void end() {
		screenshot("account");
	}
}
