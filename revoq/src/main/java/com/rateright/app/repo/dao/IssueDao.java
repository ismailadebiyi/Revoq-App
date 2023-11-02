package com.rateright.app.repo.dao;

import com.rateright.app.model.IssueLog;
import com.rateright.app.model.Status;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IssueDao {

    void raiseIssueTicket(IssueLog issueLog);
    List<IssueLog> viewAllIssues();
    List<IssueLog> viewAllIssuesByTime(Date issueTime);
    List<IssueLog> viewAllIssuesByCustomerId(Long customerId);
    Optional<IssueLog> viewissueById(Long ticketId);
    List<IssueLog> viewAllIssuesByStatus(Status status);
}
