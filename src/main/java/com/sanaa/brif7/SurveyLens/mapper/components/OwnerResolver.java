package com.sanaa.brif7.SurveyLens.mapper.components;

import com.sanaa.brif7.SurveyLens.entity.Owner;
import com.sanaa.brif7.SurveyLens.repository.OwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
@Component
@RequiredArgsConstructor
public class OwnerResolver {
    private final OwnerRepository ownerRepository;

    public Owner mapOwnerIdToOwner(Long ownerId) {
        return ownerRepository.findById(ownerId).orElse(null);
    }

}
