package com.sanaa.brif7.SurveyLens.mapper;

import com.sanaa.brif7.SurveyLens.dto.request.SubjectCreateDTO;
import com.sanaa.brif7.SurveyLens.dto.response.SubjectResponseDTO;
import com.sanaa.brif7.SurveyLens.entity.Subject;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring", uses = SubjectMapperHelper.class)
public interface SubjectMapper {
    @Mapping(source = "parentSubject.id", target = "parentSubjectId")
    @Mapping(source = "subSubjects", target = "subSubjects")
    @Mapping(source = "surveyEdition.id", target = "surveyEditionId")
    @Mapping(source = "questions", target = "questions")
    SubjectResponseDTO toResponseDTO(Subject entity);

    @Mapping(target = "parentSubject", source = "parentSubjectId")
    Subject toEntity(SubjectCreateDTO requestDTO);

    void updateEntityFromDTO(SubjectCreateDTO dto, @MappingTarget Subject subject);
}




