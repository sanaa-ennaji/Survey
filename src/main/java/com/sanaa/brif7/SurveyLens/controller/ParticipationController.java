package com.sanaa.brif7.SurveyLens.controller;

import com.sanaa.brif7.SurveyLens.annotation.Exists;
import com.sanaa.brif7.SurveyLens.dto.ParticipationDTO;
import com.sanaa.brif7.SurveyLens.dto.SurveyResultDTO;
import com.sanaa.brif7.SurveyLens.entity.Survey;
import com.sanaa.brif7.SurveyLens.service.impl.ParticipationService;
import com.sanaa.brif7.SurveyLens.service.impl.ResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/surveys")
public class ParticipationController {

    private final ParticipationService participationService;
    private final ResultService resultService;

    @PostMapping("/{id}/participate")
    public ResponseEntity<String> participateSurvey(
            @Exists(entity = Survey.class, message = "survey not found.") @PathVariable("id") Long surveyId,
            @RequestBody @Valid ParticipationDTO participationDTO) {


        participationService.saveParticipation(surveyId, participationDTO);
        return new ResponseEntity<>("Participation saved", HttpStatus.OK);
    }

    @GetMapping("/{id}/results")
    public ResponseEntity<SurveyResultDTO> getSurveyResults(@PathVariable("id") Long surveyId) {
        SurveyResultDTO surveyResult = resultService.getResults(surveyId);
        return new ResponseEntity<>(surveyResult, HttpStatus.OK);
    }
}

