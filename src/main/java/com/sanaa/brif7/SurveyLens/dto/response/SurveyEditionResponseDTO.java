package com.sanaa.brif7.SurveyLens.dto.response;

import com.sanaa.brif7.SurveyLens.dto.embbedable.AnswerEmbeddebleDTO;
import com.sanaa.brif7.SurveyLens.dto.embbedable.SurveyEditionEmbeddebleDTO;
import com.sanaa.brif7.SurveyLens.dto.embbedable.SurveyEmbeddebleDTO;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SurveyEditionResponseDTO {

    private Long id;

    private String title;

    private String description;

    private AnswerEmbeddebleDTO owner;

    private List<SurveyEditionEmbeddebleDTO> surveyEditions ;
    private SurveyEmbeddebleDTO survey;
}
