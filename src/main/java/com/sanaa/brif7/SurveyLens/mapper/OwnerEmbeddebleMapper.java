package com.sanaa.brif7.SurveyLens.mapper;

import com.sanaa.brif7.SurveyLens.dto.embbedable.OwnerEmbeddebleDTO;
import com.sanaa.brif7.SurveyLens.entity.Owner;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OwnerEmbeddebleMapper {
    OwnerEmbeddebleDTO toEmbeddebleDto(Owner owner);
}
