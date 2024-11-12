package com.sanaa.brif7.SurveyLens.controller;

import com.sanaa.brif7.SurveyLens.annotation.Exists;
import com.sanaa.brif7.SurveyLens.dto.request.AnswerCreateDTO;
import com.sanaa.brif7.SurveyLens.dto.response.AnswerResponseDTO;
import com.sanaa.brif7.SurveyLens.entity.Answer;
import com.sanaa.brif7.SurveyLens.service.implementations.AnswerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/answer")
public class AnswerController {

    private AnswerService answerService;

    @PostMapping
    public ResponseEntity<AnswerResponseDTO> createAnswer(@Valid @RequestBody AnswerCreateDTO createAnswerDTO) {
        AnswerResponseDTO answer = answerService.create(createAnswerDTO);
        return new ResponseEntity<>(answer, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnswerResponseDTO > getAnswerById(@Exists(entity = Answer.class , message = "Cette réponse n'existe pas.")  @PathVariable("id") Long id) {
        AnswerResponseDTO  answer = answerService.findById(id);
        return new ResponseEntity<>(answer, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<AnswerResponseDTO > getAllAnswersPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ) {
        AnswerResponseDTO  answers = answerService.findAll(page, size);
        return new ResponseEntity<>(answers, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAnswer(@Exists(entity = Answer.class , message = "Cette réponse n'existe pas.") @PathVariable("id") Long id) {
        answerService.deleteById(id);
        return new ResponseEntity<>("Question est supprimé avec succès", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnswerResponseDTO > updateAnswer(@Exists(entity = Answer.class , message = "Cet réponse n'existe pas.") @PathVariable("id") Long id, @Valid @RequestBody UpdateAnswerDTO updateAnswerDTO) {

        AnswerResponseDTO  updatedAnswer = answerService.update(id, updateAnswerDTO);
        return new ResponseEntity<>(updatedAnswer, HttpStatus.OK);
    }


}
