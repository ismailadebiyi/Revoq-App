package com.rateright.app.requests;

import java.util.Date;

public record ResolutionPostRequest(
        Long ticketId,
        String resolutionComment,
        Date updateTime
) {
}
