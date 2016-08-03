package fsmac.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FormService {

	private String questionsFile = "/questions.txt";
	private String encoding = "Cp1251";
	
	public List<String> getQuestions() {
		
		List<String> list = new ArrayList<>();
		try {
			InputStream is = this.getClass().getResourceAsStream(
					questionsFile);
			BufferedReader file = new BufferedReader(new InputStreamReader(is, encoding));
			
			String temp = "";
			
			try {
				for (; (temp = file.readLine()) != null;) {
				list.add(temp);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
}
