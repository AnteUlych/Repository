package sender.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sender.dao.EmailDAO;
import sender.domain.Email;


public class EmailService {

	ApplicationContext ctx = (ApplicationContext) new ClassPathXmlApplicationContext(
			"spring-context.xml");
	EmailDAO emailDAO = (EmailDAO) ctx.getBean("emailDAO");
	
	public List <String> showAllEmails(){
		
		List<Email> list =emailDAO.findAll();
		List<String> stringList = new ArrayList();
		
		for(Email mail:list){
			stringList.add(mail.getAddress());
		}
		
		return stringList;
		}
	
	public void addEmail(String address){
		
		Email email = new Email();
		email.setAddress(address);
		emailDAO.add(email);
	}
	
	public void deleteByAddress(String address){
		int id=0;
		List<Email> list =emailDAO.findAll();
		for(Email email:list){
			if (email.getAddress().equals(address)){
				id = email.getId();
				deleteEmail(id);
			}
		}
	}

	public void deleteEmail(int id){
		emailDAO.delete(id);
	}
	
	public String showAllEmailsInOneString(List <String> list){
		
		String begining = "No mail addresses were added";
		
		if(list.size()==1){
			begining = "Mail was sended to";
		}
		if(list.size()>1){
			begining = "Mails were sended to";
		}
		
		StringBuilder text = new StringBuilder();
		text.append(begining);
		
		for(String address:list){
			text.append(" " + address + ",");
		}
		
		String result = text.toString();
		result = result.substring(0, result.length()-1);
		
		return result+".";	
	}
}
