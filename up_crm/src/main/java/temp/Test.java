package temp;

import java.util.ArrayList;
import java.util.List;

import racoon.logic.BaseController;
import racoon.model.Client;
import racoon.model.Manager;

public class Test {

	public static void main(String[] args) {

		BaseController base = new BaseController();
		Client client = base.getClientById(119);
		System.out.println(client.getId()+" "+client.getManager());
		//int managerId = base.getManagerIdByName(client.getManager());
		//System.out.println(managerId);
	}

}
