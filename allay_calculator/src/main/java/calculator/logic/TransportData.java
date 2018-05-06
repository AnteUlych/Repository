package calculator.logic;

import java.util.ArrayList;
import java.util.List;

public class TransportData {

	public String createTheRoute(String fob, String fot){
		
		String route = "";
		List<String> sea = loadSeaData();
		for(String port:sea){		
			if(port.contains(fob)){
				route = route.concat(port);
			}
		}
		List<String> road = loadRoadData();
		for(String wh:road){
			if(wh.contains(fot)){
				route = route.concat("|"+wh);
			}
		}
		List<String> rail = loadRailData();
		for(String station:rail){
			if(station.contains(fob)){
				route = route.concat("|"+station);
			}
		}
		return route;
	}
	
	private List<String> loadSeaData() {

		List<String> data = new ArrayList<String>();

		data.add("Beijing City, China|150|35");
		data.add("Dalian, China|125|35");
		data.add("Foshan, China|120|32");
		data.add("Fuzhou, China|115|35");
		data.add("Guangzhou, China|102|28");
		data.add("Hong Kong, China|95|28");
		data.add("Huangpu, China|102|30");
		data.add("Jiangmen, China|115|28");
		data.add("Ningbo, China|95|35");
		data.add("Qingdao, China|99|32");
		data.add("Shanghai, China|92|30");
		data.add("Shantou, China|125|30");
		data.add("Shenzhen, China|95|30");
		data.add("Shunde, China|120|32");
		data.add("Yantian, China|95|28");
		data.add("Xiamen, China|105|35");
		data.add("Xingang / Tianjin, China|99|30");
		data.add("Zhongshan, China|115|30");
		data.add("Zhuhai, China|115|43");
		data.add("Belawan, Indonesia|141|32");
		data.add("Jakarta, Indonesia|141|34");
		data.add("Semarang, Indonesia|141|34");
		data.add("Surabaya, Indonesia|141|34");
		data.add("Kobe, Japan|120|35");
		data.add("Nagoya, Japan|120|35");
		data.add("Osaka, Japan|120|35");
		data.add("Tokyo, Japan|120|35");
		data.add("Yokohama, Japan|120|35");
		data.add("Busan, Korea|95|39");
		data.add("Inchon, Korea|190|45");
		data.add("Port Kelang, Malaysia|107|28");
		data.add("Pasir Gudang, Malaysia|107|30");
		data.add("Penang, Malaysia|107|28");
		data.add("Port Louis, Mauritius|162|40");
		data.add("Yangon, Mynamar|148|42");
		data.add("Cebu, Philipines|142|35");
		data.add("Manila, Philipines|142|35");
		data.add("Singapore, Singapore|115|29");
		data.add("Kaohsiung, Taiwan|108|28");
		data.add("Keelung, Taiwan|108|28");
		data.add("Taichung, Taiwan|108|28");
		data.add("Bangkok, Thailand|109|28");
		data.add("Haiphong, Vietnam|142|35");
		data.add("Ho Chi Minh City, Vietnam|105|35");
		data.add("Danang, Vietnam|147|35");
		data.add("Chittagong, Bangladesh|125|29");
		data.add("Ahmedabad, India|130|19");
		data.add("Bangalore, India|142|29");
		data.add("Baroda, India|130|19");
		data.add("Calcutta, India|115|19");
		data.add("Chennai, India|130|32");
		data.add("Cochin, India|130|22");
		data.add("Hyderabad, India|120|29");
		data.add("Mumbai, India|99|29");
		data.add("Delhi, India|135|29");
		data.add("Nhava Sheva, India|99|29");
		data.add("Tuticorin, India|115|19");
		data.add("Karachi, Pakistan|96|25");
		data.add("Colombo, Sri Lanka|96|25");
		data.add("Adelaide, Australia|156|49");
		data.add("Brisbane, Australia|156|49");
		data.add("Fremantle, Australia|188|49");
		data.add("Melbourne, Australia|136|49");
		data.add("Sydney, Australia|136|49");
		data.add("Auckland, New Zealand|136|45");
		data.add("Lyttelton, New Zealand|201|50");
		data.add("Buenos Aires, Argentina|94|25");
		data.add("Rosario, Argentina|134|28");
		data.add("Betim, Brasil|149|32");
		data.add("Curitiba, Brasil|109|30");
		data.add("Itajai, Brasil|109|26");
		data.add("Porto Alegro, Brasil|109|26");
		data.add("Rio de Janeiro, Brasil|109|28");
		data.add("Rio Grande, Brasil|109|26");
		data.add("Santos, Brasil|106|17");
		data.add("Valparaiso, Chile|140|27");
		data.add("Callao, Peru|124|30");
		data.add("Asuncion, Paraguay|65|25");
		data.add("Montevideo, Uruguay|50|34");
		data.add("Alexandria, Egypt|94|25");
		data.add("Ashdod, Israel|115|26");
		data.add("Haifa, Israel|105|24");
		data.add("Dubai, UAE|109|25");
		data.add("Jebel Ali, UAE|109|25");
		data.add("Cape Town, South Africa|133|28");
		data.add("Durban, South Africa|133|28");
		data.add("Johannesburg, South Africa|171|28");
		data.add("Montreal, Canada|148|24");
		data.add("Toronto, Canada|151|25");
		data.add("Vancouver, Canada|211|30");
		data.add("Altamira, Mexico|121|26");
		data.add("Mexico City, Mexico|165|32");
		data.add("Vera Cruz, Mexico|121|26");
		data.add("Atlanta, USA|111|17");
		data.add("Baltimore, USA|105|25");
		data.add("Boston, USA|105|25");
		data.add("Charleston, USA|128|25");
		data.add("Charlotte, USA|129|25");
		data.add("Chicago, USA|122|21");
		data.add("Cleveland, USA|156|27");
		data.add("Dallas, USA|151|22");
		data.add("Detroit, USA|159|25");
		data.add("Houston, USA|130|22");
		data.add("Los Angeles, USA|152|25");
		data.add("Memphis, USA|172|25");
		data.add("Miami, USA|142|27");
		data.add("New Orleans, USA|171|22");
		data.add("New York, USA|95|27");
		data.add("Norfolk, USA|105|21");
		data.add("Philadelphia, USA|105|25");
		data.add("Portland, USA|165|25");
		data.add("San Francisco, USA|158|27");
		data.add("Seattle, USA|165|26");

		return data;
	}

