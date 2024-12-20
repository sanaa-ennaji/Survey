package com.sanaa.brif7.SurveyLens.service.interfaces;

import com.sanaa.brif7.SurveyLens.dto.request.SubjectCreateDTO;
import com.sanaa.brif7.SurveyLens.dto.response.SubjectResponseDTO;

import java.util.List;
import java.util.Optional;


public interface SubjectServiceI {
    SubjectResponseDTO create(SubjectCreateDTO subjectRequestDTO);
    void delete(Long id);
    List<SubjectResponseDTO> findAll();
    Optional <SubjectResponseDTO> findById(Long id);
    SubjectResponseDTO update(Long id, SubjectCreateDTO subjectRequestDTO);

}
