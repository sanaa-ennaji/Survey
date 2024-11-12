package com.sanaa.brif7.SurveyLens.controller;

import com.sanaa.brif7.SurveyLens.annotation.Exists;
import com.sanaa.brif7.SurveyLens.dto.request.SurveyEditionCreateDTO;
import com.sanaa.brif7.SurveyLens.dto.response.SurveyEditionResponseDTO;
import com.sanaa.brif7.SurveyLens.entity.SurveyEdition;
import com.sanaa.brif7.SurveyLens.service.implementations.SurveyEditionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/surveyEdition")
public class SurveyEditionController {

    private SurveyEditionService surveyEditionService;

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
    public ResponseEntity <SurveyEditionResponseDTO> getAllSurveyEditionsPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ) {
        SurveyEditionResponseDTO surveyEditions = surveyEditionService.findAll();
        return new ResponseEntity<>(surveyEditions, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSurvey(@Exists(entity = SurveyEdition.class , message = "Cet surveyEdition n'existe pas.") @PathVariable("id") Long id) {
        surveyEditionService.deleteById(id);
        return new ResponseEntity<>("delete done", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SurveyEditionResponseDTO> updateSurvey(@Exists(entity = SurveyEdition.class , message = "Cet surveyEdition n'existe pas.") @PathVariable("id") Long id, @Valid @RequestBody UpdateSurveyEditionDTO updateSurveyEditionDTO) {

        SurveyEditionResponseDTO updatedSurveyEdition = surveyEditionService.update(id, updateSurveyEditionDTO);
        return new ResponseEntity<>(updatedSurveyEdition, HttpStatus.OK);
    }


}
