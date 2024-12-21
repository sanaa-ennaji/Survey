package com.sanaa.brif7.SurveyLens.demo;

import com.sanaa.brif7.SurveyLens.dto.request.OwnerCreateDTO;
import com.sanaa.brif7.SurveyLens.dto.request.OwnerUpdateDTO;
import com.sanaa.brif7.SurveyLens.dto.response.OwnerResponseDTO;
import com.sanaa.brif7.SurveyLens.entity.Owner;
import com.sanaa.brif7.SurveyLens.mapper.OwnerMapper;
import com.sanaa.brif7.SurveyLens.repository.OwnerRepository;
import com.sanaa.brif7.SurveyLens.service.impl.OwnerService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Transactional
class OwnerServiceIntegrationTest {

    @Autowired
    private OwnerService ownerService;

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private OwnerMapper ownerMapper;

    private OwnerCreateDTO ownerCreateDTO;
    private OwnerUpdateDTO ownerUpdateDTO;

    @BeforeEach
    void setUp() {
        ownerCreateDTO = new OwnerCreateDTO();
        ownerCreateDTO.setName("Integration Owner");

        ownerUpdateDTO = new OwnerUpdateDTO();
        ownerUpdateDTO.setName("Updated Integration Owner");
    }

    @Test
    @Order(1)
    @Rollback(false)
    void testCreateOwner() {
        OwnerResponseDTO responseDTO = ownerService.create(ownerCreateDTO);
        assertThat(responseDTO).isNotNull();
        assertThat(responseDTO.getName()).isEqualTo("Integration Owner");

        Optional<Owner> owner = ownerRepository.findById(responseDTO.getId());
        assertThat(owner).isPresent();
    }

    @Test
    @Order(2)
    void testFindOwnerById() {
        OwnerResponseDTO responseDTO = ownerService.create(ownerCreateDTO);
        OwnerResponseDTO foundOwner = ownerService.findById(responseDTO.getId());

        assertThat(foundOwner).isNotNull();
        assertThat(foundOwner.getName()).isEqualTo("Integration Owner");
    }

    @Test
    @Order(3)
    void testUpdateOwner() {
        OwnerResponseDTO responseDTO = ownerService.create(ownerCreateDTO);

        OwnerResponseDTO updatedOwner = ownerService.update(responseDTO.getId(), ownerUpdateDTO);

        assertThat(updatedOwner).isNotNull();
        assertThat(updatedOwner.getName()).isEqualTo("Updated Integration Owner");
    }

    @Test
    @Order(4)
    void testFindAllOwners() {
        ownerService.create(ownerCreateDTO);
        ownerService.create(ownerCreateDTO);

        List<OwnerResponseDTO> owners = ownerService.findAll();

        assertThat(owners).isNotEmpty();
        assertThat(owners.size()).isGreaterThanOrEqualTo(2);
    }

    @Test
    @Order(5)
    void testDeleteOwner() {
        OwnerResponseDTO responseDTO = ownerService.create(ownerCreateDTO);
        Long ownerId = responseDTO.getId();

        ownerService.delete(ownerId);

        Optional<Owner> owner = ownerRepository.findById(ownerId);
        assertThat(owner).isEmpty();
    }
}
