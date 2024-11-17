package com.sanaa.brif7.SurveyLens.service.impl;

import com.sanaa.brif7.SurveyLens.dto.request.SubjectCreateDTO;
import com.sanaa.brif7.SurveyLens.dto.request.SubjectUpdateDTO;
import com.sanaa.brif7.SurveyLens.dto.response.SubjectResponseDTO;
import com.sanaa.brif7.SurveyLens.entity.Subject;
import com.sanaa.brif7.SurveyLens.mapper.SubjectMapper;
import com.sanaa.brif7.SurveyLens.repository.SubjectRepository;
import com.sanaa.brif7.SurveyLens.service.interfaces.SubjectServiceI;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SubjectService extends GenericService<Subject, SubjectCreateDTO, SubjectUpdateDTO, SubjectResponseDTO> implements SubjectServiceI {

    private final SubjectRepository subjectRepository;
    private final SubjectMapper subjectMapper;

    public SubjectService(SubjectRepository subjectRepository, SubjectMapper subjectMapper) {
        super(subjectRepository, subjectMapper);
        this.subjectRepository = subjectRepository;
        this.subjectMapper = subjectMapper;
    }

    @Override
    public Page<SubjectResponseDTO> findAll(Pageable pageable) {
        Page<Subject> subjects = subjectRepository.findAll(pageable);
        return subjects.map(subjectMapper::toDTO);
    }
}
