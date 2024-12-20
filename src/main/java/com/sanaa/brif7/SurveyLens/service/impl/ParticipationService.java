package com.sanaa.brif7.SurveyLens.service.impl;

import com.sanaa.brif7.SurveyLens.dto.AnswerDTO;
import com.sanaa.brif7.SurveyLens.dto.ParticipationDTO;
import com.sanaa.brif7.SurveyLens.dto.ResponseDTO;
import com.sanaa.brif7.SurveyLens.entity.Answer;
import com.sanaa.brif7.SurveyLens.entity.Question;
import com.sanaa.brif7.SurveyLens.entity.enums.QuestionType;
import com.sanaa.brif7.SurveyLens.repository.AnswerRepository;
import com.sanaa.brif7.SurveyLens.repository.QuestionRepository;
import com.sanaa.brif7.SurveyLens.service.interfaces.ParticipationServiceI;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParticipationService implements ParticipationServiceI {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private AnswerRepository answerRepository;

    @Override
    @Transactional
    public void saveParticipation(Long surveyId, ParticipationDTO participationDTO) {
        for (ResponseDTO responseDTO : participationDTO.getResponses()) {
            Question question = questionRepository.findById(responseDTO.getQuestionId())
                    .orElseThrow(() -> new IllegalArgumentException("Question not found"));

            if (question.getSubject() == null) {
                throw new IllegalArgumentException("La question ID = " + question.getId() + "do not have a subject.");
            }

            if (!question.getSubject().getSurveyEdition().getSurvey().getId().equals(surveyId)) {
                throw new IllegalArgumentException("La question " + responseDTO.getQuestionId() + " dosnot belong to the survey  " + surveyId);
            }

            if (question.getQuestionType() == QuestionType.SINGLE_CHOICE) {
                if (responseDTO.getSingleAnswerId() == null || responseDTO.getMultipleAnswers() != null) {
                    throw new IllegalArgumentException("one response needed for  = " + question.getId());
                }

                Answer answer = answerRepository.findById(responseDTO.getSingleAnswerId())
                        .orElseThrow(() -> new IllegalArgumentException("Answer not found"));

                if (!answer.getQuestion().getId().equals(question.getId())) {
                    throw new IllegalArgumentException("la  = " + responseDTO.getSingleAnswerId() + "dont belong to question  ID = " + question.getId());
                }

                answer.SelectionCount();
                answerRepository.save(answer);

                question.AnswerCount();
                questionRepository.save(question);

            } else if (question.getQuestionType() == QuestionType.MULTIPLE_CHOICE) {
                if (responseDTO.getMultipleAnswers() == null || responseDTO.getSingleAnswerId() != null) {
                    throw new IllegalArgumentException("needed multiple choices for this question = " + question.getId());
                }

                for (AnswerDTO answerDTO : responseDTO.getMultipleAnswers()) {
                    Answer answer = answerRepository.findById(answerDTO.getAnswerId())
                            .orElseThrow(() -> new IllegalArgumentException("Answer not found"));

                    if (!answer.getQuestion().getId().equals(question.getId())) {
                        throw new IllegalArgumentException("la response ID = " + answerDTO.getAnswerId() + "not belong to this question ID = " + question.getId());
                    }

                    answer.SelectionCount();
                    answerRepository.save(answer);

                    question.AnswerCount();
                    questionRepository.save(question);
                }
            }
        }
    }
}
