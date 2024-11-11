package com.sanaa.brif7.SurveyLens.dto.request;

import com.sanaa.brif7.SurveyLens.annotation.Unique;
import com.sanaa.brif7.SurveyLens.entity.Owner;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OwnerUpdateDTO {
    @Unique(entity = Owner.class, field = "name")
    private String name;
}
