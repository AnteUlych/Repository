package box.web;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
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
import box.model.Documents;
import box.model.Manager;

@Controller
@RequestMapping("/documents")
public class DocumentsServlet {
	
	@RequestMapping(method = RequestMethod.GET)
	public String doGet(ModelMap model, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("name");
		int status = (Integer) session.getAttribute("status");
		int managerid = (Integer) session.getAttribute("id");
		
		DataBaseController base = new DataBaseController(); 
		
		List<Documents> docs = new ArrayList();
		List<Manager> managers1 = base.getListOfManagers(); //List<Manager> managers = base.getListOfManagers();
		
		
		//very bad code!!!!!!!!!!
		List<Manager> managers = new ArrayList();
		for(Manager m:managers1){
			if(m.getName().equals("Діма")||m.getName().equals("Влад")||m.getName().equals("Лёша")||m.getName().equals("Саша")){
				managers.add(m);
			}
		}
		//very bad code!!!!!!!!!!
		String addButton = "";
		String buttonPermission = "disabled";
		
		if(status==0||status==2){
			docs = base.getListOfDocumentsWithStatus(Constants.DOCUMENTS_STATUS_START);
			addButton = "<button onclick=\"document.getElementById('subscribe').style.display='block'\" class=\"w3-button w3-xlarge w3-circle w3-white\">+</button>";
			buttonPermission = "";
		}else{
			docs = base.getListOfDocumentsWithStatusByResponsibleId(Constants.DOCUMENTS_STATUS_START, managerid);
		}
		
		base.closeConnection();
		
		model.addAttribute("name", name);
		model.addAttribute("docs", docs);
		model.addAttribute("managers", managers);
		model.addAttribute("addButton", addButton);
		model.addAttribute("buttonPermission", buttonPermission);
		
		return "documents";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String doPost(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("name");
		int status = (Integer) session.getAttribute("status");
		int managerid = (Integer) session.getAttribute("id");
		
		DataBaseController base = new DataBaseController(); 
		
		//post button
		List<Documents> docpost = base.getListOfDocumentsWithStatus(Constants.DOCUMENTS_STATUS_START);
		for(Documents d:docpost){
			if(request.getParameter("good"+d.getId()) != null){
				base.editDocumentsById(d.getId(), new Date(), Constants.DOCUMENTS_STATUS_FINISH, Constants.DOCUMENTS_STATUS_FINISH_COLOR);
			} else 
			if(request.getParameter("bad"+d.getId()) != null){
				base.editDocumentsById(d.getId(), new Date(), Constants.DOCUMENTS_STATUS_DELETED, Constants.DOCUMENTS_STATUS_DELETE_COLOR);
			}
		}
		
		//post add
		if(request.getParameter("add") != null){	
			
			String requestEnc = "ISO-8859-1";
			String clientEnc = request.getParameter("charset");
			if (clientEnc == null)
				clientEnc = "Cp1251";
			
			String weclient = request.getParameter("weclient");
			String drnumber = request.getParameter("drnumber");
			String truck = request.getParameter("truck");
			String client = request.getParameter("client");
			String aboutroute = request.getParameter("aboutroute");
			String whatneed = request.getParameter("whatneed");
			String manager = request.getParameter("manar");
			
			if (weclient != null){
				try {
					weclient = new String(weclient.getBytes(requestEnc), clientEnc);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			if (truck != null){
				try {
					truck = new String(truck.getBytes(requestEnc), clientEnc);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			if (client != null){
				try {
					client = new String(client.getBytes(requestEnc), clientEnc);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			if (aboutroute != null){
				try {
					aboutroute = new String(aboutroute.getBytes(requestEnc), clientEnc);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			if (whatneed != null){
				try {
					whatneed = new String(whatneed.getBytes(requestEnc), clientEnc);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			if (manager != null){
				try {
					manager = new String(manager.getBytes(requestEnc), clientEnc);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			
			Documents newdoc = new Documents();
			newdoc.setAboutroute(aboutroute);
			newdoc.setClient(client);
			newdoc.setColor(Constants.DOCUMENTS_STATUS_DELETE_COLOR);
			newdoc.setDatecreating(new Date());
			newdoc.setDatesolvving(new Date());
			newdoc.setDrnumber(Integer.parseInt(drnumber));
			newdoc.setResponsibleid(Integer.parseInt(manager));
			
			String responsibleManger = base.getManagerById(Integer.parseInt(manager)).getName();
			
			newdoc.setResponsiblename(responsibleManger);
			newdoc.setStatus(Constants.DOCUMENTS_STATUS_START);
			newdoc.setTruck(truck);
			newdoc.setWeclient(weclient);
			newdoc.setWhatneed(whatneed);
			newdoc.setWhoaskingid(managerid);
			newdoc.setWhoaskingname(name);
			
			base.addDocuments(newdoc);
		}
		
		List<Documents> docs = new ArrayList();
		List<Manager> managers1 = base.getListOfManagers(); //List<Manager> managers = base.getListOfManagers();
		
		
		//very bad code!!!!!!!!!!
		List<Manager> managers = new ArrayList();
		for(Manager m:managers1){
			if(m.getName().equals("Діма")||m.getName().equals("Влад")||m.getName().equals("Лёша")||m.getName().equals("Саша")){
				managers.add(m);
			}
		}
		//very bad code!!!!!!!!!!
		String addButton = "";
		String buttonPermission = "disabled";
		
		if(status==0||status==2){
			docs = base.getListOfDocumentsWithStatus(Constants.DOCUMENTS_STATUS_START);
			addButton = "<button onclick=\"document.getElementById('subscribe').style.display='block'\" class=\"w3-button w3-xlarge w3-circle w3-white\">+</button>";
			buttonPermission = "";
		}else{
			docs = base.getListOfDocumentsWithStatusByResponsibleId(Constants.DOCUMENTS_STATUS_START, managerid);
		}
		
		base.closeConnection();
		
		model.addAttribute("name", name);
		model.addAttribute("docs", docs);
		model.addAttribute("managers", managers);
		model.addAttribute("addButton", addButton);
		model.addAttribute("buttonPermission", buttonPermission);
		
		return "documents";
	}

}
