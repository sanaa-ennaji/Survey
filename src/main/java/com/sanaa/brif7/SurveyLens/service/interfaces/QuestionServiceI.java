package com.sanaa.brif7.SurveyLens.service.interfaces;

import com.sanaa.brif7.SurveyLens.dto.request.QuestionCreateDTO;
import com.sanaa.brif7.SurveyLens.dto.request.QuestionUpdateDTO;
import com.sanaa.brif7.SurveyLens.dto.response.QuestionResponseDTO;

import java.util.List;
public interface QuestionServiceI {
    QuestionResponseDTO create(QuestionCreateDTO createDTO);
    QuestionResponseDTO findById(Long id);
    List<QuestionResponseDTO> findAll();
    void deleteById(Long id);
    QuestionResponseDTO update(Long id, QuestionUpdateDTO updateDTO);
}
