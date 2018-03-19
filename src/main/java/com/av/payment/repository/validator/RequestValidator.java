package com.av.payment.repository.validator;

import com.av.payment.model.SubscriptionRequest;

/**
 * Created by Aman Verma on 18/03/2018.
 */
public interface RequestValidator {
    void validateRequest(SubscriptionRequest subscriptionRequest, String datePattern);
}
