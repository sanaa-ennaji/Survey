package com.sanaa.brif7.SurveyLens.dto.request;

import com.sanaa.brif7.SurveyLens.annotation.Exists;
import com.sanaa.brif7.SurveyLens.annotation.Unique;
import com.sanaa.brif7.SurveyLens.entity.Owner;
import com.sanaa.brif7.SurveyLens.entity.Survey;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SurveyUpdateDTO {
    @Unique(entity = Survey.class, field = "title")
    private String title;
    private String description;
    @Exists(entity = Owner.class, message = "Cet owner n'existe pas.")
    private Long ownerId ;
}
