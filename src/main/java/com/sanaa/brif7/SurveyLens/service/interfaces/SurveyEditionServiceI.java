package com.sanaa.brif7.SurveyLens.service.interfaces;

import com.sanaa.brif7.SurveyLens.dto.request.SurveyEditionCreateDTO;
import com.sanaa.brif7.SurveyLens.dto.request.SurveyEditionUpdateDTO;
import com.sanaa.brif7.SurveyLens.dto.response.SurveyEditionResponseDTO;

import java.util.List;

public interface SurveyEditionServiceI {
    SurveyEditionResponseDTO create(SurveyEditionCreateDTO createDTO);
    SurveyEditionResponseDTO findById(Long id);
    List<SurveyEditionResponseDTO> findAll();
    void deleteById(Long id);
    SurveyEditionResponseDTO update(Long id, SurveyEditionUpdateDTO updateDTO);
}
