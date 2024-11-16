package com.sanaa.brif7.SurveyLens.mapper;

import com.sanaa.brif7.SurveyLens.dto.request.SurveyEditionCreateDTO;
import com.sanaa.brif7.SurveyLens.dto.request.SurveyEditionUpdateDTO;
import com.sanaa.brif7.SurveyLens.dto.response.SurveyEditionResponseDTO;
import com.sanaa.brif7.SurveyLens.entity.SurveyEdition;
import com.sanaa.brif7.SurveyLens.mapper.components.SurveyResolver;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring",uses = {SurveyResolver.class})
public interface SurveyEditionMapper extends GenericMapper<SurveyEdition, SurveyEditionCreateDTO, SurveyEditionUpdateDTO, SurveyEditionResponseDTO> {

    @Override
    @Mapping(target = "survey.id", source = "surveyId")
    SurveyEdition toEntity(SurveyEditionCreateDTO dto);

    @Override
    @Mapping(target = "survey.id", source = "surveyId")
    void updateEntityFromDTO(SurveyEditionUpdateDTO dto, @MappingTarget SurveyEdition entity);

    @Override
    @Mapping(target = "survey", source = "survey")
    SurveyEditionResponseDTO toDTO(SurveyEdition surveyEdition);
}


