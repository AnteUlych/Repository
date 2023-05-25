package box.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import box.logic.Constants;
import box.logic.DataBaseController;
import box.logic.DecoderDBtoHTML;
import box.model.Client;
import box.model.Product;
import box.model.Weeklyreminder;

@Controller
@RequestMapping("/plan")
public class PlanServlet {

	Constants constant = new Constants();

	@RequestMapping(method = RequestMethod.GET)
	public String doGet(ModelMap model, HttpServletRequest request) {

		HttpSession session = request.getSession();

		int id = (Integer) session.getAttribute("id");
		int rank = (Integer) session.getAttribute("rank");
		String name = (String) session.getAttribute("name");

		DataBaseController base = new DataBaseController();

		List<Client> clients = new ArrayList();
		String menuForHead = "";

		if (rank == constant.MANAGER_RANK_MANAGER) {
			clients = base.getClientsByManagerIdSortedByNexcall(id);
		} else {
			clients = base.getClientsSortedByNextcall();
			menuForHead = constant.MENU_FOR_HEAD;
		}

		DecoderDBtoHTML decoder = new DecoderDBtoHTML();

		List<Product> products = base.getListOfOpenProducts();
		List<String> dates = decoder.translateFotClientsDatesFromDBtoHTML(clients);
		List<String> icons = decoder.translateForClientsFunelfromDBtoIcons(clients);

		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		int todayDayOfWeek = c.get(Calendar.DAY_OF_WEEK);

		List<Weeklyreminder> reminders = base.getListOfUncheckedWeeklyreminderByManagerIdAndDayofweek(id,
				todayDayOfWeek);

		base.closeConnection();

		model.addAttribute("name", name);
		model.addAttribute("clients", clients);
		model.addAttribute("products", products);
		model.addAttribute("dates", dates);
		model.addAttribute("menuForHead", menuForHead);
		model.addAttribute("icons", icons);

		model.addAttribute("reminders", reminders);

		return "plan";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String doPost(ModelMap model, HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();

		int id = (Integer) session.getAttribute("id");

		DataBaseController base = new DataBaseController();

		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		int todayDayOfWeek = c.get(Calendar.DAY_OF_WEEK);

		// post
		List<Weeklyreminder> remindersForDelete = base.getListOfUncheckedWeeklyreminderByManagerIdAndDayofweek(id,
				todayDayOfWeek);

		for (Weeklyreminder w : remindersForDelete) {
			if (request.getParameter("check" + w.getId()) != null) {
				base.editWeeklyreminderCheckById(w.getId(), constant.CHECKED_WEEKLYREMINDER);

			}
		}

		// post
		base.closeConnection();

		try {
			response.sendRedirect("/clientshisory/plan");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "plan";
	}

}
