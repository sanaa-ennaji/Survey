package com.sanaa.brif7.SurveyLens.service.impl;

import com.sanaa.brif7.SurveyLens.dto.PaginationDTO;
import com.sanaa.brif7.SurveyLens.dto.request.QuestionCreateDTO;
import com.sanaa.brif7.SurveyLens.dto.request.QuestionUpdateDTO;
import com.sanaa.brif7.SurveyLens.dto.response.AnswerResponseDTO;
import com.sanaa.brif7.SurveyLens.dto.response.QuestionResponseDTO;
import com.sanaa.brif7.SurveyLens.entity.Answer;
import com.sanaa.brif7.SurveyLens.entity.Question;
import com.sanaa.brif7.SurveyLens.entity.Subject;
import com.sanaa.brif7.SurveyLens.mapper.QuestionMapper;
import com.sanaa.brif7.SurveyLens.repository.QuestionRepository;
import com.sanaa.brif7.SurveyLens.service.interfaces.QuestionServiceI;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionService implements QuestionServiceI {
    private final QuestionRepository questionRepository;
    private final QuestionMapper questionMapper;
    private final SubjectService subjectService;

    @Autowired
    public QuestionService(QuestionRepository questionRepository, QuestionMapper questionMapper, SubjectService subjectService) {
        this.questionRepository = questionRepository;
        this.questionMapper = questionMapper;
        this.subjectService = subjectService;
    }


    @Override
    public QuestionResponseDTO create(QuestionCreateDTO questionRequestDTO) {
        Subject subject = subjectService.findEntityById(questionRequestDTO.getSubjectId());
        Question question  = questionMapper.toEntity(questionRequestDTO);
        question.setSubject(subject);
        Question savedQuestion = questionRepository.save(question);
        return  questionMapper.toResponseDTO(savedQuestion);
    }

    @Override
    public QuestionResponseDTO update(Long id, QuestionUpdateDTO questionRequestDTO) {
        Question  question = questionRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("question not found with ID: " + id));
        questionMapper.updateEntityFromRequest(questionRequestDTO , question);
        Question updatedQuestion = questionRepository.save(question);
        return questionMapper.toResponseDTO(updatedQuestion);
    }

    @Override
    public QuestionResponseDTO findById(Long id) {
        return questionRepository.findById(id)
            .map(questionMapper::toDTO)
            .orElseThrow(() -> new IllegalArgumentException("Question not found"));
    }

    @Override
    public PaginationDTO<QuestionResponseDTO> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Question> pagedResult = questionRepository.findAll(pageable);

        List<QuestionResponseDTO> content = pagedResult.getContent()
            .stream()
            .map(questionMapper::toDTO)
            .collect(Collectors.toList());

        return new PaginationDTO<>(
            content,
            pagedResult.getNumber(),
            pagedResult.getSize(),
            pagedResult.getTotalElements(),
            pagedResult.getTotalPages(),
            pagedResult.isLast()
        );
    }


    @Override
    public List<QuestionResponseDTO> findAll() {
        return questionRepository.findAll()
            .stream()
            .map(questionMapper::toResponseDTO)
            .toList();
    }

    @Override
    public void deleteById(Long id) {
        if(!questionRepository.existsById(id)){
            throw new  EntityNotFoundException("Question not found with ID: " + id);
        }
        questionRepository.deleteById(id);

    }
    public Question findEntityById(Long id) {
        return questionRepository.findById(id)
            .orElseThrow(()-> new EntityNotFoundException("question not found with id "+ id));
    }



}

