package com.vti.backend.service.impl;

import com.vti.backend.repository.CandidateRepository;
import com.vti.backend.repository.impl.CandidateRepositoryImpl;
import com.vti.backend.service.CandidateService;
import com.vti.entity.ExperienceCandidate;
import com.vti.entity.FresherCandidate;

public class CandidateServiceImpl implements CandidateService {
    private CandidateRepository candidateRepository = new CandidateRepositoryImpl();
    @Override
    public void saveExperienceCandidate(ExperienceCandidate experienceCandidate) {
          candidateRepository.saveExperienceCandidate(experienceCandidate);
    }

    @Override
    public void saveFresherCandidate(FresherCandidate fresherCandidate) {
         candidateRepository.saveFresherCandidate(fresherCandidate);
    }

    @Override
    public boolean loginCandidate(String email, String password) {
        return candidateRepository.loginCandidate(email,password);
    }
}
