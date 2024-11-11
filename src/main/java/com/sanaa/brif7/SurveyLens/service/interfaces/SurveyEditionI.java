package com.sanaa.brif7.SurveyLens.service.interfaces;

import com.sanaa.brif7.SurveyLens.dto.request.SurveyCreateDTO;
import com.sanaa.brif7.SurveyLens.dto.request.SurveyUpdateDTO;
import com.sanaa.brif7.SurveyLens.dto.response.SurveyResponseDTO;

import java.util.List;

public interface SurveyEditionI {
    SurveyResponseDTO create(SurveyCreateDTO createDTO);
    SurveyResponseDTO findById(Long id);
    List<SurveyResponseDTO> findAll();
    void deleteById(Long id);
    SurveyResponseDTO update(Long id, SurveyUpdateDTO updateDTO);
}
