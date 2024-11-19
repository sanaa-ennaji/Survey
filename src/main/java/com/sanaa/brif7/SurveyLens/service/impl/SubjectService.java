package com.sanaa.brif7.SurveyLens.service.impl;

import com.sanaa.brif7.SurveyLens.dto.request.SubjectCreateDTO;
import com.sanaa.brif7.SurveyLens.dto.request.SubjectUpdateDTO;
import com.sanaa.brif7.SurveyLens.dto.response.SubjectResponseDTO;
import com.sanaa.brif7.SurveyLens.entity.Subject;
import com.sanaa.brif7.SurveyLens.mapper.SubjectMapper;
import com.sanaa.brif7.SurveyLens.repository.SubjectRepository;
import com.sanaa.brif7.SurveyLens.repository.SurveyEditionRepository;
import com.sanaa.brif7.SurveyLens.service.interfaces.SubjectServiceI;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SubjectService extends GenericService<Subject, SubjectCreateDTO, SubjectUpdateDTO, SubjectResponseDTO> implements SubjectServiceI {

    private final SubjectRepository subjectRepository;
    private final SubjectMapper subjectMapper;
    private final SurveyEditionRepository surveyEditionRepository;

    public SubjectService(SubjectRepository subjectRepository,
                          SubjectMapper subjectMapper,
                          SurveyEditionRepository surveyEditionRepository) {
        super(subjectRepository, subjectMapper);
        this.subjectRepository = subjectRepository;
        this.subjectMapper = subjectMapper;
        this.surveyEditionRepository = surveyEditionRepository;
    }
}

