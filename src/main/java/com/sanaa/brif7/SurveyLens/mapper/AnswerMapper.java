package com.sanaa.brif7.SurveyLens.mapper;

import com.sanaa.brif7.SurveyLens.dto.request.AnswerCreateDTO;
import com.sanaa.brif7.SurveyLens.dto.request.AnswerUpdateDTO;
import com.sanaa.brif7.SurveyLens.dto.response.AnswerResponseDTO;
import com.sanaa.brif7.SurveyLens.entity.Answer;
import com.sanaa.brif7.SurveyLens.mapper.components.QuestionResolver;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring",uses = {QuestionResolver.class})
public interface AnswerMapper extends GenericMapper<Answer, AnswerCreateDTO, AnswerUpdateDTO, AnswerResponseDTO> {

    @Override
    @Mapping(target = "question", source = "questionId")
    Answer toEntity(AnswerCreateDTO answerCreateDTO);

    @Override
    @Mapping(target = "question", source = "questionId")
    void updateEntityFromDTO(AnswerUpdateDTO answerCreateDTO, @MappingTarget Answer answer);

    @Override
    @Mapping(target = "question", source = "question")
    AnswerResponseDTO toDTO(Answer answer);
}