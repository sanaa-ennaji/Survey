package com.sanaa.brif7.SurveyLens.demo;

import com.sanaa.brif7.SurveyLens.dto.request.QuestionCreateDTO;
import com.sanaa.brif7.SurveyLens.dto.response.QuestionResponseDTO;
import com.sanaa.brif7.SurveyLens.entity.Question;
import com.sanaa.brif7.SurveyLens.entity.Subject;
import com.sanaa.brif7.SurveyLens.entity.enums.QuestionType;
import com.sanaa.brif7.SurveyLens.mapper.QuestionMapper;
import com.sanaa.brif7.SurveyLens.repository.QuestionRepository;
import com.sanaa.brif7.SurveyLens.repository.SubjectRepository;
import com.sanaa.brif7.SurveyLens.service.impl.QuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class QuestionServiceTest {

    @Mock
    private SubjectRepository subjectRepository;


    @Mock
    private QuestionRepository questionRepository;

    @Mock
    private QuestionMapper questionMapper;

    @InjectMocks
    private QuestionService questionService;

    private Subject subject;
    private QuestionCreateDTO createQuestionDTO;
    private Question question;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);


        subject = new Subject();
        subject.setId(1L);
        subject.setSubSubjects(null);

        createQuestionDTO = new QuestionCreateDTO();
        createQuestionDTO.setText("What is Java?");
        createQuestionDTO.setQuestionType(QuestionType.SINGLE_CHOICE);
        createQuestionDTO.setSubjectId(1L);

        question = new Question();
        question.setText(createQuestionDTO.getText());
        question.setQuestionType(createQuestionDTO.getQuestionType());
    }

    @Test
    void testCreateQuestionSuccessfully() {
        when(subjectRepository.findById(1L)).thenReturn(Optional.of(subject));
        when(questionMapper.toEntity(createQuestionDTO)).thenReturn(question);
        when(questionRepository.save(question)).thenReturn(question);
        when(questionMapper.toDTO(question)).thenReturn(new QuestionResponseDTO());

        QuestionResponseDTO result = questionService.create(createQuestionDTO);
        assertNotNull(result);
        verify(subjectRepository, times(1)).findById(1L);
        verify(questionRepository, times(1)).save(question);
    }

    @Test
    void testCreateQuestionThrowsExceptionWhenSubjectHasSubSubjects() {

        subject.setSubSubjects(Arrays.asList(new Subject()));

        when(subjectRepository.findById(1L)).thenReturn(Optional.of(subject));
        IllegalStateException thrown = assertThrows(IllegalStateException.class, () -> {
            questionService.create(createQuestionDTO);
        });
        assertEquals("Can't add question to a subject with sub-subjects.", thrown.getMessage());
    }

    @Test
    void testCreateQuestionThrowsExceptionWhenSubjectNotFound() {
        when(subjectRepository.findById(1L)).thenReturn(Optional.empty());

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            questionService.create(createQuestionDTO);
        });
        assertEquals("Subject not found.", thrown.getMessage());
    }
}