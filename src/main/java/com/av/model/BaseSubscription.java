package com.av.model;

import com.av.model.type.SubscriptionTypeEnum;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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