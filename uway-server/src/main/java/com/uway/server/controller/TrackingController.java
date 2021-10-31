package com.uway.server.controller;

import com.uway.server.model.dto.TrackingInformation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class TrackingController {

    private final WebClient.Builder builder;

    @PostMapping(value = "/api/v1/track", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String getTrackingResponse(@RequestBody TrackingInformation payload) {
        return builder.build()
                .get()
                .uri("https://api.goshippo.com/tracks/" + payload.getCarrier() + "/" + payload.getTracking_number())
                .header("Authorization", "ShippoToken shippo_test_3aaa1205a3ac9c183292d350b4b8cc55f25bf372")
                .retrieve()
                .bodyToMono(String.class)
                .block();


    }


}
