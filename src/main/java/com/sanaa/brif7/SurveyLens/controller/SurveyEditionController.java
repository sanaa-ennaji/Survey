package com.sanaa.brif7.SurveyLens.controller;

import com.sanaa.brif7.SurveyLens.annotation.Exists;
import com.sanaa.brif7.SurveyLens.dto.PaginationDTO;
import com.sanaa.brif7.SurveyLens.dto.request.SurveyEditionCreateDTO;
import com.sanaa.brif7.SurveyLens.dto.request.SurveyEditionUpdateDTO;
import com.sanaa.brif7.SurveyLens.dto.response.SurveyEditionResponseDTO;
import com.sanaa.brif7.SurveyLens.entity.SurveyEdition;
import com.sanaa.brif7.SurveyLens.service.impl.SurveyEditionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/surveyEdition")
public class SurveyEditionController {

    private  final SurveyEditionService surveyEditionService;

    @PostMapping
    public ResponseEntity<SurveyEditionResponseDTO> createSurveyEdition(@Valid @RequestBody SurveyEditionCreateDTO createSurveyEditionDTO) {
        SurveyEditionResponseDTO survey = surveyEditionService.create(createSurveyEditionDTO);
        return new ResponseEntity<>(survey, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SurveyEditionResponseDTO> getSurveyEditionById(@Exists(entity = SurveyEdition.class , message = "surveyEdition not found.")  @PathVariable("id") Long id) {
        SurveyEditionResponseDTO surveyEdition = surveyEditionService.findById(id);
        return new ResponseEntity<>(surveyEdition, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<PaginationDTO<SurveyEditionResponseDTO>> getAllSurveyEditionPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size) {
        PaginationDTO<SurveyEditionResponseDTO> surveyEditions = surveyEditionService.findAll(page, size);
        return new ResponseEntity<>(surveyEditions, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSurvey(@Exists(entity = SurveyEdition.class , message = "surveyEdition not found.") @PathVariable("id") Long id) {
        surveyEditionService.deleteById(id);
        return new ResponseEntity<>("delete done", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SurveyEditionResponseDTO> updateSurvey(@Exists(entity = SurveyEdition.class , message = "surveyEdition not found.") @PathVariable("id") Long id, @Valid @RequestBody SurveyEditionUpdateDTO updateSurveyEditionDTO) {

        SurveyEditionResponseDTO updatedSurveyEdition = surveyEditionService.update(id, updateSurveyEditionDTO);
        return new ResponseEntity<>(updatedSurveyEdition, HttpStatus.OK);
    }


}
