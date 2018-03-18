package com.av.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.DayOfWeek;

/**
 * Created by Aman Verma on 16/03/2018.
 */

public class SubscriptionRequest extends BaseSubscription {
    @JsonProperty("day_of_week")
    private DayOfWeek dayOfWeek;

    @JsonProperty("date_of_month")
    private Integer dateOfMonth;

    @JsonProperty("start_date")
    private String startDate;

    @JsonProperty("end_date")
    private String endDate;

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Integer getDateOfMonth() {
        return dateOfMonth;
    }

    public void setDateOfMonth(Integer dateOfMonth) {
        this.dateOfMonth = dateOfMonth;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return super.toString() +
                "SubscriptionRequest{" +
                "dayOfWeek='" + dayOfWeek + '\'' +
                ", dateOfMonth='" + dateOfMonth + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }
}