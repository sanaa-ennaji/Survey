package com.sanaa.brif7.SurveyLens.service.impl;

import com.sanaa.brif7.SurveyLens.dto.request.QuestionCreateDTO;
import com.sanaa.brif7.SurveyLens.dto.request.QuestionUpdateDTO;
import com.sanaa.brif7.SurveyLens.dto.response.QuestionResponseDTO;
import com.sanaa.brif7.SurveyLens.entity.Question;
import com.sanaa.brif7.SurveyLens.entity.Subject;
import com.sanaa.brif7.SurveyLens.mapper.QuestionMapper;
import com.sanaa.brif7.SurveyLens.repository.QuestionRepository;
import com.sanaa.brif7.SurveyLens.repository.SubjectRepository;
import com.sanaa.brif7.SurveyLens.service.interfaces.QuestionServiceI;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class QuestionService extends GenericService<Question, QuestionCreateDTO, QuestionUpdateDTO, QuestionResponseDTO> implements QuestionServiceI {

    private final QuestionRepository questionRepository;
    private final SubjectRepository subjectRepository;
    private final QuestionMapper questionMapper;

    public QuestionService(QuestionRepository questionRepository, SubjectRepository subjectRepository, QuestionMapper questionMapper) {
        super(questionRepository, questionMapper);
        this.questionRepository = questionRepository;
        this.subjectRepository = subjectRepository;
        this.questionMapper = questionMapper;
    }

    @Override
    public QuestionResponseDTO create(QuestionCreateDTO createQuestionDTO) {
        Long subjectId = createQuestionDTO.getSubjectId();
        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new IllegalArgumentException("Subject not found."));

        if (subject.getSubSubjects() != null && !subject.getSubSubjects().isEmpty()) {
            throw new IllegalStateException("Can't add question to a subject with sub-subjects.");
        }

        Question question = questionMapper.toEntity(createQuestionDTO);
        question.setSubject(subject);

        Question savedQuestion = questionRepository.save(question);
        return questionMapper.toDTO(savedQuestion);
    }

    @Override
    public QuestionResponseDTO update(Long id, QuestionUpdateDTO updateQuestionDTO) {
        Question existingQuestion = questionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Question not found."));

        Subject subject = existingQuestion.getSubject();
        if (subject.getSubSubjects() != null && !subject.getSubSubjects().isEmpty()) {
            throw new IllegalStateException("Cannot update question under a subject with sub-subjects.");
        }

        questionMapper.updateEntityFromDTO(updateQuestionDTO, existingQuestion);
        Question updatedQuestion = questionRepository.save(existingQuestion);

        return questionMapper.toDTO(updatedQuestion);
    }


}
