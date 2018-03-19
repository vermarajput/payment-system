package com.av.payment.repository.validator;

import com.av.payment.exception.PaymentSubscriptionException;
import com.av.payment.model.SubscriptionRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static com.av.payment.repository.TestData.getMonthlySubscriptionRequest;
import static com.av.payment.repository.TestData.getWeeklySubscriptionRequest;

/**
 * Created by Aman Verma on 18/03/2018.
 */
@RunWith(MockitoJUnitRunner.class)
public class RequestValidatorImplTest {
    private static final String DATE_PATTERN = "dd/MM/yyyy";

    @InjectMocks
    private RequestValidatorImpl reqValidator;

    @Test(expected = PaymentSubscriptionException.class)
    public void testSaveInvalidMonthlySubscriptionRequestNoDateOfMonth() throws Exception {
        SubscriptionRequest subReq = getMonthlySubscriptionRequest();
        subReq.setDateOfMonth(null);
        reqValidator.validateRequest(subReq, DATE_PATTERN);
    }

    @Test(expected = PaymentSubscriptionException.class)
    public void testSaveInvalidWeeklySubscriptionRequestNoDayOfWeek() throws Exception {
        SubscriptionRequest subReq = getWeeklySubscriptionRequest();
        subReq.setDayOfWeek(null);
        reqValidator.validateRequest(subReq, DATE_PATTERN);
    }

    @Test(expected = PaymentSubscriptionException.class)
    public void testSaveInvalidSubscriptionRequestNoStartDate() throws Exception {
        SubscriptionRequest subReq = getMonthlySubscriptionRequest();
        subReq.setStartDate(null);
        reqValidator.validateRequest(subReq, DATE_PATTERN);
    }

    @Test(expected = PaymentSubscriptionException.class)
    public void testSaveInvalidSubscriptionRequestNoStartDateGreaterThanEndDate() throws Exception {
        SubscriptionRequest subReq = getMonthlySubscriptionRequest();
        subReq.setStartDate("11/01/2012");
        subReq.setStartDate("01/01/2012");
        reqValidator.validateRequest(subReq, DATE_PATTERN);
    }

    @Test(expected = PaymentSubscriptionException.class)
    public void testSaveInvalidSubscriptionRequestMoreThanThreeMonthsSubscription() throws Exception {
        SubscriptionRequest subReq = getMonthlySubscriptionRequest();
        subReq.setStartDate("11/01/2013");
        subReq.setEndDate("11/01/2012");
        reqValidator.validateRequest(subReq, DATE_PATTERN);
    }

    @Test(expected = PaymentSubscriptionException.class)
    public void testSaveInvalidSubscriptionRequestNoEndDate() throws Exception {
        SubscriptionRequest subReq = getMonthlySubscriptionRequest();
        subReq.setStartDate(null);
        reqValidator.validateRequest(subReq, DATE_PATTERN);
    }
}