package com.sanaa.brif7.SurveyLens.dto.response;

import com.sanaa.brif7.SurveyLens.dto.embbedable.QuestionEmbeddebleDTO;
import com.sanaa.brif7.SurveyLens.dto.embbedable.SubjectEmbeddebleDTO;
import com.sanaa.brif7.SurveyLens.dto.embbedable.SurveyEditionEmbeddebleDTO;
import com.sanaa.brif7.SurveyLens.entity.Subject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubjectResponseDTO {
    private Long id;
    private String title;
    private long parentSubjectId;
    private List<SubjectEmbeddebleDTO> subSubjects;
    private SurveyEditionEmbeddebleDTO surveyEdition;
    private Long surveyEditionId;


}
