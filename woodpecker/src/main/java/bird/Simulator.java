package bird;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Simulator {

	public Simulator(WebDriver driver) {
		this.driver = driver;
	}

	WebDriver driver;
	int attempt;

	public boolean start() {

		driver.get(Constants.GOOGLE);
		waiting(Constants.MIN_WAITING, Constants.MAX_WAITING);

		WebElement googleTextBox = driver.findElement(By
				.id(Constants.GOOGLE_TEXT_BOX));
		waiting(Constants.MIN_WAITING, Constants.MAX_WAITING);

		typing(googleTextBox, Order.WORD);
		waiting(Constants.MIN_WAITING, Constants.MAX_WAITING);

		boolean botBanned = driver.findElements(
				By.id(Constants.GOOGLE_TEXT_BOX)).size() == 0;
		if (botBanned) {
			return false;
		}

		return deepSearch();
	}

	private boolean deepSearch() {
		attempt++;
		scrollingImitation();
		boolean result;
		String lottery;
		String text = "";

		List<WebElement> link = driver.findElements(By.tagName("a"));

		for (WebElement finding : link) {
			lottery = finding.getAttribute("href");

			if (lottery == null) {
				lottery = "notforusingjustforsubstitutionofnull";
			}
			if (lottery.contains(Constants.GOOGLE_ACCOUNT)) {
				continue;
			}
			System.out.println(lottery); // delete
			if (lottery.contains(Order.TARGET)) {
				finding.click();
				targetSurfing();
				targetSurfing();
				targetSurfing();
				return true;
			}
		}

		WebElement googleTextBox = driver.findElement(By
				.id(Constants.GOOGLE_TEXT_BOX));
		if (attempt == 1) {
			text = " " + Order.TARGET;
		} else {
			googleTextBox.clear();
			text = Order.TARGET;
		}
		typing(googleTextBox, " " + text);
		waiting(Constants.MIN_WAITING, Constants.MAX_WAITING);
		result = deepSearch();

		return result;
	}

	private void targetSurfing() {
		waiting(Constants.MIN_WAITING, Constants.MAX_WAITING);
		String choice = Order.STROLL[(int) (Math.random() * Order.STROLL.length)];
		waiting(Constants.MIN_WAITING, Constants.MAX_WAITING);
		scrollingImitation();
		
		String lottery;
		List<WebElement> link = driver.findElements(By.tagName("a"));
		
		for (WebElement finding : link) {
			lottery = finding.getAttribute("href");
			if (lottery == null) {
				lottery = "notforusingjustforsubstitutionofnull";
			}
			System.out.println(lottery); // delete
			if (lottery.contains(choice)) {	
				finding.click();
				waiting(Constants.MIN_WAITING, Constants.MAX_WAITING);
				scrollingImitation();
				break;
			}
		}
	}

	private void scrollingImitation() {
		JavascriptExecutor jsx = (JavascriptExecutor) driver;
		jsx.executeScript("window.scrollBy(0," + (int) (Math.random() * 1400)
				+ ")", "");
		waiting(Constants.MIN_WAITING, Constants.MAX_WAITING);
		jsx.executeScript("window.scrollBy(0,"
				+ (0 - (int) (Math.random() * 700)) + ")", "");
	}

	private void typing(WebElement element, String text) {

		String[] textForBot = text.split("");

		for (int index = 0; index < textForBot.length; index++) {
			element.sendKeys(textForBot[index]);
			waiting(Constants.MIN_TYPING, Constants.MAX_TYPING);
		}

		element.sendKeys(Keys.ENTER);

	}

	private void waiting(int min, int max) {

		int time = min + (int) (Math.random() * max);
		System.out.println("waiting " + time + " ms...");
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
