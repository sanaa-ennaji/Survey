package com.sanaa.brif7.SurveyLens.service.implementations;

import com.sanaa.brif7.SurveyLens.dto.request.SurveyCreateDTO;
import com.sanaa.brif7.SurveyLens.dto.request.SurveyUpdateDTO;
import com.sanaa.brif7.SurveyLens.dto.response.SurveyResponseDTO;
import com.sanaa.brif7.SurveyLens.entity.Survey;
import com.sanaa.brif7.SurveyLens.mapper.SurveyMapper;
import com.sanaa.brif7.SurveyLens.repository.SurveyRepository;
import com.sanaa.brif7.SurveyLens.service.interfaces.SurveyServiceI;
import org.springframework.stereotype.Service;

@Service
public class SurveyService extends GenericService<Survey, SurveyCreateDTO, SurveyUpdateDTO, SurveyResponseDTO> implements SurveyServiceI {

    public SurveyService(SurveyRepository surveyRepository , SurveyMapper surveyMapper) {
        super(surveyRepository , surveyMapper);
    }

}