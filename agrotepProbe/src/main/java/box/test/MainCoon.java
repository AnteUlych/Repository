package box.test;

import java.util.Date;
import java.util.List;

import box.logic.LogicDataBase;
import box.model.Proposition;
import box.model.Transport;

public class MainCoon {

	public static void main(String[] args) {
		
		LogicDataBase logic = new LogicDataBase();
		logic.setPropositionStatus(1, "w3-green");
	List<Proposition> propositions = logic.getAllPropositionsByTransportId(1);
		
		for(Proposition p:propositions){
			
			System.out.println(p.getInformation());
		}
		
		//System.out.println("end");
		/**
		List<Transport> trucks = logic.getAllTransportByDirection("export");
		
		for(Transport t:trucks){
			
			System.out.println(t.getRoute()+" "+t.getTruckdriver()+" "+t.getStatus());
		}
       */
	}

}
