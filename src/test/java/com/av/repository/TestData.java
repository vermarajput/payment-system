package com.av.repository;

import com.av.model.Amount;
import com.av.model.SubscriptionRequest;

import static com.av.model.type.SubscriptionTypeEnum.MONTHLY;
import static com.av.model.type.SubscriptionTypeEnum.WEEKLY;
import static java.time.DayOfWeek.TUESDAY;

/**
 * Created by Aman Verma on 18/03/2018.
 */
public class TestData {

    public static SubscriptionRequest getMonthlySubscriptionRequest() throws Exception {
        SubscriptionRequest subReq = new SubscriptionRequest();
        subReq.setId("MonthlyId1");
        subReq.setSubscriptionType(MONTHLY);
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
        subReq.setSubscriptionType(WEEKLY);
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
