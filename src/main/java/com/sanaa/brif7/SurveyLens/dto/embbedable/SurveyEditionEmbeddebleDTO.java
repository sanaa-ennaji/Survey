package com.sanaa.brif7.SurveyLens.dto.embbedable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SurveyEditionEmbeddebleDTO {
    private Long id;

    private LocalDate creationDate;

    private LocalDate startDate;

    private Integer year;
}
