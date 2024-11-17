package com.sanaa.brif7.SurveyLens.service.interfaces;

import com.sanaa.brif7.SurveyLens.dto.ParticipationDTO;

public interface ParticipationServiceI {

    void saveParticipation(Long surveyId, ParticipationDTO participationDTO);
}