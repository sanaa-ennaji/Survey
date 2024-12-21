package com.sanaa.brif7.SurveyLens.demo;

import com.sanaa.brif7.SurveyLens.dto.request.OwnerCreateDTO;
import com.sanaa.brif7.SurveyLens.dto.request.OwnerUpdateDTO;
import com.sanaa.brif7.SurveyLens.dto.response.OwnerResponseDTO;
import com.sanaa.brif7.SurveyLens.entity.Owner;
import com.sanaa.brif7.SurveyLens.mapper.OwnerMapper;
import com.sanaa.brif7.SurveyLens.repository.OwnerRepository;
import com.sanaa.brif7.SurveyLens.service.impl.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;
import java.util.Arrays;

public class OwnerServiceTest {

    @Mock
    private OwnerRepository ownerRepository;

    @Mock
    private OwnerMapper ownerMapper;

    @InjectMocks
    private OwnerService ownerService;

    private Owner owner;
    private OwnerCreateDTO ownerCreateDTO;
    private OwnerUpdateDTO ownerUpdateDTO;
    private OwnerResponseDTO ownerResponseDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        owner = new Owner(1L, "John Doe", null);

        ownerCreateDTO = new OwnerCreateDTO();
        ownerCreateDTO.setName("John Doe");

        ownerUpdateDTO = new OwnerUpdateDTO();
        ownerUpdateDTO.setName("Updated Name");

        ownerResponseDTO = new OwnerResponseDTO();
        ownerResponseDTO.setId(1L);
        ownerResponseDTO.setName("John Doe");
    }

    @Test
    void testCreateOwner() {
        when(ownerMapper.toEntity(ownerCreateDTO)).thenReturn(owner);
        when(ownerRepository.save(owner)).thenReturn(owner);
        when(ownerMapper.toDTO(owner)).thenReturn(ownerResponseDTO);

        OwnerResponseDTO result = ownerService.create(ownerCreateDTO);

        assertNotNull(result);
        assertEquals("John Doe", result.getName());
        verify(ownerRepository, times(1)).save(owner);
    }

    @Test
    void testUpdateOwner() {
        when(ownerRepository.findById(1L)).thenReturn(Optional.of(owner));
        doNothing().when(ownerMapper).updateEntity(ownerUpdateDTO, owner);
        when(ownerRepository.save(owner)).thenReturn(owner);
        when(ownerMapper.toDTO(owner)).thenReturn(ownerResponseDTO);

        OwnerResponseDTO result = ownerService.update(1L, ownerUpdateDTO);

        assertNotNull(result);
        verify(ownerRepository, times(1)).save(owner);
    }

    @Test
    void testDeleteOwner() {
        when(ownerRepository.existsById(1L)).thenReturn(true);
        doNothing().when(ownerRepository).deleteById(1L);

        assertDoesNotThrow(() -> ownerService.delete(1L));
        verify(ownerRepository, times(1)).deleteById(1L);
    }

    @Test
    void testFindByIdOwner() {
        when(ownerRepository.findById(1L)).thenReturn(Optional.of(owner));
        when(ownerMapper.toDTO(owner)).thenReturn(ownerResponseDTO);

        OwnerResponseDTO result = ownerService.findById(1L);

        assertNotNull(result);
        assertEquals("John Doe", result.getName());
        verify(ownerRepository, times(1)).findById(1L);
    }

    @Test
    void testFindAllOwners() {
        List<Owner> owners = Arrays.asList(owner);
        List<OwnerResponseDTO> ownerResponseDTOs = Arrays.asList(ownerResponseDTO);

        when(ownerRepository.findAll()).thenReturn(owners);
        when(ownerMapper.toDTO(owner)).thenReturn(ownerResponseDTO);

        List<OwnerResponseDTO> result = ownerService.findAll();

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(ownerRepository, times(1)).findAll();
    }

    @Test
    void testDeleteOwner_NotFound() {
        when(ownerRepository.existsById(1L)).thenReturn(false);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> ownerService.delete(1L));

        assertEquals("Owner not found with ID: 1", exception.getMessage());
        verify(ownerRepository, never()).deleteById(anyLong());
    }

    @Test
    void testFindByIdOwner_NotFound() {
        when(ownerRepository.findById(1L)).thenReturn(Optional.empty());

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> ownerService.findById(1L));

        assertEquals("Owner not found with ID: 1", exception.getMessage());
        verify(ownerRepository, times(1)).findById(1L);
    }
}
