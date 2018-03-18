package com.av.repository;

import com.av.model.SubscriptionResponse;
import com.av.repository.persistor.SubscriptionPersister;
import com.av.repository.validator.RequestValidator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static com.av.repository.TestData.getMonthlySubscriptionRequest;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

/**
 * Created by Aman Verma on 18/03/2018.
 */
@RunWith(MockitoJUnitRunner.class)
public class SubscriptionRepositoryTest {
    @InjectMocks
    private SubscriptionRepository subscriptionRepository;

    @Mock
    private RequestValidator reqValidator;
    @Mock
    private SubscriptionPersister subPersister;
    @Mock
    private SubscriptionRepositoryUtil subReqUtil;

    List<String> dates;

    @Before
    public void setUp() throws Exception {
        dates = Arrays.asList("20/02/2001", "20/03/2001");
        doNothing().when(reqValidator).validateRequest(any(), any());
        doNothing().when(subPersister).saveSubscriptionRequest(any());
        when(subReqUtil.computeInvoiceDates(any())).thenReturn(dates);
    }

    @Test
    public void testFetchSubscriptionInvoiceDetails() throws Exception {
        SubscriptionResponse response = subscriptionRepository.fetchSubscriptionInvoiceDetails(getMonthlySubscriptionRequest());
        assertArrayEquals(dates.toArray(), response.getInvoiceDates().toArray());
    }

}