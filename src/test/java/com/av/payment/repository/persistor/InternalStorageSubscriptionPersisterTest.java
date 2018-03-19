package com.av.payment.repository.persistor;

import com.av.payment.model.type.SubscriptionTypeEnum;
import com.av.payment.repository.TestData;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static com.av.payment.model.type.SubscriptionTypeEnum.MONTHLY;
import static com.av.payment.model.type.SubscriptionTypeEnum.WEEKLY;
import static com.av.payment.repository.TestData.getMonthlySubscriptionRequest;
import static com.av.payment.repository.TestData.getWeeklySubscriptionRequest;
import static org.junit.Assert.*;
import static org.springframework.util.CollectionUtils.isEmpty;

/**
 * Created by Aman Verma on 18/03/2018.
 */
@RunWith(MockitoJUnitRunner.class)
public class InternalStorageSubscriptionPersisterTest {
    @InjectMocks
    private InternalStorageSubscriptionPersister persister;

    @Test
    public void testSaveValidMonthlySubscriptionRequest() throws Exception {
        assertTrue(isEmpty(persister.getAllSubscriptionRequests()));
        persister.saveSubscriptionRequest(getMonthlySubscriptionRequest());
        assertFalse(isEmpty(persister.getAllSubscriptionRequests()));
        assertEquals(1, persister.getAllSubscriptionRequests().size());
        assertEquals(persister.getAllSubscriptionRequests().get("MonthlyId1").getSubscriptionType(), MONTHLY);
    }

    @Test
    public void testSaveValidWeeklySubscriptionRequest() throws Exception {
        assertTrue(isEmpty(persister.getAllSubscriptionRequests()));
        persister.saveSubscriptionRequest(getWeeklySubscriptionRequest());
        assertFalse(isEmpty(persister.getAllSubscriptionRequests()));
        assertEquals(1, persister.getAllSubscriptionRequests().size());
        assertEquals(persister.getAllSubscriptionRequests().get("WeeklyId1").getSubscriptionType(), WEEKLY);
    }
}
