package com.sanaa.brif7.SurveyLens.service.interfaces;

import com.sanaa.brif7.SurveyLens.dto.request.OwnerCreateDTO;
import com.sanaa.brif7.SurveyLens.dto.request.OwnerUpdateDTO;
import com.sanaa.brif7.SurveyLens.dto.response.OwnerResponseDTO;

import java.util.List;

public interface OwnerServiceI {
    OwnerResponseDTO create(OwnerCreateDTO createDTO);
    OwnerResponseDTO findById(Long id);
    List<OwnerResponseDTO> findAll();
    void deleteById(Long id);
    OwnerResponseDTO update(Long id, OwnerUpdateDTO updateDTO);
}
