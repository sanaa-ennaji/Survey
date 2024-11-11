package com.sanaa.brif7.SurveyLens.mapper;

import com.sanaa.brif7.SurveyLens.dto.request.AnswerCreateDTO;
import com.sanaa.brif7.SurveyLens.dto.request.AnswerUpdateDTO;
import com.sanaa.brif7.SurveyLens.dto.response.AnswerResponseDTO;
import com.sanaa.brif7.SurveyLens.entity.Answer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface AnswerMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "selectionCount", constant = "0")
    Answer toEntity(AnswerCreateDTO dto);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(AnswerUpdateDTO dto, @MappingTarget Answer answer);

    AnswerResponseDTO toResponseDto(Answer answer);
}
