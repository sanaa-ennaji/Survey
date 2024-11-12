package com.sanaa.brif7.SurveyLens.service.implementations;

import com.sanaa.brif7.SurveyLens.dto.request.QuestionCreateDTO;
import com.sanaa.brif7.SurveyLens.dto.request.QuestionUpdateDTO;
import com.sanaa.brif7.SurveyLens.dto.response.QuestionResponseDTO;
import com.sanaa.brif7.SurveyLens.entity.Question;
import com.sanaa.brif7.SurveyLens.entity.Subject;
import com.sanaa.brif7.SurveyLens.mapper.QuestionMapper;
import com.sanaa.brif7.SurveyLens.repository.QuestionRepository;
import com.sanaa.brif7.SurveyLens.repository.SubjectRepository;
import com.sanaa.brif7.SurveyLens.service.interfaces.QuestionServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService extends GenericService<Question, QuestionCreateDTO, QuestionUpdateDTO, QuestionResponseDTO> implements QuestionServiceI {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private QuestionMapper questionMapper;

    public QuestionService(QuestionRepository questionRepository, QuestionMapper questionMapper) {
        super(questionRepository, questionMapper);
    }
    @Override
    public QuestionResponseDTO create(QuestionCreateDTO createQuestionDTO) {
        Long subjectId = createQuestionDTO.getSubjectId();
        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new IllegalArgumentException("subject not found."));

        if (subject.getSubSubjects() != null && !subject.getSubSubjects().isEmpty()) {
            throw new IllegalStateException("can't add question.");
        }

        Question question = questionMapper.toEntity(createQuestionDTO);
        question.setSubject(subject);

        Question savedQuestion = questionRepository.save(question);
        return questionMapper.toDTO(savedQuestion);
    }

    @Override
    public QuestionResponseDTO update(Long id, QuestionUpdateDTO updateQuestionDTO) {
        Question existingQuestion = questionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("La question avec cet ID n'existe pas."));

        Subject subject = existingQuestion.getSubject();

        if (subject.getSubSubjects() != null && !subject.getSubSubjects().isEmpty()) {
            throw new IllegalStateException("Impossible de mettre à jour une question dans un subject qui possède des sous-sujets.");
        }

        existingQuestion = questionMapper.updateEntityFromDTO(updateQuestionDTO, existingQuestion);

        Question updatedQuestion = questionRepository.save(existingQuestion);

        return questionMapper.toDTO(updatedQuestion);
    }


}