package com.sanaa.brif7.SurveyLens.service.impl;


import com.sanaa.brif7.SurveyLens.dto.request.OwnerCreateDTO;
import com.sanaa.brif7.SurveyLens.dto.request.OwnerUpdateDTO;
import com.sanaa.brif7.SurveyLens.dto.response.OwnerResponseDTO;
import com.sanaa.brif7.SurveyLens.entity.Owner;
import com.sanaa.brif7.SurveyLens.mapper.OwnerMapper;
import com.sanaa.brif7.SurveyLens.repository.OwnerRepository;
import com.sanaa.brif7.SurveyLens.service.interfaces.OwnerServiceI;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService implements OwnerServiceI {

    private final OwnerRepository ownerRepository;
    private final OwnerMapper ownerMapper;

    public OwnerService(OwnerRepository ownerRepository, OwnerMapper ownerMapper) {
        this.ownerRepository = ownerRepository;
        this.ownerMapper = ownerMapper;
    }

    @Override
    public OwnerResponseDTO create(OwnerCreateDTO ownerCreateDTO) {
        Owner owner = ownerMapper.toEntity(ownerCreateDTO);
        Owner savedOwner = ownerRepository.save(owner);
        return ownerMapper.toDTO(savedOwner);
    }

    @Override
    public OwnerResponseDTO update(Long id, OwnerUpdateDTO ownerUpdateDTO) {
        Owner existingOwner = ownerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Owner not found with ID: " + id));
        ownerMapper.updateEntity(ownerUpdateDTO, existingOwner);
        Owner updatedOwner = ownerRepository.save(existingOwner);
        return ownerMapper.toDTO(updatedOwner);
    }

    @Override
    public void delete(Long id) {
        if (!ownerRepository.existsById(id)) {
            throw new IllegalArgumentException("Owner not found with ID: " + id);
        }
        ownerRepository.deleteById(id);
    }

    @Override
    public OwnerResponseDTO findById(Long id) {
        Owner owner = ownerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Owner not found with ID: " + id));
        return ownerMapper.toDTO(owner);
    }



    @Override
    public List<OwnerResponseDTO> findAll() {
        List<Owner> owners = ownerRepository.findAll();
        return owners.stream()
                .map(ownerMapper::toDTO)
                .toList();
    }
}

