package com.av.repository.validator;

import com.av.exception.PaymentSubscriptionException;
import com.av.model.SubscriptionRequest;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

import static com.av.model.type.SubscriptionTypeEnum.MONTHLY;
import static com.av.model.type.SubscriptionTypeEnum.WEEKLY;
import static java.time.format.DateTimeFormatter.ofPattern;
import static java.time.temporal.ChronoUnit.MONTHS;
import static org.springframework.util.StringUtils.isEmpty;

/**
 * Created by Aman Verma on 18/03/2018.
 */
@Component
public class RequestValidatorImpl implements RequestValidator {

    /**
     * Validate requests
     * throws exception if Start Date is greater than End Date
     * throws exception if subscription duration is more than 3 months
     *
     * @param subReq
     */
    @Override
    public void validateRequest(SubscriptionRequest subReq, String datePattern) {
        LocalDate startDate = parseDate(subReq.getStartDate(), datePattern);
        LocalDate endDate = parseDate(subReq.getEndDate(), datePattern);

        if (startDate.isAfter(endDate)) {
            throw new PaymentSubscriptionException("StartDate cannot be after EndDate.");
        }
        if (MONTHS.between(startDate, endDate) > 3) {
            throw new PaymentSubscriptionException("Subscription cannot be more than 3 months.");
        }
        if (subReq.getSubscriptionType().equals(WEEKLY) && isEmpty(subReq.getDayOfWeek())) {
            throw new PaymentSubscriptionException("Day of week information is mandatory if Subscription type is Weekly.");
        }
        if (subReq.getSubscriptionType().equals(MONTHLY) && isEmpty(subReq.getDateOfMonth())) {
            throw new PaymentSubscriptionException("Date of month information is mandatory if Subscription type is Monthly.");
        }
    }

    /**
     * Parse date as per pattern given, throws exception if invalid input.
     *
     * @param date
     * @param datePattern
     * @return
     */
    private LocalDate parseDate(String date, String datePattern) {
        try {
            return LocalDate.parse(date, ofPattern(datePattern));
        } catch (Exception exception) {
            throw new PaymentSubscriptionException("Invalid date [" + date + "]\n" +
                    "Valid format [" + datePattern + "]");
        }
    }
}
