package com.av.payment.repository.persistor;

import com.av.payment.model.SubscriptionRequest;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aman Verma on 18/03/2018.
 *
 * Persister class can be switched based on <link>@Profile</link> Annotation in future
 */
@Component
public class InternalStorageSubscriptionPersister implements SubscriptionPersister {
    private Map<String, SubscriptionRequest> subscriptionRequests = Collections.synchronizedMap(new HashMap<>());

    /**
     * Persists request object in local datastructure
     *
     * @param subReq
     */
    @Override
    public void saveSubscriptionRequest(SubscriptionRequest subReq) {
        // Can check for already existing recode and throw exception
        subscriptionRequests.put(subReq.getId(), subReq);
    }

    @Override
    public SubscriptionRequest getSubscriptionRequest(String id) {
        return null;
    }

    @Override
    public Map<String, SubscriptionRequest> getAllSubscriptionRequests() {
        return subscriptionRequests;
    }

    @Override
    public void deleteSubscriptionRequest(String id) {

    }
}
