package com.sanaa.brif7.SurveyLens.service.interfaces;

import com.sanaa.brif7.SurveyLens.dto.request.OwnerCreateDTO;
import com.sanaa.brif7.SurveyLens.dto.request.OwnerUpdateDTO;
import com.sanaa.brif7.SurveyLens.dto.response.OwnerResponseDTO;

import java.util.List;

public interface OwnerServiceI {

    List<OwnerResponseDTO> findAll();
    OwnerResponseDTO findById(Long id);
    void delete(Long id);
    OwnerResponseDTO update(Long id, OwnerUpdateDTO ownerUpdateDTO);
    OwnerResponseDTO create(OwnerCreateDTO ownerCreateDTO);
}
