package com.av.repository;

import com.av.model.SubscriptionRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static com.av.repository.TestData.getMonthlySubscriptionRequest;
import static com.av.repository.TestData.getWeeklySubscriptionRequest;
import static java.time.DayOfWeek.WEDNESDAY;
import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Aman Verma on 18/03/2018.
 */
@RunWith(MockitoJUnitRunner.class)
public class SubscriptionRepositoryUtilTest {
    @InjectMocks
    private SubscriptionRepositoryUtil subReqUtil;

    @Test
    public void testComputeInvoiceDatesForMontlySubscriptionRequest() throws Exception {
        SubscriptionRequest subReq = getMonthlySubscriptionRequest();
        subReq.setStartDate("01/02/2001");
        subReq.setEndDate("01/04/2001");
        subReq.setDateOfMonth(20);
        List<String> dates = subReqUtil.computeInvoiceDates(subReq);
        assertArrayEquals(new String[]{"20/02/2001", "20/03/2001"}, dates.toArray());
    }

    @Test
    public void testComputeInvoiceDatesForWeeklySubscriptionRequest() throws Exception {
        SubscriptionRequest subReq = getWeeklySubscriptionRequest();
        subReq.setStartDate("01/02/2001");
        subReq.setEndDate("01/03/2001");
        subReq.setDayOfWeek(WEDNESDAY);
        List<String> dates = subReqUtil.computeInvoiceDates(subReq);
        assertArrayEquals(new String[]{
                "07/02/2001"
                , "14/02/2001"
                , "21/02/2001"
                , "28/02/2001"}, dates.toArray());
    }

}