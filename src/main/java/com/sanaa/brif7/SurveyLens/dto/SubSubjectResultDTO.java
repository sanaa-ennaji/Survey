package com.sanaa.brif7.SurveyLens.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubSubjectResultDTO {
    private String title;
    private String question;
    private Map<String, Integer> answers;
    private int totalAnswers;
}
