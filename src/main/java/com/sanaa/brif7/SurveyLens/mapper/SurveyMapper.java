package com.sanaa.brif7.SurveyLens.mapper;

import com.sanaa.brif7.SurveyLens.dto.request.SurveyCreateDTO;
import com.sanaa.brif7.SurveyLens.dto.response.SurveyResponseDTO;
import com.sanaa.brif7.SurveyLens.entity.Survey;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {OwnerEmbeddebleMapper.class, SurveyEditionEmbeddebleMapper.class})
public interface SurveyMapper {

    SurveyMapper INSTANCE = Mappers.getMapper(SurveyMapper.class);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "owner.id", source = "ownerId")
    Survey toEntity(SurveyCreateDTO dto);


    @Mapping(target = "owner", source = "owner")
    @Mapping(target = "surveyEditions", source = "surveyEditions")
    SurveyResponseDTO toResponseDto(Survey survey);
}
