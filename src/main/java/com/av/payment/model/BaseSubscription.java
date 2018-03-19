package com.av.payment.model;

import com.av.payment.model.type.SubscriptionTypeEnum;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.util.UUID;

/**
 * Created by Aman Verma on 16/03/2018.
 */
public class BaseSubscription {

    /**
     * The Id
     */
    private String id;

    /**
     * Amount charged based per subscription type
     */
    @JsonProperty("amount")
    @NotNull
    private Amount amount;

    /**
     * The Subscription_type
     */
    @JsonProperty("subscription_type")
    @NotNull
    private SubscriptionTypeEnum subscriptionType;

    public BaseSubscription() {
        //In real scenario, the ID would be automatically generated.
        id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public SubscriptionTypeEnum getSubscriptionType() {
        return subscriptionType;
    }

    public void setSubscriptionType(SubscriptionTypeEnum subscriptionType) {
        this.subscriptionType = subscriptionType;
    }

    @Override
    public String toString() {
        return "BaseSubscription{" +
                "id='" + id + '\'' +
                ", amount=" + amount +
                ", subscriptionType='" + subscriptionType + '\'' +
                '}';
    }
}