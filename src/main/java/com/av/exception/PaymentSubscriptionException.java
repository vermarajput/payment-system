package com.av.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Aman Verma on 18/03/2018.
 */
public class PaymentSubscriptionException extends RuntimeException {
    public PaymentSubscriptionException(String message) {
        super(message);
    }
}
