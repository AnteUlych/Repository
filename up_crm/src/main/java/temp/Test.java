package temp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import racoon.logic.BaseController;
import racoon.logic.Encoder;
import racoon.logic.Sender;
import racoon.model.Client;
import racoon.model.Manager;
import racoon.model.Proposition;
import racoon.model.Request;

public class Test {

	public static void main(String[] args)  {
		String company ="&#1070;&#1085;&#1072;&#1081;&#1089;";
		String start = "2018-12-01";
		String ending = "2018-12-27";
		
		BaseController encoder = new BaseController();
		int r = encoder.getNumberOfAllRequestsByCompanyBetweenDates(company, start, ending);
		System.out.println(r);
		int b = encoder.getNumberOfAllBookingRequestsByCompanyBetweenDates(company, start, ending);
		System.out.println(b);
		
		/**
		String manager = "Pasha";
		String result = "booking";
		
		String start = "2018-12-04";
		String ending = "2018-12-27";

		BaseController encoder = new BaseController();
		//List<Request> requests = encoder.getAllRequestsByManagerTypeResultsBetweenDates(manager, type, result, start, ending);
		List<Proposition> requests = encoder.getAllPropositionsByManagerTypeAndDates(start, ending, manager, result);
		
		for(Proposition r:requests){
			
			System.out.println(r.getAnswer()+" "+r.getManager()+" "+r.getResult());
		}
		System.out.println(encoder.getNumberOfAllPropositionsByManagerTypeAndDates(start, ending, manager, result));
	*/
	}

}
