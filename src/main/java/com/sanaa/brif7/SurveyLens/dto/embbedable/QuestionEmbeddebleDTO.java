package com.sanaa.brif7.SurveyLens.dto.embbedable;

import com.sanaa.brif7.SurveyLens.entity.enums.QuestionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionEmbeddebleDTO {
    private Long id;

    private String text;

    private Integer answerCount;

    private QuestionType questionType;
}
