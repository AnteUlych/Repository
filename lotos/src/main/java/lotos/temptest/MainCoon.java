package lotos.temptest;

import lotos.logic.DataController;

public class MainCoon {

	public static void main(String[] args) {
		
		System.out.println("class start");
		DataController data = new DataController();
	
		boolean w = data.isCodeInRequestExist("124");
		boolean w1 = data.isMailInRequestExist("satru@i.ua");
		
		System.out.println(w+" "+w1);
		System.out.println("class end");
	}

}
