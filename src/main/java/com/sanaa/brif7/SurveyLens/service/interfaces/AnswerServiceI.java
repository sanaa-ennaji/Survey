package com.sanaa.brif7.SurveyLens.service.interfaces;

import com.sanaa.brif7.SurveyLens.dto.request.AnswerCreateDTO;
import com.sanaa.brif7.SurveyLens.dto.request.AnswerUpdateDTO;
import com.sanaa.brif7.SurveyLens.dto.response.AnswerResponseDTO;


import java.util.List;


public interface AnswerServiceI extends IGenericService<AnswerCreateDTO, AnswerUpdateDTO, AnswerResponseDTO> {
    List<AnswerResponseDTO> getAnswerByQuestionId(Long questionId);
}
