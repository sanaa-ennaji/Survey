package com.sanaa.brif7.SurveyLens.controller;

import com.sanaa.brif7.SurveyLens.annotation.Exists;
import com.sanaa.brif7.SurveyLens.dto.PaginationDTO;
import com.sanaa.brif7.SurveyLens.dto.request.SurveyCreateDTO;
import com.sanaa.brif7.SurveyLens.dto.request.SurveyUpdateDTO;
import com.sanaa.brif7.SurveyLens.dto.response.OwnerResponseDTO;
import com.sanaa.brif7.SurveyLens.dto.response.SurveyResponseDTO;
import com.sanaa.brif7.SurveyLens.entity.Survey;
import com.sanaa.brif7.SurveyLens.service.impl.SurveyService;
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
@RequestMapping("/api/v1/survey")
public class SurveyController {

    private  final SurveyService surveyService;

    @PostMapping
    public ResponseEntity<SurveyResponseDTO> createSurvey(@Valid @RequestBody SurveyCreateDTO createSurveyDTO) {
        SurveyResponseDTO survey = surveyService.create(createSurveyDTO);
        return new ResponseEntity<>(survey, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SurveyResponseDTO> getSurveyById(@Exists(entity = Survey.class , message = "survey not found.")  @PathVariable("id") Long id) {
        SurveyResponseDTO survey = surveyService.findById(id);
        return new ResponseEntity<>(survey, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<PaginationDTO<SurveyResponseDTO>> getAlSurveysPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size) {
        PaginationDTO<SurveyResponseDTO> surveys = surveyService.findAll(page, size);
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
