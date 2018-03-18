package com.av.repository;

import com.av.model.SubscriptionRequest;
import com.av.model.SubscriptionResponse;
import com.av.repository.persistor.SubscriptionPersister;
import com.av.repository.validator.RequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static com.av.util.Contants.DATE_PATTERN;

/**
 * Created by Aman Verma on 18/03/2018.
 * <p>
 * Internal data struture used to save the data
 */
@Service
public class SubscriptionRepository {
    private final RequestValidator reqValidator;
    private final SubscriptionPersister reqPersister;
    private final SubscriptionRepositoryUtil subReqUtil;

    /**
     * @param reqValidator
     * @param reqPersister
     * @param subReqUtil
     */
    @Autowired
    public SubscriptionRepository(RequestValidator reqValidator, SubscriptionPersister reqPersister, SubscriptionRepositoryUtil subReqUtil) {
        this.reqValidator = reqValidator;
        this.reqPersister = reqPersister;
        this.subReqUtil = subReqUtil;
    }

    /**
     * Service endpoint /api/createSub
     * creates subscription, persists and send response with invoice dates details.
     *
     * @param subReq
     * @return
     */
    public SubscriptionResponse fetchSubscriptionInvoiceDetails(SubscriptionRequest subReq) {
        reqValidator.validateRequest(subReq, DATE_PATTERN);
        reqPersister.saveSubscriptionRequest(subReq);

        List<String> invoiceDates = subReqUtil.computeInvoiceDates(subReq);
        SubscriptionResponse response = new SubscriptionResponse(subReq.getId(), subReq.getAmount(), subReq.getSubscriptionType(), invoiceDates);

        return response;
    }
}
