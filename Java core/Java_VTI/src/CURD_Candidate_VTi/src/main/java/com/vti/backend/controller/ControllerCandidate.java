package com.vti.backend.controller;

import com.vti.backend.service.CandidateService;
import com.vti.backend.service.impl.CandidateServiceImpl;
import com.vti.entity.ExperienceCandidate;
import com.vti.entity.FresherCandidate;

public class ControllerCandidate {
    private CandidateService candidateService=new CandidateServiceImpl();

    public void saveExperienceCandidate(ExperienceCandidate experienceCandidate) {
        candidateService.saveExperienceCandidate(experienceCandidate);
    }


    public void saveFresherCandidate(FresherCandidate fresherCandidate) {
        candidateService.saveFresherCandidate(fresherCandidate);
    }

    public boolean loginCandidate(String email, String password) {
        return candidateService.loginCandidate(email,password);
    }
}
