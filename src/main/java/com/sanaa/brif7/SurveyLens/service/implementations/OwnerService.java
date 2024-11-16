package com.sanaa.brif7.SurveyLens.service.implementations;

import com.sanaa.brif7.SurveyLens.Exeptions.EntityNotFoundException;
import com.sanaa.brif7.SurveyLens.dto.request.OwnerCreateDTO;
import com.sanaa.brif7.SurveyLens.dto.request.OwnerUpdateDTO;
import com.sanaa.brif7.SurveyLens.dto.response.OwnerResponseDTO;
import com.sanaa.brif7.SurveyLens.entity.Owner;
import com.sanaa.brif7.SurveyLens.mapper.OwnerMapper;
import com.sanaa.brif7.SurveyLens.repository.OwnerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OwnerService extends GenericService<Owner, OwnerCreateDTO, OwnerUpdateDTO, OwnerResponseDTO> {

    private final OwnerMapper ownerMapper;

    public OwnerService(OwnerRepository ownerRepository, OwnerMapper ownerMapper) {
        super(ownerRepository, ownerMapper);
        this.ownerMapper = ownerMapper;
    }


    @Override
    public Page<OwnerResponseDTO> findAll(Pageable pageable) {
        Page<Owner> owners = repository.findAll(pageable);
        return owners.map(ownerMapper::toDTO);
    }

    @Override
    public OwnerResponseDTO update(Long id, OwnerUpdateDTO updateOwnerDTO) {
        Owner owner = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Owner not found"));
        ownerMapper.updateEntityFromDTO(updateOwnerDTO, owner);
        return ownerMapper.toDTO(repository.save(owner));
    }
}
