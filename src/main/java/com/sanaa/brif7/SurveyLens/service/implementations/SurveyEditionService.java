package com.sanaa.brif7.SurveyLens.service.implementations;

import com.sanaa.brif7.SurveyLens.dto.request.SurveyEditionCreateDTO;
import com.sanaa.brif7.SurveyLens.dto.request.SurveyEditionUpdateDTO;
import com.sanaa.brif7.SurveyLens.dto.response.SurveyEditionResponseDTO;
import com.sanaa.brif7.SurveyLens.entity.SurveyEdition;
import com.sanaa.brif7.SurveyLens.mapper.SurveyEditionMapper;
import com.sanaa.brif7.SurveyLens.repository.SurveyEditionRepository;
import com.sanaa.brif7.SurveyLens.service.interfaces.SurveyEditionServiceI;
import org.springframework.stereotype.Service;

@Service
public class SurveyEditionService extends GenericService<SurveyEdition, SurveyEditionCreateDTO, SurveyEditionUpdateDTO, SurveyEditionResponseDTO> implements SurveyEditionServiceI {

    public SurveyEditionService(SurveyEditionRepository surveyEditionRepository, SurveyEditionMapper surveyEditionMapper) {
        super(surveyEditionRepository,surveyEditionMapper);
    }

}
