package com.sanaa.brif7.SurveyLens.mapper;

import com.sanaa.brif7.SurveyLens.dto.embbedable.SurveyEditionEmbeddebleDTO;
import com.sanaa.brif7.SurveyLens.entity.SurveyEdition;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SurveyEditionEmbeddebleMapper {
    SurveyEditionEmbeddebleDTO toEmbeddebleDto(SurveyEdition surveyEdition);
}
