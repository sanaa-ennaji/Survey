package com.sanaa.brif7.SurveyLens.mapper.components;

import com.sanaa.brif7.SurveyLens.entity.Survey;
import com.sanaa.brif7.SurveyLens.repository.SurveyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SurveyResolver {

    private SurveyRepository surveyRepository;

    public Survey mapSurveyIdToSurvey(Long surveyId) {
        return surveyRepository.findById(surveyId).orElse(null);
    }
}
