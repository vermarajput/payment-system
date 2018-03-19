package com.av.payment.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Aman Verma on 16/03/2018.
 */
public class Amount {

    /**
     * The Value
     */
    @JsonProperty("value")
    @NotNull
    @Min(1)
    private Integer value;

    /**
     * The Currency
     */
    @JsonProperty("currency")
    @NotNull
    @Size(min = 3)
    private String currency;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Amount{" +
                "value=" + value +
                ", currency='" + currency + '\'' +
                '}';
    }
}

