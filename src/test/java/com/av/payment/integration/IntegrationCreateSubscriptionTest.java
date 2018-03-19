package com.av.payment.integration;

import com.av.payment.PaymentSystemApplication;
import com.av.payment.model.SubscriptionRequest;
import com.av.payment.model.SubscriptionResponse;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import static com.av.payment.repository.TestData.getMonthlySubscriptionRequest;
import static com.av.payment.repository.TestData.getWeeklySubscriptionRequest;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Aman Verma on 18/03/2018.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = PaymentSystemApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationCreateSubscriptionTest {
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    private TestRestTemplate restTemplate = new TestRestTemplate();
    private HttpHeaders headers = new HttpHeaders();

    @LocalServerPort
    private int port;

    /**
     * Tests endpoint /api/createSub for subscription creation
     *
     * @throws Exception
     */
    @Test
    public void testCreateMonthlySubscription() throws Exception {
        HttpEntity<SubscriptionRequest> entity = new HttpEntity<>(getMonthlySubscriptionRequest(), headers);

        ResponseEntity<SubscriptionResponse> response = restTemplate.exchange(
                createURLWithPort("/api/createSub"),
                HttpMethod.POST, entity, SubscriptionResponse.class);

        assertTrue(response.getStatusCode().equals(HttpStatus.OK));
        SubscriptionResponse actual = response.getBody();
        assertArrayEquals(new String[]{"20/02/2016", "20/03/2016"}, actual.getInvoiceDates().toArray());
    }

    @Test
    public void testCreateWeeklySubscription() throws Exception {
        HttpEntity<SubscriptionRequest> entity = new HttpEntity<>(getWeeklySubscriptionRequest(), headers);

        ResponseEntity<SubscriptionResponse> response = restTemplate.exchange(
                createURLWithPort("/api/createSub"),
                HttpMethod.POST, entity, SubscriptionResponse.class);

        assertTrue(response.getStatusCode().equals(HttpStatus.OK));
        SubscriptionResponse actual = response.getBody();
        String[] expectedInvoiceDates = {
                "02/02/2016",
                "09/02/2016",
                "16/02/2016",
                "23/02/2016",
                "01/03/2016",
                "08/03/2016",
                "15/03/2016",
                "22/03/2016",
                "29/03/2016"};
        assertArrayEquals(expectedInvoiceDates, actual.getInvoiceDates().toArray());
    }

    @Test
    public void testCreateSubscriptionWrongData() throws Exception {
        SubscriptionRequest subReq = getWeeklySubscriptionRequest();
        subReq.setDayOfWeek(null);
        HttpEntity<SubscriptionRequest> entity = new HttpEntity<>(subReq, headers);

        ResponseEntity<SubscriptionResponse> response = restTemplate.exchange(
                createURLWithPort("/api/createSub"),
                HttpMethod.POST, entity, SubscriptionResponse.class);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }

}
