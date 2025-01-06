package com.sanaa.brif7.SurveyLens.repository;

import com.sanaa.brif7.SurveyLens.entity.Question;
import com.sanaa.brif7.SurveyLens.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {


}
