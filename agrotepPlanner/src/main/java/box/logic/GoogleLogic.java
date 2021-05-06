package box.logic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class GoogleLogic {

	public static final String API_KEU = "AIzaSyDvzr8p07fENAftZAumRG2tdfOE8VJQDwE";

	public int calculateDistanceInKmBetweenCoordinates(Double longitudeFrom,
			Double latitudeFrom, Double longitudeTo, Double latitudeTo) {

		try {

			String requestUrl = "https://maps.googleapis.com/maps/api/distancematrix/json?units=metric&origins="
					+ longitudeFrom
					+ ","
					+ latitudeFrom
					+ "&destinations="
					+ longitudeTo + "," + latitudeTo + "&key=" + API_KEU;

			URL url = new URL(requestUrl);
			URLConnection connection = url.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
			String inputLine;
			String resultURL = "";
			
			while ((inputLine = in.readLine()) != null) {
				System.out.println(inputLine);
				if (inputLine.contains("value")) {
					resultURL = inputLine;
					break;
				}
			}
			in.close();

			resultURL = resultURL.replaceAll("\\s+", "").replaceAll(
					"\"value\":", "");

			int distance = Integer.parseInt(resultURL);
			int kilimetrs = distance / 1000;

			return kilimetrs;

		} catch (Exception e) {
			return 0;
		}
	}

}
