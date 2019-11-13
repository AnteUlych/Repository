package box.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import box.dao.MessageDAO;
import box.model.Message;

@Service("MessageService")
@Transactional
public class MessageService {

	@Autowired
	private MessageDAO dao;

	public void addMessage(Message message) {
		dao.persist(message);
	}

	public void deleteMessage(int id) {
		dao.deleteMessage(id);
	}

	public Message getMessageByRecipientid(int recipientid) {
		List<Message> list = dao.getMessageByRecipientid(recipientid);
		return list.get(0);
	}
	
	public boolean isAnyMessagesForRecipient(int recipientid){
		List<Message> list = dao.getMessageByRecipientid(recipientid);
		return !list.isEmpty();
	}

}
