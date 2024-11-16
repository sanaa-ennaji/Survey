package com.sanaa.brif7.SurveyLens.mapper;
import com.sanaa.brif7.SurveyLens.dto.response.AnswerResponseDTO;
import com.sanaa.brif7.SurveyLens.entity.Answer;
import org.mapstruct.MappingTarget;
import java.util.List;

public interface GenericMapper<Entity, CreateDTO, UpdateDTO, ResponseDTO> {

    Entity toEntity(CreateDTO createDTO);

    ResponseDTO toDTO(Entity entity);

    List<ResponseDTO> toDTOs(List<Entity> entities);

    void updateEntityFromDTO(UpdateDTO updateDTO, @MappingTarget Entity entity);


}