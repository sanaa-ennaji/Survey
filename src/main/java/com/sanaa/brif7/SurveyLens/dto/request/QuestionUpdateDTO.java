package com.sanaa.brif7.SurveyLens.dto.request;


import com.sanaa.brif7.SurveyLens.entity.enums.QuestionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionUpdateDTO {
    private String text;

    private QuestionType questionType;

    private Long subjectId;

}
