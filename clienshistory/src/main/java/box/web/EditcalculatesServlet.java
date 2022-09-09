package box.web;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import box.logic.Constants;
import box.logic.DataBaseController;
import box.model.Calculates;
import box.model.Client;
import box.model.Product;

@Controller
public class EditcalculatesServlet {

	Constants constant = new Constants();

	@RequestMapping(value = "/editcalculates/{calculatesid}", method = RequestMethod.GET)
	public String doGet(@PathVariable("calculatesid") String calculatesid,
			ModelMap model, HttpServletRequest request) {

		HttpSession session = request.getSession();

		int id = (Integer) session.getAttribute("id");
		int rank = (Integer) session.getAttribute("rank");
		String name = (String) session.getAttribute("name");

		DataBaseController base = new DataBaseController();

		String addRecord = "";
		String editClient = "";
		String menuForHead = "";

		if (rank == constant.MANAGER_RANK_MANAGER) {

		} else {
			menuForHead = constant.MENU_FOR_HEAD;
		}

		List<Product> products = base.getListOfOpenProducts();

		// logic
		int idofcalculate = Integer.parseInt(calculatesid);
		Calculates calculate = base.getCalculatesById(idofcalculate);

		String adr = "";
		if (calculate.getDangerous().equals("ADR")) {
			adr = "checked";
		}

		String tent = "";
		String ref = "";
		String tentref = "";

		if (calculate.getTruck().equals("реф")) {
			ref = "checked";
		} else if (calculate.getTruck().equals("тент")) {
			tent = "checked";
		} else {
			tentref = "checked";
		}

		List<Client> clients = base.getClientsSortedByName();
		// logic

		base.closeConnection();

		model.addAttribute("name", name);
		model.addAttribute("products", products);
		model.addAttribute("menuForHead", menuForHead);

		model.addAttribute("adr", adr);

		model.addAttribute("tent", tent);
		model.addAttribute("ref", ref);
		model.addAttribute("tentref", tentref);

		model.addAttribute("clients", clients);

		model.addAttribute("calculate", calculate);

		return "editcalculates";
	}

	@RequestMapping(value = "/editcalculates/{calculatesid}", method = RequestMethod.POST)
	public String doPost(@PathVariable("calculatesid") String calculatesid,
			ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {

		DataBaseController base = new DataBaseController();

		String requestEnc = "ISO-8859-1";
		String clientEnc = request.getParameter("charset");
		if (clientEnc == null)
			clientEnc = "Cp1251";

		String idclient = request.getParameter("idclient");
		int clientid = Integer.parseInt(idclient);
		String company;
		if (clientid == 0) {
			company = "";
		} else {
			company = base.getClientById(clientid).getCompany();
		}
		String comments = request.getParameter("comments");
		if (comments == null) {
			comments = "";
		}
		String weightString = request.getParameter("weight");
		int weight = Integer.parseInt(weightString);
		Date dateofcalculate = new Date();
		String freight = request.getParameter("freight");
		String typetruck = request.getParameter("typetruck");
		String temperature = request.getParameter("temperature");
		if (temperature == null) {
			temperature = "без режиму";
		}
		String adrCheck = request.getParameter("adr");
		String adr;
		if (adrCheck != null) {
			adr = "ADR";
		} else {
			adr = "";
		}
		String countryfrom = request.getParameter("countryfrom");
		countryfrom = countryfrom.toUpperCase();
		String countryto = request.getParameter("countryto");
		countryto = countryto.toUpperCase();
		String cityfrom = request.getParameter("cityfrom");
		String cityto = request.getParameter("cityto");
		String budget = request.getParameter("budget");
		if (budget == null) {
			budget = "";
		}
		String rate = request.getParameter("rate");
		if (rate == null) {
			rate = "";
		}
		String calculateonadate = request.getParameter("calculateonadate");

		String exportimport;

		if (countryfrom.equals("UA") && countryto.equals("UA")) {
			exportimport = "Ukraine";
		} else if (!countryfrom.equals("UA") && !countryto.equals("UA")) {
			exportimport = "Europe";
		} else if (countryto.equals("UA")) {
			exportimport = "Import";
		} else {
			exportimport = "Export";
		}

		if (comments != null) {
			try {
				comments = new String(comments.getBytes(requestEnc), clientEnc);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}

		if (freight != null) {
			try {
				freight = new String(freight.getBytes(requestEnc), clientEnc);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}

		if (typetruck != null) {
			try {
				typetruck = new String(typetruck.getBytes(requestEnc),
						clientEnc);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}

		if (temperature != null) {
			try {
				temperature = new String(temperature.getBytes(requestEnc),
						clientEnc);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}

		if (countryfrom != null) {
			try {
				countryfrom = new String(countryfrom.getBytes(requestEnc),
						clientEnc);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		if (countryto != null) {
			try {
				countryto = new String(countryto.getBytes(requestEnc),
						clientEnc);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}

		if (budget != null) {
			try {
				budget = new String(budget.getBytes(requestEnc), clientEnc);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		if (rate != null) {
			try {
				rate = new String(rate.getBytes(requestEnc), clientEnc);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		if (calculateonadate != null) {
			try {
				calculateonadate = new String(
						calculateonadate.getBytes(requestEnc), clientEnc);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}

		if (cityfrom != null) {
			try {
				cityfrom = new String(cityfrom.getBytes(requestEnc), clientEnc);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}

		if (cityto != null) {
			try {
				cityto = new String(cityto.getBytes(requestEnc), clientEnc);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		int idofcalculate = Integer.parseInt(calculatesid);
		
		base.editCalculatesById(idofcalculate, budget, cityfrom, cityto, comments, company, clientid, countryfrom, countryto, adr, calculateonadate, exportimport, freight, rate, temperature, typetruck, weight);

		base.closeConnection();
		
		try {
			response.sendRedirect("/clientshisory/calculates");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "editcalculates";
	}

}
