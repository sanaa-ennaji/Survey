package com.sanaa.brif7.SurveyLens.service.impl;

import com.sanaa.brif7.SurveyLens.dto.request.AnswerCreateDTO;
import com.sanaa.brif7.SurveyLens.dto.request.AnswerUpdateDTO;
import com.sanaa.brif7.SurveyLens.dto.response.AnswerResponseDTO;
import com.sanaa.brif7.SurveyLens.entity.Answer;
import com.sanaa.brif7.SurveyLens.mapper.AnswerMapper;
import com.sanaa.brif7.SurveyLens.repository.AnswerRepository;
import com.sanaa.brif7.SurveyLens.service.interfaces.AnswerServiceI;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AnswerService extends GenericService<Answer, AnswerCreateDTO, AnswerUpdateDTO, AnswerResponseDTO>
        implements AnswerServiceI {


    public AnswerService(AnswerRepository answerRepository, AnswerMapper answerMapper) {
        super(answerRepository, answerMapper);

    }

}


