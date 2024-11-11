package com.sanaa.brif7.SurveyLens.dto.embbedable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswerEmbeddebleDTO {
    private Long id;

    private String text;

    private Integer selectionCount;
}
