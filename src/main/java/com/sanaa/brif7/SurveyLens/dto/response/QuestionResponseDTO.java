package com.sanaa.brif7.SurveyLens.dto.response;

import com.sanaa.brif7.SurveyLens.dto.embbedable.AnswerEmbeddebleDTO;
import com.sanaa.brif7.SurveyLens.dto.embbedable.SubjectEmbeddebleDTO;
import com.sanaa.brif7.SurveyLens.entity.enums.QuestionType;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionResponseDTO {
    private Long id;

    private String text;

    private Integer answerCount;

    private QuestionType questionType;

    private SubjectEmbeddebleDTO subject;

    private List<AnswerEmbeddebleDTO> answers;


}

