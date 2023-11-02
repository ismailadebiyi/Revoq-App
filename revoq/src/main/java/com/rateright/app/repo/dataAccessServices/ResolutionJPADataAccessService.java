package com.rateright.app.repo.dataAccessServices;

import com.rateright.app.model.Resolutions;
import com.rateright.app.repo.ResolutionRepo;
import com.rateright.app.repo.dao.ResolutionDao;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("resolveJpa")
public class ResolutionJPADataAccessService implements ResolutionDao {

    private final ResolutionRepo resolutionRepo;

    public ResolutionJPADataAccessService(ResolutionRepo resolutionRepo) {
        this.resolutionRepo = resolutionRepo;
    }

    @Override
    public void postResolutionComment(Resolutions resolution) {
        resolutionRepo.save(resolution);

    }

    @Override
    public List<Resolutions> showAllResolutionByTicketId(Long ticketId) {
        return resolutionRepo.findAllResolutionsByTicketId(ticketId);
    }

    @Override
    public List<Resolutions> showAllResolutions() {
        return resolutionRepo.findAll();
    }
}
