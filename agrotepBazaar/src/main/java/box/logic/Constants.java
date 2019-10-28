package box.logic;

import java.util.ArrayList;
import java.util.List;

public class Constants {

	public List<String> getDirectionConstants() {

		List<String> list = new ArrayList<String>();

		list.add("import");
		list.add("export");

		return list;
	}

	public List<String> getCurrencyConstants() {

		List<String> list = new ArrayList<String>();

		list.add("EUR");
		list.add("UAH");
		list.add("USD");

		return list;
	}

	public List<String> getTruckConstants() {

		List<String> list = new ArrayList<String>();

		list.add("any");
		list.add("tent");
		list.add("allmetal");
		list.add("refrigerator");
		list.add("dual-mode");

		return list;

	}

	public List<String> getRankConstants() {

		List<String> list = new ArrayList<String>();

		list.add("top");
		list.add("coordinator");
		list.add("manager");
		list.add("chief");

		return list;

	}

	public List<Integer> getImportanceConstants() {

		List<Integer> list = new ArrayList<Integer>();

		list.add(1);
		list.add(2);
		list.add(3);

		return list;

	}

	public List<String> getStatusConstants() {

		List<String> list = new ArrayList<String>();

		list.add("auction_open");
		list.add("auction_waiting");
		list.add("bet_win");
		list.add("proposition_taken");
		list.add("sold_waiting");
		list.add("deal_confirmed");
		list.add("deal_waiting");
		list.add("deal_canceled");

		return list;

	}

}
