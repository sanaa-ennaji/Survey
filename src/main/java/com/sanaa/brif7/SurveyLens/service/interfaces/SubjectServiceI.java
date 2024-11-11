package com.sanaa.brif7.SurveyLens.service.interfaces;
import com.sanaa.brif7.SurveyLens.dto.request.SubjectUpdateDTO;
import com.sanaa.brif7.SurveyLens.dto.request.SubjectCreateDTO;
import com.sanaa.brif7.SurveyLens.dto.response.SubjectResponseDTO;

import java.util.List;

public interface SubjectServiceI {
    SubjectResponseDTO create(SubjectCreateDTO createDTO);
    SubjectResponseDTO findById(Long id);
    List<SubjectResponseDTO> findAll();
    void deleteById(Long id);
    SubjectResponseDTO update(Long id, SubjectUpdateDTO updateDTO);
}
