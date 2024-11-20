package com.sanaa.brif7.SurveyLens.dto.request;

import com.sanaa.brif7.SurveyLens.annotation.Exists;
import com.sanaa.brif7.SurveyLens.entity.Subject;
import com.sanaa.brif7.SurveyLens.entity.SurveyEdition;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubjectUpdateDTO {
    private String title;

    @Exists(entity = Subject.class, message = "subject not found.")
    private Long parentSubjectId;

    @Exists(entity = SurveyEdition.class, message = "surveyEdition not found.")
    private Long surveyEditionId;
}
