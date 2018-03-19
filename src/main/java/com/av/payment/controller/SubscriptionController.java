package com.av.payment.controller;

import com.av.payment.model.SubscriptionRequest;
import com.av.payment.model.SubscriptionResponse;
import com.av.payment.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Created by Aman Verma on 16/03/2018.
 */
@RestController
@RequestMapping("/api")
public class SubscriptionController {


    private final SubscriptionRepository repository;

    @Autowired
    public SubscriptionController(SubscriptionRepository repository) {
        this.repository = repository;
    }

    @PostMapping(value = "/createSub", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<SubscriptionResponse> createSubscription(@Valid @NotNull @RequestBody SubscriptionRequest request) {
        SubscriptionResponse subscriptionResponse = repository.fetchSubscriptionInvoiceDetails(request);
        return new ResponseEntity<>(subscriptionResponse, HttpStatus.OK);
    }
}

