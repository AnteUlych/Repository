package bird;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class Simulator {
	
	
	public Simulator(WebDriver driver) {
		this.driver = driver;
	}
	
	WebDriver driver;
	//Actions action = new Actions(driver);
	
	public boolean start(){
		
		driver.get(Constants.GOOGLE);
		waiting(Constants.MIN_WAITING, Constants.MAX_WAITING);
		
		WebElement googleTextBox = driver.findElement(By.id(Constants.GOOGLE_TEXT_BOX));
		waiting(Constants.MIN_WAITING, Constants.MAX_WAITING);

		typing(googleTextBox, Order.FIRST_TARGET);
		waiting(Constants.MIN_WAITING, Constants.MAX_WAITING);
		
		//boolean botBanned = driver.findElements(By.id(Constants.DENIAL)).size()>0;
		boolean botBanned = driver.findElements(By.id(Constants.GOOGLE_TEXT_BOX)).size()==0;
		if(botBanned){
			return false;
		}
		return true;// add method of searching deepSearch();
	}


	private void typing(WebElement element, String text) {
		
		String [] textForBot = text.split("");
		
		for(int index = 0; index<textForBot.length; index++){
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
