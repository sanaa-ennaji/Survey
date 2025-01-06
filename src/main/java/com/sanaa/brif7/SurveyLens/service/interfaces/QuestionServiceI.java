package com.sanaa.brif7.SurveyLens.service.interfaces;


import com.sanaa.brif7.SurveyLens.dto.request.QuestionCreateDTO;
import com.sanaa.brif7.SurveyLens.dto.request.QuestionUpdateDTO;
import com.sanaa.brif7.SurveyLens.dto.response.QuestionResponseDTO;

import java.util.List;


public interface QuestionServiceI  extends IGenericService<QuestionCreateDTO, QuestionUpdateDTO, QuestionResponseDTO> {
    List<QuestionResponseDTO> findAll();
}
