package com.av.repository.validator;

import com.av.model.SubscriptionRequest;

/**
 * Created by Aman Verma on 18/03/2018.
 */
public interface RequestValidator {
    void validateRequest(SubscriptionRequest subscriptionRequest, String datePattern);
}
