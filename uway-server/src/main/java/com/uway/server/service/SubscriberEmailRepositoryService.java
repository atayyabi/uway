package com.uway.server.service;

import com.uway.server.model.dto.SubscriberEmailStatus;
import com.uway.server.model.entity.SubscriberEmail;
import com.uway.server.repository.SubscriberEmailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class SubscriberEmailRepositoryService {
	
	private final SubscriberEmailRepository subscriberRepo;

	public SubscriberEmailStatus saveSubscriberEmail(SubscriberEmail subscriberEmail) {
		final String email = Objects.requireNonNull(subscriberEmail.getEmail(), "Email is null");
		if (subscriberRepo.exists(Example.of(subscriberEmail))) {
			return new SubscriberEmailStatus("Email exists!", email);
		} else {
			subscriberRepo.save(subscriberEmail);
			return new SubscriberEmailStatus("Succeeded", email);
		}
	}


}
