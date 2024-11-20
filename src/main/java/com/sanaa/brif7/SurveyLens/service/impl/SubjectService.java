package com.sanaa.brif7.SurveyLens.service.impl;

import com.sanaa.brif7.SurveyLens.dto.request.SubjectCreateDTO;
import com.sanaa.brif7.SurveyLens.dto.request.SubjectUpdateDTO;
import com.sanaa.brif7.SurveyLens.dto.response.SubjectResponseDTO;
import com.sanaa.brif7.SurveyLens.entity.Subject;
import com.sanaa.brif7.SurveyLens.mapper.SubjectMapper;
import com.sanaa.brif7.SurveyLens.repository.SubjectRepository;
import org.springframework.stereotype.Service;

@Service
public class SubjectService extends GenericService<Subject, SubjectCreateDTO, SubjectUpdateDTO, SubjectResponseDTO> {

    private final SubjectRepository subjectRepository;
    private final SurveyEditionService surveyEditionService;


    public SubjectService(SubjectRepository subjectRepository,
                          SubjectMapper subjectMapper, SubjectRepository subjectRepository1,
                          SurveyEditionService surveyEditionService) {
        super(subjectRepository, subjectMapper);
        this.subjectRepository = subjectRepository1;
        this.surveyEditionService = surveyEditionService;

    }


}



