package com.sanaa.brif7.SurveyLens.mapper;

import com.sanaa.brif7.SurveyLens.dto.request.SurveyCreateDTO;
import com.sanaa.brif7.SurveyLens.dto.request.SurveyUpdateDTO;
import com.sanaa.brif7.SurveyLens.dto.response.SurveyResponseDTO;
import com.sanaa.brif7.SurveyLens.entity.Survey;
import com.sanaa.brif7.SurveyLens.mapper.components.OwnerResolver;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {OwnerResolver.class})
public interface SurveyMapper extends GenericMapper<Survey, SurveyCreateDTO, SurveyUpdateDTO, SurveyResponseDTO> {

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "owner.id", source = "ownerId")
    Survey toEntity(SurveyCreateDTO dto);

    @Override
    @Mapping(target = "owner", source = "owner")
    @Mapping(target = "surveyEditions", source = "surveyEditions")
    @Mapping(target = "survey", source = "survey")  
    SurveyResponseDTO toDTO(Survey survey);
}
