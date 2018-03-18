package com.av.model;

import com.av.model.type.SubscriptionTypeEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aman Verma on 16/03/2018.
 */

public class SubscriptionResponse extends BaseSubscription {
    @JsonProperty("invoice_dates")
    private List<String> invoiceDates = new ArrayList<>();

    public SubscriptionResponse(){}

    public SubscriptionResponse(String id, Amount amount, SubscriptionTypeEnum subscriptionType, List<String> invoiceDates) {
        super.setId(id);
        super.setAmount(amount);
        super.setSubscriptionType(subscriptionType);
        this.invoiceDates = invoiceDates;
    }

    public List<String> getInvoiceDates() {
        return invoiceDates;
    }

    public void setInvoiceDates(List<String> invoiceDates) {
        this.invoiceDates = invoiceDates;
    }

    @Override
    public String toString() {
        return super.toString() +
                "SubscriptionResponse{" +
                " invoiceDates=" + invoiceDates +
                '}';
    }
}