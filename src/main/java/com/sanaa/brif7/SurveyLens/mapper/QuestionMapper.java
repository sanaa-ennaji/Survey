package com.sanaa.brif7.SurveyLens.mapper;


import com.sanaa.brif7.SurveyLens.dto.request.QuestionCreateDTO;
import com.sanaa.brif7.SurveyLens.dto.request.QuestionUpdateDTO;
import com.sanaa.brif7.SurveyLens.dto.response.QuestionResponseDTO;
import com.sanaa.brif7.SurveyLens.entity.Question;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {SubjectMapper.class, AnswerMapper.class})
public interface QuestionMapper {

    QuestionMapper INSTANCE = Mappers.getMapper(QuestionMapper.class);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "subject.id", source = "subjectId")
    @Mapping(target = "answerCount", constant = "0")
    Question toEntity(QuestionCreateDTO dto);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "subject.id", source = "subjectId")
    void updateEntityFromDto(QuestionUpdateDTO dto, @MappingTarget Question question);


    @Mapping(target = "subject", source = "subject")
    @Mapping(target = "answers", source = "answers")
    QuestionResponseDTO toResponseDto(Question question);
}
