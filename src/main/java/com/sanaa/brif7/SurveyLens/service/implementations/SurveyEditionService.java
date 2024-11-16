package com.sanaa.brif7.SurveyLens.service.implementations;

import com.sanaa.brif7.SurveyLens.Exeptions.EntityNotFoundException;
import com.sanaa.brif7.SurveyLens.dto.request.SurveyEditionCreateDTO;
import com.sanaa.brif7.SurveyLens.dto.request.SurveyEditionUpdateDTO;
import com.sanaa.brif7.SurveyLens.dto.response.SurveyEditionResponseDTO;
import com.sanaa.brif7.SurveyLens.entity.SurveyEdition;
import com.sanaa.brif7.SurveyLens.mapper.SurveyEditionMapper;
import com.sanaa.brif7.SurveyLens.repository.SurveyEditionRepository;
import com.sanaa.brif7.SurveyLens.service.interfaces.SurveyEditionServiceI;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SurveyEditionService extends GenericService<SurveyEdition, SurveyEditionCreateDTO, SurveyEditionUpdateDTO, SurveyEditionResponseDTO> implements SurveyEditionServiceI {

    private final SurveyEditionRepository surveyEditionRepository;
    private final SurveyEditionMapper surveyEditionMapper;

    public SurveyEditionService(SurveyEditionRepository surveyEditionRepository, SurveyEditionMapper surveyEditionMapper) {
        super(surveyEditionRepository, surveyEditionMapper);
        this.surveyEditionRepository = surveyEditionRepository;
        this.surveyEditionMapper = surveyEditionMapper;
    }

    @Override
    public Page<SurveyEditionResponseDTO> findAll(Pageable pageable) {
        Page<SurveyEdition> surveyEditions = surveyEditionRepository.findAll(pageable);
        return surveyEditions.map(surveyEditionMapper::toDTO);
    }

    public SurveyEditionResponseDTO update(Long id, SurveyEditionUpdateDTO updateDTO) {
        SurveyEdition surveyEdition = surveyEditionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("SurveyEdition not found"));

        surveyEditionMapper.updateEntityFromDTO(updateDTO, surveyEdition);
        SurveyEdition updatedSurveyEdition = surveyEditionRepository.save(surveyEdition);
        return surveyEditionMapper.toDTO(updatedSurveyEdition);
    }
}

