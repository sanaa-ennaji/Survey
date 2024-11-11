package com.sanaa.brif7.SurveyLens.dto.request;

import com.sanaa.brif7.SurveyLens.annotation.Unique;
import com.sanaa.brif7.SurveyLens.entity.Owner;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OwnerCreateDTO {

    @NotBlank
    @Unique(entity = Owner.class, field = "name")
    private String name;

}
