package com.sanaa.brif7.SurveyLens.service.interfaces;

import com.sanaa.brif7.SurveyLens.dto.request.AnswerCreateDTO;
import com.sanaa.brif7.SurveyLens.dto.request.AnswerUpdateDTO;
import com.sanaa.brif7.SurveyLens.dto.response.AnswerResponseDTO;
import java.util.List;

public interface AnswerServiceI {

    AnswerResponseDTO create(AnswerCreateDTO createDTO);
    AnswerResponseDTO findById(Long id);
    List<AnswerResponseDTO> findAll();
    void deleteById(Long id);
    AnswerResponseDTO update(Long id, AnswerUpdateDTO updateDTO);
}
