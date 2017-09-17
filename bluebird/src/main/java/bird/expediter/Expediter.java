package bird.expediter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bird.service.ReviewService;

public class Expediter {


	ApplicationContext ctx = (ApplicationContext) new ClassPathXmlApplicationContext(
			"spring.xml");
	ReviewService s = (ReviewService) ctx.getBean("reviewService");
	
	public int giveAnumber(){

		return s.getCountByRate(5);
		
	}
}
