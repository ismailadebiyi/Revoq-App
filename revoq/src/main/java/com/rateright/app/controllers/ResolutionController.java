package com.rateright.app.controllers;

import com.rateright.app.model.Resolutions;
import com.rateright.app.requests.ResolutionPostRequest;
import com.rateright.app.service.ResolutionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/resolution")
@Slf4j
public class ResolutionController {

    private final ResolutionService resolutionService;

    public ResolutionController(ResolutionService resolutionService) {
        this.resolutionService = resolutionService;
    }

    @PostMapping
    public void postResolutionComment(@RequestBody ResolutionPostRequest postRequest){
        resolutionService.postResolutionComment(postRequest);
    }

    @GetMapping
    public List<Resolutions> showAllResolution(){
        return resolutionService.showAllResolution();
    }
}
