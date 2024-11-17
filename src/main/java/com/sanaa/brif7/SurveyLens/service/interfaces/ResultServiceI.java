package com.sanaa.brif7.SurveyLens.service.interfaces;

import com.sanaa.brif7.SurveyLens.dto.SurveyResultDTO;

public interface ResultServiceI {

  SurveyResultDTO getResults(Long surveyId);
}