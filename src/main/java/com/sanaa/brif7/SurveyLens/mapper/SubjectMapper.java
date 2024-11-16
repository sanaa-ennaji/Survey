package com.sanaa.brif7.SurveyLens.mapper;

import com.sanaa.brif7.SurveyLens.dto.request.SubjectCreateDTO;
import com.sanaa.brif7.SurveyLens.dto.request.SubjectUpdateDTO;
import com.sanaa.brif7.SurveyLens.dto.response.SubjectResponseDTO;
import com.sanaa.brif7.SurveyLens.entity.Subject;
import com.sanaa.brif7.SurveyLens.mapper.components.SubjectResolver;
import com.sanaa.brif7.SurveyLens.mapper.components.SurveyEditionResolver;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring",uses = {SurveyEditionResolver.class , SubjectResolver.class})
public interface SubjectMapper extends GenericMapper<Subject, SubjectCreateDTO, SubjectUpdateDTO, SubjectResponseDTO> {

    @Override
    @Mapping(target = "surveyEdition", source = "surveyEditionId")
    @Mapping(target = "parentSubject", source = "parentSubjectId")
    Subject toEntity(SubjectCreateDTO subjectCreateDTO);

    @Override
    @Mapping(target = "surveyEdition", source = "surveyEditionId")
    @Mapping(target = "parentSubject", source = "parentSubjectId")
    void updateEntityFromDTO(SubjectUpdateDTO SubjectUpdateDTO, @MappingTarget Subject entity);

    @Override
    @Mapping(target = "surveyEdition", source = "surveyEdition")
    @Mapping(target = "parentSubject", source = "parentSubject")
    SubjectResponseDTO toDTO(Subject subject);
}




