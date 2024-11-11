package com.sanaa.brif7.SurveyLens.dto.request;
import com.sanaa.brif7.SurveyLens.annotation.Exists;
import com.sanaa.brif7.SurveyLens.annotation.Unique;
import com.sanaa.brif7.SurveyLens.entity.Owner;
import com.sanaa.brif7.SurveyLens.entity.Survey;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SurveyCreateDTO {
    @NotBlank
    @Unique(entity = Survey.class, field = "title")
    private String title;

    @NotBlank
    private String description;

    @NotNull
    @Exists(entity = Owner.class, message = "owner not found.")
    private Long ownerId ;

}
