package com.sanaa.brif7.SurveyLens.dto.response;

import com.sanaa.brif7.SurveyLens.dto.embbedable.QuestionEmbeddebleDTO;
import com.sanaa.brif7.SurveyLens.dto.embbedable.SubjectEmbeddebleDTO;
import com.sanaa.brif7.SurveyLens.dto.embbedable.SurveyEditionEmbeddebleDTO;

import java.util.List;

public class SubjectResponseDTO {
    private Long id;

    private String title;

    private SubjectEmbeddebleDTO parentSubject;

    private List<SubjectEmbeddebleDTO > subSubjects;

    private SurveyEditionEmbeddebleDTO surveyEdition;

    private List<QuestionEmbeddebleDTO> questions;
}
