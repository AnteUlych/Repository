package sender.logic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SenderProperties {
	
	private static final String SEPARATOR = ":";
	private static final int INFORMATION_AT_PROPERTIES = 1;
	private static final int MAIL = 0;
	private static final int PASSWORD = 1;

	
	private String getProperties(){
		String properties ="";
	try {
		InputStream is = this.getClass().getResourceAsStream("/sender.properties");
        BufferedReader file = new BufferedReader(new InputStreamReader(is));;
		String temp ="";
		
		String [] settings;
		try {
			for(;(temp=file.readLine())!=null;){

				settings = temp.split(SEPARATOR); 
				properties = properties+settings[INFORMATION_AT_PROPERTIES]+SEPARATOR;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	} catch (IOException e) {
		e.printStackTrace();
	}
	return properties;
	}
	 private String getData(int request){
		 String data[];
		 data = getProperties().split(SEPARATOR);
		return data[request];
	 }
	 public String getMail(){
		 return getData(MAIL);
	 }
	 public String getPassword(){
		 return getData(PASSWORD);
	 }
}
