package com.sanaa.brif7.SurveyLens.repository;

import com.sanaa.brif7.SurveyLens.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {


}
