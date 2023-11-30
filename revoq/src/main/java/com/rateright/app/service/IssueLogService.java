package com.rateright.app.service;

import com.rateright.app.exceptions.ResourceNotFoundException;
import com.rateright.app.model.IssueLog;
import com.rateright.app.model.Status;
import com.rateright.app.repo.dao.IssueDao;
import com.rateright.app.requests.RaiseIssueTicketRequest;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.util.DateUtil.now;

@Service
public class IssueLogService {
    private final IssueDao issueDao;

    public IssueLogService(IssueDao issueDao) {
        this.issueDao = issueDao;
    }

    public void raiseIssueTicket(RaiseIssueTicketRequest issueTicketRequest){
        IssueLog issueLog = IssueLog.builder()
                .issueDescription(issueTicketRequest.issueDescription())
                .status(Status.PENDING)
                .build();
        issueDao.raiseIssueTicket(issueLog);
    }
    public List<IssueLog> showAllRaisedIssues(){
        return issueDao.viewAllIssues();
    }
    public List<IssueLog> showAllIssuesRaisedByTime(Date issueTime){
        return issueDao.viewAllIssuesByTime(issueTime);
    }
    /*public List<IssueLog> viewAllIssuesByCustomerId(Long customerId){
        return  issueDao.viewAllIssuesByCustomerId(customerId);
    }*/
    public IssueLog viewissueById(Long ticketId){
        return issueDao.viewissueById(ticketId)
                .orElseThrow(()-> new ResourceNotFoundException("Issue Ticket Not Found"));
    }
    public List<IssueLog> viewAllIssuesByStatus(Status status){
        return issueDao.viewAllIssuesByStatus(status);
    }

}
