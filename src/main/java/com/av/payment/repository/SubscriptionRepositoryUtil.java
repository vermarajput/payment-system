package com.av.payment.repository;

import com.av.payment.model.SubscriptionRequest;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static com.av.payment.model.type.SubscriptionTypeEnum.WEEKLY;
import static com.av.payment.util.Contants.DATE_PATTERN;
import static java.time.format.DateTimeFormatter.ofPattern;
import static java.time.temporal.ChronoUnit.MONTHS;
import static java.time.temporal.ChronoUnit.WEEKS;

/**
 * Created by Aman Verma on 18/03/2018.
 * <p>
 * Internal data struture used to save the data
 */
@Component
public class SubscriptionRepositoryUtil {
    /**
     * Computes dates on which invoice would be generated for Subscriptions
     *
     * @param subReq
     * @return
     */
    public List<String> computeInvoiceDates(SubscriptionRequest subReq) {
        List<String> invoiceDate = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_PATTERN);
        LocalDate startDate = LocalDate.parse(subReq.getStartDate(), ofPattern(DATE_PATTERN));
        LocalDate endDate = LocalDate.parse(subReq.getEndDate(), ofPattern(DATE_PATTERN));

        int period = 0;
        LocalDate current;

        if (subReq.getSubscriptionType().equals(WEEKLY)) {
            current = startDate.with(subReq.getDayOfWeek());
            period = ((int) WEEKS.between(startDate, endDate)); // as frequency cant span across 3 months, so precision loss
        } else {
            current = startDate.withDayOfMonth(subReq.getDateOfMonth());
            period = ((int) MONTHS.between(startDate, endDate)); // as frequency cant span across 3 months, so precision loss
        }

        if (current.isEqual(startDate) || current.isAfter(startDate)) {
            invoiceDate.add(formatter.format(current));
        }

        for (int i = 0; i < period; i++) {
            if (subReq.getSubscriptionType().equals(WEEKLY)) {
                current = current.plusWeeks(1);
            } else {
                current = current.plusMonths(1);
            }
            if (current.isAfter(endDate)) {
                return invoiceDate;
            }
            invoiceDate.add(formatter.format(current));
        }

        return invoiceDate;
    }
}
