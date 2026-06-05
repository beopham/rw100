package com.vti.backend.repository;

import com.vti.entity.ExperienceCandidate;
import com.vti.entity.FresherCandidate;

public interface CandidateRepository {

    public void saveExperienceCandidate(ExperienceCandidate experienceCandidate);
    public void saveFresherCandidate(FresherCandidate fresherCandidate);
    public  boolean loginCandidate(String email, String password);
}
