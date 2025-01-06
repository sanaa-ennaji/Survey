package com.sanaa.brif7.SurveyLens.dto.embbedable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubjectEmbeddebleDTO {
    private Long id;
    private String title;
    private List<QuestionEmbeddebleDTO> questions;
}
