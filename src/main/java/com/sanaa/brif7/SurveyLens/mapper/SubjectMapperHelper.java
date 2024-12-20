package com.sanaa.brif7.SurveyLens.mapper;

import com.sanaa.brif7.SurveyLens.entity.Subject;
import com.sanaa.brif7.SurveyLens.repository.SubjectRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class SubjectMapperHelper {

    private final SubjectRepository subjectRepository;

    public SubjectMapperHelper(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public Subject mapParentSubject(Long parentSubjectId) {
        if (parentSubjectId == null) {
            return null;
        }
        return subjectRepository.findById(parentSubjectId)
                .orElseThrow(() -> new EntityNotFoundException("Parent Subject not found with ID: " + parentSubjectId));
    }
}