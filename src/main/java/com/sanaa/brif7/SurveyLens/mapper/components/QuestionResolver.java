package com.sanaa.brif7.SurveyLens.mapper.components;

import com.sanaa.brif7.SurveyLens.entity.Question;
import com.sanaa.brif7.SurveyLens.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class QuestionResolver {

    private QuestionRepository questionRepository;

    public Question mapQuestionIdToQuestion(Long questionId) {
        return questionRepository.findById(questionId).orElse(null);
    }
}
