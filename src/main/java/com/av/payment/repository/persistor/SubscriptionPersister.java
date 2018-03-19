package com.av.payment.repository.persistor;

import com.av.payment.model.SubscriptionRequest;

import java.util.Map;

/**
 * Created by Aman Verma on 18/03/2018.
 */
public interface SubscriptionPersister {
    void saveSubscriptionRequest(SubscriptionRequest subscriptionRequest);

    SubscriptionRequest getSubscriptionRequest(String id);

    Map<String, SubscriptionRequest> getAllSubscriptionRequests();

    void deleteSubscriptionRequest(String id);
}
