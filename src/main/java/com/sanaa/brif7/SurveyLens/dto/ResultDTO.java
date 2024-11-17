package com.sanaa.brif7.SurveyLens.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultDTO {
    private String surveyTitle;
    private List<SubjectResultDTO> subjects;
}