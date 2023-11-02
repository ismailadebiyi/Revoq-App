package com.rateright.app.service;

import com.rateright.app.model.Resolutions;
import com.rateright.app.repo.dao.ResolutionDao;
import com.rateright.app.requests.ResolutionPostRequest;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.assertj.core.util.DateUtil.now;

@Service
public class ResolutionService {

    private final ResolutionDao resolutionDao;

    public ResolutionService(ResolutionDao resolutionDao) {
        this.resolutionDao = resolutionDao;
    }

    public void postResolutionComment(ResolutionPostRequest request){
        Resolutions resolutions = Resolutions.builder()
                .ticketId(request.ticketId())
                .resolutionComments(request.resolutionComment())
                .updateTime(now())
                .build();
        resolutionDao.postResolutionComment(resolutions);
    }
    public List<Resolutions> showAllResolution(){
        return resolutionDao.showAllResolutions();
    }

    public List<Resolutions> showAllResolutionByTicketId(Long ticketId){
        return resolutionDao.showAllResolutionByTicketId(ticketId);
    }
}
