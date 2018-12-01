package com.itc.apti.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itc.apti.entity.IStatus;
import com.itc.apti.services.IProcessor;

/**
 * The Class WebPageController is used for page navigation and connecting to
 * server socket.
 * 
 * @author Debadatta Mishra
 */
@Controller
public class WebPageController {

	/** The messaging template to send to client. */
	@Autowired
	private SimpMessagingTemplate template;

	/** The processor. */
	@Autowired
	@Qualifier("statusProcessorImpl")
	private IProcessor<String, IStatus> processor;

	/**
	 * Home page
	 *
	 * @return the string
	 */
	@RequestMapping("/")
	String home() {
		return "aptimusPage.html";
	}

	/**
	 * Broadcast services status to client.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@MessageMapping("/check")
	@SendTo("/topic/services")
	public void broadcastServicesStatus() throws Exception {
		List<String> allUrls = new ArrayList<String>();
		// Temporary , team members have to solve this part
		// Read from config files
		allUrls.add("https://developer.aptimus.com/api/validation-service/1/apti/status");
		allUrls.add("https://developer.aptimus.com/api/utility/2/apti/status");
		allUrls.add("https://developer.aptimus.com/api/survey-service/2/apti/status");
		allUrls.add("https://developer.aptimus.com/api/skill-service/1/apti/status");
		allUrls.add("https://developer.aptimus.com/api/session-service/2/apti/status");

		allUrls.add("https://developer.aptimus.com/api/session-service-hati-ghoda/2/apti/status");

		for (String url : allUrls) {
			IStatus status = processor.get(url);
			this.template.convertAndSend("/topic/services", status);
		}

	}

}
