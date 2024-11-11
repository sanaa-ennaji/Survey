package com.sanaa.brif7.SurveyLens.dto.response;

import com.sanaa.brif7.SurveyLens.dto.embbedable.AnswerEmbeddebleDTO;
import com.sanaa.brif7.SurveyLens.dto.embbedable.SurveyEditionEmbeddebleDTO;

import java.util.List;

public class SurveyEditionResponseDTO {

    private Long id;

    private String title;

    private String description;

    private AnswerEmbeddebleDTO owner;

    private List<SurveyEditionEmbeddebleDTO> surveyEditions ;
}
