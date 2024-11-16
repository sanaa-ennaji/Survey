package com.sanaa.brif7.SurveyLens.controller;

import com.sanaa.brif7.SurveyLens.annotation.Exists;
import com.sanaa.brif7.SurveyLens.dto.request.QuestionCreateDTO;
import com.sanaa.brif7.SurveyLens.dto.request.QuestionUpdateDTO;
import com.sanaa.brif7.SurveyLens.dto.response.QuestionResponseDTO;
import com.sanaa.brif7.SurveyLens.entity.Question;
import com.sanaa.brif7.SurveyLens.service.implementations.QuestionService;
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
@RequestMapping("/api/v1/question")
public class QuestionController {

    private final QuestionService questionService;

    @PostMapping
    public ResponseEntity<QuestionResponseDTO> createQuestion(@Valid @RequestBody QuestionCreateDTO createQuestionDTO) {
        QuestionResponseDTO question = questionService.create(createQuestionDTO);
        return new ResponseEntity<>(question, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuestionResponseDTO> getQuestionById(
            @Exists(entity = Question.class, message = "question not found.")
            @PathVariable("id") Long id) {
        QuestionResponseDTO question = questionService.findById(id);
        return ResponseEntity.ok(question);
    }

    @GetMapping
    public ResponseEntity<Page<QuestionResponseDTO>> getAllQuestionsPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page <QuestionResponseDTO> questions = questionService.findAll(pageable);
        return  new ResponseEntity<>(questions, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteQuestion(
            @Exists(entity = Question.class, message = "question not found.")
            @PathVariable("id") Long id) {
        questionService.deleteById(id);
        return ResponseEntity.ok("Question deleted");
    }

    @PutMapping("/{id}")
    public ResponseEntity<QuestionResponseDTO> updateQuestion(
            @Exists(entity = Question.class, message = "question not found.")
            @PathVariable("id") Long id,
            @Valid @RequestBody QuestionUpdateDTO updateQuestionDTO) {
        QuestionResponseDTO updatedQuestion = questionService.update(id, updateQuestionDTO);
        return ResponseEntity.ok(updatedQuestion);
    }
}
