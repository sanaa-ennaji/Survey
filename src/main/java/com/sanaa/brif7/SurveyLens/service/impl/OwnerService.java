package com.sanaa.brif7.SurveyLens.service.impl;


import com.sanaa.brif7.SurveyLens.dto.request.OwnerCreateDTO;
import com.sanaa.brif7.SurveyLens.dto.request.OwnerUpdateDTO;
import com.sanaa.brif7.SurveyLens.dto.response.OwnerResponseDTO;
import com.sanaa.brif7.SurveyLens.entity.Owner;
import com.sanaa.brif7.SurveyLens.mapper.OwnerMapper;
import com.sanaa.brif7.SurveyLens.repository.OwnerRepository;
import com.sanaa.brif7.SurveyLens.service.interfaces.OwnerServiceI;
import org.springframework.stereotype.Service;

@Service
public class OwnerService extends GenericService<Owner, OwnerCreateDTO, OwnerUpdateDTO, OwnerResponseDTO> implements OwnerServiceI {


        public OwnerService(OwnerRepository ownerRepository, OwnerMapper ownerMapper) {
            super(ownerRepository, ownerMapper);
        }



}