	private List<String> loadRailData() {

		List<String> data = new ArrayList<String>();

		data.add("Beijing City, China|95|16");
		data.add("Dalian, China|105|20");
		data.add("Foshan, China|98|17");
		data.add("Fuzhou, China|101|17");
		data.add("Guangzhou, China|95|17");
		data.add("Jiangmen, China|98|17");
		data.add("Ningbo, China|100|18");
		data.add("Qingdao, China|98|17");
		data.add("Shanghai, China|90|17");
		data.add("Shantou, China|98|17");
		data.add("Shenzhen, China|90|17");
		data.add("Shunde, China|90|17");
		data.add("Tianjin, China|94|16");
		data.add("Xiamen, China|103|18");
		data.add("Zhongshan, China|98|17");
		data.add("Zhuhai, China|98|17");

		return data;
	}

	private List<String> loadRoadData() {

		List<String> data = new ArrayList<String>();

		data.add("Kyiv|100|5");
		data.add("Cherkasy|100|5");
		data.add("Chernihiv|102|7");
		data.add("Chernivtsi|150|4");
		data.add("Dnipro|70|9");
		data.add("Ivano-Frankivsk|104|5");
		data.add("Kharkiv|105|6");
		data.add("Kherson|106|7");
		data.add("Khmelnytskyi|111|8");
		data.add("Kropyvnytskyi|99|6");
		data.add("Lutsk|60|4");
		data.add("Lviv|100|5");
		data.add("Mykolaiv|115|8");
		data.add("Odessa|140|9");
		data.add("Poltava|105|7");
		data.add("Rivne|75|4");
		data.add("Sumy|95|6");
		data.add("Ternopil|100|5");
		data.add("Uzhhorod|110|4");
		data.add("Vinnytsia|120|6");
		data.add("Zaporizhia|130|7");
		data.add("Zhytomyr|100|5");
	
		return data;
	}
}
