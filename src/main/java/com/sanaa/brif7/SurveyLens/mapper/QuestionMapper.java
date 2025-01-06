package com.sanaa.brif7.SurveyLens.mapper;

import com.sanaa.brif7.SurveyLens.dto.request.QuestionCreateDTO;
import com.sanaa.brif7.SurveyLens.dto.request.QuestionUpdateDTO;
import com.sanaa.brif7.SurveyLens.dto.response.QuestionResponseDTO;
import com.sanaa.brif7.SurveyLens.entity.Question;
import com.sanaa.brif7.SurveyLens.mapper.components.SubjectResolver;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring", uses = {AnswerMapper.class})
public interface QuestionMapper {


    QuestionResponseDTO toResponseDTO(Question entity);
    @Mapping(target =  "subject.id", source = "subjectId")
    Question toEntity (QuestionCreateDTO requestDTO);
    QuestionResponseDTO toDTO(Question question);
    void updateEntityFromRequest(QuestionUpdateDTO questionRequestDTO,@MappingTarget Question question);
}



