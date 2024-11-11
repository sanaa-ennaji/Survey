package com.sanaa.brif7.SurveyLens.mapper;

import com.sanaa.brif7.SurveyLens.dto.request.SubjectCreateDTO;
import com.sanaa.brif7.SurveyLens.dto.request.SubjectUpdateDTO;
import com.sanaa.brif7.SurveyLens.dto.response.SubjectResponseDTO;
import com.sanaa.brif7.SurveyLens.entity.Subject;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {SubjectEmbeddebleMapper.class, SurveyEditionMapper.class, QuestionEmbeddebleMapper.class})
public interface SubjectMapper {

    SubjectMapper INSTANCE = Mappers.getMapper(SubjectMapper.class);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "parentSubject.id", source = "parentSubjectId")
    @Mapping(target = "surveyEdition.id", source = "surveyEditionId")
    Subject toEntity(SubjectCreateDTO dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "parentSubject.id", source = "parentSubjectId")
    @Mapping(target = "surveyEdition.id", source = "surveyEditionId")
    void updateEntityFromDto(SubjectUpdateDTO dto, @MappingTarget Subject subject);

    @Mapping(target = "parentSubject", source = "parentSubject")
    @Mapping(target = "subSubjects", source = "subSubjects")
    @Mapping(target = "surveyEdition", source = "surveyEdition")
    @Mapping(target = "questions", source = "questions")
    SubjectResponseDTO toResponseDto(Subject subject);
}
