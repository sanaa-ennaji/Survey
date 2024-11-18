package com.sanaa.brif7.SurveyLens.service.interfaces;

import com.sanaa.brif7.SurveyLens.dto.PaginationDTO;


public interface IGenericService<CreateDTO, UpdateDTO, ResponseDTO> {
    ResponseDTO create(CreateDTO createDTO);
    ResponseDTO findById(Long id);
    PaginationDTO<ResponseDTO> findAll(int page, int size);
    void deleteById(Long id);
    ResponseDTO update(Long id, UpdateDTO updateDTO);
}

