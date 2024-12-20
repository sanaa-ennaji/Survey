package com.sanaa.brif7.SurveyLens.dto.response;

import com.sanaa.brif7.SurveyLens.dto.embbedable.AnswerEmbeddebleDTO;
import com.sanaa.brif7.SurveyLens.dto.embbedable.SurveyEditionEmbeddebleDTO;
import com.sanaa.brif7.SurveyLens.dto.embbedable.SurveyEmbeddebleDTO;

import java.time.LocalDate;
import java.util.List;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SurveyEditionResponseDTO {

    private Long id;

    private LocalDate creationDate;

    private LocalDate startDate;

    private Integer year;
    private SurveyEmbeddebleDTO survey;
}
