package com.sanaa.brif7.SurveyLens.mapper;

import com.sanaa.brif7.SurveyLens.dto.embbedable.AnswerEmbeddebleDTO;
import com.sanaa.brif7.SurveyLens.entity.Answer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AnswerEmbeddebleMapper {
    AnswerEmbeddebleDTO toEmbeddebleDto(Answer answer);
}
