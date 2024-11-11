package com.sanaa.brif7.SurveyLens.dto.request;

import com.sanaa.brif7.SurveyLens.annotation.Exists;
import com.sanaa.brif7.SurveyLens.entity.Survey;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SurveyEditionUpdateDTO {
    @PastOrPresent(message = "date expired.")
    private LocalDate creationDate;
    @Future(message = "date is in the paste.")
    private LocalDate startDate;

    private Integer year;

    @Exists(entity = Survey.class, message = "survey not found.")
    private Long surveyId;
}
