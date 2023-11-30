package com.rateright.app.repo;

import com.rateright.app.model.IssueLog;
import com.rateright.app.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface IssueRepo extends JpaRepository<IssueLog, Long> {

    List<IssueLog> findAllIssueLogByTicketTime(Date issueTime);
    List<IssueLog> findAllIssueLogByStatus(Status status);
    /*List<IssueLog> findAllIssueLogByCustomerId(Long customerId);*/
}
