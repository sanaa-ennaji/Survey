package com.sanaa.brif7.SurveyLens.controller;


import com.sanaa.brif7.SurveyLens.annotation.Exists;
import com.sanaa.brif7.SurveyLens.dto.request.SubjectCreateDTO;
import com.sanaa.brif7.SurveyLens.dto.response.SubjectResponseDTO;
import com.sanaa.brif7.SurveyLens.entity.Subject;
import com.sanaa.brif7.SurveyLens.service.impl.SubjectService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/subject")
public class SubjectController {

    private final SubjectService subjectService;

    @PostMapping
    public ResponseEntity<SubjectResponseDTO> createSubject(@Valid @RequestBody SubjectCreateDTO createSubjectDTO) {
        SubjectResponseDTO subject = subjectService.create(createSubjectDTO);
        return new ResponseEntity<>(subject, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubjectResponseDTO> getSubjectById(@PathVariable Long id) {
        return subjectService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }


    @GetMapping
    public ResponseEntity<List<SubjectResponseDTO>> getAllSubjects() {
        List<SubjectResponseDTO> subjects = subjectService.findAll();
        return ResponseEntity.ok(subjects);
    }

    @GetMapping("/edition/{id}")
    public ResponseEntity<List<SubjectResponseDTO>> getSubjectsByEditionId(@PathVariable Long id) {
        List<SubjectResponseDTO> subjects = subjectService.getSubjectsBySurveyEditionId(id);
        return ResponseEntity.ok(subjects);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSubject(@Exists(entity = Subject.class , message = "subject not found.") @PathVariable("id") Long id) {
        subjectService.delete(id) ;
        return new ResponseEntity<>("Subject was deleted", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubjectResponseDTO> updateSubject(@Exists(entity = Subject.class , message = "subject not found.") @PathVariable("id") Long id, @Valid @RequestBody SubjectCreateDTO SubjectDTO) {
        SubjectResponseDTO updatedSubject = subjectService.update(id, SubjectDTO);
        return new ResponseEntity<>(updatedSubject, HttpStatus.OK);
    }


}
