package sender.test;

import java.util.List;

import org.junit.Before;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sender.logic.SendMechanism;
import sender.logic.SenderProperties;
import sender.service.EmailService;

import static org.junit.Assert.*;

public class SenderTest {

	SendMechanism sm = new SendMechanism("test", "test");
	EmailService es = new EmailService();
	SenderProperties sp = new SenderProperties();

	String testMailForOperations = "test";
	String testMailInBase = "testMail";

	@Before
	public void changeContext() {

		es.ctx = (ApplicationContext) new ClassPathXmlApplicationContext(
				"file:src/test/resources/spring-context.xml");
	}

	@Test
	public void showAllEmailsTest() {

		List<String> testList = es.showAllEmails();
		assertTrue(testList.contains(testMailInBase));
	}

	@Test
	public void addAndDeleteTest() {

		es.addEmail(testMailForOperations);
		List<String> testList = es.showAllEmails();
		assertTrue(testList.contains(testMailForOperations));

		es.deleteByAddress(testMailForOperations);
		List<String> testListAfterDeleting = es.showAllEmails();

		assertTrue(!testListAfterDeleting.contains(testMailForOperations));
	}

	@Test
	public void showAllEmailsInOneStringTest() {
		List<String> testList = es.showAllEmails();
		String result = es.showAllEmailsInOneString(testList);
		System.out.println(result);
		String expectation = "Mails were sended to adress, testMail.";
		assertEquals(result, expectation);
	}

	@Test
	public void getMailTest() {
		String expectation = "test";
		String testMail = sp.getMail();
		assertEquals(expectation, testMail);
	}

	@Test
	public void getPasswordTest() {
		String expectation = "test";
		String testPassword = sp.getPassword();
		assertEquals(expectation, testPassword);
	}

	@Test(expected = RuntimeException.class)
	public void sendTest() {

		SendMechanism smSpy = Mockito.spy(sm);
		smSpy.spam();

	}
}