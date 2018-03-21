package bird;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class Fox {

	public void snoop() {

		File torProfileDir = new File(Constants.TOR_PROFILE);
		FirefoxBinary binary = new FirefoxBinary(new File(Constants.BROWSER));
		FirefoxProfile torProfile = new FirefoxProfile(torProfileDir);
		torProfile.setPreference("webdriver.load.strategy", "unstable");
		try {
			binary.startProfile(torProfile, torProfileDir, "");
		} catch (IOException e) {
			e.printStackTrace();
		}

		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("network.proxy.type", 1);
		profile.setPreference("network.proxy.socks", "127.0.0.1");
		profile.setPreference("network.proxy.socks_port", 9150);

		System.setProperty("webdriver.gecko.driver", Constants.DRIVER);

		WebDriver driver = new FirefoxDriver(profile);
		

		Simulator robot = new Simulator(driver);
		boolean isSucceed = robot.start();
		
		if(!isSucceed){
			System.out.println("Status - failed simulation.");
		}else{
			System.out.println("Status - succeed simulation.");
			makeStatistic();
		}
		
		hide(); 

	}

	private void makeStatistic() {
		File file = new File(Order.STATISTIC);
		if(!file.exists()){
			try (PrintWriter out = new PrintWriter(Order.STATISTIC)) {
			    out.println("0");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

		}
		
		int number = 0;
		
		try(BufferedReader br = new BufferedReader(new FileReader(Order.STATISTIC))) {
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		        sb.append(line);
		        line = br.readLine();
		    }
		    String statistic = sb.toString();
		    number = Integer.parseInt(statistic);
		    number++;
		    
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		try (PrintWriter out = new PrintWriter(Order.STATISTIC)) {
		    out.println(number);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	private void hide() {
		
		 Runtime rt = Runtime.getRuntime();

		    try {
		        rt.exec("taskkill /F /IM firefox.exe");
		        while (processIsRunning("firefox.exe")) {
		            Thread.sleep(100);
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		}

		private boolean processIsRunning(String process) {
		    boolean processIsRunning = false;
		    String line;
		    try {
		        Process proc = Runtime.getRuntime().exec("wmic.exe");
		        BufferedReader input = new BufferedReader(new InputStreamReader(proc.getInputStream()));
		        OutputStreamWriter oStream = new OutputStreamWriter(proc.getOutputStream());
		        oStream.write("process where name='" + process + "'");
		        oStream.flush();
		        oStream.close();
		        while ((line = input.readLine()) != null) {
		            if (line.toLowerCase().contains("caption")) {
		                processIsRunning = true;
		                break;
		            }
		        }
		        input.close();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		    return processIsRunning;
		}

	}
