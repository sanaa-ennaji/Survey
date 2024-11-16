package com.sanaa.brif7.SurveyLens.mapper;

import com.sanaa.brif7.SurveyLens.dto.request.QuestionCreateDTO;
import com.sanaa.brif7.SurveyLens.dto.request.QuestionUpdateDTO;
import com.sanaa.brif7.SurveyLens.dto.response.QuestionResponseDTO;
import com.sanaa.brif7.SurveyLens.entity.Question;
import com.sanaa.brif7.SurveyLens.mapper.components.SubjectResolver;
import com.sanaa.brif7.SurveyLens.mapper.components.SurveyEditionResolver;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring",uses = {SubjectResolver.class})
public interface QuestionMapper extends GenericMapper<Question, QuestionCreateDTO, QuestionUpdateDTO, QuestionResponseDTO> {

    @Override
    @Mapping(target = "subject", source = "subjectId")
    Question toEntity(QuestionCreateDTO questionCreateDTO);

    @Override
    @Mapping(target = "subject", source = "subjectId")
    void updateEntityFromDTO(QuestionUpdateDTO questionUpdateDTO, @MappingTarget Question question);

    @Override
    @Mapping(target = "subject", source = "subject")
    QuestionResponseDTO toDTO(Question question);
}


