package box.logic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class RuptelaLogic {
	
	public int getKmFromRuptela(String dateStart, String dateFinish, String truckKey){
		
		int startKm = this.getMileageFromRuptela(dateStart, truckKey);
		int finishKm = this.getMileageFromRuptela(dateFinish, truckKey);
		
		int km = finishKm-startKm;
		
		if(km<0){
			km = 1;
		}
		
		return km;
		
	}
	
	public int getMileageFromRuptela(String date, String truckKey){
		
		try {

			String requestUrl = "https://api.fm-track.com/objects/"+truckKey+"/coordinates?version=2&from_datetime="+date+"T00:00:01.000Z&to_datetime="+date+"T03:00:01.000Z&api_key=A82MBFH6QijEY1RnKTkDL-u3uqdm9nJS";

			URL url = new URL(requestUrl);
			URLConnection connection = url.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
			String inputLine;
			String text = "";
			
			while ((inputLine = in.readLine()) != null) {
			//	System.out.println(inputLine);
				text=text+inputLine;
			}
			in.close();
			

			String deleteTextBefore = text.substring(text.indexOf("virtual_gps_odometer\":")+22);
			String resultText = deleteTextBefore.substring(0, deleteTextBefore.indexOf("."));
			
			int km = Integer.parseInt(resultText); 
			return km;
					
		} catch (Exception e){
			return 0;
		}
		
	}
	
	public String getLocation(String truckKey) {
		
		try {
		String requestUrl = "https://api.fm-track.com/object-coordinates-stream?version=3&object_id="+truckKey+"&api_key=A82MBFH6QijEY1RnKTkDL-u3uqdm9nJS";
		
		URL url = new URL(requestUrl);
		URLConnection connection = url.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(
				connection.getInputStream()));
		String inputLine = in.readLine();

		//	System.out.println(inputLine); //test
			
			String deleteTextBefore = inputLine.substring(inputLine.indexOf("region\":")+9);
			String region = deleteTextBefore.substring(0, deleteTextBefore.indexOf("\""));
			
			if(region.length()==0) {
				
				deleteTextBefore = inputLine.substring(inputLine.indexOf(",\"county\":")+11);
				region = deleteTextBefore.substring(0, deleteTextBefore.indexOf("\""));
				
			};
			
		//	String deleteTextBefore1 = inputLine.substring(inputLine.indexOf(",\"county\":")+11);
		//	String oblast = deleteTextBefore1.substring(0, deleteTextBefore1.indexOf("\""));

		//	System.out.println(region+" "+oblast); //test

		in.close();
	
		return region;
		} catch (Exception e){
			return "";
		}
	}

}
