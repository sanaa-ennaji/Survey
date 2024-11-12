package com.sanaa.brif7.SurveyLens.controller;

import com.sanaa.brif7.SurveyLens.annotation.Exists;
import com.sanaa.brif7.SurveyLens.dto.request.SurveyCreateDTO;
import com.sanaa.brif7.SurveyLens.dto.request.SurveyUpdateDTO;
import com.sanaa.brif7.SurveyLens.dto.response.SurveyResponseDTO;
import com.sanaa.brif7.SurveyLens.entity.Survey;
import com.sanaa.brif7.SurveyLens.service.implementations.SurveyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/survey")
public class SurveyController {

    private SurveyService surveyService;

    @PostMapping
    public ResponseEntity<SurveyResponseDTO> createSurvey(@Valid @RequestBody SurveyCreateDTO createSurveyDTO) {
        SurveyResponseDTO survey = surveyService.create(createSurveyDTO);
        return new ResponseEntity<>(survey, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SurveyResponseDTO> getSurveyById(@Exists(entity = Survey.class , message = "Cet survey n'existe pas.")  @PathVariable("id") Long id) {
        SurveyResponseDTO survey = surveyService.findById(id);
        return new ResponseEntity<>(survey, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<PageDTO<SurveyResponseDTO>> getAllSurveysPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ) {
        PageDTO<SurveyResponseDTO> surveys = surveyService.findAll(page, size);
        return new ResponseEntity<>(surveys, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSurvey(@Exists(entity = Survey.class , message = "survey not found.") @PathVariable("id") Long id) {
        surveyService.deleteById(id);
        return new ResponseEntity<>("Survey deleted", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SurveyResponseDTO> updateSurvey(@Exists(entity = Survey.class , message = " survey not found.") @PathVariable("id") Long id, @Valid @RequestBody SurveyUpdateDTO updateSurveyDTO) {

        SurveyResponseDTO updatedSurvey = surveyService.update(id, updateSurveyDTO);
        return new ResponseEntity<>(updatedSurvey, HttpStatus.OK);
    }


}
