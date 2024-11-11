package com.sanaa.brif7.SurveyLens.dto.response;

import com.sanaa.brif7.SurveyLens.dto.embbedable.OwnerEmbeddebleDTO;
import com.sanaa.brif7.SurveyLens.dto.embbedable.SurveyEditionEmbeddebleDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SurveyResponseDTO {
    private Long id;

    private String title;

    private String description;

    private OwnerEmbeddebleDTO owner;

    private List<SurveyEditionEmbeddebleDTO> surveyEditions ;
}
