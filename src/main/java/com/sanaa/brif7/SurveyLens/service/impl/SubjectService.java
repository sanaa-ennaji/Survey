package com.sanaa.brif7.SurveyLens.service.impl;

import com.sanaa.brif7.SurveyLens.dto.request.SubjectCreateDTO;
import com.sanaa.brif7.SurveyLens.dto.request.SubjectUpdateDTO;
import com.sanaa.brif7.SurveyLens.dto.response.SubjectResponseDTO;
import com.sanaa.brif7.SurveyLens.entity.Subject;
import com.sanaa.brif7.SurveyLens.mapper.SubjectMapper;
import com.sanaa.brif7.SurveyLens.repository.SubjectRepository;
import com.sanaa.brif7.SurveyLens.service.interfaces.SubjectServiceI;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SubjectService implements SubjectServiceI {
    private final SubjectRepository subjectRepository;
    private final SubjectMapper subjectMapper;

    public SubjectService(SubjectRepository subjectRepository, SubjectMapper subjectMapper) {
        this.subjectRepository = subjectRepository;
        this.subjectMapper = subjectMapper;
    }
    @Override
    public List<SubjectResponseDTO> getSubjectsBySurveyEditionId(Long surveyEditionId) {
        List<Subject> subjects = subjectRepository.findBySurveyEditionId(surveyEditionId);
        return subjects.stream()
            .map(subjectMapper::toResponseDTO)
            .collect(Collectors.toList());
    }
    @Override
    public SubjectResponseDTO create(SubjectCreateDTO subjectRequestDTO) {
        Subject subject = subjectMapper.toEntity(subjectRequestDTO);
        Subject savedSubject = subjectRepository.save(subject);
        return subjectMapper.toResponseDTO(savedSubject);
    }

    @Override
    public SubjectResponseDTO update(Long id, SubjectCreateDTO subjectRequestDTO) {
        Subject subject = subjectRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Subject not found"));

        subjectMapper.updateEntityFromDTO(subjectRequestDTO, subject);
        Subject updatedSubject = subjectRepository.save(subject);

        return subjectMapper.toResponseDTO(updatedSubject);
    }

    @Override
    public Optional<SubjectResponseDTO> findById(Long id) {
        return subjectRepository.findById(id)
                .map(subjectMapper::toResponseDTO);
    }

    @Override
    public List<SubjectResponseDTO> findAll() {
        return subjectRepository.findAll().stream()
                .map(subjectMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        subjectRepository.deleteById(id);
    }

    public Subject findEntityById(Long id) {
        return subjectRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("subject not found with id "+ id));
    }
}



