package com.sanaa.brif7.SurveyLens.service.impl;

import com.sanaa.brif7.SurveyLens.dto.SubSubjectResultDTO;
import com.sanaa.brif7.SurveyLens.dto.SubjectResultDTO;
import com.sanaa.brif7.SurveyLens.dto.SurveyResultDTO;
import com.sanaa.brif7.SurveyLens.entity.*;
import com.sanaa.brif7.SurveyLens.repository.SurveyRepository;
import com.sanaa.brif7.SurveyLens.service.interfaces.ResultServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class ResultService implements ResultServiceI {

    private SurveyRepository surveyRepository;

    @Override
    public SurveyResultDTO getResults(Long surveyId) {
        Survey survey = surveyRepository.findById(surveyId)
                .orElseThrow(() -> new IllegalArgumentException("Survey not found"));

        SurveyResultDTO surveyResult = new SurveyResultDTO();
        surveyResult.setSurveyTitle(survey.getTitle());
        List<SubjectResultDTO> subjects = new ArrayList<>();

        for (SurveyEdition surveyEdition : survey.getSurveyEditions()) {
            for (Subject subject : surveyEdition.getSubjects()) {
                SubjectResultDTO subjectResult = new SubjectResultDTO();
                subjectResult.setTitle(subject.getTitle());
                subjectResult.setSubSubjects(buildSubSubjects(subject));
                subjects.add(subjectResult);
            }
        }

        surveyResult.setSubjects(subjects); // Should work now
        return surveyResult;
    }


    private List<SubSubjectResultDTO> buildSubSubjects(Subject subject) {
        List<SubSubjectResultDTO> subSubjects = new ArrayList<>();

        for (Subject subSubject : subject.getSubSubjects()) {
            for (Question question : subSubject.getQuestions()) {
                subSubjects.add(buildSubSubjectsResult(subSubject, question));
            }
        }

        return subSubjects;
    }

    private SubSubjectResultDTO buildSubSubjectsResult(Subject subSubject, Question question) {
        SubSubjectResultDTO subSubjectResult = new SubSubjectResultDTO();
        subSubjectResult.setTitle(subSubject.getTitle());
        subSubjectResult.setQuestion(question.getText());

        Map<String, Integer> answerCounts = new HashMap<>();
        for (Answer answer : question.getAnswers()) {
            answerCounts.put(answer.getText(), answer.getSelectionCount());
        }

        subSubjectResult.setAnswers(answerCounts);
        subSubjectResult.setTotalAnswers(question.getAnswerCount());

        return subSubjectResult;
    }


}


