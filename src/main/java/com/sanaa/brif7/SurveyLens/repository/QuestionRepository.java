package com.sanaa.brif7.SurveyLens.repository;

import com.sanaa.brif7.SurveyLens.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
