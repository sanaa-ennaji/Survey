package com.sanaa.brif7.SurveyLens.service.impl;

import com.sanaa.brif7.SurveyLens.dto.PaginationDTO;
import com.sanaa.brif7.SurveyLens.dto.request.AnswerCreateDTO;
import com.sanaa.brif7.SurveyLens.dto.request.AnswerUpdateDTO;
import com.sanaa.brif7.SurveyLens.dto.response.AnswerResponseDTO;
import com.sanaa.brif7.SurveyLens.dto.response.SubjectResponseDTO;
import com.sanaa.brif7.SurveyLens.entity.Answer;
import com.sanaa.brif7.SurveyLens.entity.Question;
import com.sanaa.brif7.SurveyLens.entity.Subject;
import com.sanaa.brif7.SurveyLens.mapper.AnswerMapper;
import com.sanaa.brif7.SurveyLens.repository.AnswerRepository;
import com.sanaa.brif7.SurveyLens.service.interfaces.AnswerServiceI;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnswerService implements AnswerServiceI {

        private final AnswerRepository answerRepository;
        private final AnswerMapper answerMapper;
        private final QuestionService questionService;

        @Autowired
        public AnswerService(AnswerRepository answerRepository, AnswerMapper answerMapper, QuestionService questionService) {
            this.answerRepository = answerRepository;
            this.answerMapper = answerMapper;
            this.questionService = questionService;
        }
          @Override
        public AnswerResponseDTO create(AnswerCreateDTO createDTO) {
            Question question = questionService.findEntityById(createDTO.getQuestionId());
            Answer answer = answerMapper.toEntity(createDTO);
            answer.setQuestion(question);
            Answer savedAnswer = answerRepository.save(answer);
            return answerMapper.toDTO(savedAnswer);
        }

    @Override
  public  List<AnswerResponseDTO> getAnswerByQuestionId(Long questionId){
        List<Answer> answers = answerRepository.findByQuestionId(questionId);
        return answers.stream()
            .map(answerMapper::toResponseDTO)
            .collect(Collectors.toList());
    }


    @Override
    public AnswerResponseDTO findById(Long id) {
        Answer entity = answerRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Answer with ID " + id + " not found"));
        return answerMapper.toDTO(entity);
    }

    @Override
    public PaginationDTO<AnswerResponseDTO> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Answer> pagedResult = answerRepository.findAll(pageable);

        List<AnswerResponseDTO> content = pagedResult.getContent()
            .stream()
            .map(answerMapper::toDTO)
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
    public AnswerResponseDTO update(Long id, AnswerUpdateDTO updateDTO) {
        Answer entity = answerRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Answer with ID " + id + " not found"));

        answerMapper.updateEntityFromDTO(updateDTO, entity);
        Answer updatedEntity = answerRepository.save(entity);
        return answerMapper.toDTO(updatedEntity);
    }


    @Override
    public void deleteById(Long id) {
        if (!answerRepository.existsById(id)) {
            throw new EntityNotFoundException("Answer with ID " + id + " not found");
        }
        answerRepository.deleteById(id);
    }
}


