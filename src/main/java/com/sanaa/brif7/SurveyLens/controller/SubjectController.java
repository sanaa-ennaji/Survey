package com.sanaa.brif7.SurveyLens.controller;


import com.sanaa.brif7.SurveyLens.annotation.Exists;
import com.sanaa.brif7.SurveyLens.dto.request.SubjectCreateDTO;
import com.sanaa.brif7.SurveyLens.dto.request.SubjectUpdateDTO;
import com.sanaa.brif7.SurveyLens.dto.response.SubjectResponseDTO;
import com.sanaa.brif7.SurveyLens.entity.Subject;
import com.sanaa.brif7.SurveyLens.service.implementations.SubjectService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api/v1/subject")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @PostMapping
    public ResponseEntity<SubjectResponseDTO> createSubject(@Valid @RequestBody SubjectCreateDTO createSubjectDTO) {
        SubjectResponseDTO subject = subjectService.create(createSubjectDTO);
        return new ResponseEntity<>(subject, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubjectResponseDTO> getSubjectById(@Exists(entity = Subject.class , message = "Cet subject n'existe pas.")  @PathVariable("id") Long id) {
        SubjectResponseDTO subject = subjectService.findById(id);
        return new ResponseEntity<>(subject, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<SubjectResponseDTO> getAllSubjectsPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ) {
        SubjectResponseDTO subjects = (SubjectResponseDTO) subjectService.findAll();
        return new ResponseEntity<>(subjects, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSubject(@Exists(entity = Subject.class , message = "subject not found.") @PathVariable("id") Long id) {
        subjectService.deleteById(id);
        return new ResponseEntity<>("Subject was deleted", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubjectResponseDTO> updateSubject(@Exists(entity = Subject.class , message = "subject not found.") @PathVariable("id") Long id, @Valid @RequestBody SubjectUpdateDTO SubjectupdateDTO) {

        SubjectResponseDTO updatedSubject = subjectService.update(id, SubjectupdateDTO);
        return new ResponseEntity<>(updatedSubject, HttpStatus.OK);
    }


}
