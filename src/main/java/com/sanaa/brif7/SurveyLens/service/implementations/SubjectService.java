package com.sanaa.brif7.SurveyLens.service.implementations;

import com.sanaa.brif7.SurveyLens.dto.request.SubjectCreateDTO;
import com.sanaa.brif7.SurveyLens.dto.request.SubjectUpdateDTO;
import com.sanaa.brif7.SurveyLens.dto.response.SubjectResponseDTO;
import com.sanaa.brif7.SurveyLens.entity.Subject;
import com.sanaa.brif7.SurveyLens.mapper.SubjectMapper;
import com.sanaa.brif7.SurveyLens.repository.SubjectRepository;
import com.sanaa.brif7.SurveyLens.service.interfaces.SubjectServiceI;
import org.springframework.stereotype.Service;

@Service
public class SubjectService extends GenericService<Subject, SubjectCreateDTO, SubjectUpdateDTO, SubjectResponseDTO> implements SubjectServiceI {

    public SubjectService(SubjectRepository subjectRepository , SubjectMapper subjectMapper) {
        super(subjectRepository , subjectMapper);
    }

}
