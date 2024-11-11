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

    @Exists(entity = Subject.class, message = "Cet subject n'existe pas.")
    private Long parentSubjectId;

    @Exists(entity = SurveyEdition.class, message = "Cet surveyEdition n'existe pas.")
    private Long surveyEditionId;
}
