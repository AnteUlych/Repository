package box.logic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import box.model.Client;

public class DecoderDBtoHTML {
	
	Constants constant = new Constants();
		
	public String CLIENT_FUNEL_COLD_CALL = "fa fa-snowflake-o w3-text-blue";
	public String CLIENT_FUNEL_COMUNICATION_WITH_LPR = "fa fa-user-secret";
	public String CLIENT_FUNEL_CONTRACT_DEALING = "fa fa-flag-checkered";
	public String CLIENT_FUNEL_BECAME_CLIENT = "fa fa-check w3-text-green";
	public String CLIENT_FUNEL_STOP_COWORKING = "fa fa fa-ban w3-text-red";
	
	
	public List<String> translateFotClientsDatesFromDBtoHTML(
			List<Client> clients) {

		List<String> dates = new ArrayList();
		SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

		for (Client client : clients) {
			dates.add(formatter.format(client.getNextcall()));
		}
		return dates;
	}
	
	public List<String> translateForClientsFunelfromDBtoIcons(List<Client> clients){
		
		List<String> icons = new ArrayList();
		
		for (Client client : clients) {
			
			int clientsFunel = client.getFunel();
			
			if(clientsFunel == constant.CLIENT_FUNEL_COLD_CALL){
				icons.add(CLIENT_FUNEL_COLD_CALL);
			}else if(clientsFunel==constant.CLIENT_FUNEL_COMUNICATION_WITH_LPR){
				icons.add(CLIENT_FUNEL_COMUNICATION_WITH_LPR);
			}else if(clientsFunel==constant.CLIENT_FUNEL_CONTRACT_DEALING){
				icons.add(CLIENT_FUNEL_CONTRACT_DEALING);
			}else if(clientsFunel==constant.CLIENT_FUNEL_BECAME_CLIENT){
				icons.add(CLIENT_FUNEL_BECAME_CLIENT);
			}else{
				icons.add(CLIENT_FUNEL_STOP_COWORKING);
			}
		}
				
		return icons;
	}

}
