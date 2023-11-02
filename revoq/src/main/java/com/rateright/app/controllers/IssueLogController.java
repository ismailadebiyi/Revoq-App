package com.rateright.app.controllers;

import com.rateright.app.requests.RaiseIssueTicketRequest;
import com.rateright.app.service.IssueLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("api/v1/issueLog")
public class IssueLogController {

    private final IssueLogService logService;

    public IssueLogController(IssueLogService logService) {
        this.logService = logService;
    }
    /* TODO
        View all ticket raised
        View all ticket raised by customer, time, and status
        Update Ticket status
    * */

    @PostMapping
    public void raiseIssueTicket(@RequestBody RaiseIssueTicketRequest ticketRequest){
        log.info("New Issue raise {}",ticketRequest);
        logService.raiseIssueTicket(ticketRequest);
    }
}
