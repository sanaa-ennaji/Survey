package com.sanaa.brif7.SurveyLens.mapper.components;

import com.sanaa.brif7.SurveyLens.entity.SurveyEdition;
import com.sanaa.brif7.SurveyLens.repository.SurveyEditionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SurveyEditionResolver {

    private SurveyEditionRepository surveyEditionRepository;

    public SurveyEdition mapSurveyEditionIdToSurveyEdition(Long surveyEditionId) {

        return surveyEditionRepository.findById(surveyEditionId).orElse(null);
    }
}
