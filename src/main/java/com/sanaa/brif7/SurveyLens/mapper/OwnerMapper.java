package com.sanaa.brif7.SurveyLens.mapper;

import com.sanaa.brif7.SurveyLens.dto.request.OwnerCreateDTO;
import com.sanaa.brif7.SurveyLens.dto.request.OwnerUpdateDTO;
import com.sanaa.brif7.SurveyLens.dto.response.OwnerResponseDTO;
import com.sanaa.brif7.SurveyLens.entity.Owner;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
@Mapper(componentModel = "spring")
public interface OwnerMapper {

    @Mapping(target = "id", ignore = true)
    Owner toEntity(OwnerCreateDTO dto);


    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(OwnerUpdateDTO dto, @MappingTarget Owner owner);


    @Mapping(target = "surveys", source = "surveys")
    OwnerResponseDTO toResponseDto(Owner owner);
}
