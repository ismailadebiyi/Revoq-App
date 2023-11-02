package com.rateright.app.repo;

import com.rateright.app.model.Resolutions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResolutionRepo extends JpaRepository<Resolutions, Long> {

    List<Resolutions> findAllResolutionsByTicketId(Long ticketId);
}
