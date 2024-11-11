package com.sanaa.brif7.SurveyLens.mapper;

import com.sanaa.brif7.SurveyLens.dto.embbedable.QuestionEmbeddebleDTO;
import com.sanaa.brif7.SurveyLens.entity.Question;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuestionEmbeddebleMapper {
    QuestionEmbeddebleDTO toEmbeddebleDto(Question question);
}
