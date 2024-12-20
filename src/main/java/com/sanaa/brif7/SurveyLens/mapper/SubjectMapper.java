package com.sanaa.brif7.SurveyLens.mapper;

import com.sanaa.brif7.SurveyLens.dto.request.SubjectCreateDTO;
import com.sanaa.brif7.SurveyLens.dto.response.SubjectResponseDTO;
import com.sanaa.brif7.SurveyLens.entity.Subject;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring", uses = SubjectMapperHelper.class)
public interface SubjectMapper {

    @Mapping(source = "parentSubject.id", target = "parentSubjectId")
    SubjectResponseDTO toResponseDTO(Subject entity);

    @Mapping(target = "parentSubject", source = "parentSubjectId")
    Subject toEntity(SubjectCreateDTO requestDTO);

    void updateEntityFromDTO(SubjectCreateDTO dto, @MappingTarget Subject subject);

    List<SubjectResponseDTO> toResponseDTOList(List<Subject> entities);

    List<Subject> toEntityList(List<SubjectCreateDTO> requestDTOs);
}




