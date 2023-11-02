package com.rateright.app.repo.dataAccessServices;

import com.rateright.app.model.IssueLog;
import com.rateright.app.model.Status;
import com.rateright.app.repo.IssueRepo;
import com.rateright.app.repo.dao.IssueDao;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository("issueJpa")
public class IssuesJPADataAccessServices implements IssueDao {

    private final IssueRepo issueRepo;

    public IssuesJPADataAccessServices(IssueRepo issueRepo) {
        this.issueRepo = issueRepo;
    }

    /**
     * @param issueLog
     */
    @Override
    public void raiseIssueTicket(IssueLog issueLog) {
        issueRepo.save(issueLog);
    }

    /**
     * @return
     */
    @Override
    public List<IssueLog> viewAllIssues() {
        return issueRepo.findAll();
    }

    /**
     * @param issueTime
     * @return
     */
    @Override
    public List<IssueLog> viewAllIssuesByTime(Date issueTime) {
        return issueRepo.findAllIssueLogByTicketTime(issueTime);
    }

    /**
     * @param customerId
     * @return
     */
    @Override
    public List<IssueLog> viewAllIssuesByCustomerId(Long customerId) {
        return issueRepo.findAllIssueLogByCustomerId(customerId);
    }

    /**
     * @param ticketId
     * @return
     */
    @Override
    public Optional<IssueLog> viewissueById(Long ticketId) {
        return issueRepo.findById(ticketId);
    }

    /**
     * @param status
     * @return
     */
    @Override
    public List<IssueLog> viewAllIssuesByStatus(Status status) {
        return issueRepo.findAllIssueLogByStatus(status);
    }
}
