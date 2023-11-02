package com.rateright.app.requests;

import com.rateright.app.model.Status;

import java.util.Date;

public record RaiseIssueTicketRequest(
        Long customerId,
        String issueDescription,
        Status issueStatus,
        Date ticketTime
) {
}
