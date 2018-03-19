package com.av.payment.repository;

import com.av.payment.model.Amount;
import com.av.payment.model.SubscriptionRequest;
import com.av.payment.model.type.SubscriptionTypeEnum;

import static java.time.DayOfWeek.TUESDAY;

/**
 * Created by Aman Verma on 18/03/2018.
 */
public class TestData {

    public static SubscriptionRequest getMonthlySubscriptionRequest() throws Exception {
        SubscriptionRequest subReq = new SubscriptionRequest();
        subReq.setId("MonthlyId1");
        subReq.setSubscriptionType(SubscriptionTypeEnum.MONTHLY);
        subReq.setDateOfMonth(20);
        subReq.setStartDate("01/02/2016");
        subReq.setEndDate("01/04/2016");
        Amount amount = new Amount();
        amount.setCurrency("AUD");
        amount.setValue(225);
        subReq.setAmount(amount);
        return subReq;
    }

    public static SubscriptionRequest getWeeklySubscriptionRequest() throws Exception {
        SubscriptionRequest subReq = new SubscriptionRequest();
        subReq.setId("WeeklyId1");
        subReq.setSubscriptionType(SubscriptionTypeEnum.WEEKLY);
        subReq.setDayOfWeek(TUESDAY);
        subReq.setStartDate("01/02/2016");
        subReq.setEndDate("01/04/2016");
        Amount amount = new Amount();
        amount.setCurrency("AUD");
        amount.setValue(22);
        subReq.setAmount(amount);
        return subReq;
    }
}
