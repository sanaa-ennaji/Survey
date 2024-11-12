package com.sanaa.brif7.SurveyLens.controller;

import com.sanaa.brif7.SurveyLens.annotation.Exists;
import com.sanaa.brif7.SurveyLens.dto.request.QuestionCreateDTO;
import com.sanaa.brif7.SurveyLens.dto.response.QuestionResponseDTO;
import com.sanaa.brif7.SurveyLens.entity.Question;
import com.sanaa.brif7.SurveyLens.service.implementations.QuestionService;
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
@RequestMapping("/api/v1/question")
public class QuestionController {

    private QuestionService questionService;

    @PostMapping
    public ResponseEntity<QuestionResponseDTO> createQuestion(@Valid @RequestBody QuestionCreateDTO createQuestionDTO) {
        QuestionResponseDTO question = questionService.create(createQuestionDTO);
        return new ResponseEntity<>(question, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuestionResponseDTO> getQuestionById(@Exists(entity = Question.class , message = "Cette question n'existe pas.")  @PathVariable("id") Long id) {
        QuestionResponseDTO question = questionService.findById(id);
        return new ResponseEntity<>(question, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<QuestionResponseDTO> getAllQuestionsPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ) {
        PageDTO<QuestionResponseDTO> questions = questionService.findAll(page, size);
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteQuestion(@Exists(entity = Question.class , message = "Cette question n'existe pas.") @PathVariable("id") Long id) {
        questionService.deleteById(id);
        return new ResponseEntity<>("Question est supprimé avec succès", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<QuestionResponseDTO> updateQuestion(@Exists(entity = Question.class , message = "Cet question n'existe pas.") @PathVariable("id") Long id, @Valid @RequestBody UpdateQuestionDTO updateQuestionDTO) {

        QuestionResponseDTO updatedQuestion = questionService.update(id, updateQuestionDTO);
        return new ResponseEntity<>(updatedQuestion, HttpStatus.OK);
    }


}

