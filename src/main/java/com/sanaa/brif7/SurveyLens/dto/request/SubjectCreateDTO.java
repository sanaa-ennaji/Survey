package com.sanaa.brif7.SurveyLens.dto.request;

import com.sanaa.brif7.SurveyLens.annotation.Exists;
import com.sanaa.brif7.SurveyLens.entity.Subject;
import com.sanaa.brif7.SurveyLens.entity.SurveyEdition;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubjectCreateDTO {
    @NotNull
    private String title;
    private Long parentSubjectId;
    @Exists(entity = SurveyEdition.class, message = "surveyEdition not found.")
    private Long surveyEditionId;

}
