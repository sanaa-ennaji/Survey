package com.sanaa.brif7.SurveyLens.mapper;

import com.sanaa.brif7.SurveyLens.dto.request.AnswerCreateDTO;
import com.sanaa.brif7.SurveyLens.dto.request.AnswerUpdateDTO;
import com.sanaa.brif7.SurveyLens.dto.response.AnswerResponseDTO;
import com.sanaa.brif7.SurveyLens.entity.Answer;
import com.sanaa.brif7.SurveyLens.mapper.components.QuestionResolver;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring", uses = {QuestionResolver.class})
public interface AnswerMapper {


    @Mapping(target = "question.id", source = "questionId")
    Answer toEntity(AnswerCreateDTO answerCreateDTO);

    @Mapping(source = "question.id", target = "questionId")
    AnswerResponseDTO toDTO(Answer answer);

    List<AnswerResponseDTO> toDTOs(List<Answer> answers);

    @Mapping(target = "question", source = "questionId")
    void updateEntityFromDTO(AnswerUpdateDTO answerUpdateDTO, @MappingTarget Answer answer);
}

