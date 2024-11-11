package com.sanaa.brif7.SurveyLens.mapper;

import com.sanaa.brif7.SurveyLens.dto.request.SurveyEditionCreateDTO;
import com.sanaa.brif7.SurveyLens.dto.request.SurveyEditionUpdateDTO;
import com.sanaa.brif7.SurveyLens.dto.response.SurveyEditionResponseDTO;
import com.sanaa.brif7.SurveyLens.entity.SurveyEdition;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = {AnswerEmbeddebleMapper.class, SurveyEditionEmbeddebleMapper.class})
public interface SurveyEditionMapper {

    SurveyEditionMapper INSTANCE = Mappers.getMapper(SurveyEditionMapper.class);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "survey.id", source = "surveyId")
    SurveyEdition toEntity(SurveyEditionCreateDTO dto);


    @Mapping(target = "survey.id", source = "surveyId")
    void updateEntityFromDto(SurveyEditionUpdateDTO dto, @MappingTarget SurveyEdition entity);

    @Mapping(target = "surveyEditions", source = "surveyEditions")
    SurveyEditionResponseDTO toResponseDto(SurveyEdition surveyEdition);

    List<SurveyEditionResponseDTO> toResponseDtos(List<SurveyEdition> surveyEditions);
}
