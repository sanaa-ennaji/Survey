package com.sanaa.brif7.SurveyLens.mapper.components;

import com.sanaa.brif7.SurveyLens.entity.Subject;
import com.sanaa.brif7.SurveyLens.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SubjectResolver {

    private SubjectRepository subjectRepository;

    public Subject mapSubjectIdToSubject(Long subjectId) {
        if (subjectId == null) {
            return null;
        }
        return subjectRepository.findById(subjectId).orElse(null);
    }
}
