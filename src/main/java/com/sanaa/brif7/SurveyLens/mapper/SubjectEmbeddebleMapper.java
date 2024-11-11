package com.sanaa.brif7.SurveyLens.mapper;

import com.sanaa.brif7.SurveyLens.dto.embbedable.SubjectEmbeddebleDTO;
import com.sanaa.brif7.SurveyLens.entity.Subject;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubjectEmbeddebleMapper {
    SubjectEmbeddebleDTO toEmbeddebleDto(Subject subject);
}
