package com.sanaa.brif7.SurveyLens.controller;

import com.sanaa.brif7.SurveyLens.annotation.Exists;
import com.sanaa.brif7.SurveyLens.dto.PaginationDTO;
import com.sanaa.brif7.SurveyLens.dto.request.AnswerCreateDTO;
import com.sanaa.brif7.SurveyLens.dto.request.AnswerUpdateDTO;
import com.sanaa.brif7.SurveyLens.dto.response.AnswerResponseDTO;
import com.sanaa.brif7.SurveyLens.entity.Answer;
import com.sanaa.brif7.SurveyLens.service.impl.AnswerService;
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
@RequestMapping("/api/v1/answer")
public class AnswerController {

    private  final AnswerService answerService;

    @PostMapping
    public ResponseEntity<AnswerResponseDTO> createAnswer(@RequestBody @Valid AnswerCreateDTO createDTO) {
        AnswerResponseDTO response = answerService.create(createDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @GetMapping("/{id}")
    public ResponseEntity<AnswerResponseDTO > getAnswerById(@Exists(entity = Answer.class , message = "answer not found.")  @PathVariable("id") Long id) {
        AnswerResponseDTO  answer = answerService.findById(id);
        return new ResponseEntity<>(answer, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<PaginationDTO<AnswerResponseDTO>> getAllAnswersPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size) {
        PaginationDTO<AnswerResponseDTO> answers = answerService.findAll(page, size);
        return new ResponseEntity<>(answers, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAnswer(@Exists(entity = Answer.class , message = "answer not found.") @PathVariable("id") Long id) {
        answerService.deleteById(id);
        return new ResponseEntity<>("Question is deleted", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnswerResponseDTO > updateAnswer(@Exists(entity = Answer.class , message = "answer not found.") @PathVariable("id") Long id, @Valid @RequestBody AnswerUpdateDTO updateAnswerDTO) {

        AnswerResponseDTO  updatedAnswer = answerService.update(id, updateAnswerDTO);
        return new ResponseEntity<>(updatedAnswer, HttpStatus.OK);
    }


}
