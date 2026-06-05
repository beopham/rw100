package com.vti.backend.service;

import com.vti.entity.ExperienceCandidate;
import com.vti.entity.FresherCandidate;

public interface CandidateService {
    public void saveExperienceCandidate(ExperienceCandidate experienceCandidate);
    public void saveFresherCandidate(FresherCandidate fresherCandidate);
    public boolean loginCandidate(String email, String password);
}
