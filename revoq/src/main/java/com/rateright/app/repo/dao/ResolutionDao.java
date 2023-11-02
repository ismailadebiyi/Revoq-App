package com.rateright.app.repo.dao;

import com.rateright.app.model.Resolutions;

import java.util.List;

public interface ResolutionDao {

    void postResolutionComment(Resolutions resolution);
    List<Resolutions> showAllResolutionByTicketId(Long ticketId);
    List<Resolutions> showAllResolutions();

}
