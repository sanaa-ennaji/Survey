package com.sanaa.brif7.SurveyLens.service.impl;

import com.sanaa.brif7.SurveyLens.dto.request.SurveyCreateDTO;
import com.sanaa.brif7.SurveyLens.dto.request.SurveyUpdateDTO;
import com.sanaa.brif7.SurveyLens.dto.response.SurveyResponseDTO;
import com.sanaa.brif7.SurveyLens.entity.Survey;
import com.sanaa.brif7.SurveyLens.mapper.SurveyMapper;
import com.sanaa.brif7.SurveyLens.repository.SurveyRepository;
import com.sanaa.brif7.SurveyLens.service.interfaces.SurveyServiceI;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SurveyService extends GenericService<Survey, SurveyCreateDTO, SurveyUpdateDTO, SurveyResponseDTO> implements SurveyServiceI {

    private final SurveyRepository surveyRepository;
    private final SurveyMapper surveyMapper;

    public SurveyService(SurveyRepository surveyRepository, SurveyMapper surveyMapper) {
        super(surveyRepository, surveyMapper);
        this.surveyRepository = surveyRepository;
        this.surveyMapper = surveyMapper;
    }


}
