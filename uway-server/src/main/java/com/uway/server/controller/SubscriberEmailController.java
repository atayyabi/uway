package com.uway.server.controller;

import com.uway.server.model.dto.SubscriberEmailStatus;
import com.uway.server.model.entity.SubscriberEmail;
import com.uway.server.service.SubscriberEmailRepositoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class SubscriberEmailController {
	
	private final SubscriberEmailRepositoryService service;
	
	@PostMapping(path="/api/v1/email/save-subscriber-email")
	public SubscriberEmailStatus saveSubscriberEmail(@RequestBody SubscriberEmail subscriberEmail) {
		return service.saveSubscriberEmail(subscriberEmail);
	}

}
