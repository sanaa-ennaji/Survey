package com.sanaa.brif7.SurveyLens.repository;

import com.sanaa.brif7.SurveyLens.dto.response.SubjectResponseDTO;
import com.sanaa.brif7.SurveyLens.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface SubjectRepository  extends JpaRepository<Subject, Long> {
    List<Subject> findBySurveyEditionId(Long surveyEditionId);
}
