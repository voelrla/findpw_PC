package findpw_PC.findpw_PC;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.Selenide.switchTo;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;

import com.codeborne.selenide.SelenideElement;

public class pushbullet_login {
	public void Pb() throws AWTException {
		opentab();

		sleep(2000);
		switchTo().window(1); // 탭 이동
		open("https://www.pushbullet.com/#sms/ujEUBotXlYqsjAcQMJtx24/19"); // pushbullet.com 이동

		$(By.id("sign-in-btn")).click();
		$(By.xpath("//div[@id='onecup']/div[2]/div[2]/button")).click();

		$(By.id("identifierId")).sendKeys("voelrla4");
		sleep(2000);
//			enter();
		$(By.xpath("//div[@id='identifierNext']/content")).click();

		$(By.name("password")).sendKeys("!Q@W3e4r");
		$(By.xpath("//div[@id='passwordNext']/content/span")).click();

		sleep(10000);
		$(By.xpath("//div[@id='sink']/div[2]/div/div/div[5]/div")).click(); // Text

		SelenideElement sms = $(By.xpath("//div[@id='sidebar']/div[6]"));
		String smstext = sms.getText(); // SMS문자 추출
		String smsnumber = getNumber(smstext); // 받아온 문자에서 숫자만 추출
		String snumber = smsnumber.substring(8, 14); // 뒷 6자리만 추출
//			System.out.println(snumber); //받아온 텍스트 출력
		closetab();
		switchTo().window(0); // 첫번째 탭으로 전환
		$(By.id("_findAgr")).sendKeys(snumber);

	}

	public static void Mclick() throws Exception {
		Robot robot = new Robot();

		// SET THE MOUSE X Y POSITION
		robot.mouseMove(300, 550);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
	}

	public static void opentab() throws AWTException {
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_T);
	}

	public static void closetab() throws AWTException {
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_W);
	}

	public static String getNumber(String code) {
		return code.replaceAll("[^0-9]", "");
	}

}