package com.cgi.cf.demo.company;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
class MessageController {

	private static final Logger logger = Logger.getLogger(MessageController.class);

	@Value("${message:Hello default}")
	private String message;

	@RequestMapping("/message")

	String getMessage() {
		logger.debug("Show the message!");
		return "\n" + this.message + "\n\n";
	}
}