package no.uio.inf5750.assignment1_martily.controller;

import no.uio.inf5750.assignment1_martily.dao.MessageDao;
import no.uio.inf5750.assignment1_martily.model.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/")
@Controller
public class BaseController {

	// Tell Spring to perform databindings between our implementation and the
	// DAO
	@Autowired
	private MessageDao messageDao;

	/*
	 * Welcome page - don't poll DB
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(ModelMap model) {

		model.addAttribute("message", "Leave a message below");
		model.addAttribute("message2", "This is my second message you know");
		// Spring uses InternalResourceViewResolver and return back index.jsp
		return "index";

	}

	/*
	 * Test of PathVariable usage
	 */
	@RequestMapping(value = "/welcome/{name}", method = RequestMethod.GET)
	public String welcomeName(@PathVariable String name, ModelMap model) {

		model.addAttribute("message", "Maven Web Project + Spring 3 MVC - "
				+ name);
		return "index";

	}

	/*
	 * Save a supplied message in the databse
	 */
	@RequestMapping(value = "send", method = RequestMethod.GET)
	public String send(@RequestParam(value = "content") String content,
			ModelMap model) {
		Message msg = new Message();
		msg.setContent(content);
		int id = messageDao.save(msg);
		model.addAttribute(
				"message",
				"Message id of newly stored message= "
						+ id
						+ ", you can hit the button below to display the message in its entirity");
		return "index";
	}

	/*
	 * Print the last message
	 */
	@RequestMapping(value="/read", method = RequestMethod.GET) 
	public String read(ModelMap model) {
		Message message = messageDao.getLast();
		if(message != null) {
			model.addAttribute("message", "The last message was : " + message.getContent());
		}else {
			model.addAttribute("message", "No message fount in local DB");
		}
		return "index";
	}

	
	/*
	 * Print the message with the supplied ID
	 */
	 @RequestMapping(value="/read/{id}", method = RequestMethod.GET)
	public String readId(@PathVariable int id, ModelMap model) {
		Message message = messageDao.get(id);
		if(message!= null) {
			model.addAttribute("message", "Message with ID " + id + " was : " + message.getContent());
		}else {
			model.addAttribute("message", "No message with ID" + id + " found in local DB");
		}
		
		return "index";
	}
	 
	
}